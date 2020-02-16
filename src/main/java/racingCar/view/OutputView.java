package racingCar.view;

public class OutputView {
    private static final String RESULT_HEAD = "실행 결과";
    private static final String INVALID_NAME_WARNING = "각 이름의 길이를 1 이상 5 이하로 입력해주세요.";

    public static void printResultTitle() {
        System.out.println(RESULT_TITLE);
    }

    public static void printRoundNum(int round) {
        System.out.println();
        if (round == 0) {
            System.out.println(ROUND_START_TEXT);
            return;
        }
        System.out.println(round + ROUND_TAIL);
    }

    public static void printRoundResult(List<String> names, List<Integer> positions) {
        for (int i = ZERO_INDEX; i < names.size(); i++) {
            System.out.println(names.get(i) + COLON_WRAPPED_WITH_SPACE + positionToHyphens(positions.get(i)));
        }
    }

    public static void printWinners(List<String> names) {
        System.out.println();
        System.out.print(PRINT_WINNERS_HEAD);
        System.out.print(createWinnerList(names));
        System.out.println(PRINT_WINNERS_TAIL);
    }

    private static String createWinnerList(List<String> names) {
        return String.join(", ", names);
    }

    private static String positionToHyphens(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append(HYPHEN);
        }
        return stringBuilder.toString();
    }

    public static void printInvalidNameWarning() {
        System.out.println(INVALID_NAME_WARNING);
    }

    public static void printInvalidRoundNumWarning() {
        System.out.println(REINPUT_REQUEST_TEXT);
    }
}
