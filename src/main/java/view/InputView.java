package view;

import message.Constant;
import message.Error;
import util.Validator;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private Scanner scanner;

    public InputView(InputStream in) {
        scanner = new Scanner(in);
    }

    public List<String> carNames() {
        System.out.println(Constant.CAR_NAMES_MENTION);
        List<String> carNames = Arrays.asList(scanner.nextLine().split(Constant.SEPARATOR));
        carNames = removeBlank(carNames);
        Validator.carNames(carNames);

        return carNames;
    }

    private List<String> removeBlank(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int numberOfTimes() {
        System.out.println(Constant.NUMBER_OF_TIME_MENTION);
        int number;

        try {
            number = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(Error.NON_NUMBER_ERROR);
        }

        Validator.numberOfTimes(number);

        return number;
    }
}
