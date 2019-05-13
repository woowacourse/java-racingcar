package racing.domain;

import racing.util.RandomNumberGenerator;
import racing.view.InputView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Race {
    private List<Car> cars = new ArrayList<>();
    private final int numTrials;

    public Race(int numTrials){
        this.numTrials =numTrials;
        createCars();
    }

    /*
     * 경기 준비 메소드
     */
    public void createCars() {
        List<String> carNames = InputView.inputCarNames();
        Iterator<String> it = carNames.iterator();
        while (it.hasNext()) {
            cars.add(new Car(it.next()));
        }
    }

    /*
     * 경기 진행 메소드
     */
    public void repeatRace(){
        for (int i = 0; i < numTrials; i++){
            progressRace();
        }
    }

    public void progressRace() {
        Iterator<Car> it = cars.iterator();
        while (it.hasNext()) {
            Car car = it.next();
            car.tryGoForward(RandomNumberGenerator.generate(Car.MAX_RANDOM_NUM_UPPER_BOUND));
        }
    }

    public int getNumTrials(){
        return this.numTrials;
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
