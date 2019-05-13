package racinggame;

public class CarsName {

    static final int MAX_NAME_LENGTH = 5;
    static final int MIN_NAME_LENGTH = 1;

    public static String[] makeCarsName (String inputText) {
        String[] carsName;

        do {
            inputText = removeBlank(inputText);
            inputText = removeDuplicatedComma(inputText);
            carsName = splitByComma(inputText);
        } while (!checkCarsNameLength(carsName));

        return carsName;
    }

    private static String removeBlank(String carsName) {
        carsName = carsName.replace(" ", "");

        return carsName;
    }

    private static String removeDuplicatedComma(String carsName) {
        while (carsName.contains(",,")) {
            carsName = carsName.replace(",,", ",");
        }

        return carsName;
    }

    private static String[] splitByComma(String carsName) {
        return carsName.split(",");
    }

    private static boolean checkCarsNameLength(String[] carsName) {
        boolean allNamesAreRightLength = true;

        for (String carName : carsName) {
            allNamesAreRightLength = checkEachCarNameLength(allNamesAreRightLength, carName);
        }

        return allNamesAreRightLength;
    }

    private static boolean checkEachCarNameLength(boolean allNamesAreRightLength, String carName) {
        boolean eachIsRightLength;

        eachIsRightLength = carName.length() <= MAX_NAME_LENGTH && carName.length() >= MIN_NAME_LENGTH
                && allNamesAreRightLength;

        return eachIsRightLength;
    }

}