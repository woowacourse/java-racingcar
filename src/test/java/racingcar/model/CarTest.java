package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CarTest {

    Car car;

    @BeforeEach
    void setup(){
        car=new Car("tmp",0);
    }

    @Test
    void 자동차_정지(){
        car.move(3);
        assertThat(car).isEqualTo(new Car("tmp",0));
    }

    @Test
    void 자동차_이동(){
        car.move(4);
        assertThat(car).isEqualTo(new Car("tmp",1));
    }


//
//    @Test
//    void maxPosition_비교_검사(){
//        car.move(true);
//        car.move(true);
//        car.move(true);
//        assertThat(car.getMaxPosition(2)).isEqualTo(3);
//        assertThat(car.getMaxPosition(3)).isEqualTo(3);
//        assertThat(car.getMaxPosition(4)).isEqualTo(4);
//    }

}
