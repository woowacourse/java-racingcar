package view;

import java.util.Scanner;

public class Input {
    static final String DELIMETER = ",";
    
    Validate validate;
    Scanner sc;

    public Input() {
        validate = new Validate();
        sc = new Scanner(System.in);
    }

    public String getInput() {
        return sc.nextLine();
    }

    public String[] getCarNames(String input) {
        String[] carNames = input.split(DELIMETER);
        validate.isValidCarNames(carNames);
        return carNames;
    }

    public int getTryCount(String input) {
        validate.checkDigits(input);
        int tryCount = Integer.parseInt(input);
        validate.checkRange(tryCount);
        return tryCount;
    }
}
