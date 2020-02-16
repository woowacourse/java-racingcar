package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Winners;

public class OutputView {
    public static final String DELIMTER = " : ";
    public static final String POSITION_MARK = "-";

    private OutputView() {
    }

    public static void askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void askTrial() {
        System.out.println("시도 횟수를 입력해주세요.");
    }

    public static void printCurrentResultTitle() {
        System.out.println("실행 결과");
    }

    private static void printCurrentPosition(Car car) {
        StringBuilder currentPosition = new StringBuilder(car.toString());
        currentPosition.append(DELIMTER);
        for (int i = 0; i < car.getPosition(); i++) {
            currentPosition.append(POSITION_MARK);
        }
        System.out.println(currentPosition);
    }

    public static void printIntermediateResult(Cars cars) {
        for (Car car : cars.getCars()) {
            OutputView.printCurrentPosition(car);
        }
        System.out.println();
    }

//    public static void printCurrentResult(String result) {
//        System.out.println(result);
//    }

    public static void printWinnerResult() {
        System.out.println(Winners.getWinners() + "가 최종 우승했습니다.");
    }

    public static void printErrorMessage(String errorMessage) {
        System.err.println(errorMessage);
    }

}
