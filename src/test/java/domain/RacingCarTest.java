package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    @DisplayName("랜덤값이 4이상일 시 전진하는 지 테스트")
    @Test
    public void moveTest(){
        RacingCar racingCar = new RacingCar("bito");
        racingCar.race(4);
        Assertions.assertThat(racingCar.getMoveNumber()).isEqualTo(1);
    }

    @DisplayName("랜덤값이 4미만일 시 멈추는 지 테스트")
    @Test
    public void notMoveTest(){
        RacingCar racingCar = new RacingCar("bito");
        racingCar.race(3);
        Assertions.assertThat(racingCar.getMoveNumber()).isEqualTo(0);
    }

}
