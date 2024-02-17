package domain;

import domain.car.Cars;
import domain.name.Name;
import domain.name.Names;
import domain.race.RaceProgress;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RaceProgressTest {
    @Test
    @DisplayName("자동차 목록 포함한 일급객체를 통해 자동차 결과를 포함한 일급객체를 만든다.")
    void createRaceProgress() {
        List<Name> names = List.of(new Name("pond"), new Name("poby"));
        Names nameCatalog = new Names(names);
        Cars cars = Cars.from(nameCatalog);

        RaceProgress raceProgress = RaceProgress.from(cars.getValue());

        assertInstanceOf(RaceProgress.class, raceProgress);
    }
}
