package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> requestCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNameLine = scanner.nextLine();
        validateCarNamesString(carNameLine);
        StringTokenizer tokenizer = new StringTokenizer(carNameLine, ",");
        List<String> carNames = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            carNames.add(tokenizer.nextToken());
        }
        return carNames;
    }

    private void validateCarNamesString(String carNameLine) {
        carNameLine.strip();
        if (Objects.isNull(carNameLine) || carNameLine.equals("")) {
            throw new IllegalArgumentException("입력된 차량 이름이 없습니다.");
        }
    }

    public int requestTrialCount() {
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
