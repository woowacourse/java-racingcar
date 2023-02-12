package domain;

public class Coin {

    private int remaining;

    public Coin(int remaining) {
        this.remaining = remaining;
    }

    public void use() {
        remaining--;
    }

    public boolean isLeft() {
        return remaining > 0;
    }
}
