import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
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