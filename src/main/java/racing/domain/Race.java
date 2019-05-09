package racing.domain;

import racing.view.InputView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Race {
    private List<Car> cars;
    private int numTrials;

    public void createCars(List<String> carNames) {
        cars = new ArrayList<Car>();
        Iterator<String> it = carNames.iterator();
        while (it.hasNext()) {
            cars.add(new Car(it.next()));
        }
    }

    public void inputNumTrials(){
        numTrials = InputView.requestNumTrials();
    }


}
