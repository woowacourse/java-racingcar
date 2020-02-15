package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "metro", "sony"})
    void Should_Return_True_When_Get_Name(String name) {
        CarName carName = new CarName(name);

        Assertions.assertThat(carName.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiconnan", "subway", "sonypark"})
    void Throw_Error_When_CarName_isMoreThan_5(String name) {
        Assertions.assertThatThrownBy(() -> new Car(new CarName(name)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "metro", "sony2"})
    void Not_Throw_Error_When_CarName_isLessThanOrEqualTo5_(String name) {
        Assertions.assertThatCode(() -> new Car(new CarName(name)))
            .doesNotThrowAnyException();

    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void Throw_when_Not_ValidName(String name) {

        Assertions.assertThatThrownBy(() ->
            new CarName(name))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageMatching("공백만 입력 할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"  a", " sd "})
    void when_is_ValidName(String name) {
        Assertions.assertThatCode(() ->
            new CarName(name))
            .doesNotThrowAnyException();
    }

    // @Test
    // void Throw_When_DuplicatedName() {
    //     String[] names = {"pobi", "pobi"};
    //
    //     assertThatThrownBy(() ->
    //         Validator.validateCarNames(names))
    //         .isInstanceOf(IllegalArgumentException.class)
    //         .hasMessageMatching("중복된 이름입력이 불가합니다.");
    // }
    //
    // @Test
    // void When_NotDuplicatedName() {
    //     String[] names = {"pobi", "pob"};
    //
    //     assertThatCode(() ->
    //         Validator.validateCarNames(names)).doesNotThrowAnyException();
    // }
}
