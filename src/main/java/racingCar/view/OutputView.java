package racingCar.view;

public class OutputView {
    private static final String RESULT_HEAD = "실행 결과";
    private static final String INVALID_NAME_WARNING = "각 이름의 길이를 1 이상 5 이하로 입력해주세요.";

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    private static void printRoundResult(Players players) {
        for (Player player : players.getUnmodifiableList()) {
            System.out.println(player.getName() + COLON_WRAPPED_WITH_SPACE + getHyphens(player));
        }
    }

    public static void printWinners(Players players) {
        System.out.println();
        System.out.print(PRINT_WINNERS_HEAD);
        System.out.print(createWinnerList(players));
        System.out.println(PRINT_WINNERS_TAIL);
    }

    private static String createWinnerList(Players players) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Player player : players.getWinners()) {
            stringBuilder.append(player.getName())
                    .append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());

        return stringBuilder.toString();
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

    private static void printRoundNum(int round) {
        if (round == 0) {
            System.out.println(ROUND_START_TEXT);
            return;
        }
        System.out.println(round + ROUND_TAIL);
    }

    public static void printInvalidNameWarning() {
        System.out.println(INVALID_NAME_WARNING);
    }

    public static void printRoundResultWithRoundNum(int roundNum, Players players) {
        System.out.println();
        printRoundNum(roundNum);
        printRoundResult(players);
    }
}
