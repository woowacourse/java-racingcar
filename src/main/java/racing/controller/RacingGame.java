package racing.controller;

import racing.model.Car;
import racing.model.CarLineUp;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGame {

    private CarLineUp lineUp;
    private int trialTime;

    public void play(){
        initializeLineUp();
        initializeTrialTime();
        race();
        showWinners();
    }

    private void initializeLineUp(){
        try {
            lineUp = new CarLineUp();
            enrollCarToLineUp();
        } catch (NullPointerException | IllegalArgumentException e){
            OutputView.printExceptionMessage(e);
            initializeLineUp();
        }
    }

    private void enrollCarToLineUp() {
        for (String name : InputView.inputCarNames()){
            Car car = new Car(name);
            checkNameDuplicate(lineUp, car);
            lineUp.add(new Car(name));
        }
    }

    private void initializeTrialTime(){
        try {
            trialTime = InputView.inputTrialTime();
        } catch(Exception e){
            OutputView.printExceptionMessage(e);
            initializeLineUp();
        }
    }

    private void race(){
        OutputView.printResultMessage();
        for (int index = 0; index < trialTime; index++){
            lineUp.raceOneTime();
            OutputView.printOneRoundResult(lineUp);
        }
    }

    private void showWinners() {
        OutputView.printWinners(lineUp.findWinner());
    }


    public void checkNameDuplicate(CarLineUp lineUp, Car car) {
        if (lineUp.isAlready(car)){
            throw new IllegalArgumentException("차이름이 중복되었습니다.");
        }
    }
}
