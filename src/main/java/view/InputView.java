package view;

import utils.Parser;
import validation.Validator;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GAME_TRIAL_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String DELIMITER = ",";
    private Scanner scanner = new Scanner(System.in);

    public List<String> readCars() {
        printMessage(CAR_NAME_INPUT_MESSAGE);
        String inputCars = scanner.nextLine();
        List<String> carNames = Parser.parse(inputCars, DELIMITER);
//        Validator.validateCarName(carNames);
        return carNames;
    }

    public int readGameTrial() {
        printMessage(GAME_TRIAL_INPUT_MESSAGE);
        String inputGameTrial = scanner.nextLine();
        Validator.validateTrialCount(inputGameTrial);
        return Integer.parseInt(inputGameTrial);
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
