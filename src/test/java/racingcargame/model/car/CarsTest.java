package racingcargame.model.car;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcargame.dto.CarDto;
import racingcargame.model.movevaluegenerator.MoveValueGenerator;

class CarsTest {

    class MoveValueGeneratorTest implements MoveValueGenerator {
        private int base = 0;

        @Override
        public int generateMoveValue() {
            base += 1;
            return base;
        }
    }

    private final MoveValueGenerator moveValueGenerator = new MoveValueGeneratorTest();

    @DisplayName("자동차 이름이 중복되면 오류를 발생한다.")
    @Test
    void Cars_checkDuplicate() {
        final List<String> carNames = List.of("포인", "비니", "마크", "비니");

        assertThatThrownBy(() -> {
            Cars cars = new Cars(carNames);
        }).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("[error] 입력한 자동차 이름 중 중복되는 이름이 있습니다.");
    }

    @DisplayName("자동차를 움직임 값만큼 전진시킨다.")
    @Test
    void moveCars() {
        final Cars cars = new Cars(List.of("포인", "비니", "마크"));
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

    @DisplayName("가장 멀리간 자동차(들)을 우승자로 뽑는다.")
    @Test
    void findWinner() {
        final Cars cars = new Cars(List.of("포인", "비니", "마크"));
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