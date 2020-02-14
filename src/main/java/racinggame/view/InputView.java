package racinggame.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    /* 인스턴스를 사용하지 않으므로 추가 */
    private InputView() {
    }

    public static String inputName() {
        OutputView.printNameFormat();
        return scanner.nextLine();
    }

    public static String inputRepeat() {
        OutputView.printRepeatFormat();
        return scanner.nextLine();
    }
}
