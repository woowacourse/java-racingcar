package racinggame.domain.car;

import racinggame.domain.data.GameStatus;

public class Car {
    private final String name;
    private Position position;

    /**
     * START_POSITION은 Car 클래스 생성 시 기본 position 값으로 설정되는 정수형 상수이다.
     */
    private static final int START_POSITION = 0;

    public Car(String name) {
        this(name, START_POSITION);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = new Position(position);
    }

    public void accelerate() {
        position.accelerate();
    }

    public boolean match(int position) {
        return this.position.match(position);
    }

    public void passingLog(GameStatus gameStatus) {
        gameStatus.updateCarStatus(name, position.getPosition());
    }
}
