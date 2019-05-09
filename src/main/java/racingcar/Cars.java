package racingcar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        List<Car> result = new ArrayList<>();

        for (Car car : carList) {
            if (car.getPosition() == this.maxPosition) {
                result.add(car);
            }
        }

        return result;
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    public void setMaxPosition(int position) {
        this.maxPosition = position;
    }

}
