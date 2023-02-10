package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public List<String> inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = SCANNER.nextLine();
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());
    }

    public int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return inputNumber();
    }

    private int inputNumber() {
        String input = SCANNER.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 숫자여아합니다.");
        }
    }
}
