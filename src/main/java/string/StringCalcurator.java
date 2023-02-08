package string;

public class StringCalcurator {

    public String[] splitString(String value) {
        if (value.isEmpty()) {
            return null;
        }
        String[] result = value.split(",");

        return result;
    }

    public String removeString(String value) {
        if (value.isEmpty())
            return value;

        value = value.replace("(", "").replace(")", "");

        return value;
    }

    public String findCharToIndex(int index) {
        String testString = "abc";

        return testString.substring(index, index + 1);
    }
}
