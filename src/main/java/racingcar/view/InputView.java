package racingcar.view;

import java.util.Scanner;

public class InputView {

    private final Scanner sc = new Scanner(System.in);
    public String inputCarName() {
        System.out.println(OutputView.INPUT_CAR_NAME);
        String input = sc.nextLine();
        return input;
    }
}
