package racinggame.domain;

import racinggame.view.InputView;

public class Repeat {
    public static final String NUMBER_FORMAT_ERROR_MESSAGE = "횟수는 정수만 " +
            "가능합니다.";
    public static final String NOT_POSITIVE_ERROR_MESSAGE = "횟수는 1이상의" +
            " 정수만 가능합니다.";
    private final int repeat;

    public Repeat(){
        this(InputView.inputRepeat());
    }

    public Repeat(int repeat){
        this.repeat = repeat;
    }

    public Repeat(String repeat){
        this(validateRepeat(repeat));
    }

    private static int validateRepeat(String repeat) {
        try {
            int parseRepeat = Integer.parseInt(repeat);
            validateRepeatPositive(parseRepeat);
            return parseRepeat;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void validateRepeatPositive(int repeat) {
        if (repeat <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
    public int getRepeat() {
        return repeat;
    }
}
