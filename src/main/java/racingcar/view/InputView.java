package racingcar.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public String[] getCarNames() {
        String input = "";
        try{
            input = enterCarNames();
        } catch (Exception e){
            System.err.println(e.getMessage());
            getCarNames();
        }
        return splitName(input);
    }

    public int getTrial() {
        String input = "";
        try {
            input = enterGameCounts();
        } catch (Exception e){
            System.err.println(e.getMessage());
            getTrial();
        }
        return Integer.parseInt(input);
    }

    private String enterGameCounts() throws Exception {
        OutputView.askGameCounts();
        String inputGameCounts = scanner.nextLine();
        ValidateInput.isNotNumber(inputGameCounts);
        return inputGameCounts;
    }

    private String enterCarNames() throws Exception {
        OutputView.askCarNames();
        String inputCarNames = scanner.nextLine();
        ValidateInput.isBlank(inputCarNames);
        checkCarNames(splitName(inputCarNames));
        return inputCarNames;
    }

    public static String[] splitName(String input) {
        String[] carNames = input.split(",");
        return carNames;
    }

    private static void checkCarNames(String[] carNames) throws Exception {
        for (String carName : carNames) {
            ValidateInput.isOverSixLetters(carName);
        }
    }
}
