package racingcar.model.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NamesTest {
    @DisplayName("from 메소드로 여러 이름을 콤마(,) 구분자로 넘겨주면, 각 이름이 Names 에 추가된다.")
    @Test
    void from() {
        Names names = Names.from("hudi,tonic");
        Assertions.assertThat(names.get())
                .contains(Name.from("hudi"), Name.from("tonic"));
    }

    @DisplayName("from 메소드에 중복된 이름이 주어지면, 각 예외가 발생 한다.")
    @Test
    void fromWithDuplicatedNames() {
        Assertions.assertThatThrownBy(() -> Names.from("tonic,tonic"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
