package racinggame.race.view.dto;

import racinggame.race.car.Car;
import racinggame.race.car.Cars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class RacingResponseBundleDTO implements Iterable<RacingResponseDTO> {
    private final List<RacingResponseDTO> racingResponseDTOS;

    private RacingResponseBundleDTO(Cars cars) {
        racingResponseDTOS = new ArrayList<>();
        for (Car car : cars) {
            racingResponseDTOS.add(RacingResponseDTO.from(car));
        }
    }

    public static RacingResponseBundleDTO from(Cars cars) {
        return new RacingResponseBundleDTO(cars);
    }

    @Override
    public Iterator<RacingResponseDTO> iterator() {
        return this.racingResponseDTOS.iterator();
    }

    @Override
    public void forEach(Consumer<? super RacingResponseDTO> action) {
        racingResponseDTOS.forEach(action);
    }

    @Override
    public Spliterator<RacingResponseDTO> spliterator() {
        return racingResponseDTOS.spliterator();
    }

}
