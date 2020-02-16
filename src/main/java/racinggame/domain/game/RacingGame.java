package racinggame.domain.game;

import racinggame.domain.data.Names;
import racinggame.domain.data.GameStatus;
import racinggame.domain.car.Car;
import racinggame.domain.data.Repeat;
import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * RacingGame 클래스는 자동차 리스트를 만들어 경주를 진행하고 그 결과를 출력한다.
 * 클래스 메서드를 통해 수행되도록 설계되었다.
 */
public class RacingGame {
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

    /**
     * 생성자 메서드는 private로 설정되어 호출될 수 없도록 하였다.
     * 이 클래스는 인스턴스 없이 실행될 것을 가정하여 설계되었기 때문이다.
     *
     * @throws AssertionError : 잘못된 선언이 발생할 경우 예외처리한다.
     */
    private RacingGame() {
        throw new AssertionError();
    }

    public static int generateRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    public static List<Car> initCars(Names names){
        List<String> splitName = names.splitNamesByComma();
        List<Car> cars = new ArrayList<>();

        for(String name : splitName){
            cars.add(new Car(name));
        }
        return cars;
    }

    /**
     * moveCars 메서드는 output, cars, repeat를 전달받아, repeat만큼 경주를 반복한다.
     * 이 과정에서 난수값을 생성해 Car 인스턴스의 move 메서드를 통해 전달하며, 이를 바탕으로 Car 인스턴스는 가속하거나 정지한다.
     * 이후 Car 인스턴스의 passingLog 메서드를 통해 자동차의 상태값을 output에 전달해준다.
     * 1번의 경주가 끝날 때마다, output을 통해 결과값 출력을 지시한다.
     *
     * @param output 출력값을 저장하는 Output 인스턴스이다.
     * @param cars   Car 객체를 저장하는 List 이다.
     * @param repeat 반복할 횟수를 저장하는 정수형 변수이다.
     */
    public static void moveCars(GameStatus gameStatus, List<Car> cars) {
        for(Car car : cars) {
            car.accelerate(generateRandomNumber(), FORWARD_NUMBER);
            car.passingLog(gameStatus);
        }
    }
}
