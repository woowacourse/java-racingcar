package car;

import java.util.Objects;

public class Name {

    private static final int CAR_NAME_LIMIT = 5;
    private static final String NAME_SPACE_ERROR = "자동차 이름에 공백은 불가능합니다.";
    private static final String NAME_LENGTH_ERROR = "자동차 이름이 너무 깁니다.";
    private String name;

    public Name(String name) {
        this.name = name;
    }

    public String getName() {
        isCarName(name);
        return name;
    }

    private void isCarName(String name) {
        try {
            nameLengthCheck();
            nameEmptyCheck();
        } catch (IllegalArgumentException error) {
            OutputView outputView = new OutputView();
            outputView.errorPrint();
        }

    }

    private void nameEmptyCheck() {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(NAME_SPACE_ERROR);
        }
    }

    private void nameLengthCheck() {
        if (name.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
