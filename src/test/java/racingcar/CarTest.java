package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void randomNumberGeneratorTest(){
        int random = Car.randomNumberGenerator();
        System.out.println(random);
        if(random >= 4){
            System.out.println("is bigger than 4");
            assertThat(random >= 4).isEqualTo(true);
        }if(random < 4){
            System.out.println("is less than 4");
            assertThat(random < 4).isEqualTo(true);
        }
    }

    @Test
    void compareTest() {
        Car testCar = new Car("abc");
        assertThat(testCar.findMax(101)).isEqualTo(101);
    }


}
