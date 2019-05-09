package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    Car car;

    @BeforeEach
    void setup(){
        car=new Car("tmp");
    }

    @Test
    void 자동차_이동_검사(){
        assertThat(car.getPosition()).isEqualTo(0);     // 초기에 0인지 확인
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);     // 1회 이동했을 때 Poistion 변경 확인
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(1);     // 이동을 하지 않았을 때 Position이 변경되지 않음을 확인
    }

    @Test
    void maxPosition_비교_검사(){
        car.move(true);
        car.move(true);
        car.move(true);
        assertThat(car.getMaxPosition(2)).isEqualTo(3);
        assertThat(car.getMaxPosition(3)).isEqualTo(3);
        assertThat(car.getMaxPosition(4)).isEqualTo(4);
    }

}
