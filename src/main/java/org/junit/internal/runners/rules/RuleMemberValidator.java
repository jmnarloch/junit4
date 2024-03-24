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
        
    }

    /**
     * Validate the {@link org.junit.runners.model.TestClass} and adds reasons
     * for rejecting the class to a list of errors.
     *
     * @param target the {@code TestClass} to validate.
     * @param errors the list of errors.
     */
    public void validate(TestClass target, List<Throwable> errors) {
        
    }

    private void validateMember(FrameworkMember<?> member, List<Throwable> errors) {
        
    }

    private static Builder classRuleValidatorBuilder() {
        
    }

    private static Builder testRuleValidatorBuilder() {
        
    }

    private static class Builder {
        private final Class<? extends Annotation> annotation;
        private boolean methods;
        private final List<RuleValidator> validators;

        private Builder(Class<? extends Annotation> annotation) {
            
        }

        Builder forMethods() {
            
        }

        Builder withValidator(RuleValidator validator) {
            
        }

        RuleMemberValidator build() {
            
        }
    }

    private static boolean isRuleType(FrameworkMember<?> member) {
        
    }

    private static boolean isTestRule(FrameworkMember<?> member) {
        
    }

    private static boolean isMethodRule(FrameworkMember<?> member) {
        
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
            
        }
    }

    /**
     * Requires the member to be static
     */
    private static final class MemberMustBeStatic implements RuleValidator {
        public void validate(FrameworkMember<?> member, Class<? extends Annotation> annotation, List<Throwable> errors) {
            
        }
    }

    /**
     * Requires the member's declaring class to be public
     */
    private static final class DeclaringClassMustBePublic implements RuleValidator {
        public void validate(FrameworkMember<?> member, Class<? extends Annotation> annotation, List<Throwable> errors) {
            
        }

        private boolean isDeclaringClassPublic(FrameworkMember<?> member) {
            
        }
    }

    /**
     * Requires the member to be public
     */
    private static final class MemberMustBePublic implements RuleValidator {
        public void validate(FrameworkMember<?> member, Class<? extends Annotation> annotation, List<Throwable> errors) {
            
        }
    }

    /**
     * Requires the member is a field implementing {@link org.junit.rules.MethodRule} or {@link org.junit.rules.TestRule}
     */
    private static final class FieldMustBeARule implements RuleValidator {
        public void validate(FrameworkMember<?> member, Class<? extends Annotation> annotation, List<Throwable> errors) {
            
        }
    }

    /**
     * Require the member to return an implementation of {@link org.junit.rules.MethodRule} or
     * {@link org.junit.rules.TestRule}
     */
    private static final class MethodMustBeARule implements RuleValidator {
        public void validate(FrameworkMember<?> member, Class<? extends Annotation> annotation, List<Throwable> errors) {
            
        }
    }
    
    /**
     * Require the member to return an implementation of {@link org.junit.rules.TestRule}
     */
    private static final class MethodMustBeATestRule implements RuleValidator {
        public void validate(FrameworkMember<?> member,
                Class<? extends Annotation> annotation, List<Throwable> errors) {
            
        }
    }
    
    /**
     * Requires the member is a field implementing {@link org.junit.rules.TestRule}
     */
    private static final class FieldMustBeATestRule implements RuleValidator {

        public void validate(FrameworkMember<?> member,
                Class<? extends Annotation> annotation, List<Throwable> errors) {
            
        }
    }
}
