package racingCar.view;

public class OutputView {
    private static final String RESULT_HEAD = "실행 결과";
    private static final String INVALID_NAME_WARNING = "각 이름의 길이를 1 이상 5 이하로 입력해주세요.";

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void printEachRound(Players players) {
        for (Player player : players.getUnmodifiableList()) {
            System.out.println(player.getName() + COLON_WRAPPED_WITH_SPACE + getHyphens(player));
        }
    }

    public static void printWinners(Players players) {
        System.out.println(PRINT_WINNERS_HEAD);
        for (Player player: players.getWinners()) {
            System.out.println(FOUR_SPACE + player.getName());
        }
        System.out.println(PRINT_WINNERS_TAIL);
    }

    private static String getHyphens(Player player) {
        return positionToHyphens(player.getPosition());
    }

    private static String positionToHyphens(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(HYPHEN);
        }
        return stringBuilder.toString();
    }

    public static void printRound(int round) {
        System.out.println(round + ROUND_TAIL);
    }

    public static void printInvalidNameWarning() {
        System.out.println(INVALID_NAME_WARNING);
    }
}
