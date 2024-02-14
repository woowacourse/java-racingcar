package view;

import domain.Car;
import java.util.List;

public class OutputView {

    public static void printResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printException(Exception exception) {
        System.out.println("[ERROR] " + exception.getMessage());
    }
}
