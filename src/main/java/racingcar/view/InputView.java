package racingcar.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> names = filterTypos(input.nextLine());
        if (areInvalidNames(names)) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return inputCarNames();
        }
        return names;
    }

    public static List<String> filterTypos(String arg) {
        return new ArrayList<>(
                Arrays.stream(arg.split(","))
                .filter(x -> (!x.equals("")) && (!x.equals(" ")) && (!x.equals(",")))
                .map(x -> x.trim())
                .collect(Collectors.toList())
        );
    }
    private static boolean areInvalidNames(List<String> names) {
        return names.size() < 2
                || names.size() != new HashSet<>(names).size()
                || names.stream().map(x -> x.length() > 5).reduce(false, (x, y) -> x || y);
    }

    public static int inputNumberOfTrial() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int number = input.nextInt();
            if (number < 1) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                return inputNumberOfTrial();
            }
            System.out.println();
            return number;
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return inputNumberOfTrial();
        }
    }
}