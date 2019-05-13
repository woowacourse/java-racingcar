package racing.view;

import racing.domain.Car;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputCarNames() {
        List<String> carNames;
        do {
            carNames = InputView.requestNames();
        } while (isValidNames(carNames));
        return carNames;
    }

    private static boolean isValidNames(List<String> names) {
        Iterator<String> it = names.iterator();
        if (isDuplicatedNames(names)) {
            return true;
        }
        while (it.hasNext()) {
            String s  = it.next();
            if (isOverLength(s) || isBlank(s)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isDuplicatedNames(final List<String> names) {
        List<String> reducedNames = names.stream().distinct().collect(Collectors.toList());
        if (names.size() != reducedNames.size()) {
            System.out.println("중복된 이름이 존재하면 안됩니다.");
            return true;
        }
        return false;
    }


    private static boolean isOverLength(String name) {
        if (name.length() > Car.NAME_MAX_LENGTH) {
            System.out.println("차 이름은 5자 이하여야 합니다.");
            return true;
        }
        return false;
    }

    private static boolean isBlank(String name) {
        /** 공백으로만 이루어진 이름 체크 */
        if (name.length() == 0) {
            System.out.println("이름이 공백으로만 이루어질 수 없습니다.");
            return true;
        }

        return false;
    }


    public static List<String> requestNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = requestString();
        List<String> splittedNames = Arrays.asList(names.split(",")).stream()
                .map(s -> s.trim())
                .collect(Collectors.toList());
        return splittedNames;
    }

    private static String requestString() {
        String inputString;
        do {
            inputString = scanner.nextLine();
        } while (isValidString(inputString));

        return inputString;
    }

    private static boolean isValidString(final String input) {
        if (isContinuousRest(input)) return true;
        return false;
    }

    private static boolean isContinuousRest(final String input) {
        /** 연속된 "," 체크 */
        if (input.contains(",,")) {
            return true;
        }
        return false;
    }


    public static int inputNumTrials() {
        OutputView.printTrialRequest();
        int numTrials = requestNaturalNumber();
        return numTrials;
    }

    public static int requestNaturalNumber() {
        boolean isValidNumber = false;
        int nums = 0;
        do {
            try {
                nums = Integer.parseInt(requestString());
                checkValidateNaturalNumber(nums);
                isValidNumber = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }while (!isValidNumber);
        return nums;
    }

    private static boolean checkValidateNaturalNumber(final int numTrials) {
        if (0 >= numTrials) {
            throw new IllegalArgumentException("자연수만 입력 가능합니다.");
        }
        return true;
    }
}
