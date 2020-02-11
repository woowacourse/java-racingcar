package calculator;

public class Calculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        int result = 0;
        String[] inputs = input.split(",");
        if(inputs.length == 1) {
            return Integer.parseInt(inputs[0]);
        }
        for (String val : inputs){
            result += Integer.parseInt(val);
        }
        return result;
    }
}
