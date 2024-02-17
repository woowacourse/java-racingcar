package racingcar.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private InputView() {
    }

    public static List<String> inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = new Scanner(System.in).nextLine();
        return Arrays.stream(input.split(","))
                .toList();
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException exception) {
            throw new IllegalArgumentException("시도 횟수는 숫자이어야 합니다.");
        }
    }
}
