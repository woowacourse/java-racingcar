package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_CAR_NAMES_ANNOUNCEMENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_ANNOUNCEMENT);
        String rawCarNames = scanner.nextLine();
        return Arrays.stream(rawCarNames.split(","))
                .collect(Collectors.toList());
    }

}
