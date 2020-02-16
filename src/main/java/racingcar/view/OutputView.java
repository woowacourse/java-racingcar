package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final int START_POSITION = 0;

    private OutputView() {
    }

    public static void printRoundResult(List<Car> racingCars) {
        StringBuilder trace;

        for(Car car:racingCars) {
            trace = addTrace(car);
            System.out.println(car.getName() + ": " + trace.toString());
        }
    }

    public static void printWinners(List<String> winners) {
        String winner = String.join(",", winners);
        System.out.println(winner + "가 최종 우승했습니다.");
    }

    private static StringBuilder addTrace(Car car){
        StringBuilder trace = new StringBuilder();

        for (int i = START_POSITION; i < car.getPosition(); i++) {
            trace.append("-");
        }
        return trace;
    }

}
