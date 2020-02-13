package racinggame.domain;

import racinggame.controller.Input;
import racinggame.controller.Output;
import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * RacingGame 클래스는 자동차 리스트를 만들어 경주를 진행하고 그 결과를 출력한다.
 * 클래스 메서드를 통해 수행되도록 설계되었다.
 */
public class RacingGame {
    /**
     * random은 난수값 생성을 위한 Random 객체의 인스턴스이다.
     */
    private static final Random random = new Random();
    /**
     * RANDOM_NUMBER_BOUND는 랜덤값의 생성 범위를 지정하는 정수형 상수값이다.
     */
    private static final int RANDOM_NUMBER_BOUND = 10;

    /**
     * FORWARD_NUMBER는 자동차의 가속 여부를 결정할 경계값을 지정하는 정수형 상수값이다.
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

    /**
     * generateRandom 메서드는 random 인스턴스를 통해 정해진 범위 내에서 정수형 난수값을 생성해 반환한다.
     *
     * @return 정수형의 난수 값을 반환한다.
     */
    public static int generateRandomNumber() {
        return random.nextInt(RANDOM_NUMBER_BOUND);
    }

    /**
     * play 메서드는 Input 인스턴스를 통해 입력값을 전달받아 Car 인스턴스의 리스트를 만든다.
     * 이후 이 값을 바탕으로 moveCars를 호출하여 cars에 소속된 Car 인스턴스들을 임의로 가속시킨다.
     * 이후 이를 바탕으로 output 인스턴스에 승자 목록을 만들 수 있도록 cars를 전달한다.
     * 이 과정에서 양식에 맞게 OutputView를 통한 포맷, 여백 출력 메서드를 호출한다.
     *
     * @param input  입력값을 저장하는 Input 인스턴스이다.
     * @param output 출력값을 저장하는 Output 인스턴스이다.
     */
    public static void play(Input input, Output output) {
        List<String> names = input.splitInputByComma();
        List<Car> cars = new ArrayList<>();
        int repeat = input.parseRepeatToInt();

        output.initCarStatus(names);
        names.stream().forEach(x -> cars.add(new Car(x)));
        OutputView.printResultFormat();
        moveCars(output, cars, repeat);
        output.makeWinnerNames(cars);
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
    private static void moveCars(Output output, List<Car> cars, int repeat) {
        for (int i = 0; i < repeat; i++) {
            cars.stream().forEach(car -> {
                car.accelarate(generateRandomNumber(), FORWARD_NUMBER);
                car.passingLog(output);
            });
            output.printLog();
        }
    }
}
