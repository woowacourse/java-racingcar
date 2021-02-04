package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

public class StringCalculator {
    public static int splitAndSum(String text) {

        if (isEmpty(text)) {
            return 0;
        }
        if(isOneDigit(text)){
            return Integer.parseInt(text);
        }
        List<String> tokens;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);   // group 1-> //랑 \n사이에 거를 딜리미터로 받고 (.) (.) 문자하나 아무거나
            tokens = Arrays.asList(m.group(2).split(customDelimiter));   //나머지 (.*)는 group2
            // 덧셈 구현
            return 1;
        }
        tokens = Arrays.asList(text.split(",|:"));
        int sum = 0;
//        tokens.stream().;

        //https://www.baeldung.com/java-stream-sum

        // java.util.regex 패키지의 Matcher, Pattern import

        //음수 전달 예외처리
        return 0;
    }

    public static boolean isEmpty(String text) {
        if (text == null) {
            return true;
        }
        if (text.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isOneDigit(String text){
        if(text.length() == 1 && Character.isDigit(text.charAt(0))){
            return true;
        }
        return false;
    }

    public static boolean isContainSeparator(String text){

        return false;
    }
}

//    요구사항
//    쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
//        앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
//        문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

//        프로그래밍 요구사항
//        indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
//        depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
//        메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
//        method가 한 가지 일만 하도록 최대한 작게 만들어라.
//        else를 사용하지 마라.
//