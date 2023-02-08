package racingcar;

import java.util.List;

public class RacingCarGame {

    private static final int MOVABLE = 4;

    public void moveCars() {
        List<Car> cars = CarRepository.findAll();
        for (Car car : cars) {
            // TODO : 랜덤 숫자 메소드 분리
            int randomNumber = getRandomNumber();
            if (isMovable(randomNumber)) {
                car.move();
            }
        }
    }

    private boolean isMovable(int randomNumber) {
        return randomNumber >= MOVABLE;
    }

    private int getRandomNumber() {
        // TODO : 0~9까지 설정 필요
        return (int) Math.random();
    }
}
