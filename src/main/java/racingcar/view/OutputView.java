package racingcar.view;

import racingcar.Car;
import racingcar.CarRepository;

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

    public static void showOneLapResult() {
        List<Car> RacingCars = CarRepository.getCars();
        RacingCars.forEach(System.out::println);
        System.out.println();
    }

    public static void showWinners() {
        System.out.println(String.join(", ", CarRepository.getWinners()) + "가 최종 우승했습니다.");
    }

    public static void showResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
