package domain;

import dto.CarDto;
import dto.ResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.PowerGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 그룹 테스트")
class CarGroupTest {

    static class FixedPowerGenerator implements PowerGenerator {
        private final List<Integer> numbers;
        private Integer index = 0;

        FixedPowerGenerator(final List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int getNumber() {
            return numbers.get(index++);
        }
    }

    @Nested
    @DisplayName("자동차 그룹 움직임 테스트")
    class CarGroupMovementTest {

        @Test
        @DisplayName("자동차를 한 번 정상적으로 움직이는가")
        void is_cars_move_correctly_once() {
            // given
            String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            List<Integer> powers = List.of(9, 0, 9, 0);
            CarGroup carGroup = new CarGroup(carNames, new FixedPowerGenerator(powers));

            // when
            ResultDto result = carGroup.move();

            // then

            ResultDto expected = new ResultDto(List.of(new CarDto("mang", 1),
                    new CarDto("weve", 0), new CarDto("pobi", 1), new CarDto("neo", 0)));
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("자동차를 두 번 정상적으로 움직이는가")
        void is_cars_move_correctly_twice() {
            // given
            String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            List<Integer> powers = List.of(9, 0, 9, 0, 9, 0, 9, 0);
            CarGroup carGroup = new CarGroup(carNames, new FixedPowerGenerator(powers));

            // when, then
            ResultDto firstRound = carGroup.move();
            ResultDto expectedFirstRound = new ResultDto(List.of(new CarDto("mang", 1),
                    new CarDto("weve", 0), new CarDto("pobi", 1), new CarDto("neo", 0)));
            assertThat(firstRound).isEqualTo(expectedFirstRound);

            // when, then
            ResultDto secondRound = carGroup.move();
            ResultDto expectedSecondRound = new ResultDto(List.of(new CarDto("mang", 2),
                    new CarDto("weve", 0), new CarDto("pobi", 2), new CarDto("neo", 0)));
            assertThat(secondRound).isEqualTo(expectedSecondRound);
        }
    }

    @Nested
    @DisplayName("우승자 테스트")
    class CarGroupWinnerTest {

        @Test
        @DisplayName("우승자가 한 명인가")
        void is_winner_one_person() {
            // given
            String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            List<Integer> powers = List.of(9, 0, 0, 0);
            CarGroup carGroup = new CarGroup(carNames, new FixedPowerGenerator(powers));

            // when
            carGroup.move();

            // then
            List<CarDto> winners = carGroup.getWinners();
            assertThat(winners).containsExactly(new CarDto("mang", 1));
        }

        @Test
        @DisplayName("우승자가 여러 명인가")
        void is_winner_two_people() {
            // given
            String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            List<Integer> powers = List.of(9, 0, 9, 0, 9, 0, 9, 0);
            CarGroup carGroup = new CarGroup(carNames, new FixedPowerGenerator(powers));

            // when
            carGroup.move();
            carGroup.move();

            // then
            List<CarDto> winners = carGroup.getWinners();
            assertThat(winners).containsExactly(new CarDto("mang", 2),
                    new CarDto("pobi", 2));
        }
    }

}
