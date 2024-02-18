package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 자동차들 동작 테스트")
public class CarGroupTest {

    @Test
    @DisplayName("이름에 따라 자동차들이 정상적으로 생성되는가")
    void is_cars_correctly_made_by_name() {
        // given
        String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};

        // when
        CarGroup carGroup = new CarGroup(carNames);

        // then
        assertThat(carGroup.getAllCars()).extracting("name")
                .containsExactlyElementsOf(Arrays.stream(carNames).toList());
    }

    @Nested
    @DisplayName("우승자 반환 테스트")
    class WinnersReturnTest {

        @Test
        @DisplayName("단독 우승인 경우를 정상적으로 반환되는가")
        void return_single_winner_correctly_test() {
            // given
            String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            CarGroup carGroup = new CarGroup(carNames);

            // when
            List<Car> cars = carGroup.getAllCars();
            Car winner = cars.get(0);
            winner.move(9);

            // then
            List<Car> winners = carGroup.getWinners();
            assertThat(winners).containsExactly(winner);
        }

        @Test
        @DisplayName("복수 우승인 경우를 정상적으로 반환되는가")
        void return_multiple_winners_correctly_test() {
            // given
            String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            CarGroup carGroup = new CarGroup(carNames);

            // when
            List<Car> cars = carGroup.getAllCars();
            Car winnerA = cars.get(0);
            winnerA.move(9);
            Car winnerB = cars.get(1);
            winnerB.move(6);

            // then
            List<Car> winners = carGroup.getWinners();
            assertThat(winners).containsExactlyElementsOf(List.of(winnerA, winnerB));
        }

        @Test
        @DisplayName("우승자가 없는가")
        void no_winners_test() {
            // given
            String[] carNames = new String[]{"mang", "weve", "pobi", "neo"};
            CarGroup carGroup = new CarGroup(carNames);

            // then
            List<Car> winners = carGroup.getWinners();
            assertThat(winners).isEmpty();
        }
    }

}
