package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.next();
        return Arrays.stream(names.split(","))
                .collect(Collectors.toList());
    }

    public static int readTryTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
