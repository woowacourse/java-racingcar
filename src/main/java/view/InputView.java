package view;

import domain.TryCount;
import dto.input.ReadCarNamesDto;
import dto.input.ReadTryCountDto;
import error.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private static final Scanner sc = new Scanner(System.in);

    private InputView() {
    }

    private static class InputViewSingletonHelper {
        private static final InputView INPUT_VIEW = new InputView();
    }

    public static InputView getInstance() {
        return InputViewSingletonHelper.INPUT_VIEW;
    }

    public ReadCarNamesDto readCarNames() {
        printMessage(Message.ASK_CAR_NAMES);
        List<String> input = Arrays.stream(readLine().split(DELIMITER))
                .collect(Collectors.toUnmodifiableList());
        validateDuplicatedCarNames(input);

        return new ReadCarNamesDto(input);
    }

    public ReadTryCountDto readTryCount() {
        printMessage(Message.ASK_TRY_COUNT);

        int input = validateCount(readLine());

        return new ReadTryCountDto(new TryCount(input));
    }

    private static void validateDuplicatedCarNames(List<String> input) {
        if (input.size() != input.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NAMES.getValue());
        }
    }

    private static int validateCount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.", e);
        }
    }

    private static String readLine() {
        return sc.nextLine();
    }

    private static void printMessage(Message message) {
        System.out.println(message.value);
    }


    private enum Message {
        ASK_CAR_NAMES("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
        ASK_TRY_COUNT("시도할 횟수는 몇회인가요?");

        private final String value;

        Message(String value) {
            this.value = value;
        }
    }

}
