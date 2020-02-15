package racinggame.domain.data;

public class Repeat {
    private int repeat;
    private static final String NUMBER_FORMAT_ERROR_MESSAGE = "횟수는 정수만 가능합니다.";
    private static final String NOT_POSITIVE_ERROR_MESSAGE = "횟수는 1이상의 정수만 가능합니다.";

    public Repeat(String repeat) {
        this.repeat = validateRepeat(repeat);
    }

    public boolean isLoopDone(int repeat) {
        return repeat < this.repeat;
    }

    /**
     * validateRepeat 는 반복횟수 값에 대한 예외처리 사항을 확인하여 문제 시 예외를 발생시킨다.
     * Input의 필드에 있는 repeat 값이 정수값이 아니어서 parseInt가 불가한 경우가 이에 해당한다.
     */
    private int validateRepeat(String inputRepeat) {
        try {
            int repeat = Integer.parseInt(inputRepeat);
            validateRepeatPositive(repeat);
            return repeat;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    /**
     * validateRepeatPositive 는 반복횟수 값에 대한 예외처리 사항을 확인하여 문제 시 예외를 발생시킨다.
     * 만약 반복 횟수가 0이나 음수일 경우, 이는 비정상적인 값으로 판단되어 메서드에서 예외를 발생시킨다.
     */
    private void validateRepeatPositive(int inputRepeat) {
        if (inputRepeat <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
}
