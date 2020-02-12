package racingcar.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public String getCarNames() {
        String input = "";
        try{
            input = enterCarNames();
        } catch (Exception e){
            System.err.println(e.getMessage());
            getCarNames();
        }
        return input;
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
