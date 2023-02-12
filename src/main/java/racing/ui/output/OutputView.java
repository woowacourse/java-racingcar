package racing.ui.output;

import racing.domain.Cars;

import java.util.List;

public class OutputView {

    public static final String CANT_CONTAIN_SPACE = "자동차 이름에 공백이 포함될 수 없습니다.";
    public static final String UNSUITABLE_LENGTH = "자동차 이름은 1자~5자만 입력할 수 있습니다.";
    public static final String INPUT_ONLY_DIGIT = "시도 회수는 숫자만 입력할 수 있습니다.";
    public static final String FINAL_WINNER = "가 최종 우승했습니다.";
    private static final String EXECUTE_RESULT = "실행 결과";
    public static final String COLON = " : ";
    public static final String HYPHEN = "-";
    public static final String COMMA = ",";
    private static final String SPACE = " ";

    public static void printPhrase() {
        System.out.println();
        System.out.println(EXECUTE_RESULT);
    }

    public static void printProcessing(Cars cars) {
        cars.getPrintForm()
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printResult(Cars cars) {
        List<String> winners = cars.getWinners();
        System.out.println(makeWinnersPrintForm(winners));
    }

    private static String makeWinnersPrintForm(List<String> winners) {
        StringBuilder sb = new StringBuilder();
        for (String winnerName : winners) {
            sb.append(winnerName).append(COMMA + SPACE);
        }
        return sb.substring(0, sb.toString().length() - 2) + FINAL_WINNER;
    }
}
