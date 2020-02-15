package racingcar.domain;

public class Car {
    static final int INIT_POSITION = 0;

    private final Name name;
    private Position position;

    public Car(Name name) {
        if (RaceResult.EMPTY.equals(name.getName())) {
            throw new IllegalArgumentException("입력이 없는 이름이 있습니다.");
        }

        this.name = name;
        this.position = new Position(INIT_POSITION);
    }

    public void moveForward() {
        position.moveForward();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean matchesPosition(Position position) {
        return this.position.equals(position);
    }

    public String getName() {
        return name.getName();
    }
}