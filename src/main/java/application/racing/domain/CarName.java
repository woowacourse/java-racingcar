package application.racing.domain;

public class CarName {
    private final static String BLANK = " ";
    private final static String ERR_MESSAGE_FOR_INVALID_CARNAME = "이름을 잘못 입력하였습니다.";

    private String carName;

    public CarName(String carName) {
        validateCarNameFormat(carName);
        validateCarNameContainBlank(carName);
        validateCarNameLength(carName);
        this.carName = carName;
    }

    private void validateCarNameFormat(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException(ERR_MESSAGE_FOR_INVALID_CARNAME);
        }
    }

    private void validateCarNameContainBlank(String carName) {
        if (carName.contains(BLANK)) {
            throw new IllegalArgumentException(ERR_MESSAGE_FOR_INVALID_CARNAME);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERR_MESSAGE_FOR_INVALID_CARNAME);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof CarName)) {
            return false;
        }
        CarName compareCarName = (CarName) o;
        return compareCarName.carName.equals(this.carName);
    }

    public int hashCode() {
        return super.hashCode() + 137;
    }

    @Override
    public String toString() {
        return this.carName;
    }
}
