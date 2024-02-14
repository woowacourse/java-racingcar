package view;

import domain.Car;
import java.util.List;

public class OutputView {
    public static void printHeadLine() {
        System.out.println("실행 결과");
    }

    // TODO : 대쉬 반복 ..잘해보기
    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + ":" + repeatDash(car.getLocation()));
        }
    }
    private static StringBuilder repeatDash(int repeatCount) {
        StringBuilder dash = new StringBuilder();
        dash.append("-".repeat(Math.max(0, repeatCount)));
        return dash;
    }
}
