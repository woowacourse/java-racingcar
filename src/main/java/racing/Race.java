package racing;

import racing.car.CarFactory;
import racing.car.Cars;
import racing.view.RacingInputView;
import racing.view.RacingReqDTO;

public class Race {

    public void run() {
        // List<String 이름들, count
        RacingReqDTO reqDTO = RacingInputView.inputRequest();

        Cars cars = CarFactory.makeCars(reqDTO.getNames());

        for (int i = 0; i < reqDTO.getCount(); i++) {

        }
    }

}
