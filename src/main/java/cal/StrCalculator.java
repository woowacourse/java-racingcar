package cal;

import java.util.Scanner;

public class StrCalculator {
    private static final String INPUT_REQUEST_MESSAGE = "수식을 입력하세요 !";
    private static final String INPUT_ERROR_MESSAGE = "수식을 확인해주세요 !";
    private static final String RESULT_MESSAGE = "의 결과는 %d 입니다 ! ^^";

    private Scanner sc = new Scanner(System.in);
    String[] values;

    public void input() {
        System.out.println(INPUT_REQUEST_MESSAGE);
        values = sc.nextLine().split(" ");
    }

    public int calculate() {
        if (values.length % 2 == 0) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        if (!isEvenPositionMatch(values) || !isOddPositionMatch(values)){
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        int result = Integer.parseInt(values[0]);
        Calculator cal = new Calculator();
        for(int i = 1; i < values.length; i += 2) {
            if(values[i].equals("+")) {
                result = cal.plus(result, Integer.parseInt(values[i + 1]));
            }
            if(values[i].equals("-")) {
                result = cal.subtract(result, Integer.parseInt(values[i + 1]));
            }
            if(values[i].equals("*")) {
                result = cal.multiple(result, Integer.parseInt(values[i + 1]));
            }
            if(values[i].equals("/")) {
                result = cal.divide(result, Integer.parseInt(values[i + 1]));
            }
        }
        return result;
    }

    public boolean isEvenPositionMatch(String[] values) {
        for (int i = 0; i < values.length; i += 2){
            try {
                Integer.parseInt(values[i]);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public boolean isOddPositionMatch(String[] values) {
        for (int i = 1; i < values.length; i += 2) {
            if (!values[i].matches("[\\+\\-\\*\\/]")) {
                return false;
            }
        }
        return true;
    }


    public void printResult(int calResult) {
        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            sb.append(value);
            sb.append(' ');
        }
        sb.append(RESULT_MESSAGE);
        System.out.printf(sb.toString(), calResult);
        System.out.println();
    }
}
