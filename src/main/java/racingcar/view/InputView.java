package racingcar.view;

import racingcar.view.message.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String DELIMITER = ",";
    public static final String FORMAT_OF_NUMBER = "\\d+";
    private final Scanner scanner;
    private final OutputView outputView;

    public InputView(final Scanner scanner, final OutputView outputView) {
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

    private void validateCarNames(final String content) {
        if (content.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_ERROR_FOR_CAR_NAMES.getMessage());
        }
    }

    private void validateGameRound(final String content) {
        if (!content.matches(FORMAT_OF_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_ERROR_FOR_GAME_ROUND.getMessage());
        }
    }
}
