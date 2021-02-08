package racingcar.view;

public class OutputView {
    private static final String ENTER_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).\n";
    private static final String ENTER_TRIAL_NUMBER = "시도할 회수는 몇회인가요?\n";
    private static final String OUTPUT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.\n";
    private static final String DASH = "-";
    private static final String STATUS_INDICATOR = " : ";

    public static void readCarName() {
        System.out.print(ENTER_CAR_NAME);
    }

    public static void readTrialNumber() {
        System.out.print(ENTER_TRIAL_NUMBER);
    }

    public static void printErrorMessage(final String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printOutputMessage() {
        System.out.println(OUTPUT_MESSAGE);
    }

    public static void printCarInformation(final String carName, final int carDistance) {
        StringBuilder carDistanceIndicator = new StringBuilder();
        for (int i=0 ;i<carDistance; i++) {
            carDistanceIndicator.append(DASH);
        }
        System.out.println(carName + STATUS_INDICATOR + carDistanceIndicator);
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinner(final String winnerResult) {
        System.out.print(winnerResult + WINNER_MESSAGE);
    }
}
