package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingGameController {
    private static final String COMMA = ",";
    private static final String BLANK = " ";
    private static final String BLANK_INPUT_ERROR_MSG = "[ERROR] 공백을 입력할 수 없습니다.";
    private static final String SAME_NAME_ERROR_MSG = "[ERROR] 동일한 이름이 있습니다.";

    public void start() {
        List<String> nameInput = takeNameInput();
        RacingGame racingGame = new RacingGame(nameInput);

        executeRound(racingGame);

        OutputView.announceWinners(racingGame.findWinners());
    }

    private void executeRound(RacingGame racingGame) {
        int round = InputView.getNumberOfRounds();
        OutputView.printResultMessage();
        for (int i = 0; i < round; i++) {
            racingGame.playRound();
            OutputView.printLeaderBoard(racingGame.getCarsResponseDto());
        }
    }

    private List<String> takeNameInput() {
        String input = InputView.getCarsName();
        validateBlank(input);
        List<String> names = Arrays.asList(input.split(COMMA));
        validateDuplicate(names);
        return names;
    }

    private void validateDuplicate(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException(SAME_NAME_ERROR_MSG);
        }
    }

    private void validateBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_INPUT_ERROR_MSG);
        }
    }
}
