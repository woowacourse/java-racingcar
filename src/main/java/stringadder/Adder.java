package stringadder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adder {

    private List<Integer> result = new ArrayList<>();
    private List<Integer> finalNumbers = new ArrayList<>();

    public int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        return Calculate(inputString);
    }

    private int Calculate(String inputString) {
        if (validateCustomMark(inputString)) {
            finalNumbers = getSplit(customMarkAndEquation(inputString)[0], customMarkAndEquation(inputString)[1]);
            return finalNumbers.stream().reduce((x, y) -> x + y).get();
        }
        finalNumbers = getSplit(inputString);
        return finalNumbers.stream().reduce((x, y) -> x + y).get();
    }

    private boolean validateCustomMark(String inputString) {
        return inputString.charAt(0) == '/';
    }

    public List<Integer> getSplit(String inputString) {
        String[] stringNumbers = inputString.split(",|:");
        return getFinalNumbers(result, stringNumbers);
    }

    public List<Integer> getSplit(String custom, String inputString) {
        String[] stringNumbers = inputString.split(custom);
        return getFinalNumbers(result, stringNumbers);
    }

    private List<Integer> getFinalNumbers(List<Integer> result, String[] stringNumbers) {
        for (String stringNum : stringNumbers) {
            result.add(toInteger(stringNum));
            validateNegativeNumber(result.get(result.size() - 1));
        }
        return result;
    }

    private int toInteger(String stringNum) {
        try {
            return Integer.parseInt(stringNum);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public String[] customMarkAndEquation(String inputString) {
        Pattern pattern = Pattern.compile("//(.)\n(.*)");
        Matcher matcher = pattern.matcher(inputString);
        String[] result = new String[2];
        while (matcher.find()) {
            result[0] = matcher.group(1);
            result[1] = matcher.group(2);
        }
        return result;
    }

    public void validateNegativeNumber(int input) {
        if (input < 0) {
            throw new RuntimeException();
        }
    }
}
