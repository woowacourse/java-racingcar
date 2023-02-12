package racingcar.domain;

import static java.text.MessageFormat.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.TestNumberGenerator;

public class CarsTest {

    @Test
    @DisplayName("이름 목록이 비어있으면 예외를 던진다.")
    void should_throwException_when_emptyNames() {
        final List<String> names = Collections.emptyList();

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(format("입력된 자동차 개수[{0}]: 자동차는 1대 이상, 100대 이하만 경주 가능합니다.", names.size()));
    }

    @Test
    @DisplayName("이름 목록에 중복이 존재하면 예외를 던진다.")
    void should_throwException_when_duplicateNames() {
        final List<String> names = List.of("허브", "다즐", "허브");

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(format("입력된 이름 목록{0}: 자동차 이름은 중복될 수 없습니다.", names));
    }

    @Test
    @DisplayName("이름 목록의 개수가 100개를 초과하면 예외를 던진다.")
    void should_throwException_when_tooManyNames() {
        final List<String> names = new ArrayList<>();

        for (int i = 0; i <= 100; i++) {
            names.add("이름" + i);
        }

        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(format("입력된 자동차 개수[{0}]: 자동차는 1대 이상, 100대 이하만 경주 가능합니다.", names.size()));
    }

    @ParameterizedTest(name = "개수: {0}")
    @ValueSource(ints = {1, 50, 100})
    @DisplayName("이름 목록의 개수가 유효하면 예외를 던지지 않는다.")
    void should_generateCars_when_validNames(final int size) {
        final List<String> names = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            names.add("이름" + i);
        }

        assertThatNoException().isThrownBy(() -> new Cars(names));
    }

    @Test
    @DisplayName("move 메서드는 전진 가능한 자동차들을 이동시킨다.")
    void should_moveCars_when_move() {
        final Cars cars = new Cars(List.of("car1", "car2", "car3"));
        final NumberGenerator numberGenerator = new TestNumberGenerator(Lists.newArrayList(4, 3, 5));

        cars.move(numberGenerator);

        assertThat(cars.getCars())
                .extracting(Car::getPosition)
                .containsExactly(1, 0, 1);
    }

    @Test
    @DisplayName("findWinners 메서드는 우승자 이름 목록을 반환한다.")
    void should_returnWinnersName_when_findWinners() {
        final Cars cars = new Cars(List.of("car1", "car2", "car3"));
        final NumberGenerator numberGenerator = new TestNumberGenerator(Lists.newArrayList(4, 3, 5));
        cars.move(numberGenerator);

        final List<String> result = cars.findWinners();

        assertThat(result).containsExactly("car1", "car3");
    }
}
