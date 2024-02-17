package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.exception.NotANumberException;
import racingcar.exception.TryNumberOutOfRangeException;
import racingcar.view.reader.Reader;

public class InputView {

    private static final int MIN_RACE_RANGE = 1;
    private static final int MAX_RACE_RANGE = 100;

    private final Reader reader;

    public InputView(final Reader reader) {
        this.reader = reader;
    }

    public List<String> getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = reader.readLine();
        String[] names = input.split(",");
        return Arrays.stream(names)
                .map(String::trim)
                .toList();
    }

    public int getTryNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = reader.readLine();

        int number = convertToInteger(input);
        validateNumberInRange(number);

        return number;
    }

    private int convertToInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NotANumberException();
        }
    }

    private void validateNumberInRange(final int number) {
        if (number < MIN_RACE_RANGE || number > MAX_RACE_RANGE) {
            throw new TryNumberOutOfRangeException();
        }
    }
}
