package application.racing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarName {
    private List<String> carName;

    public CarName(String input) {
        throwExceptionWhenInputIsEmptyOrNullOrBlank(input);
        String[] splitName = input.split(",");
        addCarName(splitName);
        validateName();
        throwExceptionWhenHasDuplicateCarName();
    }

    private void throwExceptionWhenHasDuplicateCarName() {
        Set<String> nonDuplicateName = new HashSet<>(this.carName);
        if (nonDuplicateName.size() != this.carName.size()) {
            throw new IllegalArgumentException();
        }
    }

    private void addCarName(String[] splitName) {
        this.carName = new ArrayList<>();
        for (String name : splitName) {
            this.carName.add(name);
        }
    }

    private void throwExceptionWhenNameLengthOverFive(String s) {
        if (s.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateName() {
        for (String s : this.carName) {
            throwExceptionWhenInputIsEmptyOrNullOrBlank(s);
            throwExceptionWhenNameLengthOverFive(s);
        }
    }

    private void throwExceptionWhenInputIsEmptyOrNullOrBlank(String input) {
        if (input.isEmpty() || input == null || " ".equals(input)) {
            throw new IllegalArgumentException();
        }
    }
}
