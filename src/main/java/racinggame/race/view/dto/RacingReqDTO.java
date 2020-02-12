package racinggame.race.view.dto;

import racinggame.race.car.Car;
import racinggame.race.car.Cars;

import java.util.Arrays;
import java.util.List;

import static java.util.Collections.unmodifiableList;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class RacingReqDTO {
    private static final String COMMA = ",";

    private final List<String> names;
    private final int count;

    public RacingReqDTO(String names, int count) {
        this.names = Arrays.stream(names.split(COMMA))
                .map(String::trim)
                .collect(toList());
        this.count = count;
    }

    public List<String> getNames() {
        return unmodifiableList(this.names);
    }

    public int getCount() {
        return count;
    }

    public Cars toCars() {
        return this.names.stream()
                .map(Car::new)
                .collect(collectingAndThen(toList(), Cars::new));
    }
}
