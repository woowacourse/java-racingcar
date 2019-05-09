package racing.view;

import racing.domain.Car;

import java.util.Iterator;
import java.util.List;

public class OutputView {
    public static void printRace(List<Car> carList){
        Iterator <Car> it = carList.iterator();
        while(it.hasNext()){
            Car car = it.next();
            System.out.println(car);
        }
        System.out.println();
    }
}
