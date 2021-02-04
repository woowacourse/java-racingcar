package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public static int splitAndSum(String input) {
        if (isNull(input)) {
            return 0;
        }
        List<String> parsingInfo = findDelimiter(input);
        int[] parsedResult = parseInput(parsingInfo);
        return calculateSum(parsedResult);
    }

    private static boolean isNull(String input) {
        return (input == null || input.length() == 0);
    }

    private static int[] parseInput(List<String> parsingInfo) {
        String delimiter = parsingInfo.get(0);
        String input = parsingInfo.get(1);
        String[] tokens = input.split(delimiter);
        int[] nums = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
        hasNegative(nums);
        return nums;
    }

    private static void hasNegative(int[] nums) {
        if (Arrays.stream(nums).filter(num -> num < 0).findAny().isPresent()) {
            throw new RuntimeException("런타임 에러");
        }
    }

    private static int calculateSum(int[] parsedResult) {
        return Arrays.stream(parsedResult).sum();
    }

    public static List<String> findDelimiter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) { // 커스텀 구분자가 있을 시
            return makeParsingInfoWithCustomDelimiter(m);
        }
        List<String> parsingInfo = new ArrayList<>();
        parsingInfo.add(",|:");
        parsingInfo.add(input);
        return parsingInfo;
    }

    private static List<String> makeParsingInfoWithCustomDelimiter(Matcher m) {
        List<String> parsingInfo = new ArrayList<>();
        parsingInfo.add(m.group(1));
        parsingInfo.add(m.group(2));
        return parsingInfo;
    }
}
