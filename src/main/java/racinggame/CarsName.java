package racinggame;

import racinggame.view.UserInput;

public class CarsName {

    public static String[] makeCarsName () {
        String[] carsName;
        CarNameLengthChecker checker;
        String inputText;

        do {
            inputText = UserInput.inputCarsName();
            carsName = splitByComma(removeDuplicatedComma(removeBlank(inputText)));
            checker = new CarNameLengthChecker(carsName);
        } while (!checker.isRightLength());

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

}