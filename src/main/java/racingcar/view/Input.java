package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Input {
    Scanner scan = new Scanner(System.in);

    public Input() {
    }

    public String[] carName() {
        try {
            Output.getCarName();
            String inputValue = scan.nextLine();
            allCarsValid(inputValue);
            return inputValue.split(",");
        } catch (IllegalArgumentException e) {
            Output.errorMessage(e.getMessage());
            return carName();
        }
    }

    public int attempt() {
        try {
            Output.getAttempt();
            String inputValue = scan.nextLine();
            return Integer.parseInt(inputValue);
        } catch (IllegalArgumentException e) {
            Output.errorMessage(e.getMessage());
            return attempt();
        }
    }

    public void allCarsValid(String names) {
        if (isBlank(names)) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        String[] cars = names.split(",");
        if (!isCars(cars)) {
            throw new IllegalArgumentException("자동차를 두 개 이상 입력해주세요.");
        }
        if (isDuplicated(cars)) {
            throw new IllegalArgumentException("자동차 이름을 모두 다르게 입력해주세요.");
        }
        nameValid(cars);
    }

    private void nameValid(String[] cars) {
        for (String name : cars) {
            if (isBlank(name)) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }
            if (!isValidLength(name)) {
                throw new IllegalArgumentException("자동차의 이름은 5글자를 초과할 수 없습니다.");
            }
        }
    }

    public boolean isBlank(String name) {
        return name.trim().isEmpty();
    }

    public boolean isCars(String[] names) {
        return names.length >= 2;
    }

    public boolean isDuplicated(String[] names) {
        Set<String> carNames = new HashSet<>(Arrays.asList(names));
        return carNames.size() != names.length;
    }

    public boolean isValidLength(String name) {
        return name.length() <= 5;
    }

    public boolean isNumber(String string) {
        return string.matches("[+-]?\\d*(\\.\\d+)?");
    }
}
