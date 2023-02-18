package genertor;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    @Override
    public int getNum() {
        Random random = new Random();
        return random.nextInt(9);
    }
}
