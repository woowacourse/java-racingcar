package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public List<String> askCarNames() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return parseCarNames(input);
    }

    private List<String> parseCarNames(String input) {
        return List.of(input.split(","));
    }
}
