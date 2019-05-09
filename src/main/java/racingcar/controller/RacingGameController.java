package racingcar.controller;

import racingcar.view.InputView;

public class RacingGameController {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;
    private static final String SPLIT_REGEX = ",";

    public String requestCarList() {
        return InputView.inputCarList();
    }

    public String[] splitCarList(String carNameList) {
        String[] carList;

        carNameList = carNameList.replaceAll(" ", "");
        if (hasContinuousComma(carNameList)) {
            throw new IllegalArgumentException("연속된 콤마가 발견 되었습니다.");
        }
        carList = carNameList.split(SPLIT_REGEX);
        if(hasLongCarName(carList)) {
            throw new IllegalArgumentException("5자 이하의 자동차 이름만 허용됩니다.");
        }
        return carList;
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
