package racingcar;

class RacingGameResult {
    private Cars carList;

    RacingGameResult(Cars carList) {
        this.carList = carList;
    }

    Cars getWinners() {
        Car maxCar = carList.getMaxAdvancedCar();
        Cars winners = new Cars();
        for (Car car : carList) {
            if (car.compareTo(maxCar) == 0) {
                winners.addCar(car);
            }
        }
        return winners;
    }

    String getCarsStatString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : carList) {
            sb.append(car.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
