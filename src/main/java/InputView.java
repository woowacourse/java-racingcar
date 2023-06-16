import java.util.Scanner;

public class InputView {
    static Scanner scanner = new Scanner(System.in);
    public int getCarNumber() {
        System.out.println("자동차 대수는 몇 대인가요?");
        int carNumber = scanner.nextInt();

        return carNumber;
    }

    public int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = scanner.nextInt();

        return tryCount;
    }
}
