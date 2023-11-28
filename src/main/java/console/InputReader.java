package console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputReader {

    private static final Scanner sc = new Scanner(System.in);

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();
        return Arrays.stream(input.split(","))
                .map(String::strip)
                .collect(Collectors.toList());
    }

    public int readTryCount() {
        System.out.println("진행할 게임 횟수를 입력해주세요.");
        return sc.nextInt();
    }
}
