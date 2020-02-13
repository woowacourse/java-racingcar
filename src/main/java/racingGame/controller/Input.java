package racingGame.controller;
import racingGame.view.InputView;

import java.util.Arrays;
import java.util.List;
public class Input {
    private String names;
    private String repeat;
    public Input() {
        this(InputView.inputName(), InputView.inputRepeat());
    }
    public Input(String inputName, String inputRepeat) {
        this.names = inputName;
        this.repeat = inputRepeat;
        validateInput();
        validateRepeat();
        validateRepeatPositive();
    }
    public List<String> splitInputByComma() {
        String[] splitName = names.split(",");
        List<String> list = Arrays.asList(splitName);
        return list;
    }
    public int parseRepeatToInt() {
        return Integer.parseInt(repeat);
    }
    private static void validateNameLength(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 1자 이상, 5자 이하만 가능합니다.");
        }
    }
    public void validateInput() {
        List<String> list = splitInputByComma();
        if (list == null) {
            throw new IllegalArgumentException("이름의 길이는 1자 이상, 5자 이하만 가능합니다.");
        }
        list.stream().forEach((x) -> Input.validateNameLength(x));
    }
    private void validateRepeat() {
        try {
            Integer.parseInt(repeat);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 정수만 가능합니다.");
        }
    }
    private void validateRepeatPositive() {
        int castingRepeat = parseRepeatToInt();
        if (castingRepeat <= 0) {
            throw new IllegalArgumentException("횟수는 1이상의 정수만 가능합니다.");
        }
    }
}