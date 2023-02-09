import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Validate {
    public void isValidCarNames(String[] carNames) {
        try {
            checkBlank(carNames);
            checkLength(carNames);
            checkDouble(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void isValidTryCount(String input){
        try {
            checkDigits(input);
            checkRange(input);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void checkBlank(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkLength(String[] carNames) {
        long invalidCount = Arrays.stream(carNames)
                .filter(names -> names.isEmpty() || names.length() > 5)
                .count();
        if(invalidCount != 0){
            throw new IllegalArgumentException();
        }
    }

    private void checkDouble(String[] carNames) {
        Set<String> set = new HashSet<>(Arrays.asList(carNames));
        if (set.size() != carNames.length) {
            throw new IllegalArgumentException();
        }
    }

    public void checkDigits(String input) {
        boolean isMatch = input.matches("\\d+");
        if (!isMatch) {
            throw new IllegalArgumentException();
        }
    }

    public void checkRange(int tryCount) {
        if (tryCount < 1) {
            throw new IllegalArgumentException();
        }
    }
}
