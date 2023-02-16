package domain;

public class Coin {

    private int remaining;

    public Coin(int remaining) {
        this.remaining = remaining;
    }

    public void use() {
        if (isLeft()) {
            remaining--;
        }
    }

    public boolean isLeft() {
        return remaining > 0;
    }
}
