package racing.view;

import java.util.Scanner;

public class InputView {
    private static final String ENTER_TRYCOUNT = "시도할 횟수는 몇회인가요?";
    private static final String ENTER_NAMES = "경주할 자동차 이름을 입력하세요(이름을 쉼표(,)를 기준으로 구분).";
    private final Scanner scanner = new Scanner(System.in);

    public String readNames() {
        System.out.println(ENTER_NAMES);
        return readLine();
    }

    public int readTryCount() {
        System.out.println(ENTER_TRYCOUNT);
        return readInt();
    }

    private String readLine() {
        String input = scanner.nextLine();
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private int readInt() {
        return Integer.parseInt(readLine());
    }
}
