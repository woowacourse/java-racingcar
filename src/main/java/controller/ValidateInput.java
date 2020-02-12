package controller;

public class ValidateInput {

    public static boolean checkNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOverZero(int count) {
        return count > 0;
    }
}
