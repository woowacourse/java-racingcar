package racingcargame.domain;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String LENGTH_LIMIT_EXCEED_ERROR_MESSAGE = "길이 최대치를 초과하는 이름을 가지고 있습니다.";
    private static final String SPACE_ERROR_MESSAGE = "공백 혹은 null 이름을 가지고 있습니다.";

    private String name;

    public Name(String name) {
        checkBlankOrNullInput(name);
        isExceededMaxLength(name);
        this.name = name;
    }

    private void isExceededMaxLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            System.out.println(LENGTH_LIMIT_EXCEED_ERROR_MESSAGE);
            throw new IllegalArgumentException(LENGTH_LIMIT_EXCEED_ERROR_MESSAGE);
        }
    }

    private void checkBlankOrNullInput(String name) {
        if (name == null || name.isEmpty()) {
            System.out.println(SPACE_ERROR_MESSAGE);
            throw new NullPointerException(SPACE_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Name name = (Name) obj;
        return this.name.equals(name.name);
    }
}
