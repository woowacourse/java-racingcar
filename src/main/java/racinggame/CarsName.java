package racinggame;

public class CarsName {
    static final int MAX_NAME_LENGTH = 5;
    static final int MIN_NAME_LENGTH = 1;
    private String[] carsName;

    public CarsName(String inputText) {
        String[] carsName;

        do {
            inputText = removeBlank(inputText);
            inputText = removeDuplicatedComma(inputText);
            carsName = splitByComma(inputText);
        } while (!checkCarsNameLength(carsName));

        this.carsName = carsName;
    }

    private String removeBlank(String carsName) {
        carsName = carsName.replace(" ", "");

        return carsName;
    }

    private String removeDuplicatedComma(String carsName) {
        while (carsName.contains(",,")) {
            carsName = carsName.replace(",,", ",");
        }

        return carsName;
    }

    private String[] splitByComma(String carsName) {
        return carsName.split(",");
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

    public String[] getCarsName() {
        return carsName;
    }
}