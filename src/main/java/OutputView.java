import java.util.List;

public class OutputView {
    public static void showCarLocation(String name, int location) {
        System.out.println(name + " : " + "-".repeat(location));
    }

    public static void showWinners(List<String> winnersName) {
        System.out.println(String.join(", ", winnersName) + "가 최종 우승했습니다.");
    }
}
