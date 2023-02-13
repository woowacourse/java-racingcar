package car.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {
    @Test
    @DisplayName("생성자 테스트")
    void 생성자_테스트(){
        Car car = new Car("물떡", 1);
        assertThat(car.getName()).isEqualTo("물떡");
        assertThat(car.getPosition()).isEqualTo(1);
    }
    @Test
    @DisplayName("이름이 있는지 확인하는 테스트")
    void 이름을_가진다() {
        Car car = new Car("물떡");

        assertThat(car.getName()).isEqualTo("물떡");
    }
    @Test
    @DisplayName("더큰 위치를 반환하는 테스트")
    void 더큰_위치_반환_테스트(){
        Car car = new Car("물떡",3);
        assertThat(car.selectMaxPosition(1)).isEqualTo(3);
    }
    @Test
    @DisplayName("위치가 있는지 확인하는 테스트")
    void 위치를_가진다() {
        Car car = new Car("물떡", 2);

        assertThat(car.getPosition()).isEqualTo(2);
    }
    @Test
    @DisplayName("차가 움직이는지 테스트")
    void 차가_움직이는지_테스트(){
        Car car = new Car("물떡",0);
        car.move(()->true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("차 이름 가져오는지 테스트")
    void Get_이름_테스트(){
        Car car = new Car("물떡",0);
        assertThat(car.getName()).isEqualTo("물떡");
    }
    @Test
    @DisplayName("차 위치 가져오는지 테스트")
    void Get_위치_테스트(){
        Car car = new Car("물떡",3);
        assertThat(car.getPosition()).isEqualTo(3);
    }
    @ParameterizedTest(name = "움직일 수 있는지 확인하는 테스트")
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void 움직일_수_있으면_전진하고_아니면_정지한다(boolean provided, int result) {
        Car car = new Car("물떡");
        car.move(() -> provided);
        assertThat(car.getPosition()).isEqualTo(result);
    }

    @Test
    @DisplayName("위치는 시작점보다 작은지 확인하는 테스트")
    void 위치는_시작점보다_작으면_안된다() {
        assertThatThrownBy(() -> new Car("포비", -1))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @ParameterizedTest(name = "이름 길이가 1글자 이상 5글자 이하인지 확인하는 테스트")
    @ValueSource(strings = {"", "aaaaaa"})
    void 이름_길이_1글자이상_5글자_이하이다(String provided) {

        assertThatThrownBy(() -> new Car(provided))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
