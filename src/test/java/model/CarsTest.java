package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static model.Cars.checkCarNamesDuplication;
import static model.Cars.checkCarNamesFormat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarsTest {
    @Test
    void cars_create_test() {
        String carNames = "pobi,aiden,cozy";
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new CarName("pobi")));
        cars.add(new Car(new CarName("aiden")));
        cars.add(new Car(new CarName("cozy")));

        assertThat(cars.equals(new Cars(carNames).getCars())).isTrue();
    }

    @Test
    void 자동차이름_형식_예외_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            checkCarNamesFormat("pobi, aiden");
            checkCarNamesFormat(" pobi,aiden");
            checkCarNamesFormat("pobi,aiden ");
            checkCarNamesFormat("pobi,aiden,");
        });
    }

    @Test
    void 자동차이름_중복_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(new CarName("aiden")));
        cars.add(new Car(new CarName("aiden")));
        cars.add(new Car(new CarName("cozy")));

        assertThrows(IllegalArgumentException.class, () -> {
            checkCarNamesDuplication(cars, new Car(new CarName("aiden")));
        });
    }

    @Test
    void Cars_복제_테스트() {
        Cars sourceCars = new Cars("aaa,bbb,ccc");
        Cars copyCars = sourceCars.copy();
        assertThat(sourceCars != copyCars).isTrue();

        List<Car> sourceCarsValues = sourceCars.getCars();
        List<Car> copyCarsValues = copyCars.getCars();
        assertThat(sourceCarsValues != copyCarsValues).isTrue();
        assertThat(sourceCarsValues.size() == copyCarsValues.size()).isTrue();

        for (int i = 0; i < sourceCars.getCars().size(); i++) {
            assertThat(sourceCarsValues.get(i) != copyCarsValues.get(i)).isTrue();
        }
    }
}