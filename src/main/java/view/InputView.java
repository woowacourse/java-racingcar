package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String readCarNames() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String inputData = reader.readLine();
        // TODO: 입력값 검증
        return inputData;
    }

    public static Integer readNumberOfAttempts() throws IOException {
        System.out.println("시도할 회수는 몇회인가요?");
        final String inputData = reader.readLine();
        // TODO : 검증하며 우리가 원하는 Integer 리턴
        return Integer.parseInt(inputData);
    }

}
