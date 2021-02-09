package racingcar.domain.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.view.ErrorMessages;

public class Cars {

    private final List<Car> container;

    public Cars() {
        this.container = new ArrayList<>();
    }

    public Cars(final List<Car> cars) {
        this.container = cars;
    }

    public List<Car> toList() {
        return Collections.unmodifiableList(container);
    }

    public void add(final Car car) {
        if (alreadyContains(car)) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_CARS_HAVE_DUPLICATE_NAMES);
        }
        container.add(car);
    }

    public void add(final String car) {
        if (alreadyContains(car)) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_CARS_HAVE_DUPLICATE_NAMES);
        }
        container.add(new Car(car));
    }

    private boolean alreadyContains(final String car) {
        return container.contains(new Car(car));
    }

    private boolean alreadyContains(final Car car) {
        return container.contains(car);
    }

    public int size() {
        return container.size();
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }
}
