import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Input {
    Validate validate;
    Scanner sc;
    Output output;

    public Input() {
        validate = new Validate();
        sc = new Scanner(System.in);
        output = new Output();
    }

    public String[] inputNames() {
        output.printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();
        String[] carNames = input.split(",");
        validate.isValidCarNames(carNames);
        return carNames;
    }

    public int inputTryCount() {
        output.printMessage("시도할 회수는 몇회인가요?");
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
