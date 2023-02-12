package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String requestDelimiter = ",";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> askCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNamesLine = scanner.nextLine();
        return Arrays.stream(carNamesLine.split(requestDelimiter))
                .collect(Collectors.toList());
    }

    public int askTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int trialCount = readInt();
        if (trialCount <= 0) {
            throw new IllegalArgumentException("시도할 회수는 자연수여야 합니다.");
        }
        return trialCount;
    }

    private int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력받은 값이 숫자가 아닙니다.");
        }
    }
}
