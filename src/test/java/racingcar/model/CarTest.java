package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CarTest {

    Car car;

    @BeforeEach
    void setup() {
        car = new Car("tmp", 0);
    }

    @Test
    void 자동차_이름_NULL_검사() {
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
    }

    @Test
    void 자동차_이름_Blank_검사() {
        assertThrows(IllegalArgumentException.class, () -> new Car(" "));
        assertThrows(IllegalArgumentException.class, () -> new Car(""));
    }

    @Test
    void 자동차_이름_Alphabet_검사(){
        assertThrows(IllegalArgumentException.class, () -> new Car("a1"));
    }

    @Test
    void 자동차_이름_Length_검사(){
        assertThrows(IllegalArgumentException.class, ()-> new Car("abcdefg"));
    }

    @Test
    void 올바른_자동차_이름_생성_검사(){
        assertThat(new Car("abcd").isEqualName("abcd")).isTrue();
    }

    @Test
    void 자동차_정지() {
        car.move(3);
        assertThat(car).isEqualTo(new Car("tmp", 0));
    }

    @Test
    void 자동차_이동() {
        car.move(4);
        assertThat(car).isEqualTo(new Car("tmp", 1));
    }

    @Test
    void 자신의_Position이_maxPosition이_맞을_경우(){
        car=new Car("a",5);
        assertThat(car.isMaxPosition(5)).isTrue();
    }

    @Test
    void 자신의_Position이_maxPosition이_아닐_경우(){
        car=new Car("a",0);
        assertThat(car.isMaxPosition(5)).isFalse();
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
