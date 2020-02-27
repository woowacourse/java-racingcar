package racing.controller;

import racing.model.Car;
import racing.model.CarLineUp;
import racing.model.RandomNo;
import racing.model.TrialTime;
import racing.view.InputView;
import racing.view.OutputView;

public class RacingGame {

    private CarLineUp lineUp;
    private TrialTime trialTime;

    public void play(){
        initializeLineUp();
        initializeTrialTime();
        race();
        showWinners();
    }

    private void initializeLineUp(){
        try {
            this.lineUp = new CarLineUp(InputView.inputCarNames());
        } catch (NullPointerException | IllegalArgumentException e){
            OutputView.printExceptionMessage(e);
            initializeLineUp();
        }
    }

    private void initializeTrialTime(){
        try {
            this.trialTime = new TrialTime(InputView.inputTrialTime());
        } catch(NullPointerException | IllegalArgumentException e){
            OutputView.printExceptionMessage(e);
            initializeTrialTime();
        }
    }

    private void race(){
        OutputView.printResultMessage();
        for (int index = 0; index < trialTime.getTrialTime(); index++){
            raceOneTime();
            OutputView.printOneRoundResult(lineUp);
        }
    }

    private void raceOneTime() {
        for (Car car : lineUp.getLineUp()){
            car.move(RandomNo.getNumber());
        }
    }

    private void showWinners() {
        OutputView.printWinners(lineUp.findWinner());
    }



}
