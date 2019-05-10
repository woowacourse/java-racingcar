package racing.domain;

import racing.util.RandomNumberGenerator;
import racing.view.InputView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private List<Car> cars;

    /*
     * 경기 준비 메소드
     */
    public void createCars() {
        cars = new ArrayList<>();
        Iterator<String> it = inputCarNames().iterator();
        while (it.hasNext()) {
            cars.add(new Car(it.next()));
        }
    }

    private List<String> inputCarNames() {
        try {
            List<String> carNames = InputView.requestNames();
            checkDuplicatedNames(carNames);
            return carNames;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputCarNames();
        }
    }

    private boolean checkDuplicatedNames(final List<String> names) {
        List<String> reducedNames = names.stream().distinct().collect(Collectors.toList());
        if (names.size() != reducedNames.size()) throw new IllegalArgumentException("중복된 이름이 존재하면 안됩니다.");
        return true;
    }

    /*
     * 경기 진행 메소드
     */
    public void progressRace() {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            Car car = it.next();
            car.tryGoForward(RandomNumberGenerator.generate(Car.MAX_RANDOM_NUM_UPPER_BOUND));
        }
    }

    /*
     * 경기 결과 메소드
     */
    public RaceResult getResult() {
        RaceReferee raceReferee = new RaceReferee(cars);
        return raceReferee.getResult();
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList<>();

        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            result.add(it.next().toString());
        }
        return String.join("\n", result);
    }
}
