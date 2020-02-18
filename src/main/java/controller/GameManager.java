package controller;

import model.Car;
import model.Dice;
import model.Round;
import model.Winner;
import view.ValidateInput;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public static final String COMMA = ",";
    private List<Car> cars = new ArrayList<>();
    private Winner winner;
    private Round round;

    public GameManager(String carNames, String round) {
        ValidateInput.validateInput(carNames, round);
        initiateCars(carNames.split(COMMA));
        winner = new Winner();
        this.round = new Round(Integer.parseInt(round));
    }

    public void race() {
        for (Car car : cars) {
            car.moveOrNot(Dice.makeRandomNumber());
        }
        round.afterOneRound();
    }

    public boolean isFinish() {
        return round.isLastRound();
    }

    private void initiateCars(String[] carNames) {
        for (String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    public List<String> whoIsWinner() {
        winner.determineWinners(cars);
        return winner.getWinners();
    }

    public List<Car> getCars() {
        return this.cars;
    }

}
