package racing;

import racing.car.Car;
import racing.car.CarFactory;
import racing.view.RacingInputView;
import racing.view.RacingReqDTO;

import java.util.List;

public class Race {

    public void run() {
        // List<String 이름들, count
        RacingReqDTO reqDTO = RacingInputView.inputRequest();

        List<Car> cars = CarFactory.makeCars(reqDTO.getNames());

    }

}
