package application.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Racing {
    public int generateRandomNumber() {
        double randomValue = Math.random();
        return (int)(randomValue * 9);
    }


    public List<String> findWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        maxPosition = findMaxPosition(cars, maxPosition);
        addWinners(cars, winners, maxPosition);
        return winners;
    }

    private void addWinners(List<Car> cars, List<String> winners, int maxPosition) {
        for(Car car : cars) {
            if(car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
    }

    private int findMaxPosition(List<Car> cars, int maxPosition) {
        for(Car car : cars) {
            if(maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
