package view;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();
        List<String> name = Arrays.stream(names.split(","))
                .collect(Collectors.toList());
        validateListIsNotEmpty(name);
        return name;
    }

    private void validateListIsNotEmpty(List<String> input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 1개 이상 입력해주세요.");
        }
    }

    public int readTryTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextInt();
    }
}
