package controller;

import domain.Car;
import domain.Race;
import java.util.List;
import repository.CarRepository;
import utils.Judge;
import view.output.OutputView;

public class RaceController {

    private final CarRepository carRepository;
    private Race race;
    private final int DRIVING_DISTANCE = 1;

    public RaceController() {
        carRepository = new CarRepository();
    }

    public void playGame(int totalCount) {
        race = new Race(totalCount);
        while (!race.isFinished()) {
            playRound();
        }
        printRoundResult();
    }

    public void addAllParticipants(List<String> carNames) {
        carNames.forEach(carRepository::add);
    }

    private void playRound() {
        List<Car> participants = carRepository.findAll();
        participants.forEach(this::driveOrNot);
        race.addCount();
        printRoundResult();
    }

    private void driveOrNot(Car car) {
        int number = car.chooseNumber();
        if (Judge.isAble(number)) {
            car.drive(DRIVING_DISTANCE);
        }
    }

    private void printRoundResult() {
        OutputView.printRoundResult(carRepository.findAll());
    }
}
