package domain;

import utils.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private final NumberGenerator numberGenerator;

    public Field(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void moveCars(CarGroup carGroup) {
        List<Car> cars = carGroup.getAllCars();
        for (Car car : cars) {
            int randomNumber = numberGenerator.getNumber();
            car.move(randomNumber);
        }
    }

    public String getResult(CarGroup carGroup) {
        StringBuilder result = new StringBuilder();
        List<Car> winners = carGroup.getWinners();

        if (winners.size() == 0) {
            return result.append("우승자가 없습니다.").toString();
        }

        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }
        String winnerResult = String.join(", ", winnerNames).concat("가 최종 우승했습니다.");
        return result.append(winnerResult).toString();
    }
}
