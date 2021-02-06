package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    private static final String IS_NOT_NUMBER_ERROR_MSG = "[ERROR] 숫자를 입력해 주세요.";
    private static final String BLANK_INPUT_ERROR_MSG = "[ERROR] 공백을 입력할 수 없습니다.";
    private static final String SAME_NAME_ERROR_MSG = "[ERROR] 동일한 이름이 있습니다.";
    private static final String BLANK = " ";
    private static final String COMMA = ",";

    private static final Scanner scanner = new Scanner(System.in);
    public static final int ZERO = 0;

    public static String nextLine() {
        return scanner.nextLine();
    }

    public static CarsDto getCarsName() {
        OutputView.printInputCarsNameMessage();
        return createCarsDto(nextLine());
    }

    private static CarsDto createCarsDto(String input) {
        validateBlank(input);
        List<String> names = Arrays.asList(input.split(COMMA));
        validateDuplicate(names);
        return new CarsDto(names
                .stream()
                .map(name -> new CarDto(name, ZERO))
                .collect(Collectors.toList()));
    }

    public static int getNumberOfRounds(){
        OutputView.printInputNumberOfRoundsMessage();
        try {
            return Integer.parseInt(InputView.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_NUMBER_ERROR_MSG);
        }
    }

    private static void validateDuplicate(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (nameSet.size() != names.size()) {
            throw new IllegalArgumentException(SAME_NAME_ERROR_MSG);
        }
    }

    private static void validateBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException(BLANK_INPUT_ERROR_MSG);
        }
    }
}
