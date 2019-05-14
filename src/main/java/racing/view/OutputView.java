package racing.view;

public class OutputView {
    private static final String CARNAMES_ERROR = "입력형식이 틀렸습니다. 쉼표로 구분된 6자 미만의 이름들을 입력해 주세요.";
    private static final String ROUND_NUMBER_ERROR = "1 이상의 정수를 입력해 주세요.";
    private static final String NEW_LINE = "\n";

    public static void showNamesError() {
        System.out.println(CARNAMES_ERROR);
    }

    public static void showRoundNumError() {
        System.out.println(ROUND_NUMBER_ERROR);
    }

    public static void showRace() {
        System.out.println(NEW_LINE + "실행 결과");
    }

    public static void showCarsPosition(String result) {
        System.out.println(result);
    }

    public static void showChampion(String winner) {
        System.out.println(winner);
    }

}
