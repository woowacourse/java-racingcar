package racing.controller;

import java.util.List;

import racing.domain.CarList;

public class Controller {
    public static String[] splitNames(String carNames) {
        String[] names = carNames.split(",");
        if (names.length == 0) {
            throw new IllegalArgumentException("이름을 입력해주세요 !");
        }
        return names;
    }

    public static String getWinners(CarList carList) {
        List<String> winnerList = carList.getWinnerList();
        return String.join(", ", winnerList);
    }

}
