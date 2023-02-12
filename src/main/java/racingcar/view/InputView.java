package racingcar.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import static racingcar.exception.ErrorMessages.*;

public class InputView {
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GAME_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public List<String> inputCarNames() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String carNamesInput = null;

        try {
            carNamesInput = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(CAR_NAME_INPUT_EXCEPTION.getMessage());
        }

        List<String> carNames = splitByComma(carNamesInput);
        return carNames;
    }

    public int inputGameRound() {
        System.out.println(GAME_ROUND_INPUT_MESSAGE);
        String totalRoundInput = null;

        try {
            totalRoundInput = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(GAME_ROUND_INPUT_EXCEPTION.getMessage());
        }

        validateGameRound(totalRoundInput);
        int totalRound = Integer.parseInt(totalRoundInput);
        return totalRound;
    }

    private static List<String> splitByComma(String carNames) {
        String[] splitCarNames = carNames.split("\\s*,\\s*");
        return Arrays.asList(splitCarNames);
    }

    private void validateGameRound(String gameRound) {
        validateBlank(gameRound);
        validateInteger(gameRound);
        validateNotStartZero(gameRound);
    }

    private void validateBlank(String gameRound) {
        if (gameRound.isBlank()) {
            throw new IllegalArgumentException(GAME_ROUND_INPUT_BLANK_EXCEPTION.getMessage());
        }
    }

    private void validateInteger(String gameRound) {
        boolean isDigit = gameRound.chars().allMatch(Character::isDigit);
        if (!isDigit) {
            throw new IllegalArgumentException(GAME_ROUND_INPUT_FORMAT_DIGIT_EXCEPTION.getMessage());
        }
    }

    private void validateNotStartZero(String gameRound) {
        if (gameRound.charAt(0) == '0') {
            throw new IllegalArgumentException(GAME_ROUND_INPUT_FORMAT_ZERO_EXCEPTION.getMessage());
        }
    }
}
