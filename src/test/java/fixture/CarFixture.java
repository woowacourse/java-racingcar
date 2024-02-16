package fixture;

import java.util.Arrays;
import java.util.List;
import model.Car;
import model.Name;

public class CarFixture {
    public static Car 자동차() {
        return 자동차("prin");
    }

    public static Car 자동차(String name) {
        return new Car(new Name(name));
    }

    public static List<Car> 자동차들(String... names) {
        return Arrays.stream(names)
                .map(CarFixture::자동차)
                .toList();
    }
}
