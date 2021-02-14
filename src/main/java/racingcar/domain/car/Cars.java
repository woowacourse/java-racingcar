package racingcar.domain.car;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.utils.RandomUtils;
import racingcar.view.ErrorMessages;

public class Cars {

    private final List<Car> container;

    public Cars(final String rawNames) {
        List<Name> names = Names.create(rawNames);
        container = names.stream()
                .map(Car::new)
                .collect(Collectors.toList());
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

    private boolean alreadyContains(final Car car) {
        return container.contains(car);
    }

    public void moveIndividuals() {
        container.forEach(car -> car.move(RandomUtils.generate()));
    }

    public Winners collectWinners() {
        return new Winners(container);
    }

    public int size() {
        return container.size();
    }

    public boolean isEmpty() {
        return container.isEmpty();
    }
}
