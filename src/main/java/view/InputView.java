package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private InputView() {
    }

    public static List<String> inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = input();
        return Arrays.stream(input.split(","))
                .toList();
    }

    private static String input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (IOException exception) {
            throw new IllegalStateException("입력 단계에서 에러가 발생했습니다.");
        }
    }

    public static int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("시도 횟수는 숫자이어야 합니다.");
        }
    }
}
