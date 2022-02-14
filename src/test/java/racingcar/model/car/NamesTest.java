package racingcar.model.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NamesTest {
    @DisplayName("from 메소드는")
    @Nested
    class From {
        @Test
        void 중복_이름을_입력_받지_않았다면() {
            Names names = Names.from("hudi,tonic");
            Assertions.assertThat(names.get())
                    .contains(Name.from("hudi"), Name.from("tonic"));
        }

        @Test
        void 중복_이름을_입력_받았다면() {
            Assertions.assertThatThrownBy(() -> Names.from("tonic,tonic"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
