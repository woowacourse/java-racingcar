import java.util.List;

public class OutputView {

    public static final String LOCATION_UNIT_MESSAGE = "-";

    public static void showRoundStart() {
        System.out.println("\n실행 결과");
    }

    public static void showRoundResult(List<Car> roundResult) {
        for (Car car : roundResult) {
            showCarLocation(car.getName(), car.getLocation());
        }
        System.out.println();
    }

    private static void showCarLocation(String name, int location) {
        System.out.println(name + " : " + LOCATION_UNIT_MESSAGE.repeat(location));
    }

    public static void showWinners(List<String> winnersName) {
        System.out.println(String.join(", ", winnersName) + "가 최종 우승했습니다.");
    }
}