package car.view;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private final Input input;
    public InputView(Input input){
        this.input = input;
    }
    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return input.inputCarNames().split(",");
    }

    public int inputTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(input.inputTrialCount());
    }
}
