import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CarTest {
    Car car1;
    Car car2;
    Car car3;
    @BeforeAll
    static void setup(){
        car1 = new Car("jerry");
        car2 = new Car("jena");
        car3 = new Car("poby");

        for (int i = 0; i < 5; i++){
            car1.move();
            car2.move();
            car3.move();
        }
    }

    @Test
    void testToString() {
        int distance = car1.getDistance();
        assertThat(car1.toString().split(": ").length).isEqualTo(distance);
    }

    @Test
    void move() {
    }
}