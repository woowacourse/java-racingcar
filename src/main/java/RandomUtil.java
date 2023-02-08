import java.util.Random;

public class RandomUtil {
    private final static int RANDOM_RANGE = 10;
    private final static int MOVE_STANDARD = 4;

    private RandomUtil() {

    }


    public static boolean canMoveForward(int randomNumber) {
        if (randomNumber >= MOVE_STANDARD) {
            return true;
        }

        return false;
    }

    public static int createRandomNumber() {
        return new Random().nextInt(RandomUtil.RANDOM_RANGE);
    }

}
