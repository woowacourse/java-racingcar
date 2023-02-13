package racingcar.domain;

public class Car {
    public static final int START_POSITION_VALUE = 0;
    public static final int MIN_TRY_COUNT = 0;
    public static final int RANDOM_NUMBER_BOUNDARY = 10;
    public static final int FORWARD_BOUNDARY = 4;

    private final Name name;
    private int position;

    public Car(String name, int position) {
        validateStartPosition(position);
        this.name = new Name(name);
        this.position = position;
    }

    private void validateStartPosition(int position) {
        int startPosition = START_POSITION_VALUE;
        if (position != startPosition) {
            throw new IllegalArgumentException(String.format("[ERROR] 자동차의 시작 위치는 %d으로 설정되어야 합니다.", startPosition));
        }
    }

    public void validateCurrentPosition(int round) {
        if (this.position > round) {
            throw new IllegalArgumentException("[ERROR] 자동차의 현재 위치는 해당 라운드보다 클 수 없습니다.");
        }
    }

    public void increasePosition() {
        this.position++;
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
