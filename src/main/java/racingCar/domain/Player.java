package racingCar.domain;

public class Player {
    private final String name;
    private int position;
    public Player (final String name) {
        this.name = name;
    }

    public void play(boolean shouldGo) {
        if(shouldGo) {
            goOneStep();
        }
    }

    private void goOneStep() {
        position += 1;
    }

    public PlayerInfoPair getPlayerInfoPair() {
        return new PlayerInfoPair(name, position);
    }
}
