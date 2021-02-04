package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class RacingGameController {
    private static final String INPUT_CARS_NAME_MSG = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String BLANK_INPUT_ERROR_MSG = "[ERROR] 공백을 입력할 수 없습니다.";
    private static final String SAME_NAME_ERROR_MSG = "[ERROR] 동일한 이름이 있습니다.";
    private static final String INPUT_NUMBER_OF_ROUNDS_MSG = "시도할 회수는 몇회인가요?";
    private static final String IS_NOT_NUMBER_ERROR_MSG = "[ERROR] 숫자를 입력해 주세요.";
    private static final String EXECUTE_RESULT_MSG = "실행 결과";
    private static final String COMMA = ",";
    private static final String BLANK = " ";

    public void start() {
        RacingGame racingGame = new RacingGame();

        createCars(racingGame);

        executeRound(racingGame);

        OutputView.output(racingGame.decideWinner());
    }

    private void createCars(RacingGame racingGame) {
        racingGame.makeCars(takeNameInput());
    }

    private void executeRound(RacingGame racingGame){
        int round = inputRound();
        OutputView.output(EXECUTE_RESULT_MSG);
        for (int i = 0; i < round; i++) {
            racingGame.playRound();
            OutputView.printLeaderBoard(racingGame.getCarsResponseDto());
        }
    }

    private List<String> takeNameInput(){
        OutputView.output(INPUT_CARS_NAME_MSG);
        String input = InputView.nextLine();
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

    private int inputRound(){
        OutputView.output(INPUT_NUMBER_OF_ROUNDS_MSG);
        try{
            return Integer.parseInt(InputView.nextLine());
        } catch(NumberFormatException e){
            throw new IllegalArgumentException(IS_NOT_NUMBER_ERROR_MSG);
        }
    }
}
