package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String DELIMITER = ",";
    public static final String FORMAT_OF_NUMBER = "\\d+";
    private final Scanner scanner;
    private final OutputView outputView;

    public InputView(Scanner scanner, OutputView outputView) {
        this.scanner = scanner;
        this.outputView = outputView;
    }

    public List<String> readCarNames() {
        outputView.printCarNameInputGuide();

        String carNamesContent = scanner.nextLine();
        validateCarNames(carNamesContent);

        return Arrays.asList(carNamesContent.split(DELIMITER));
    }

    public int readGameRound() {
        outputView.printGameRoundGuide();

        String gameRoundContent = scanner.nextLine();
        validateGameRound(gameRoundContent);

        return Integer.parseInt(gameRoundContent);
    }

    private void validateCarNames(String content) {
        if (content.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    private void validateGameRound(String content) {
        if (!content.matches(FORMAT_OF_NUMBER)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력이 가능합니다.");
        }
    }
}
