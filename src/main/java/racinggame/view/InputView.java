package racinggame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import racinggame.domain.Cars;
import racinggame.domain.Round;

public class InputView {

    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static Cars readCars() {
        String inputNames = readLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> carNames = Arrays.stream(inputNames.split(DELIMITER))
                .map(String::trim)
                .toList();

        return Cars.of(Objects.requireNonNull(carNames));
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
