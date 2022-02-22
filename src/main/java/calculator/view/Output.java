package calculator.view;

public class Output {
    private static void info(final String message) {
        System.out.println("[INFO] " + message);
    }

    public static void emptyValueOfSum() {
        info("빈 값은 0으로 바뀌어 계산됩니다.");
    }
}
