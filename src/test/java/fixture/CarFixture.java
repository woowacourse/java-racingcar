package fixture;

import model.Car;
import model.Name;

public class CarFixture {
    public static Car 자동차() {
        return 자동차("prin");
    }

    public static Car 자동차(String name) {
        return new Car(new Name(name));
    }
}
