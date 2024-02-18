package racinggame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class InputView {

    public String readCars() throws IOException {
        return readLine("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public String readRound() throws IOException {
        return readLine("시도할 회수는 몇회인가요?");
    }

    private String readLine(String message) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(message);

        return Objects.requireNonNull(br.readLine()).trim();
    }
}
