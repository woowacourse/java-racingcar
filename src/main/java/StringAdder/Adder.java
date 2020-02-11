package StringAdder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adder {
    public int splitAndSum(String inputString) {
        int result = 0;
        if (inputString.isEmpty()) return 0;
        if (inputString.charAt(0) == '/') {
            String[] customList = customSplit(inputString);
            return customSum(customList);
        }
        String[] inputStrings = getSplit(inputString);
        if (inputStrings.length == 1) {
            return Integer.parseInt(inputString);
        }
        for (String stringNumber : inputStrings) {
            result += Integer.parseInt(stringNumber);
        }

        return result;
    }

    private int customSum(String[] customList) {
        int result = 0;
        String[] listToSum = getSplit(customList[0], customList[1]);
        for (String number : listToSum) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    public String[] getSplit(String inputString) {
        return inputString.split(",|:");
    }

    public String[] getSplit(String custom, String inputString) {
        return inputString.split(custom);
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
