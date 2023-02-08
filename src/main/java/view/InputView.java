package view;

import java.io.IOException;

import util.InputUtil;

public class InputView {

    public String readCarNames() throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return InputUtil.readLine();
    }

    public String readMovingTrial() throws IOException {
        System.out.println("시도할 회수는 몇회인가요?");

        return InputUtil.readLine();
    }
}
