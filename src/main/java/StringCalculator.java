public class StringCalculator {
    public static int calculate(String s) {
        String[] splitStrings = s.split(",|:");
        int[] splitNumbers = toIntArray(splitStrings);
        return sumOfList(splitNumbers);
    }

    public static int[] toIntArray(String[] testData) {
        int[] result = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            result[i] = Integer.parseInt(testData[i]);
        }
        return result;
    }

    public static int sumOfList(int[] numberList) {
        int total = 0;
        for (int number : numberList) {
            total += number;
        }
        return total;
    }
}
