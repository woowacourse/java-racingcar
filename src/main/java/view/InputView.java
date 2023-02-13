package view;

import utils.Converter;
import utils.InputReader;
import vo.CarName;
import vo.Trial;

import java.util.Arrays;
import java.util.List;

public class InputView {
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
        return CarName.of(
                Arrays.asList(input.split(SEPARATOR))
        );
    }

    public Trial getTrial() {
        System.out.println(ASKING_TRIAL_MESSAGE);
        String input = inputReader.readInput();
        return Trial.of(Converter.convertStringToLong(input));
    }
}
