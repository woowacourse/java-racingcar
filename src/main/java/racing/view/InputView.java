package racing.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static String[] inputCarNames(){
        OutputView.printInputCarNamesMessage();
        return scanner.nextLine()
                .split(DELIMITER);
    }

    public static String inputTrialTime() {
        OutputView.printInputTrialTimeMessage();
        return scanner.nextLine();
    }
}


