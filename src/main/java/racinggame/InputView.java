package racinggame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import racinggame.domain.Car;
import racinggame.domain.Round;

class InputView {

    private InputView() {
    }

    public static List<Car> readNames() throws IOException {
        String inputNames = readLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> carNames = Arrays.asList(inputNames.split(","));

        return carNames.stream()
            .map(Car::createDefault)
            .toList();
    }

    public static Round readRound() throws IOException {
        String inputRound = readLine("시도할 회수는 몇회인가요?");

        return new Round(Integer.parseInt(inputRound));
    }

    private static String readLine(String message) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(message);
        return br.readLine().trim();
    }
}
