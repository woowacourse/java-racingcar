package view;

public class OutputView {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_ROUND = "시도할 회수는 몇회인가요?";
    private static final String ROUND_RESULT = "실행 결과";
    private static final String WINNING_MESSAGE = "가 최종 우승했습니다.";

    public static void printCarNames() {
        System.out.println(INPUT_CAR_NAMES);
    }

    public static void printRound() {
        System.out.println(INPUT_ROUND);
    }

    public static void printRoundResult() {
        System.out.println(ROUND_RESULT);
    }
}
