package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @ParameterizedTest
    @DisplayName("정상 자동차 이름 테스트")
    @ValueSource(strings={"푸우","에코","그레이","콩하나","깃짱","이리내"})
    public void validCarNameTest(String carName){
        CarName testCarName = new CarName(carName);
        assertThat(testCarName).isInstanceOf(CarName.class);
    }

    @ParameterizedTest
    @DisplayName("비정상 자동차 이름 예외 테스트")
    @ValueSource(strings={"가나다라마바사","다섯글자이상"})
    public void invalidCarNameTest(String carName){
        assertThatThrownBy(()->{
            CarName testCarName = new CarName(carName);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
