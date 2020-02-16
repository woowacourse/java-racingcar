package racing.controller;

import racing.model.Car;
import racing.model.CarLineUp;
import racing.model.TrialTime;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGame {

    CarLineUp lineUp = new CarLineUp();
    TrialTime trialTime;

    private void enrollLineUp(){
        for (String name : InputView.inputCarNames()){
            checkNameDuplicate(lineUp, name);
            lineUp.add(new Car(name));
        }
    }

    private void initializeTrialTime(){
        trialTime = InputView.inputTrialTime();
    }

    private void race(){
        OutputView.printResultMessage();
        trialTime.raceByTrialTime(lineUp);
        OutputView.printNewLine();
    }

    public void checkNameDuplicate(CarLineUp lineUp, String name) {
        if (lineUp.isContainAlready(name)){
            throw new IllegalArgumentException("차이름이 중복되었습니다.");
        }
    }
}
