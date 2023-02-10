package domain;

public class Judge {

    private final int MOVING_STANDARD = 4;

    public boolean judgeDriving(int number) {
        return number >= MOVING_STANDARD;
    }
}
