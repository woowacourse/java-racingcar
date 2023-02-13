package racingcar.domain;

public class Position {
    public static final int START_POSITION_VALUE = 0;

    private int position;

    public Position(int position) {
        validateStartPosition(position);
        this.position = position;
    }

    private void validateStartPosition(int position) {
        int startPosition = START_POSITION_VALUE;
        if (position != startPosition) {
            throw new IllegalArgumentException(String.format("[ERROR] 자동차의 시작 위치는 %d으로 설정되어야 합니다.", startPosition));
        }
    }

    public void validateCurrentPosition(int position, int round) {
        if (position > round) {
            throw new IllegalArgumentException("[ERROR] 자동차의 현재 위치는 해당 라운드보다 클 수 없습니다.");
        }
    }

    public void increasePosition() {
        this.position++;
    }

    public int getPosition() {
        return position;
    }
}
