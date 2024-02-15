import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static List<String> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();
        if (isFinishWithDelimiter(input)) {
            throw new IllegalArgumentException("잘못된 이름입니다.");
        }
        return Arrays.stream(input.split(","))
                .toList();
    }

    private static boolean isFinishWithDelimiter(String input) {
        Pattern finishWithDelimiterRegex = Pattern.compile(".*,$");
        return finishWithDelimiterRegex.matcher(input).matches();
    }

    public static int readRoundNumber() {
        System.out.println("시도할 횟수는 몇회인가요?");
        int number;
        try {
            number = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("자연수를 입력해 주세요.");
        }

        if (number < 1) {
            throw new IllegalArgumentException("자연수를 입력해 주세요.");
        }
        return number;
    }
}