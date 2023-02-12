package racing.domain;

import racing.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    // 테스트를 위한 메서드
    public Car getCar(int n) {
        return cars.get(n);
    }

    public void calculator() {
        cars.stream()
                .filter(car -> 4 <= RandomUtil.getRandomNumber())
                .forEach(Car::move);
    }

    public List<String> getPrintForm() {
        List<String> forms = new ArrayList<>();
        for (Car car : cars) {
            forms.add(car.getCarStepForm());
        }
        return forms;
    }

    public List<String> getWinners() {
        int winnerStep = getWinnerStep();
        return findWinners(winnerStep);
    }

    private int getWinnerStep() {
        int winnerStep = 0;
        for (Car car : cars) {
            winnerStep = car.getCarStep(winnerStep);
        }
        return winnerStep;
    }

    private List<String> findWinners(int winnerStep) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            winners = car.ifMeetAddWinners(winners, winnerStep);
        }
        return winners;
    }
}
