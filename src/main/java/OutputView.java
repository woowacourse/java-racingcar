import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행결과";
    private static final String CAR_NAME_FORMAT = " : ";
    private static final String MOVEMENT = "-";
    private static final String END_MESSAGE = "가 최종 우승했습니다.";
    private static final String DIVISION_CHAR = ",";

    public void printStatus(String carName, int position) {
        System.out.print(carName + CAR_NAME_FORMAT);
        for (int index = 0; index < position; index++) {
            System.out.print(MOVEMENT);
        }
        System.out.println();
    }

    public void resultMessage() {
        System.out.println(RESULT_MESSAGE);
    }


    public void printWinners(List<String> winners) {
        System.out.println(winnerFormat(winners) + END_MESSAGE);
    }

    private String winnerFormat(List<String> winners) {
        return String.join(DIVISION_CHAR, winners);
    }
}
