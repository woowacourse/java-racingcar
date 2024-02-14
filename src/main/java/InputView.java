import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> readCarNames() {
        String input = sc.nextLine();
        return Arrays.stream(input.split(","))
                .toList();
    }

    public static int readRoundNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
        while (true) {
            try {
                int number = sc.nextInt();
                if (number < 1) {
                    throw new InputMismatchException();
                }
                return number;
            } catch (InputMismatchException e) {
                System.out.println("자연수를 입력해주세요.");
            }
        }
    }
}