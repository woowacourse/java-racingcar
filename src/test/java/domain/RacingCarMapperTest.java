package domain;

import dto.RacingCarNames;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RacingCarMapperTest {
    @Test
    @DisplayName("레이싱카 이름들로 레이싱카 객체를 생성한다.")
    void createBy() {
        RacingCarMapper racingCarMapper = new RacingCarMapper();
        RacingCarNames racingCarNames = new RacingCarNames("zeze,bito");

        List<RacingCar> racingCars = racingCarMapper.mapToRacingCars(racingCarNames);

        Assertions.assertThat(racingCars).hasSize(2);
        Assertions.assertThat(racingCars).extracting("name").contains("zeze", "bito");
    }
}
