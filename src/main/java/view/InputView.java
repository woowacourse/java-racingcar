package view;

import message.Constant;
import util.Validator;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner reader;

    public InputView(InputStream readerConnector) {
        reader = new Scanner(readerConnector);
    }

    public List<String> carNames() {
        System.out.println(Constant.CAR_NAMES_HEADER);
        String carNames = reader.nextLine();
        Validator.validateCarNames(carNames.trim());
        List<String> carNamesBySplit = List.of(carNames.split(Constant.DELIMITER));

        return trimCarNames(carNamesBySplit);
    }

    private List<String> trimCarNames(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int numberOfTimes() {
        System.out.println(Constant.NUMBER_OF_TIME_HEADER);
        String number = reader.nextLine();
        Validator.validateNumberOfTimes(number);

        return Integer.parseInt(number);
    }
}
