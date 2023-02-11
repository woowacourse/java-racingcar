import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    @Test
    @DisplayName("move 함수를 실행시켰을 때 distance 가 move 함수의 결과(전진/멈춤)에 따라 잘 변경되는지 확인 테스트")
    void move() {
        Car car = new Car("jena");
        for (int i = 0; i < 5; i++) {
            car.move();
        }
        assertThat(car.toString().split(": ")[1].length())
                .isEqualTo(car.getDistance());
    }
}
