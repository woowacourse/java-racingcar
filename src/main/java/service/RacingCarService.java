package service;

import domain.Car;
import domain.Cars;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {

    public int getCount(String rawCount) {
        validateNumberFormat(rawCount);

        int count = Integer.parseInt(rawCount);
        validateInvalidNumber(count);

        return count;
    }

    // TODO: validateNumberFormat을 isParsable과 분리할지 합칠지 고민
    private void validateNumberFormat(String rawCount) {
        if(isParsable(rawCount)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isParsable(String rawCount) {
        try {
            Integer.parseInt(rawCount);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void validateInvalidNumber(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public Cars getCars(String rawNames){
        List<String> names = List.of(rawNames.split(","));

        return new Cars(names);
    }

    public List<String> findWinners(Cars cars) {
        List<Car> winners =  cars.getCars().stream()
                .sorted(Car::compareTo)
                .takeWhile(car -> car.getForward() == cars.getMaxForward())
                .toList();

        return getWinnerNames(winners);
    }

    private List<String> getWinnerNames(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();

        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        return winnerNames;
    }
}
