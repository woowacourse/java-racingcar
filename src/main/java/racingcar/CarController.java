package racingcar;

import java.util.List;
import racingcar.domain.CarStatus;
import racingcar.domain.Circuit;
import racingcar.domain.Engine;
import racingcar.random.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;

    public CarController(InputView inputView, OutputView outputView, NumberGenerator numberGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        List<String> carNames = inputView.getNames();
        int tryNumber = inputView.getTryNumber();

        Engine engine = new Engine(numberGenerator);
        Circuit circuit = new Circuit(carNames, engine);

        outputView.printResultMessage();
        for (int tries = 0; tries < tryNumber; tries++) {
            circuit.startRace();
            List<CarStatus> raceResults = circuit.getRaceResults();
            outputView.printResults(raceResults);
        }

        reportWinners(circuit);
    }

    private void reportWinners(Circuit circuit) {
        List<CarStatus> raceResults = circuit.getRaceResults();
        List<CarStatus> winners = circuit.getWinners(raceResults);
        outputView.printWinners(winners);
    }

}
