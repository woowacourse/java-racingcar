package racinggame.race.view.dto;

import racinggame.race.car.Car;
import racinggame.race.car.Cars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class RacingResBundleDTO implements Iterable<RacingResDTO> {
    private final List<RacingResDTO> racingResDTOs;

    private RacingResBundleDTO(Cars cars) {
        racingResDTOs = new ArrayList<>();
        for (Car car : cars) {
            racingResDTOs.add(RacingResDTO.from(car));
        }
    }

    public static RacingResBundleDTO from(Cars cars) {
        return new RacingResBundleDTO(cars);
    }

    @Override
    public Iterator<RacingResDTO> iterator() {
        return this.racingResDTOs.iterator();
    }

    @Override
    public void forEach(Consumer<? super RacingResDTO> action) {
        racingResDTOs.forEach(action);
    }

    @Override
    public Spliterator<RacingResDTO> spliterator() {
        return racingResDTOs.spliterator();
    }

}
