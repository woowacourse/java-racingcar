package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceCarInfoTest {
    @Test
    @DisplayName("경주 진행중인 자동차 결과를 저장한다")
    void createRaceCarInfo(){
        Name name = new Name("poby");
        Car car=new Car(name);

        RaceCarInfo raceCarInfo = RaceCarInfo.from(car);

        assertInstanceOf(RaceCarInfo.class, raceCarInfo);

    }

}