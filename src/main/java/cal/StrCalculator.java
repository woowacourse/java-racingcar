package cal;

import java.util.Scanner;

public class StrCalculator {
    private static final String INPUT_REQUEST_MESSAGE = "수식을 입력하세요 !";
    private static final String INPUT_ERROR_MESSAGE = "수식을 확인해주세요 !";
    private static final String RESULT_MESSAGE = "의 결과는 ";

    private Scanner sc = new Scanner(System.in);

    String[] input() {
        try{
            System.out.println(INPUT_REQUEST_MESSAGE);
            return checkInputException(splitExpression(checkIsEmpty(sc.nextLine())));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return input();
        }
    }

    String[] splitExpression(String expression) {
        checkIsEmpty(expression);
        return expression.split(" ");
    }

    String checkIsEmpty(String exp) {
        String tempExp = exp;
        tempExp.trim();
        if(tempExp.length() == 0) {
            throw new IllegalArgumentException("빈 공식은 허용할 수 없습니다 !");
        }
        return exp;
    }
    private String[] checkInputException(String[] exp) {
        if (!isEvenPositionMatch(exp) || !isOddPositionMatch(exp)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
        return exp;
    }

    int calculate(String[] values) {
        Calculator cal = new Calculator();
        int result = Integer.parseInt(values[0]);

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

    boolean expressionIsOdd(String[] exp) {
        return exp.length % 2 == 0;
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
            if (values[i] == null || !values[i].matches("[\\+\\-\\*\\/]")) {
                return false;
            }
        }
        return true;
    }

    void printResult(String[] exp,int calResult) {
        System.out.printf(makeResultSentence(exp,calResult), calResult);
        System.out.println();
    }

    String makeResultSentence(String[] exp, int calResult) {
        StringBuilder sb = new StringBuilder();
        for (String value : exp) {
            sb.append(value);
            sb.append(" ");
        }
        sb.append(RESULT_MESSAGE);
        sb.append(calResult);
        return sb.toString();
    }

}
