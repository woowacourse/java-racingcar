package racingcar.model;

import racingcar.message.ErrorMessage;

public class Round {

    private int value;

    public Round(int value) {
        this.value = value;
    }

    public static Round from(final String source) {
        try {
            final int value = Integer.parseInt(source);
            if (value < 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND.get());
            }
            return new Round(value);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND.get());
        }
    }

    public boolean isContinue() {
        return value > 0;
    }

    // TODO: 괜찮은 이름 찾기
    public void progress() {
        if (!isContinue()) {
            //TODO: 이 예외 처리 고민해보기
            // 사용자 입장에선 발생할 수 없는 예외
            throw new IllegalStateException(ErrorMessage.INVALID_ROUND.get());
        }
        value--;
    }
}
