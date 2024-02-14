package RacingCarGame;

import java.util.Scanner;

public class RacingCarGame {
    public void run() {
        boolean flag = true;
        while (flag) {
            try {
                final Scanner scanner = new Scanner(System.in);
                String rawCarNames = scanner.nextLine();
                if (rawCarNames == null || rawCarNames.isEmpty()) {
                    throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다. 다시 입력해주세요.");
                }

                String[] carNames = rawCarNames.split(",");
                flag = false;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        // "포비,,브라운"
    }
}
