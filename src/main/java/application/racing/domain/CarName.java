package application.racing.domain;

import application.racing.ConstantForRacing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarName {
    private List<String> carName;

    public CarName(String input) {
        throwExceptionWhenInputIsEmptyOrNullOrBlank(input);
        String[] splitName = input.split(ConstantForRacing.NAME_DELIMITER);
        addCarName(splitName);
        validateName();
        throwExceptionWhenHasDuplicateCarName();
    }

    private void throwExceptionWhenHasDuplicateCarName() {
        Set<String> nonDuplicateName = new HashSet<>(this.carName);
        if (nonDuplicateName.size() != this.carName.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름을 입력하였습니다.");
        }
    }

    private void addCarName(String[] splitName) {
        this.carName = new ArrayList<>();
        for (String name : splitName) {
            this.carName.add(name);
        }
    }

    private void throwExceptionWhenNameLengthOverFive(String s) {
        if (s.length() > ConstantForRacing.NAME_LENGTH_STANDARD) {
            throw new IllegalArgumentException("5글자 초과의 자동차 이름을 입력하였습니다.");
        }
    }

    private void validateName() {
        for (String s : this.carName) {
            throwExceptionWhenInputIsEmptyOrNullOrBlank(s);
            throwExceptionWhenNameLengthOverFive(s);
        }
    }

    private void throwExceptionWhenInputIsEmptyOrNullOrBlank(String input) {
        if (input.isEmpty() || input == null || isContainBlank(input)) {
            throw new IllegalArgumentException("공백을 포함한 이름을 입력하였습니다.");
        }
    }

    private boolean isContainBlank(String input) {
        String[] splitName = input.split(ConstantForRacing.EMPTY_STRING);
        for (String s : splitName) {
            if (isBlankString(s)) {
                return true;
            }
        }
        return false;
    }

    private boolean isBlankString(String s) {
        return ConstantForRacing.BLANK_STRING.equals(s);
    }

    public List<String> getCarNameList() {
        return this.carName;
    }
}
