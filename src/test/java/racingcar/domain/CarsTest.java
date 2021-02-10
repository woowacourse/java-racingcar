package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.utils.NameHandler;

import java.util.Arrays;
import java.util.List;

class CarsTest {
    @DisplayName("입력한 이름이 중복되는 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, pobi , pobi "})
    void expectDuplicatedExceptionTest(String nameString) {
        assertThatThrownBy(() -> {
            List names = NameHandler.splitNames(nameString);
            Cars.createByNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 이름이 하나 뿐인 경우")
    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    void expectOnlyCarExceptionTest(String onlyName) {
        assertThatThrownBy(() -> {
            List names = Arrays.asList(new Name[]{Name.create(onlyName)});
            Cars.createByNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 이름 문자열에 이상이 없는 경우의 Cars 생성")
    @ParameterizedTest
    @ValueSource(strings = {"pobi, jin, corgi"})
    void checkInstanceWithValidNames(String input) {
        List<Name> names = NameHandler.splitNames(input);
        Cars cars = Cars.createByNames(names);

        for (Name name : names) {
            assertThat(cars.contains(Car.createByName(name))).isEqualTo(true);
        }
    }

    // XXX :: 우승 자동차를 검증할 수 있는 방법에 대한 고민
}
