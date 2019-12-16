package jsound.exceptions.codes;

public enum ErrorCodes {
    CLI_ERROR_CODE("cli error"),
    RUNTIME_EXCEPTION_ERROR_CODE("runtime exception"),
    RESOURCE_NOT_FOUND_ERROR_CODE("resource not found"),
    INVALID_TYPE_EXCEPTION("invalid atomicTypes"),
    UNEXPECTED_TYPE_EXCEPTION("unexpected atomicTypes"),
    INVALID_SCHEMA_EXCEPTION("invalid schema"),

    MISSING_KIND("JDST0001"),
    BASETYPE_NOT_FOUND("JDST0002"),
    INVALID_KIND("JDST0003"),
    INCONSISTENT_NAME("JDST0004"),
    LESS_RESTRICTIVE_FACET("JDST0005"),
    NOT_VALID_ENUM_VALUE("JDST0006"),
    NOT_CONSISTENT_KIND_BASETYPE("JDST0007"),
    MISSING_NAME_OR_TYPE_OBJECT_CONTENT("JDST0008"),
    CLOSED_SET_BACK_TO_FALSE("JDST0009"),
    CLOSED_NOT_RESPECTED("JDST0010"),
    REQUIRED_SET_BACK_TO_FALSE("JDST0011"),
    UNIONTYPE_USED_AS_ANNOTATION("JDST0012"),
    OVERRIDE_BUILTIN_TYPES("JDST0013"),
    ALREADY_EXISTING_TYPE("JDST0014"),
    INSTANCE_NOT_VALID_AGAINST_SCHEMA("JDST0015"),
    ANNOTATE_WITH_UNKNOWN_TYPE("JDST0016"),
    NOT_VALID_WHEN_ANNOTATING("JDST0017"),
    CYCLE_IN_BASETYPE("JDST0018");

    private final String errorCode;

    ErrorCodes(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
