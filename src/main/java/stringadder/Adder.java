package stringadder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adder {
    private List<Integer> finalNumbers;

    public int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        return sumNotEmpty(inputString);
    }

    private int sumNotEmpty(String inputString) {
        if (isCustomMarkIsMinus(inputString)) {
            return sumWhenCustomMarkMinus(inputString);
        }
        if (isCustom(inputString)) {
            return sumWhenCustomMarkNotMinus(inputString);
        }
        return sumNotCustomMark(inputString);
    }

    private int sumNotCustomMark(String inputString) {
        validateSingleMinus(inputString);
        finalNumbers = getSplit(inputString);
        return finalNumbers.stream().reduce((x, y) -> x + y).get();
    }

    private int sumWhenCustomMarkNotMinus(String inputString) {
        validateSingleMinus(inputString);
        finalNumbers = getSplit(customMarkAndEquation(inputString)[0], customMarkAndEquation(inputString)[1]);
        return finalNumbers.stream().reduce((x, y) -> x + y).get();
    }

    private int sumWhenCustomMarkMinus(String inputString) {
        validateDoubleMinus(inputString);
        finalNumbers = getSplit(customMarkAndEquation(inputString)[0], customMarkAndEquation(inputString)[1]);
        return finalNumbers.stream().reduce((x, y) -> x + y).get();
    }

    private boolean isCustomMarkIsMinus(String inputString) {
        return inputString.charAt(0) == '/' && customMarkAndEquation(inputString)[0] == "-";
    }

    public void validateDoubleMinus(String inputString) {
        Matcher minusMatcher = Pattern.compile("--").matcher(inputString);
        if (minusMatcher.find()) {
            throw new RuntimeException();
        }
    }

    public void validateSingleMinus(String inputString) {
        Matcher minusMatcher = Pattern.compile("-").matcher(inputString);
        if (minusMatcher.find()) {
            throw new RuntimeException();
        }
    }

    private boolean isCustom(String inputString) {
        return inputString.charAt(0) == '/';
    }

    public List<Integer> getSplit(String inputString) {
        List<Integer> result = new ArrayList<>();
        String[] stringNums = inputString.split(",|:");
        for (String stringNum : stringNums) {
            result.add(toInteger(stringNum));
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

    public List<Integer> getSplit(String custom, String inputString) {
        List<Integer> result = new ArrayList<>();
        String[] stringNums = inputString.split(custom);
        for (String stringNum : stringNums) {
            result.add(toInteger(stringNum));
        }
        return result;
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
}
