package racingcar.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String SEPARATOR = ",";

    private static final Scanner scanner = new Scanner(System.in);

    public List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        final String carNames = scanner.nextLine();
        return separate(carNames);
    }

    private List<String> separate(final String input) {
        if (input.endsWith(SEPARATOR)) {
            throw new IllegalArgumentException("[ERROR] 구분자로 끝날 수 없습니다.");
        }

        return Arrays.stream(input.split(SEPARATOR))
                .toList();
    }


    public String readTryRound() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextLine();
    }
}
