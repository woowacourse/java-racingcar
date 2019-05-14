package racinggame;

public class CarNameLengthChecker {

    static final int MAX_NAME_LENGTH = 5;
    static final int MIN_NAME_LENGTH = 1;
    private boolean isRightLength;

    public CarNameLengthChecker(String[] carsName) {
        boolean allAreRightLength = true;

        for (String carName : carsName) {
            allAreRightLength = carName.length() <= MAX_NAME_LENGTH
                    && carName.length() >= MIN_NAME_LENGTH
                    && allAreRightLength;
        }

        this.isRightLength = allAreRightLength;
    }

    public boolean isRightLength() {
        return isRightLength;
    }
}
