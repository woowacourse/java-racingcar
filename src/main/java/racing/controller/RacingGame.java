package racing.controller;

import racing.model.CarLineUp;

public class RacingGame {

    public void checkNameDuplicate(CarLineUp lineUp, String name) {
        if (lineUp.isContainAlready(name)){
            throw new IllegalArgumentException("차이름이 중복되었습니다.");
        }
    }
}
