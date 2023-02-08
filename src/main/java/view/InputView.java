package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public List<String> readCarNames() {
        String[] carNames = sc.nextLine().split(",");

        return Arrays.asList(carNames);
    }
}
