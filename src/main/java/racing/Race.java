package racing;

import racing.car.CarFactory;
import racing.car.Cars;
import racing.car.numbergenerator.RandomNumberGenerator;
import racing.view.OutputView;
import racing.view.RacingInputView;
import racing.view.RacingReqDTO;

public class Race {

    public void run() {
        // List<String 이름들, count
        RacingReqDTO reqDTO = RacingInputView.inputRequest();

        Cars cars = CarFactory.makeCars(reqDTO.getNames());

        System.out.println("실행 결과");
        OutputView.printCarsInformation(cars);
        System.out.println();

        for (int i = 0; i < reqDTO.getCount(); i++) {
            cars.go(new RandomNumberGenerator());
            OutputView.printCarsInformation(cars);
            System.out.println();
        }
    }

}
