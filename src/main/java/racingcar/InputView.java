package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static racingcar.InputValidator.*;

public class InputView {
    Scanner sc = new Scanner(System.in);
    final InputValidator inputValidator = new InputValidator();
    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String initialInput = sc.nextLine();
        inputValidator.validateIsBlank(initialInput);

        List<String> parseCarNames = parseCarName(initialInput);
        inputValidator.validateAvailableName(parseCarNames);
        return parseCarNames;
    }



    private List<String> parseCarName (String initialInput) {
        return Arrays.stream(Arrays.stream(initialInput.split(","))
                .map(String::trim)
                .toArray(String[]::new))
                .toList();
    }

}
