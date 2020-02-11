public class StringCalculator {
    public static final String DELIMITER = "";
    public static final int FIRST_SEPARATOR = 1;
    public static final int STEP = 2;

    public static int run(String value) {
        if(value==null || value.isBlank()){
            return 0;
        }
        String[] values = value.split(DELIMITER);
        int result = Integer.parseInt(values[0]);
        for (int i = FIRST_SEPARATOR; i < value.length(); i += STEP) {
            result = calculate(values, result, i);
        }
        return result;
    }

    private static int calculate(String[] values, int result, int i) {
        if (isDefaultDelimiter(values[i])) {
            result += Integer.parseInt(values[i + 1]);
        }
        return result;
    }

    private static boolean isDefaultDelimiter(String value) {
        return value.equals(",") || value.equals(":");
    }
}
