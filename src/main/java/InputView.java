import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> getCarName() {
        String input = scanner.nextLine();
        List<String> splitCarNames = new ArrayList<>();

        try {
            if (input.contains(" ")) {
                throw new IllegalArgumentException("입력에 공백이 포함될 수 없습니다.");
            }

            splitCarNames = List.of(input.split(","));

            for (String carName : splitCarNames) {
                if (carName.isEmpty() || carName.length() > 5) {
                    throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
                }
            }
            long distinctCarCount = splitCarNames.stream().distinct().count();
            if (distinctCarCount != splitCarNames.size()) {
                throw new IllegalArgumentException("중복된 자동차 이름은 사용할 수 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCarName();
        }

        return splitCarNames;
    }

    public int getTryCount() {
        String input = scanner.nextLine();
        int tryCount;
        try {
            tryCount = Integer.parseInt(input);
            if (tryCount <= 0) {
                throw new IllegalArgumentException("시도할 회수는 자연수를 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            System.out.println("시도할 회수는 숫자여야만 가능합니다.");
            return getTryCount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTryCount();
        }
        return tryCount;
    }
}
