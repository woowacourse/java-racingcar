package racing;

import racing.domain.CarFactory;
import racing.domain.Cars;
import racing.domain.RandomNumberGenerator;
import racing.view.InputView;
import racing.view.OutputView;
import racing.view.RacingReqDTO;

public class Race {

    public void run() {
        RacingReqDTO reqDTO = InputView.inputRequest();
        Cars cars = CarFactory.makeCars(reqDTO.getNames());

        OutputView.printProcess(cars);
        for (int i = 0; i < reqDTO.getCount(); i++) {
            cars.go(new RandomNumberGenerator());
            OutputView.printCarsInformation(cars);
        }
        OutputView.printWinners(cars.getWinner());
    }

}
