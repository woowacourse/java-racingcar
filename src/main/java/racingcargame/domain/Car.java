package racingcargame.domain;

public class Car {
    private static final int CAR_NAME_LIMIT = 5;
    private static final int FORWARD_THRESHOLD = 4;
    private static final int INITIAL_POSITION = 0;

    private String name;
    private Position position;

    public Car(String name) {
        if ((name == null) || (name.isEmpty())) {
            throw new IllegalArgumentException("빈 값을 입력하지 마세요.");
        }
        if (name.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException("5자 이내만 입력 가능합니다.");
        }
        this.name = name;
        this.position = new Position(INITIAL_POSITION);
    }

    public void move(int value) {
        if (value >= FORWARD_THRESHOLD) {
            position.move();
        }
    }

    public boolean isSamePosition(int positionNumber) {
        return position.isSame(positionNumber);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }
}
