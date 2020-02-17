package racinggame.domain.car;

import racinggame.domain.data.GameStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    private static final Random random = new Random(System.currentTimeMillis());

    /**
     * RANDOM_NUMBER_BOUND는 랜덤값의 생성 범위를 지정하는 정수형 상수값이다.
     * 이 값이 변경될 수 있고, 기본적으로 레이싱 게임의 룰에 속해있는 값이므로
     * RacingGame 클래스 내에 존재하도록 설계하였다.
     */
    private static final int RANDOM_NUMBER_BOUND = 10;

    /**
     * FORWARD_NUMBER는 자동차의 가속 여부를 결정할 경계값을 지정하는 정수형 상수값이다.
     * 이 값이 변경될 수 있고, 기본적으로 레이싱 게임의 룰에 속해있는 값이므로
     * RacingGame 클래스 내에 존재하도록 설계하였다.
     */
    private static final int FORWARD_NUMBER = 4;

    public Cars() {
    }

    public static int generateRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public void add(Car car){
        cars.add(car);
    }

    public void moveCars(GameStatus gameStatus){
        for (Car car : cars) {
            car.accelerate(generateRandomNumber(), FORWARD_NUMBER);
            car.passingLog(gameStatus);
        }
    }
}
