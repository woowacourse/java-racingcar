import domain.Car;
import view.InputView;

import java.util.ArrayList;

public class Main {


    public static void main(String [] args) {

        ArrayList<Car> cars = InputView.readCars();
        int n = InputView.readNum();

        CarRacing carRacing = new CarRacing();
        carRacing.play(cars, n);
    }
}
