package racingcar;

import java.util.List;

public class OutputView {
    public void printResult(List<Car> cars) {
        System.out.println("실행결과");
        for (Car car : cars) {
            System.out.println(car.getName() + ":" + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(String[] winners) {
        System.out.print(String.join(",", winners));
        System.out.println("가 최종 우승했습니다.");
    }
}
