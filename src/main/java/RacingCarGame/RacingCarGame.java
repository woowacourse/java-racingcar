package RacingCarGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarGame {
    public void run() {
        boolean nameProgress = true;
        final Scanner scanner = new Scanner(System.in);
        while (nameProgress) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

                String rawCarNames = scanner.nextLine();

                if (rawCarNames == null || rawCarNames.isEmpty()) {
                    throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다. 다시 입력해주세요.");
                }
                // "포비,,브라운"
                String[] carNames = rawCarNames.split(",");
                List<String> finalCarNames = new ArrayList<>();
                for (String carName : carNames) {
                    if (carName.length() <= 0 || carName.length() > 5) {
                        throw new IllegalArgumentException("올바르지 않는 자동차 이름입니다. 다시 입력해주세요.");
                    }
                    finalCarNames.add(carName.trim());
                }
                nameProgress = false;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        int count;
        boolean countProgress = true;
        while(countProgress) {
            try {
                System.out.println("시도할 횟수는 몇회인가요?");
                String rawCount = scanner.nextLine();
                if(rawCount == null || rawCount.isEmpty()) {
                    throw new IllegalArgumentException("올바르지 않은 횟수 입력입니다.다시 입력해주세요.");
                }
                count = Integer.parseInt(rawCount);
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }

        }
    }
}
