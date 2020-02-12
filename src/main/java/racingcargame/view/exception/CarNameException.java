package racingcargame.view.exception;

import racingcargame.util.Spliter;
import racingcargame.view.InputView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNameException {

    public static final Set<String> CAR_NAMES = new HashSet<>();
    public static final int NAME_MAX_LENGTH = 5;
    public static final String BLANK = "";

    private  static void validOneCar() {
        if (CAR_NAMES.size() == 1) {
            throw new RuntimeException("하나의 자동차만 입력되었습니다.");
        };
    }

    public static void valid(String[] input) {
        addName(input);
        try {
            for (String name : CAR_NAMES) {
                checkBlankInput(name);
                isExceededMaxLength(name);
            }
            validOneCar();
            isDuplicatedNames(input);
        } catch(RuntimeException e) {
            InputView.inputCarNames();
        }
    }

    private static void addName(String[] input) {
        CAR_NAMES.addAll(Arrays.asList(input));
    }

    private static void  isDuplicatedNames(String[] input) {
        for (String name : input) {
            if (CAR_NAMES.contains(name)) {
                throw new RuntimeException("중복된 이름을 가지고 있습니다.");
            }
        }
    }

    private static void isExceededMaxLength(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new RuntimeException("길이 최대치를 초과하는 이름을 가지고 있습니다.");
        }
    }

    private static void checkBlankInput(String name) {
        if (BLANK.equals(name)) {
            throw new RuntimeException("공백 이름을 가지고 있습니다.");
        }
    }
}
