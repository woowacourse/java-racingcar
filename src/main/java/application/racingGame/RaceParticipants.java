package application.racingGame;

import java.util.*;

public class RaceParticipants {

    public static final String CAR_NAME_DELIMITER = ",";
    public static final int MAX_CAR_LENGTH = 5;
    public static final String LETTERING_SEPARATOR = "";
    public static final String BLANK = " ";

    private final RacingCarNameInput racingCarNameInput;
    private List<Car> cars;

    public RaceParticipants(RacingCarNameInput racingCarNameInput) {
        this.racingCarNameInput = racingCarNameInput;
    }

    public void init() {
        this.cars = getCarList(racingCarNameInput.getCarNames());
    }

    public List<Car> getCars() {
        return this.cars;
    }

    private List<Car> getCarList(String inputCarNames) {
        List<String> carNames = getCarName(inputCarNames);
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private List<String> getCarName(String inputCarNames) {
        List<String> carNames = Arrays.asList(inputCarNames.split(CAR_NAME_DELIMITER));
        validateCarName(carNames);
        return carNames;
    }

    private void validateCarName(List<String> carNames) {
        checkDuplicateCarName(carNames);
        for (String carName : carNames) {
            checkNullOrBlankOrEmpty(carName);
            checkLengthMoreThanFive(carName);
        }
    }

    private void checkDuplicateCarName(List<String> carName) {
        Set<String> nonDuplicateName = new HashSet<>(carName);
        if (isDuplicateName(carName, nonDuplicateName)) {
            throw new IllegalArgumentException("중복된 자동차 이름을 입력하였습니다.");
        }
    }

    private boolean isDuplicateName(List<String> carName, Set<String> nonDuplicateName) {
        return nonDuplicateName.size() != carName.size();
    }

    private void checkLengthMoreThanFive(String carName) {
        if (isLengthMoreThanFive(carName)) {
            throw new IllegalArgumentException("5글자 초과의 자동차 이름을 입력하였습니다.");
        }
    }

    private boolean isLengthMoreThanFive(String s) {
        return s.length() > MAX_CAR_LENGTH;
    }


    private void checkNullOrBlankOrEmpty(String carName) {
        if (isEmptyOrOrContainBlank(carName)) {
            throw new IllegalArgumentException("공백을 포함한 이름을 입력하였습니다.");
        } else if(isNull(carName)) {
            throw new NullPointerException("null 값이 입력되었습니다");
        }
    }
    private boolean isEmptyOrOrContainBlank(String input) {
        return input.isEmpty() ||  isContainBlank(input);
    }

    private boolean isContainBlank(String input) {
        String[] splitName = input.split(LETTERING_SEPARATOR);
        for (String letter : splitName) {
            if (isBlankString(letter)) {
                return true;
            }
        }
        return false;
    }
    private boolean isNull(String input) {
        return input == null;
    }

    private boolean isBlankString(String s) {
        return BLANK.equals(s);
    }
}

