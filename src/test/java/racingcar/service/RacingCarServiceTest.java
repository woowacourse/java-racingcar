package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.car.Car;
import racingcar.domain.movement.FixedMovementStrategy;

class RacingCarServiceTest {

    private RacingCarService service;

    @BeforeEach
    public void setUp() {
        String inputCarNames = "pobi,seung,cha";
        String inputRoundNumber = "3";
        service = new RacingCarService(inputCarNames, inputRoundNumber);
    }

    @Test
    @DisplayName("라운드 종료 여부를 판별할 수 있다.")
    public void testIsRoundEnd() {
        Assertions.assertThat(service.isRoundEnd()).isFalse();
    }

    @Test
    @DisplayName("라운드 소진시 종료로 판별된다.")
    public void testIsRoundEndAfterConsumption() {
        // given
        int roundNumber = 3;
        // when
        for (int i = 0; i < roundNumber; i++) {
            service.run(new FixedMovementStrategy());
        }
        // then
        service.isRoundEnd();
    }

    @Test
    @DisplayName("라운드를 1회 차감하여 자동차 전진을 시도한다.")
    public void testRun() {
        // when
        List<Car> cars = service.run(new FixedMovementStrategy());
        // then
        for (Car car : cars) {
            Assertions.assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("승자를 구할 수 있다.")
    public void testFindWinners() {
        // given
        service.run(new FixedMovementStrategy());
        // when
        List<Car> winners = service.findWinners();
        List<String> names = winners.stream()
            .map(Car::getName)
            .collect(Collectors.toList());
        // then
        Assertions.assertThat(names).contains("pobi", "seung", "cha");
    }
}