package racinggame.domain.car;

import racinggame.domain.data.GameStatus;

/**
 * Car 클래스는 자동차 경주에 사용될 자동차의 정보값을 담는 클래스이다.
 * 현재 위치와 이름 값을 필드에 보유하고 있으며,
 * 추가로 static 변수인 winnerRecord을 가지고 있어
 * Car 클래스가 보유한 position값 중 제일 큰 position 값이 무엇인지 조회할 수 있다.
 */
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

    /**
     * accelerate 메서드는 랜덤한 값과 기준이 되는 값을 전달받아,
     * 랜덤한 값이 기준이 되는 값을 넘은 경우 position을 증가시킨다.
     * 또한 이 증가 메서드 호출 시, Car 인스턴스 전체에 공유되는 winnerRecord값을 갱신해준다.
     *
     * @param random 비교를 위한 임의의 정수형 변수이다.
     * @param bound  가속을 위한 비교의 기준값인 정수형 변수이다.
     */
    public void accelerate(int random, int bound) {
        if (random >= bound) {
            position.accelerate();
        }
    }

    public boolean match(int position) {
        return this.position.match(position);
    }

    /**
     * passingLog는 GameStatus 인스턴스를 전달받은 후, 현재 이 Car 인스턴스의 상태 기록을 업데이트하는 메서드이다.
     *
     * @param gameStatus 게임 상태값을 저장하는 Output 인스턴스이다.
     */
    public void passingLog(GameStatus gameStatus) {
        gameStatus.updateCarStatus(name, position.getPosition());
    }
}
