package racinggame;

public class CarsName {

    public static String[] makeCarsName (String inputText) {
        String[] carsName;

        inputText = removeBlank(inputText);
        inputText = removeDuplicatedComma(inputText);
        carsName = splitByComma(inputText);

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