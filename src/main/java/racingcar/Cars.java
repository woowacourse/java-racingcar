package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars implements Iterable<Car> {
    private List<Car> carList = new ArrayList<>();
    private int maxPosition = 0;

    public Iterator<Car> iterator() {
        return carList.iterator();
    }

    public void addCar(Car car) {
        carList.add(car);
    }

    public List<Car> getWinnerList() {
        return carList
                .stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public int size() {
        return carList.size();
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    public void updateMaxPosition(int position) {
        if (this.maxPosition < position) {
            this.maxPosition = position;
        }
    }
}
