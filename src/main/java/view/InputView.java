package view;

import message.Constant;
import util.Validator;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private Scanner console;

    public InputView(InputStream consoleConnector) {
        console = new Scanner(consoleConnector);
    }

    public List<String> carNames() {
        System.out.println(Constant.CAR_NAMES_HEADER);
        List<String> carNames = Arrays.asList(console.nextLine().split(Constant.DELIMITER));
        carNames = trimCarNames(carNames);
        Validator.carNames(carNames);

        return carNames;
    }

    private List<String> trimCarNames(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int numberOfTimes() {
        System.out.println(Constant.NUMBER_OF_TIME_HEADER);
        String number = console.nextLine();
        Validator.numberOfTimes(number);

        return Integer.parseInt(number);
    }
}
