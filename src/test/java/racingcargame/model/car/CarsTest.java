package racingcargame.model.car;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.dto.CarDto;
import racingcargame.model.carmovevalue.MoveValueGenerator;

class CarsTest {

    class MoveValueGeneratorTest implements MoveValueGenerator {
        private int base = 0;

        @Override
        public int getMoveValue() {
            base += 1;
            return base;
        }
    }

    private final Cars cars = new Cars(List.of("포인", "비니", "마크"));
    private final MoveValueGenerator moveValueGenerator = new MoveValueGeneratorTest();

    @DisplayName("입력된 자동차 이름 중 중복되는 이름이 있는지 테스트")
    @Test
    void Cars_checkDuplicate() {
        final List<String> carNames = List.of("포인", "비니", "마크", "비니");

        assertThatThrownBy(() -> {
            Cars cars = new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 입력한 자동차 이름 중 중복되는 이름이 있습니다.");
    }

    @DisplayName("자동차들 이동이 정상적으로 이루어 지는지 테스트")
    @Test
    void moveCars() {
        cars.moveCars(moveValueGenerator);
        final  List<CarDto> actual = cars.bringCarsInformation();
        final CarDto first = new CarDto("포인", 1);
        final CarDto second = new CarDto("비니", 2);
        final CarDto third = new CarDto("마크", 3);
        final List<CarDto> expected = List.of(first, second, third);

        IntStream.range(0, actual.size()).forEach(index -> {
            assertThat(actual.get(index).getName()).isEqualTo(expected.get(index).getName());
            assertThat(actual.get(index).getPosition()).isEqualTo(expected.get(index).getPosition());
        });
    }

    @DisplayName("우승자 선정이 올바르게 되는지 테스트")
    @Test
    void findWinner() {
        cars.moveCars(moveValueGenerator);
        final List<CarDto> winner = cars.findWinner();
        final CarDto third = new CarDto("마크", 3);
        final List<CarDto> expected = List.of(third);

        IntStream.range(0, winner.size()).forEach(index -> {
            assertThat(winner.get(index).getName()).isEqualTo(expected.get(index).getName());
            assertThat(winner.get(index).getPosition()).isEqualTo(expected.get(index).getPosition());
        });
    }
}