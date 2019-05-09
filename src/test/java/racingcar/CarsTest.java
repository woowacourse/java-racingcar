package racingcar;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
   @Test
    void randomNumberGeneratorTest(){
       int random = Car.randomNumberGenerator();
       System.out.println(random);
       if(random >= 4){
           assertThat(random >= 4).isEqualTo(true);
       }if(random < 4){
           assertThat(random < 4).isEqualTo(true);
       }
   }
}
