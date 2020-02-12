package racingGame;

import java.util.Arrays;
import java.util.List;

public class Input {
    private String names;
    private int repeat;

    public Input() {
        this.names = InputView.inputName();
        if (splitInput() == null) {
            throw new IllegalArgumentException("이름의 길이는 1자 이상, 5자 이하만 가능합니다.");
        }
        String stringRepeat = InputView.inputRepeat();
        this.repeat = parseIntRepeat(stringRepeat);
    }

    public Input(String inputName, String inputRepeat) {
        this.names = inputName;
        if (splitInput() == null) {
            throw new IllegalArgumentException("이름의 길이는 1자 이상, 5자 이하만 가능합니다.");
        }
        String stringRepeat = inputRepeat;
        this.repeat = parseIntRepeat(stringRepeat);
    }

    private int parseIntRepeat(String stringRepeat) {
        try {
            int intRepeat = Integer.parseInt(stringRepeat);
            validateInputNumberType(intRepeat);
            return intRepeat;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 정수만 가능합니다.");
        }
    }

    public static void validateInput(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 1자 이상, 5자 이하만 가능합니다.");
        }
    }

    public List<String> splitInput() {
        String[] splitName = names.split(",");
        List<String> list = Arrays.asList(splitName);
        validateInputList(list);
        return list;
    }

    public void validateInputList(List<String> values) {
        values.stream().forEach((x) -> Input.validateInput(x));
    }

    public void validateInputNumberType(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("횟수는 1이상의 정수만 가능합니다.");
        }
    }

}
