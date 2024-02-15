import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();

        //TODO : 구분자로 끝나는 경우 예외 처리
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