package org.junit.internal.runners.rules;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.rules.TestRule;
import org.junit.runners.model.FrameworkMember;
import org.junit.runners.model.TestClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * A RuleMemberValidator validates the rule fields/methods of a
 * {@link org.junit.runners.model.TestClass}. All reasons for rejecting the
 * {@code TestClass} are written to a list of errors.
 *
 * <p>There are four slightly different validators. The {@link #CLASS_RULE_VALIDATOR}
 * validates fields with a {@link ClassRule} annotation and the
 * {@link #RULE_VALIDATOR} validates fields with a {@link Rule} annotation.</p>
 *
 * <p>The {@link #CLASS_RULE_METHOD_VALIDATOR}
 * validates methods with a {@link ClassRule} annotation and the
 * {@link #RULE_METHOD_VALIDATOR} validates methods with a {@link Rule} annotation.</p>
 */
public class RuleMemberValidator {
    /**
     * Validates fields with a {@link ClassRule} annotation.
     */
    public static final RuleMemberValidator CLASS_RULE_VALIDATOR =
            classRuleValidatorBuilder()
            .withValidator(new DeclaringClassMustBePublic())
            .withValidator(new MemberMustBeStatic())
            .withValidator(new MemberMustBePublic())
            .withValidator(new FieldMustBeATestRule())
            .build();
    /**
     * Validates fields with a {@link Rule} annotation.
     */
    public static final RuleMemberValidator RULE_VALIDATOR =
            testRuleValidatorBuilder()
            .withValidator(new MemberMustBeNonStaticOrAlsoClassRule())
            .withValidator(new MemberMustBePublic())
            .withValidator(new FieldMustBeARule())
            .build();
    /**
     * Validates methods with a {@link ClassRule} annotation.
     */
    public static final RuleMemberValidator CLASS_RULE_METHOD_VALIDATOR =
            classRuleValidatorBuilder()
            .forMethods()
            .withValidator(new DeclaringClassMustBePublic())
            .withValidator(new MemberMustBeStatic())
            .withValidator(new MemberMustBePublic())
            .withValidator(new MethodMustBeATestRule())
            .build();

    /**
     * Validates methods with a {@link Rule} annotation.
     */
    public static final RuleMemberValidator RULE_METHOD_VALIDATOR =
            testRuleValidatorBuilder()
            .forMethods()
            .withValidator(new MemberMustBeNonStaticOrAlsoClassRule())
            .withValidator(new MemberMustBePublic())
            .withValidator(new MethodMustBeARule())
            .build();

    private final Class<? extends Annotation> annotation;
    private final boolean methods;
    private final List<RuleValidator> validatorStrategies;

    RuleMemberValidator(Builder builder) {
        this.annotation = builder.annotation;
        this.methods = builder.methods;
        this.validatorStrategies = builder.validators;
    }

    /**
     * Validate the {@link org.junit.runners.model.TestClass} and adds reasons
     * for rejecting the class to a list of errors.
     *
     * @param target the {@code TestClass} to validate.
     * @param errors the list of errors.
     */
    public void validate(TestClass target, List<Throwable> errors) {
        List<FrameworkMember<?>> members = methods ? target.getAnnotatedMethods(annotation)
        : target.getAnnotatedFields(annotation);
        
        for (FrameworkMember<?> each : members) {
            validateMember(each, errors);
        }
    }

    private void validateMember(FrameworkMember<?> member, List<Throwable> errors) {
        for (RuleValidator strategy : validatorStrategies) {
            strategy.validate(member, annotation, errors);
        }
    }

    private static Builder classRuleValidatorBuilder() {
        return new Builder(ClassRule.class);
    }

    private static Builder testRuleValidatorBuilder() {
        return new Builder(Rule.class);
    }

    private static class Builder {
        private final Class<? extends Annotation> annotation;
        private boolean methods;
        private final List<RuleValidator> validators;

        private Builder(Class<? extends Annotation> annotation) {
            this.annotation = annotation;
            validators = new ArrayList<RuleValidator>();
        }

        Builder forMethods() {
            methods = true;
            return this;
        }

        Builder withValidator(RuleValidator validator) {
            validators.add(validator);
            return this;
        }

        RuleMemberValidator build() {
            return new RuleMemberValidator(this);
        }
    }

    private static boolean isRuleType(FrameworkMember<?> member) {
        return isMethodRule(member) || isTestRule(member);
    }

    private static boolean isTestRule(FrameworkMember<?> member) {
        return TestRule.class.isAssignableFrom(member.getType());
    }

    private static boolean isMethodRule(FrameworkMember<?> member) {
        return MethodRule.class.isAssignableFrom(member.getType());
    }

    /**
     * Encapsulates a single piece of validation logic, used to determine if {@link org.junit.Rule} and
     * {@link org.junit.ClassRule} annotations have been used correctly
     */
    interface RuleValidator {
        /**
         * Examine the given member and add any violations of the strategy's validation logic to the given list of errors
         * @param member The member (field or member) to examine
         * @param annotation The type of rule annotation on the member
         * @param errors The list of errors to add validation violations to
         */
        void validate(FrameworkMember<?> member, Class<? extends Annotation> annotation, List<Throwable> errors);
    }

    /**
     * Requires the validated member to be non-static
     */
    private static final class MemberMustBeNonStaticOrAlsoClassRule implements RuleValidator {
        public void validate(FrameworkMember<?> member, Class<? extends Annotation> annotation, List<Throwable> errors) {
            if (member.isStatic()) {
                errors.add(new Exception(annotation.getSimpleName() + "s must be static."));
            }
        }
    }

    /**
     * Requires the member to be static
     */
    private static final class MemberMustBeStatic implements RuleValidator {
        public void validate(FrameworkMember<?> member, Class<? extends Annotation> annotation, List<Throwable> errors) {
            if (member.isStatic() == false) {
                String message = annotation.getSimpleName() + "s must be static.";
                errors.add(new Exception(message));
            }
        }
    }

    /**
     * Requires the member's declaring class to be public
     */
    private static final class DeclaringClassMustBePublic implements RuleValidator {
        public void validate(FrameworkMember<?> member, Class<? extends Annotation> annotation, List<Throwable> errors) {
            if (!isDeclaringClassPublic(member)) {
                String message = "The class containing %s member %s must be public.";
                errors.add(new Exception(String.format(message, annotation.getSimpleName(), member.getName())));
            }
        }

        private boolean isDeclaringClassPublic(FrameworkMember<?> member) {
            return Modifier.isPublic(member.getDeclaringClass().getModifiers());
        }
    }

    /**
     * Requires the member to be public
     */
    private static final class MemberMustBePublic implements RuleValidator {
        public void validate(FrameworkMember<?> member, Class<? extends Annotation> annotation, List<Throwable> errors) {
            if (!member.isPublic()) {
                errors.add(new Exception("The @" + annotation.getSimpleName() + " '" + member.getName() + "' must be public."));
            }
        }
    }

    /**
     * Requires the member is a field implementing {@link org.junit.rules.MethodRule} or {@link org.junit.rules.TestRule}
     */
    private static final class FieldMustBeARule implements RuleValidator {
        public void validate(FrameworkMember<?> member, Class<? extends Annotation> annotation, List<Throwable> errors) {
            if (isRuleType(member) && !isMethodRule(member)) {
                errors.add(new ValidationError(member, annotation, "must return an implementation of MethodRule."));
            }
        }
    }

    /**
     * Require the member to return an implementation of {@link org.junit.rules.MethodRule} or
     * {@link org.junit.rules.TestRule}
     */
    private static final class MethodMustBeARule implements RuleValidator {
        public void validate(FrameworkMember<?> member, Class<? extends Annotation> annotation, List<Throwable> errors) {
            if (RuleMemberValidator.isMethodRule(member)) {
                return;
            }
            if (RuleMemberValidator.isRuleType(member)) {
                return;
            }
            errors.add(new ValidationError(member, annotation, "must return an implementation of MethodRule."));
        }
    }
    
    /**
     * Require the member to return an implementation of {@link org.junit.rules.TestRule}
     */
    private static final class MethodMustBeATestRule implements RuleValidator {
        public void validate(FrameworkMember<?> member,
                Class<? extends Annotation> annotation, List<Throwable> errors) {
            if (isTestRule(member) || isRuleType(member)) {
                return;
            }
            
            errors.add(new ValidationError("This method must return an implementation of TestRule.",
            annotation));
        }
    }
    
    /**
     * Requires the member is a field implementing {@link org.junit.rules.TestRule}
     */
    private static final class FieldMustBeATestRule implements RuleValidator {

        public void validate(FrameworkMember<?> member,
                Class<? extends Annotation> annotation, List<Throwable> errors) {
            if (isTestRule(member) || isRuleType(member)) {
                return;
            }
            
            errors.add(new ValidationError("Field " + member.getName() + " must implement MethodRule"));
        }
    }
}
