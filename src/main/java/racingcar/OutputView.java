package racingcar;

public class OutputView {
    public static void printCarDistance(Car car) {
        System.out.print(car.getName() + ": ");
        for (int i = 0; i < car.getPosition(); ++i) {
            System.out.print("-");
        }
        System.out.println();
    }
}
