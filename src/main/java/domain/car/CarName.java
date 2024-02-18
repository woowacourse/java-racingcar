package domain.car;

public record CarName(String name) {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    public CarName {
        validateLength(name);
    }

    private void validateLength(final String name) {
        final int length = name.length();
        if (length < MIN_NAME_LENGTH || length > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 1이상 5이하의 문자열만 가능합니다.");
        }
    }
}
