package view;

import utils.Converter;
import utils.InputReader;
import vo.CarName;
import vo.Trial;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String EMPTY_INPUT_EXCEPTION_MESSAGE = "입력값은 비어있을 수 없습니다.";
    private final InputReader inputReader;

    public static final String ASKING_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).";
    public static final String SEPARATOR = ",";
    public static final String ASKING_TRIAL_MESSAGE = "시도할 횟수는 몇회인가요?";

    public InputView(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public List<CarName> getCarNames() {
        System.out.println(ASKING_CAR_NAMES_MESSAGE);
        String input = inputReader.readInput();
        List<CarName> carNames = CarName.of(
                Arrays.asList(input.split(SEPARATOR))
        );

        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(List<CarName> carNames) {
        hasNoNames(carNames);

        for (CarName carName : carNames) {
            isNameBlank(carName);
        }
    }

    private static void isNameBlank(CarName carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static void hasNoNames(List<CarName> carNames) {
        if (carNames.size() == 0) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public Trial getTrial() {
        System.out.println(ASKING_TRIAL_MESSAGE);
        String input = inputReader.readInput();
        return Trial.of(Converter.convertStringToLong(input));
    }
}
