package racingcar.domain;

import java.util.regex.Pattern;

public class Car {
    private static final Pattern IS_CONSIST_OF_KOREAN_OR_ALPHA = Pattern.compile("[a-zA-Z가-힣]*$");
    private static final int NAME_LENGTH_LIMIT = 5;

    private String name;
    private int position;

    public Car(final String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void carMove() {
        this.position++;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean isWinnerPosition(int winnerPosition) {
        return this.position == winnerPosition;
    }

    private void validateName(final String name) {
        if (isNullName(name) || isContainInvalidChar(name) || isExceedNameLength(name)) {
            throw new IllegalArgumentException("잘못된 자동차 이름입니다.");
        }
    }

    private boolean isNullName(final String name) {
        return "".equals(name);
    }

    private boolean isContainInvalidChar(final String name) {
        return !IS_CONSIST_OF_KOREAN_OR_ALPHA.matcher(name).matches();
    }

    private boolean isExceedNameLength(final String name) {
        return name.length() > NAME_LENGTH_LIMIT;
    }
}
