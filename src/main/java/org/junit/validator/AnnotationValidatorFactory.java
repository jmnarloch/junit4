package org.junit.validator;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Creates instances of Annotation Validators.
 *
 * @since 4.12
 */
public class AnnotationValidatorFactory {
    private static final ConcurrentHashMap<ValidateWith, AnnotationValidator> VALIDATORS_FOR_ANNOTATION_TYPES =
            new ConcurrentHashMap<ValidateWith, AnnotationValidator>();

    /**
     * Creates the AnnotationValidator specified by the value in
     * {@link org.junit.validator.ValidateWith}. Instances are
     * cached.
     *
     * @return An instance of the AnnotationValidator.
     *
     * @since 4.12
     */
    public AnnotationValidator createAnnotationValidator(ValidateWith validateWithAnnotation) {
        AnnotationValidator result;
        try {
            if (VALIDATORS_FOR_ANNOTATION_TYPES.containsKey(validateWithAnnotation)) {
                result = VALIDATORS_FOR_ANNOTATION_TYPES.get(validateWithAnnotation);
            } else {
                AnnotationValidator annotationValidator = validateWithAnnotation.value().newInstance();
                VALIDATORS_FOR_ANNOTATION_TYPES.putIfAbsent(validateWithAnnotation, annotationValidator);
                result = VALIDATORS_FOR_ANNOTATION_TYPES.get(validateWithAnnotation);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
