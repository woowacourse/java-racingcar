package cal;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public Numbers inputNumbers() {
        System.out.println("문자열을 입력하세요,");
        String[] string = scanner.nextLine().split(" ");
        Numbers numbers;

        try {
            numbers = new Numbers(string);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return inputNumbers();
        }
        return numbers;
    }
}
