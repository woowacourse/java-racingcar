package cal;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    final static int EVEN = 2;
    List<Integer> numberList = new ArrayList<>();
    List<Character> operatorList = new ArrayList<>();

    int add(int num1, int num2) {
        return num1 + num2;
    }

    int minus(int num1, int num2) {
        return num1 - num2;
    }

    int multiple(int num1, int num2) {
        return num1 * num2;
    }

    int divide(int num1, int num2) throws ArithmeticException {
        if (num2 == 0) {
            numberList.clear();
            operatorList.clear();
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return num1 / num2;
    }

    int calculate(String[] input) throws ArithmeticException {
        int num1 = 0;

        for (int i = 0; i < input.length; i++) {
            putList(input[i],i);
        }

        num1 = numberList.get(0);
        for(int i=0;i< numberList.size()-1; i++){
            int num2 = numberList.get(i+1);
            char operator = operatorList.get(i);
            num1 = subCalculate(num1, num2, operator);
        }

        return num1;
    }

    int subCalculate(int num1, int num2, char operator) throws ArithmeticException {// 이거 좋게 구현하는 힌트
        if(operator == '+') return add(num1,num2);

        if(operator == '-') return minus(num1,num2);

        if(operator == '*') return multiple(num1,num2);

        if(operator == '/') return divide(num1,num2);

        return -1;
    }

    void putList(String input, int index) {
        if (index % EVEN == 0) { // 숫자 인덱스
            numberList.add(Integer.parseInt(input));
            return;
        }
        operatorList.add(input.charAt(0));
        return;
    }
}
