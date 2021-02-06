package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingGameController {
    private static final String DUPLICATE_NAME_ERROR_MESSAGE = "[ERROR] 동일한 이름이 있습니다.";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 공백을 입력할 수 없습니다.";
    private static final String NOT_NUMBER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해 주세요.";
    private static final String COMMA = ",";
    private static final String BLANK = " ";

    public void start() {
        List<String> nameInput = takeNameInput();
        RacingGame racingGame = new RacingGame(nameInput);

        executeRound(racingGame);

        OutputView.announceWinners(racingGame.findWinners());
    }

    private void executeRound(RacingGame racingGame) {
        int round = inputRound();
        OutputView.printResultMessage();
        for (int i = 0; i < round; i++) {
            racingGame.playRound();
            OutputView.printLeaderBoard(racingGame.getCarsResponseDto());
        }
    }

    private List<String> takeNameInput() {
        OutputView.printCarNameInputRequestMessage();
        String input = InputView.nextLine();
        validateBlank(input);
        List<String> names = Arrays.asList(input.split(COMMA));
        validateDuplicate(names);
        return names;
    }

    private void validateDuplicate(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAME_ERROR_MESSAGE);
        }
    }

    private void validateBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    private int inputRound() {
        OutputView.printNumberOfRoundsInputRequestMessage();
        try {
            return Integer.parseInt(InputView.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR_MESSAGE);
        }
    }
}
