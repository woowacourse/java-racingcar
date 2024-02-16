package model;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name) {
        verifyNameLength(name);
        this.name = name;
    }

    private void verifyNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MIN_NAME_LENGTH + "자 이상 "
                    + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
    }

    protected String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Name name) {
            return this.name.equals(name.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
