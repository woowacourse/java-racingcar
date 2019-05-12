package racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String names = requestString();
        try {
            validateNoConsecutiveCommas(names);
            List<String> splittedNames = Arrays.asList(names.split(","));
            validateNoDuplication(splittedNames);
            return splittedNames;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputNames();
        }
    }

    private static String requestString() {
        try {
            return scanner.nextLine();
        } catch (Exception e) {
            System.out.println("잘못된 문자열 입력입니다.");
            return requestString();
        }
    }

    private static boolean validateNoConsecutiveCommas(final String names) {
        if (names.contains(",,")) {
            throw new IllegalArgumentException("','가 두개 이상 연달아 있으면 안 됩니다.");
        }
        return true;
    }

    private static boolean validateNoDuplication(final List<String> names) {
        List<String> reducedNames = names.stream().distinct().collect(Collectors.toList());
        if (names.size() != reducedNames.size()) throw new IllegalArgumentException("중복된 이름이 존재하면 안됩니다.");
        return true;
    }

    public static int inputNumTrials() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            int numTrials = requestInteger();
            validateNaturalNumber(numTrials);
            return numTrials;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputNumTrials();
        }
    }

    private static int requestInteger() {
        try {
            int nums = Integer.parseInt(requestString());
            return nums;
        } catch (Exception e) {
            System.out.println("올바른 정수 입력이 아닙니다.");
            return requestInteger();
        }
    }

    private static boolean validateNaturalNumber(final int numTrials) {
        if (0 >= numTrials) {
            throw new IllegalArgumentException("시도 횟수는 자연수만 입력 가능합니다.");
        }
        return true;
    }
}
