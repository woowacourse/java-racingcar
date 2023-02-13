package racing.domain;

import racing.ui.output.OutputView;

import java.util.List;

import static racing.ui.output.OutputView.HYPHEN;

public class Car {

    private final String name;
    private int step;

    public Car(String name) {
        this.name = name;
        this.step = 0;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public void move() {
        this.step++;
    }

    public String getCarStepForm() {
        return name + OutputView.COLON + HYPHEN.repeat(step);
    }

    public int getCarStep(int winnerStep) {
        return Math.max(winnerStep, step);
    }

    public List<String> ifMeetAddWinners(List<String> winners, int winnerStep) {
        if (step == winnerStep) {
            winners.add(name);
            return winners;
        }
        return winners;
    }
}
