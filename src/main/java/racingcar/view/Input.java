package racingcar.view;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Input {
    Scanner scan = new Scanner(System.in);

    public Input() {
    }

    public Cars carName() {
        try {
            Output.getCarName();
            String inputValue = scan.nextLine();
            allCarsValid(inputValue);
            return new Cars(
                    inputValue.split(","));
        } catch (IllegalArgumentException e) {
            Output.errorMessage(e.getMessage());
            return carName();
        }
    }

    public Attempt attempt() {
        try {
            Output.getAttempt();
            String inputValue = scan.nextLine();
            attemptValid(inputValue);
            return new Attempt(Integer.parseInt(inputValue));
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

    private void attemptValid(String attempt) {
        if (attempt.isBlank()) {
            throw new IllegalArgumentException("시도횟수는 공백일 수 없습니다.");
        }
        if (!isNumber(attempt)) {
            throw new IllegalArgumentException("시도횟수는 숫자를 입력해주세요.");
        }
        if (isNegative(attempt)) {
            throw new IllegalArgumentException("시도횟수는 1이상의 수를 입력해주세요.");
        }
    }

    public boolean isNumber(String string) {
        return string.matches("[+-]?\\d*(\\.\\d+)?");
    }

    public boolean isNegative(String string) {
        int attempt = Integer.parseInt(string);
        return attempt <= 0;
    }
}
