package cal;

import java.util.Scanner;

public class StrCalculator {
    private static final String INPUT_REQUEST_MESSAGE = "수식을 입력하세요 !";
    private static final String INPUT_ERROR_MESSAGE = "수식을 확인해주세요 !";
    private static final String RESULT_MESSAGE = "의 결과는 ";

    private Scanner sc = new Scanner(System.in);
    String[] values;

    void input() {
        System.out.println(INPUT_REQUEST_MESSAGE);
        values = sc.nextLine().split(" ");
    }

    int calculate() {
        checkInputException();

        int result = Integer.parseInt(values[0]);
        Calculator cal = new Calculator();
        for (int i = 1; i < values.length; i += 2) {
            if (values[i].equals("+")) {
                result = cal.add(result, Integer.parseInt(values[i + 1]));
            }
            if (values[i].equals("-")) {
                result = cal.sub(result, Integer.parseInt(values[i + 1]));
            }
            if (values[i].equals("*")) {
                result = cal.mul(result, Integer.parseInt(values[i + 1]));
            }
            if (values[i].equals("/")) {
                result = cal.div(result, Integer.parseInt(values[i + 1]));
            }
        }
        return result;
    }

    private void checkInputException() {
        if (!expressionIsOdd() || !isEvenPositionMatch(values) || !isOddPositionMatch(values)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    boolean expressionIsOdd() {
        return values.length % 2 == 0;
    }

    boolean isEvenPositionMatch(String[] values) {
        for (int i = 0; i < values.length; i += 2) {
            try {
                Integer.parseInt(values[i]);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    boolean isOddPositionMatch(String[] values) {
        for (int i = 1; i < values.length; i += 2) {
            if (!values[i].matches("[\\+\\-\\*\\/]")) {
                return false;
            }
        }
        return true;
    }

    void printResult(int calResult) {
        System.out.printf(makeResultSentence(calResult), calResult);
        System.out.println();
    }

    String makeResultSentence(int calResult) {
        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            sb.append(value);
            sb.append(" ");
        }
        sb.append(RESULT_MESSAGE);
        sb.append(calResult);
        return sb.toString();
    }


}
