package racingcargame.model.car.vo;

public class CarName {
    private static final int MAX_NAME_LENGTH_COUNT = 5;
    private static final int MIN_NAME_LENGTH_COUNT = 1;
    private static final String EMPTY_NAME = "";
    private static final String EMPTY_NAME_ERROR_MESSAGE = "[error] 입력된 자동차 이름중 이름이 없는 자동차가 있습니다.";
    private static final String NO_VALIDATE_NAME_LENGTH_ERROR_MESSAGE = "[error] 자동차 이름을 5자 이하로 입력해주세요.";

    private final String name;

    public CarName(final String name) {
        this.name = checkValidateName(name);
    }

    private String checkValidateName(final String name) {
        checkNameExists(name);
        checkValidNameLength(name);
        return name;
    }

    private void checkNameExists(final String name) {
        if (EMPTY_NAME.equals(name)) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR_MESSAGE);
        }
    }

    private void checkValidNameLength(final String name) {
        if (name.length() < MIN_NAME_LENGTH_COUNT || name.length() > MAX_NAME_LENGTH_COUNT) {
            throw new IllegalArgumentException(NO_VALIDATE_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CarName otherCarName = (CarName) o;
        return name.equals(otherCarName.name);
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(name);
    }
}
