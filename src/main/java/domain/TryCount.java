package domain;

public class TryCount {
    private int amount;

    public TryCount(int amount) {
        if(amount < 1) {
            throw new IllegalArgumentException();
        }
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
