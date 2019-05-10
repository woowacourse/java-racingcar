package racing.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @Test
    void 경계값에_따른_차량이동() {
        Car car = new Car("pobi", 0);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }
    
    @Test
    void create_name() {
        assertThat(new Car("pobi").equals(new Car("pobi"))).isEqualTo(true);
    }

    @Test
    void create_name_blank() {
        assertThrows(IllegalArgumentException.class, () -> {
           new Car("");
        });
    }

    @Test
    void create_name_5자_초과() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Car("pobing");
        });
    }

    @Test
    void move() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car).isEqualTo(new Car("pobi", 1));
    }

    @Test
    void stop() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.matchPosition(0)).isEqualTo(true);
    }

    @Test
    void create(){
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
        //equals와 hashcode를 재정의하자.
    }

//    @Test
//    void create_name_null(){
//       assertThrows()
//    }

//    @Test
//    void create_5자_초과(){
//
//    }

//    @Test
//    void create_name_blank(){
//
//    }
}
