package calculator;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//함수 접근제어자 바뀌기
public class StringCalculator {
    private static final Set<String> OPERATORS = Stream.of("+", "-", "*", "/").collect(Collectors.toSet());
    private static final Pattern NUMBER_PATTERN = Pattern.compile("(^[0-9]*$)");

    int plus(int number, int totalnumber) {
        return totalnumber + number;
    }

    int minus(int number, int totalnumber) {
        return totalnumber - number;
    }

    int mul(int number, int totalnumber) {
        return totalnumber * number;
    }

    //private일때 test안되는데 어떻게 해야되는가?

    //예외처리를 하면 다시 함수로 가는게 나은지 아니면 함수로 그냥 끝내는게 나은지
    int div(int number, int totalnumber) {
        //예외를 여기서 할지 아니면 함수를 따로 만들어야 될지
        //여기서 0에 대한 처리를 해주는게 좋다
        //div밖에서 처리를하면 호출하는 쪽에서 항상 처리를 해줘야 됨으로 별로 좋지 않다.
        //할때마다 매번 해야 됨으로 실수를 하게될 빈도가 높아진다.

        //어차피 나누기 0을하면 예외가 발생하는데 굳이 다른 처리를 해주어야 되나?
        return totalnumber / number;
    }

    void caclulateManager(int number, int totalnumber) {

    }

    private int calculate(int number, int totalNumber, String operator) {
        if (operator.equals("+")) {
            return plus(number, totalNumber);
        }
        if (operator.equals("-")) {
            return minus(number, totalNumber);
        }
        if (operator.equals("*")) {
            return mul(number, totalNumber);
        }
        return div(number, totalNumber);
    }

    int getResult(String str) {
        String[] values = str.split(" ");
        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            result = calculate(Integer.parseInt(values[i + 1]), result, values[i]);
        }
        return result;
    }

    boolean checkInputValid(String value) {
        value = value.trim().replaceAll(" +", " ");
        String[] values = value.split(" ");
        try {
            checkEvenValue(values);
            checkOddValue(values);
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    //try를 2번이상 던져도 괜찮을까 ? -->그렇게 해도 별로 상관없는 코드다.
    //try를 안쓰고 boolean을 사용해서 그냥 depth 를 쓰는게 좋은걸까? --> 어떤거 쓰든지 별 상관없다.
    //현재 이 함수는 두 가지 기능(탐색,검사) 함으로 하나로 줄이자
//    private void checkIsNumber(String[] values) {
//        Pattern p = Pattern.compile("(^[0-9]*$)");
//        for (int i = 0; i < values.length; i += 2) {
//            Matcher m = p.matcher(values[i]);
//            if (m.find()) {
//                throw new IllegalArgumentException("숫자아님");
//            }
//        }
//    }
    private void checkEvenValue(String[] values) {
        for (int i = 0; i < values.length; i += 2) {
            try {
                checkNumber(values[i]);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    private void checkNumber(String value) {
        Matcher m = NUMBER_PATTERN.matcher(value);
        if (m.find()) {
            throw new IllegalArgumentException("숫자 아님");
        }
    }

    private void checkOddValue(String[] values) {
        for (int i = 1; i < values.length; i += 2) {
            try {
                checkOperator(values[i]);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    //상수 배열 만들어서 처리하고 , 한줄로 바꿔서 처리하자
//    private boolean checkOperator(String str) {
//        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
//
//        }
//        return false;
//    }
    private void checkOperator(String str) {
        if (OPERATORS.contains(str)) {
            throw new IllegalArgumentException("사칙 연산 아님");
        }
    }
}