package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.domain.movement.FixedMovementStrategy;
import racingcar.domain.movement.MovementStrategy;
import racingcar.dto.CarDTO;

class RacingCarControllerTest {

    private RacingCarController controller;

    @BeforeEach
    public void setUp() {
        String inputCarNames = "pobi,seung,cha";
        String inputRoundNumber = "3";
        controller = new RacingCarController(inputCarNames, inputRoundNumber);
    }

    @Test
    @DisplayName("라운드가 양수면 컨트롤러가 실행할 수 있는 상태이다.")
    public void testIsRunnableWithPositiveRoundNumber() {
        // when
        boolean runnable = controller.isRunnable();
        // then
        Assertions.assertThat(runnable).isTrue();
    }

    @Test
    @DisplayName("라운드가 음수면 예외를 발생시킨다.")
    public void testIsRunnableWithNegativeRoundNumber() {
        // given
        int inputRoundNumber = 3;
        MovementStrategy strategy = new FixedMovementStrategy();
        // when
        for (int i = 0; i < inputRoundNumber; i++) {
            controller.run(strategy);
        }
        // then
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> controller.run(strategy));
    }

    @Test
    @DisplayName("컨트롤러 실행시 자동차가 움직인다")
    public void testRun() {
        // when
        List<CarDTO> dtos = controller.run(new FixedMovementStrategy());
        // then
        for (CarDTO dto : dtos) {
            Assertions.assertThat(dto.getPosition()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("우승자를 구할 수 있다.")
    public void testFindWinners() {
        // given
        controller.run(new FixedMovementStrategy());
        // when
        List<CarDTO> result = controller.end();
        List<String> names = result.stream()
            .map(CarDTO::getName)
            .collect(Collectors.toList());
        // then
        Assertions.assertThat(names).contains("pobi", "seung", "cha");
    }
}