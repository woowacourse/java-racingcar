package stringadder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adder {
    public static final String ERROR_MESSAGE_NEGATIVE_NUMBER = "0 이상의 수를 입력하세요";
    public static final String MINUS_SIGN = "-";
    private List<Integer> finalNumbers;

    public int splitAndSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }
        if (isCustom(inputString)) {
            return sumCustom(inputString);
        }
        return sumNotCustom(inputString);
    }

    private int sumCustom(String inputString) {
        if (isCustomMarkIsMinus(inputString)) {
            return sumWhenCustomMarkMinus(inputString);
        }
        return sumWhenCustomMarkNotMinus(inputString);
    }

    private int sumNotCustom(String inputString) {
        validateNumber(inputString);
        return sumWhenList(toIntegerList(inputString));
    }

    private int sumWhenList(List<Integer> finalNumbers) {
        return finalNumbers.stream().reduce((x, y) -> x + y).get();
    }

    private int sumWhenCustomMarkNotMinus(String inputString) {
        validateNumber(inputString);
        finalNumbers = toIntegerList(customMarkAndEquation(inputString)[0], customMarkAndEquation(inputString)[1]);
        return finalNumbers.stream().reduce((x, y) -> x + y).get();
    }

    private int sumWhenCustomMarkMinus(String inputString) {
        validateDoubleMinus(inputString);
        finalNumbers = toIntegerList(customMarkAndEquation(inputString)[0], customMarkAndEquation(inputString)[1]);
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

    public void validateNumber(String inputString) {
        if (inputString.contains(MINUS_SIGN)) {
            throw new RuntimeException(ERROR_MESSAGE_NEGATIVE_NUMBER);
        }
    }

    private boolean isCustom(String inputString) {
        return inputString.charAt(0) == '/';
    }

    public List<Integer> toIntegerList(String inputString) {
        List<Integer> result = new ArrayList<>();
        String[] numbers = inputString.split(",|:");
        for (String number : numbers) {
            result.add(toInteger(number));
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

    public List<Integer> toIntegerList(String custom, String inputString) {
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
