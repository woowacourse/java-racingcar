package StringAdder;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Adder {
    public int splitAndSum(String inputString) {
        List<Integer> finalNums = new ArrayList<>();
        if (inputString.isEmpty()) return 0;
        if (isCustom(inputString)) {
            finalNums = getSplit(customSplit(inputString)[0], customSplit(inputString)[1]);
            return finalNums.stream().reduce((x, y) -> x + y).get();
        }
        finalNums = getSplit(inputString);
        return finalNums.stream().reduce((x, y) -> x + y).get();
    }

    private boolean isCustom(String inputString) {
        return inputString.charAt(0) == '/';
    }

    public List<Integer> getSplit(String inputString) {
        List<Integer> result = new ArrayList<>();
        String[] stringNums = inputString.split(",|:");
        for (String stringNum : stringNums) {
            result.add(Integer.parseInt(stringNum));
        }
        return result;
    }

    public List<Integer> getSplit(String custom, String inputString) {
        List<Integer> result = new ArrayList<>();
        String[] stringNums = inputString.split(custom);
        for (String stringNum : stringNums) {
            result.add(Integer.parseInt(stringNum));
        }
        return result;
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
