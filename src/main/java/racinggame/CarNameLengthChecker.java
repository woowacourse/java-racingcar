package racinggame;

public class CarNameLengthChecker {

    static final int MAX_NAME_LENGTH = 5;
    static final int MIN_NAME_LENGTH = 1;
    private boolean isRightLength;

    public CarNameLengthChecker(String[] carsName) {
        this.isRightLength = checkCarsNameLength(carsName);
    }

    private boolean checkCarsNameLength(String[] carsName) {
        boolean allNamesAreRightLength = true;

        for (String carName : carsName) {
            allNamesAreRightLength = checkEachCarNameLength(allNamesAreRightLength, carName);
        }

        return allNamesAreRightLength;
    }

    private boolean checkEachCarNameLength(boolean allNamesAreRightLength, String carName) {
        boolean eachIsRightLength;

        eachIsRightLength = carName.length() <= MAX_NAME_LENGTH && carName.length() >= MIN_NAME_LENGTH
                && allNamesAreRightLength;

        return eachIsRightLength;
    }

    public boolean isRightLength() {
        return isRightLength;
    }
}
