package racinggame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import racinggame.domain.Name;
import racinggame.domain.Round;

public class InputView {

    private static final String DELIMITER = ",";
    private static final int MIN_ROUND = 1;

    private InputView() {
    }

    public static List<Name> readNames() {
        String inputNames = readLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<Name> names = Arrays.stream(inputNames.split(DELIMITER))
                .map(String::trim)
                .map(Name::from)
                .toList();

        checkCarNameSize(names);

        return names;
    }

    private static void checkCarNameSize(List<Name> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("자동차 이름은 최소 2대 이상 입력해야 합니다.");
        }
    }

    public static Round readRound() {
        String inputRound = readLine("시도할 회수는 몇회인가요?");

        return Round.from(Integer.parseInt(inputRound));
    }

    private static String readLine(String message) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(message);
        try {
            return br.readLine().trim();
        } catch (IOException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
