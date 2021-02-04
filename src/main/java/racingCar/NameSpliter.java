package racingCar;

public class NameSpliter {
    static boolean inputChecker(String input) {
        if (input.charAt(0) == ',' || input.charAt(input.length()-1) == ',') {
            return false;
        }
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() <= 0 || name.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
