package domain.name;

public class Name {
    private String value;
    private static final Integer LENGTH_LIMIT = 5;

    public Name(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("공백 이름입니다!");
        }
        if (value.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException(String.format("이름은 최대 %d 글자입니다!", LENGTH_LIMIT));
        }
    }

    public String getValue() {
        return value;
    }
}
