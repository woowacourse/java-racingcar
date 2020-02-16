package racing.controller;

import racing.model.Car;
import racing.model.CarLineUp;
import racing.view.InputView;

public class RacingGame {

    CarLineUp lineUp = new CarLineUp();

    private void enrollLineUp(){
        for (String name : InputView.inputCarNames()){
            checkNameDuplicate(lineUp, name);
            lineUp.add(new Car(name));
        }
    }

    public void checkNameDuplicate(CarLineUp lineUp, String name) {
        if (lineUp.isContainAlready(name)){
            throw new IllegalArgumentException("차이름이 중복되었습니다.");
        }
    }
}
