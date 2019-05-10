package racing.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> requestNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = requestString();
        List<String> splittedNames = Arrays.asList(names.split(",")).stream()
                .map(s -> s.trim())
                .collect(Collectors.toList());
        try {
            validateNames(names);
            validateSplittedNames(splittedNames);
            return splittedNames;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return requestNames();
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

    private static boolean validateNames(final String userInput) {
        /** 연속된 "," 체크 */
        if (userInput.contains(",,")) {
            throw new IllegalArgumentException("','가 두개 이상 연달아 있으면 안 됩니다.");
        }

        return true;
    }

    private static boolean validateSplittedNames(final List<String> names) {
        /** 공백으로만 이루어진 이름 체크 */
        Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.length() == 0) {
                throw new IllegalArgumentException("이름이 공백으로만 이루어질 수 없습니다.");
            }
        }
        return true;
    }

    public static int requestNaturalNumber() {
        try {
            int nums = Integer.parseInt(requestString());
            checkValidateNaturalNumber(nums);
            return nums;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return requestNaturalNumber();
        }
    }

    private static boolean checkValidateNaturalNumber(final int numTrials) {
        if (0 >= numTrials) {
            throw new IllegalArgumentException("자연수만 입력 가능합니다.");
        }
        return true;
    }
}
