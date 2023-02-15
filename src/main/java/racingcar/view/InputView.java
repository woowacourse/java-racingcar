package racingcar.view;

import racingcar.dto.CarNamesRequest;
import racingcar.dto.GameRoundRequest;
import racingcar.validator.CarValidator;
import racingcar.validator.DefaultCarValidator;
import racingcar.validator.DefaultGameRoundValidator;
import racingcar.validator.GameRoundValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.exception.ErrorMessages.INPUT_EXCEPTION;

public class InputView {
    private static final String SEPARATOR_REGEX = "\\s*,\\s";
    private static final String CAR_NAMES_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GAME_ROUND_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public CarNamesRequest inputCarName() {
        System.out.println(CAR_NAMES_INPUT_MESSAGE);
        String input = readLine();

        List<String> carNames = stringToListConverter(input);

        CarValidator carValidator = new DefaultCarValidator();
        carValidator.validateCarNames(carNames);

        return new CarNamesRequest(carNames);
    }

    public GameRoundRequest inputGameRound() {
        System.out.println(GAME_ROUND_INPUT_MESSAGE);
        String inputGameRound = readLine();

        GameRoundValidator gameRoundValidator = new DefaultGameRoundValidator();
        gameRoundValidator.validateGameRoundInput(inputGameRound);

        return new GameRoundRequest(stringToIntConverter(inputGameRound));
    }

    private String readLine() {
        String input;
        try {
            input = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(INPUT_EXCEPTION.getMessage());
        }
        return input;
    }

    public int stringToIntConverter(String input) {
        return Integer.parseInt(input);
    }

    public List<String> stringToListConverter(String input) {
        String[] splitInput = input.split(SEPARATOR_REGEX);
        return new ArrayList<>(Arrays.asList(splitInput));
    }
}
