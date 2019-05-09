package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;

import java.util.ArrayList;

public class RacingGameController {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;
    private static final int MIN_TRY_COUNT = 1;
    private static final String SPLIT_REGEX = ",";

    private ArrayList<Car> carList;
    private int tryCount;
    
    public String requestCarList() {
        return InputView.inputCarList();
    }

    public String[] makeValidCarNames(String carNames) throws Exception {
        carNames = removeWhiteSpace(carNames);
        if (hasContinuousComma(carNames)) {
            throw new IllegalArgumentException("연속된 콤마가 발견 되었습니다.");
        }
        String[] splitedCarNameList = splitCarList(carNames);
        if(hasLongCarName(splitedCarNameList)) {
            throw new IllegalArgumentException("5자 이하의 자동차 이름만 허용됩니다.");
        }
        return splitedCarNameList;
    }

    public void generateCarList(String[] carNames) {
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
    }

    public int requestTryCount() {
        return InputView.inputTryCount();
    }

    private String removeWhiteSpace(String carNameList) {
        return carNameList.replaceAll(" ", "");
    }

    private String[] splitCarList(String carNameList) {
        return carNameList.split(SPLIT_REGEX);
    }

    private boolean hasLongCarName(String[] carNameList) {
        boolean hasLongCarName = false;

        for (int i = 0; i < carNameList.length && !hasLongCarName; i++) {
            hasLongCarName = isOverFiveCharacters(carNameList[i]);
        }
        return hasLongCarName;
    }

    private boolean isOverFiveCharacters(String carName) {
        return carName.length() > LIMIT_CAR_NAME_LENGTH;
    }

    private boolean hasContinuousComma(String carNameList) {
        return carNameList.contains(",,");
    }
}
