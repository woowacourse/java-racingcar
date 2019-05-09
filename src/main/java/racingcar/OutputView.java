package racingcar;

public class OutputView {
    public static void printCarDistance(Car car) {
        System.out.print(car.getName() + ": ");
        for (int i = 0; i < car.getPosition(); ++i) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
