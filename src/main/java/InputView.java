import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ",";
    private final Scanner sc = new Scanner(System.in);

    public int readCount() {
        String input = readLine();
        validateCount(input);

        return Integer.parseInt(input);
    }

    public List<String> readCarNames() {
        return Arrays.stream(readLine().split(DELIMITER))
                .collect(Collectors.toList());
    }

    private void validateCount(String input) {
        if (!isNumeric(input)) {
            throw new IllegalStateException("숫자만 입력해야함");
        }

        if (!isValidRange(Integer.parseInt(input))) {
            throw new IllegalStateException("0이상을 입력해야함");
        }
    }

    private boolean isNumeric(String input) {
        if (!input.matches("^[0-9]*$")) {
            return false;
        }
        return true;
    }

    private boolean isValidRange(int input) {
        if (input < 1) {
            return false;
        }
        return true;
    }

    private String readLine() {
        return sc.nextLine();
    }
}
