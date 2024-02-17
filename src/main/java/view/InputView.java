package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public List<String> readCarNames() throws IOException {
        System.out.println(String.format("경주할 자동차 이름을 입력하세요(이름은 쉼표(%s)를 기준으로 구분).", CAR_NAME_DELIMITER));
        return splitNames(bufferedReader.readLine());
    }

    private List<String> splitNames(String names) {
        String[] splitNames = names.split(CAR_NAME_DELIMITER);
        return List.of(splitNames);
    }

    public String readRound() throws IOException {
        System.out.println("시도할 회수는 몇회인가요?");
        return bufferedReader.readLine();
    }
}
