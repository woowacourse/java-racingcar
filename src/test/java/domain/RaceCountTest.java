package domain;

import domain.race.RaceCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
public class RaceCountTest {

    @Test
    @DisplayName("숫자를 통해 레이스횟수를 생성한다.")
    public void createRaceCount(){
        //Given
        Integer value = 5;

        //When
        RaceCount raceCount = new RaceCount(value);

        //Then
        assertInstanceOf(RaceCount.class,raceCount);
    }
    @ParameterizedTest
    @DisplayName("0보다 작은 값을 입력하면 예외를 발생한다.")
    @ValueSource(ints = {0,-1})
    public void throwExceptionWhenLessThanZero(Integer value){

        assertThrows(IllegalArgumentException.class,()->{
            new RaceCount(value);
        });

    }
}
