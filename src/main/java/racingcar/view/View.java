package racingcar.view;

public class View {

    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_VIEW_TITLE_MESSAGE = "실행 결과";

    private static final View view = new View();

    private View() {
    }

    public static View getInstance() {
        return view;
    }

    public void printInputNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
    }

    public void printInputTryCountMessage() {
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
    }

    public void printResultViewTitle() {
        printBlankLine();
        System.out.println(RESULT_VIEW_TITLE_MESSAGE);
    }

    public void printExceptionMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public void printBlankLine() {
        System.out.println();
    }
}
