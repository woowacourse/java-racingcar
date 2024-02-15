package view;

import domain.Car;

import java.util.List;

public class OutputView {
    private final MessageResolver messageResolver;

    public OutputView(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    public void printRaceResult(List<Car> cars) {
        System.out.println(messageResolver.resolveMoveResultMessage(cars));
    }

    public void printWinner(List<Car> winners) {
        System.out.println(messageResolver.resolveWinnerMessage(winners));
    }
}
