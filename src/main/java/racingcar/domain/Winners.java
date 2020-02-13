package racingcar.domain;

import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Name> winners;

    public Winners(Cars cars) {
        List<Name> winners = new ArrayList<>();
        findMaxLocation(cars);
        this.winners = winners;
    }

    public int findMaxLocation(Cars cars) {
        List<Integer> a = cars.getCars().stream()
                .map(car -> car.getLocation())
                .collect(Collectors.toList());
        return Collections.max(a);
    }
}