package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.utils.exception.DuplicateNameException;
import racingcar.utils.exception.NotEnoughCarException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @Test
    public void 이름이_중복되는_경우_예외처리() {
        String[] names = {"pobi", "brown", "pobi"};
        assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(DuplicateNameException.class);
    }

    @Test
    public void 자동차가_1대인_경우_예외처리() {
        String[] name = {"pobi"};
        assertThatThrownBy(() -> new Cars(name))
                .isInstanceOf(NotEnoughCarException.class);
    }
}