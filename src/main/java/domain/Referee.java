package domain;

public class Referee {

    public CarRepository judgment(CarRepository cars) {
        CarRepository winners = new CarRepository();
        winners.addAll(cars.findSamePositionCar(cars.findMaxPositionCar()));

        return winners;
    }
}
