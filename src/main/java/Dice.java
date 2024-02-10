import java.util.Random;

public class Dice {
    Random random = new Random();
    private int dice;

    public Dice() {
        this.dice = random.nextInt(10);
    }

    public boolean validateMove() {
        Dice check = new Dice();
        return check.dice > 4;
    }

}
