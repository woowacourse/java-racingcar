package racingcar.view;

import racingcar.domain.Names;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static void getNames() {
        try {
            OutputView.askCarNames();
            String carNames = scanner.nextLine();
            new Names(carNames);
        } catch(IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            getNames();
        }
    }
/*
    public int getTrial() {
        String input = "";
        try {
            input = enterTrial();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            getTrial();
        }
        return Integer.parseInt(input);
    }

    private String enterTrial() throws Exception {
        OutputView.askGameCounts();
        String inputGameCounts = scanner.nextLine();
        ValidateInput.isNotNumber(inputGameCounts);
        return inputGameCounts;
    }

 */
}
