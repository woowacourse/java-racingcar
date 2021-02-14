package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {
    private static final String CAR_NAME_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String LAP_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";

    private OutputView() {
    }

    public static void showCarNameGuideMessage() {
        System.out.println(CAR_NAME_GUIDE_MESSAGE);
    }

    public static void showLapGuideMessage() {
        System.out.println(LAP_GUIDE_MESSAGE);
    }

    public static void showOneLapResult(Cars cars) {
        List<Car> RacingCars = cars.getCars();
        RacingCars.forEach(car ->
            System.out.println(car.getCarName() + " : " + buildPositionBar(car)));
        System.out.println();
    }

    public static void showResult() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void showWinners(Cars cars) {
        System.out.println(String.join(", ", cars.getWinners()) + "가 최종 우승했습니다.");
    }

    private static StringBuilder buildPositionBar(Car car) {
        StringBuilder positionBar = new StringBuilder();
        for (int i = 0; i < car.getPosition(); i++) {
            positionBar.append("-");
        }
        return positionBar;
    }

}