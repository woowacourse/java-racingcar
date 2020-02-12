package racingCar.domain;

public class Player {
    private final String name;
    private int position;
    public Player (final String name) {
        this.name = name;
    }

    public void play() {
        if(RandomGenerator.decideGoOrStop()) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
