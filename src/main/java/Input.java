import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    Validate validate;
    Scanner sc;

    public Input() {
        validate = new Validate();
        sc = new Scanner(System.in);
    }

    public String[] inputNames() {
        String input = sc.nextLine();
        String[] carNames = input.split(",");
        validate.isValidCarNames(carNames);
        return carNames;
    }

    public int inputTryCount() {
        String input = sc.nextLine();
        int tryCount = 0;
        try {
            validate.checkDigits(input);
            tryCount = Integer.parseInt(input);
            validate.checkRange(tryCount);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return tryCount;
    }
}
