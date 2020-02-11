package StringAdder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public String[] getSplit(String inputString) {

        return inputString.split(",|:");
    }

    public String[] customSplit(String inputString) {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(inputString);
        String[] result = new String[2];
        while (matcher.find()) {
            result[0] = matcher.group(1);
            result[1] = matcher.group(2);
        }
        return result;
    }
}
