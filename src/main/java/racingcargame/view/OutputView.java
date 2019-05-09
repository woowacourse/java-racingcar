package racingcargame.view;

import racingcargame.model.Car;
import racinginterface.OutputViewInterface;

import java.util.List;

public class OutputView implements OutputViewInterface {

    private static final String POSITION_MESSAGE = "-";

    @Override
    public void printRound(List<Car> carList) {
        carList.forEach(car -> System.out.println(car.getName() + " : " + positionMessage(car.getPosition())));
        System.out.println();
    }

    private String positionMessage(int carPosition) {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < carPosition; i++) {
            message.append(POSITION_MESSAGE);
        }
        return message.toString();
    }

    @Override
    public void printGameResult(List<String> winnerList) {

    }
}
