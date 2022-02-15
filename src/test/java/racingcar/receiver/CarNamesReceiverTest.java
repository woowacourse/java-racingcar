package racingcar.receiver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.exception.CarNameException;

public class CarNamesReceiverTest {

    CarNamesReceiver carNamesReceiver;

    @BeforeEach
    void setUp() {
        carNamesReceiver = new CarNamesReceiver();
    }

    @Test
    public void 컴마로_자동차_이름_분리() {
        List<String> expect = carNamesReceiver.parseNames("pobi,crong,honux");
        assertThat(expect).containsExactly("pobi", "crong", "honux");
    }

    @Test
    public void 이름이_6글자_이상인_경우_예외_발생() {
        assertThatThrownBy(() -> carNamesReceiver.validateCarNames("pobiisawesome,jason,crong")).isInstanceOf(
                CarNameException.class).hasMessage(CarNamesReceiver.INVALID_LENGTH_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_공백일_경우_예외_발생() {
        assertThatThrownBy(() -> carNamesReceiver.validateCarNames("pobi,,crong")).isInstanceOf(
                CarNameException.class).hasMessage(CarNamesReceiver.EMPTY_NAME_ERROR_MESSAGE);
    }

    @Test
    public void 이름이_중복일_경우_예외_발생() {
        assertThatThrownBy(() -> carNamesReceiver.validateCarNames("pobi,pobi,crong")).isInstanceOf(
                CarNameException.class).hasMessage(CarNamesReceiver.DUPLICATE_NAME_ERROR_MESSAGE);
    }
}
