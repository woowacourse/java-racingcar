package StringAdder;

public class Adder {
    public int splitAndSum(String inputString) {
        if (inputString.isEmpty()) return 0;
        String[] inputStrings = getSplit(inputString);
        if (inputStrings.length == 1) {
            return Integer.parseInt(inputString);
        }
        int result = 0;
        for (String stringNumber : inputStrings) {
            result += Integer.parseInt(stringNumber);
        }

        return result;
    }
}
