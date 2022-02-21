package racingcar.domain.vo;

public class CarName {

    private static final String EMPTY_CAR_NAME_ERROR_MESSAGE = "자동차 이름으로 공백을 입력할 수 없습니다.";
    private static final String TOO_LONG_CAR_NAME_ERROR_MESSAGE = "입력한 자동차 이름이 너무 깁니다.";
    private static final int MAX_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
    }

    public String get() {
        return name;
    }

    @Override
    public String toString() {
        return "CarName{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CarName)) {
            return false;
        }
        CarName carName = (CarName) object;
        return carName.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    private void validateEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(TOO_LONG_CAR_NAME_ERROR_MESSAGE);
        }
    }
}
