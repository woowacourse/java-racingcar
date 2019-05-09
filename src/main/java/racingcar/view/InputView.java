package racingcar.view;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    static final Scanner input = new Scanner(System.in);

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> namesList = filterTypos(input.next());
        if (areInvalidNames(namesList)) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return inputCarNames();
        }
        return namesList;
    }

    //프라이빗 -> 테스트 ??
    public List<String> filterTypos(String arg) {
        return new ArrayList<>(
                Arrays.stream(arg.split(","))
                .filter(x -> (!x.equals("")) && (!x.equals(" ")) && (!x.equals(",")))
                .map(x -> x.trim())
                .collect(Collectors.toList())
        );
    }
    public boolean areInvalidNames(List<String> namesList) {
        return namesList.isEmpty()
                || namesList.size() != new HashSet<>(namesList).size()
                || namesList.stream().map(x -> x.length() > 5).reduce(false, (x, y) -> x || y);
    }

    public int inputNumberOfTrial() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(input.next());
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            return inputNumberOfTrial();
        }
    }
}
