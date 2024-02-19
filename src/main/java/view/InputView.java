package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String NAME_DELIMITER = ",";
    private static final String READ_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(%s)를 기준으로 구분).";
    private static final String READ_ROUND = "시도할 회수는 몇회인가요?";

    public List<String> readCarNames() throws IOException {
        System.out.println(String.format(READ_CAR_NAMES, NAME_DELIMITER));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return splitNames(bufferedReader.readLine());
    }

    private List<String> splitNames(String names) {
        String[] splitNames = names.split(NAME_DELIMITER);
        return Arrays.asList(splitNames);
    }

    public String readRound() throws IOException {
        System.out.println(READ_ROUND);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return bufferedReader.readLine();
    }
}
