package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    public static void printRequestCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printRequestTryCountMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printCar(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printCars(Cars cars) {
        cars.getCars().forEach(OutputView::printCar);
        System.out.println();
    }

    public static void printWinner(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
