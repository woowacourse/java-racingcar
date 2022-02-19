package racingcar.model;

public class TrialNum {
    private final int trialNum;

    public TrialNum(int trialNum) {
        this.trialNum = trialNum;
    }

    public static TrialNum initTrialNum(String number) {
        return new TrialNum(convertToInteger(number));
    }

    private static int convertToInteger(String number) {
        validateTrialInput(number);
        return Integer.parseInt(number);
    }

    public boolean isTrialNumEqualCount(int count) {
        return trialNum == count;
    }

    public static void validateTrialInput(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자여야 합니다.");
        }
    }
}
