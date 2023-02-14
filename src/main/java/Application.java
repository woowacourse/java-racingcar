import common.ExecuteContext;
import controller.CarRaceController;
import domain.repository.CarRaceResultRepositoryImpl;
import domain.service.CarRaceService;
import domain.service.CarRaceServiceImpl;
import domain.service.RandomNumberGenerator;
import domain.validation.InputValidationChain;
import domain.validation.impl.EmptyValueValidationChain;
import domain.validation.impl.InputValidateSuccessChain;
import domain.validation.impl.NumberRangeValidationChain;
import domain.validation.impl.PositiveNumberValidationChain;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        config().start();
    }

    private static CarRaceController config() {
        return new CarRaceController(new InputView(), new OutputView(),
            makeValidator(), makeService(), new ExecuteContext());
    }

    private static CarRaceService makeService() {
        return new CarRaceServiceImpl(new CarRaceResultRepositoryImpl(),
            new RandomNumberGenerator());
    }

    private static InputValidationChain makeValidator() {
        final InputValidationChain emptyValueValidationChain = new EmptyValueValidationChain();
        final InputValidationChain numberRangeValidationChain = new NumberRangeValidationChain();
        final InputValidationChain positiveNumberValidationChain = new PositiveNumberValidationChain();
        final InputValidationChain inputValidationChain = new InputValidateSuccessChain();
        emptyValueValidationChain.setNext(numberRangeValidationChain);
        numberRangeValidationChain.setNext(positiveNumberValidationChain);
        positiveNumberValidationChain.setNext(inputValidationChain);
        return emptyValueValidationChain;
    }
}
