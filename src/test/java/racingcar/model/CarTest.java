package racingcar.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    @Test
    void 자동차_이동_검사(){
        Car car=new Car("tmp");
        assertThat(car.getPosition()).isEqualTo(0);     // 초기에 0인지 확인
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);     // 1회 이동했을 때 Poistion 변경 확인
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(1);     // 이동을 하지 않았을 때 Position이 변경되지 않음을 확인
    }

}
