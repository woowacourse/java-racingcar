package racingCar.view;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    public List<String> readCarNames() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] carNames = input.split(",");

        if (isEmpty(carNames)) {
            return Arrays.stream(carNames)
                    .collect(Collectors.toList());
        }
        throw new IOException();
    }

    private boolean isEmpty(String[] carNames) {
        if (carNames.length == 0) {
            return false;
        }
        return true;
    }
}
