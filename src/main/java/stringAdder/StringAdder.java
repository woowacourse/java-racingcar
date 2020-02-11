package stringAdder;

import java.util.List;

public class StringAdder {
    public static int add(String value) throws RuntimeException {
        Input input = new Input(value);
        int result = 0;
        List<String> values = input.splitInput();

        if(values == null){
            return 0;
        }
        for (String s : values) {
            try {
                int operand = Integer.parseInt(s);
                if (operand < 0) {
                    throw new RuntimeException("음수는 입력하실 수 없습니다.");
                }
                result += operand;
            }catch(NumberFormatException e){
                throw new RuntimeException("숫자 이외의 값은 입력하실 수 없습니다.");
            }
        }
        return result;
    }
}