package calculator;

public class Calculator {

    private static StringSplitter stringSplitter = StringSplitter.getInstance();

    public static int splitAndSum(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(str);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);

            sum = getSum (sum, tokens);

            return sum;
        }

        String[] tokens = str.split(",|:");

        sum = getSum (sum, tokens);

        return sum;
    }

    private static int getSum(int sum, String[] tokens) {
        for (String token : tokens) {
            int num = Integer.parseInt(token);

            if (num < 0){
                throw new RuntimeException("음수는 안됩니다!");
            }

            sum += num;
        }

        return sum;
    }
}
