package racing.view;

public class InputScreen implements Screen {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNTS_MESSAGE = "시도할 회수는 몇회인가요?";

    @Override
    public void showMessage() {
        OutputView.printMessage(INPUT_CAR_NAMES_MESSAGE);
    }

    public void showCountMessage() {
        OutputView.printMessage(INPUT_TRY_COUNTS_MESSAGE);
    }
}
