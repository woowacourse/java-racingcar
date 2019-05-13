package calculator;


import java.util.Arrays;
import java.util.List;

public class NumericExpression {
    static final String EXPRESSION_SEPERATOR = " ";
    static final String[] operators = {"+", "-", "*", "/"};

    private String expression;

    public NumericExpression(String input) throws Exception {
        checkInvalidExpression(Arrays.asList(input.split(EXPRESSION_SEPERATOR)));
        this.expression = input;
    }

    private void checkInvalidExpression(List<String> tokens) throws Exception {
        checkTokensAreEmpty(tokens);
        checkTokensEndWithOperator(tokens);
        checkInvalidToken(tokens);
    }

    private void checkTokensAreEmpty(List<String> tokens) throws Exception {
        if (tokens.size() == 0) {
            throw new Exception("빈 입력입니다! 다시 입력해주세요.");
        }
    }

    private void checkTokensEndWithOperator(List<String> tokens) throws Exception {
        if (Arrays.asList(operators).contains(tokens.get(tokens.size() - 1))) {
            throw new Exception("연산자로 끝나는 식은 허용하지 않습니다. 숫자로 끝나는 식을 써 주세요.");
        }
    }

    private void checkInvalidToken(List<String> tokens) throws Exception {
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            checkInvalidToken(token, i);
        }
    }

    private void checkInvalidToken(String token, int position) throws Exception {
        if (position % 2 == 1) {
            checkInvalidOperator(token);
            return;
        }
        checkInvalidOperand(token);
        return;
    }

    private void checkInvalidOperator(String token) throws Exception {
        if (Arrays.asList(operators).contains(token) == false) {
            throw new Exception("잘못된 연산자입니다. 다시 입력하세요");
        }
    }

    private void checkInvalidOperand(String token) throws Exception {
        try {
            int number = Integer.parseInt(token);
        } catch (Exception e) {
            throw new Exception("피연산자 값이 정수가 아닙니다. 다시 입력하세요.");
        }
    }


    @Override
    public String toString() {
        return expression;
    }
}
