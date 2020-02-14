package racinggame.race.view.dto;

import racinggame.race.car.Car;
import racinggame.race.car.Cars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingResponseBundleDTO {
    private final List<RacingResponseDTO> racingResponseDTOs;

    private RacingResponseBundleDTO(Cars cars) {
        racingResponseDTOs = new ArrayList<>();
        for (Car car : cars.getCars()) {
            racingResponseDTOs.add(RacingResponseDTO.from(car));
        }
    }

    public static RacingResponseBundleDTO from(Cars cars) {
        return new RacingResponseBundleDTO(cars);
    }

    public List<RacingResponseDTO> getRacingResponseDTOs() {
        return Collections.unmodifiableList(this.racingResponseDTOs);
    }
}
