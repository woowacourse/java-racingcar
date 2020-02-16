package application.racing.domain;

public class CarName {
    private final static String BLANK = " ";
    private final static int MAX_NAME_LENGTH = 5;

    private String carName;

    public CarName(String carName) {
        validateCarNameFormat(carName);
        validateCarNameContainBlank(carName);
        validateCarNameLength(carName);
        this.carName = carName;
    }

    private void validateCarNameFormat(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException("이름을 잘못 입력하였습니다.");
        }
    }

    private void validateCarNameContainBlank(String carName) {
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException("공백을 포함한 이름을 입력하였습니다.");
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5글자 초과의 자동차 이름을 입력하였습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || !(o instanceof CarName)) {
            return false;
        }
        CarName compareCarName = (CarName) o;
        return compareCarName.carName.equals(this.carName);
    }

    @Override
    public int hashCode() {
        return this.carName.hashCode() * 31;
    }

    @Override
    public String toString() {
        return this.carName;
    }
}
