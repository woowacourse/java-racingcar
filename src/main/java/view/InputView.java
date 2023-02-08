package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InputView {

    private static final String READ_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String READ_ATTEMPT_NUMBER_MESSAGE = "시도할 회수는 몇회인가요?";

    private BufferedReader br;

    public InputView() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readCarName() throws IOException {
        System.out.println(READ_CAR_NAME_MESSAGE);
        return br.readLine();
    }

    public int readAttemptNumber() throws IOException {
        System.out.println(READ_ATTEMPT_NUMBER_MESSAGE);
        return Integer.parseInt(br.readLine());
    }
}
