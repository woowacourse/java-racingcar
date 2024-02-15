public class RandomGenerator {

    private RandomGenerator() {
    }

    public static int getRandomNumber() {
        return (int) (Math.random() * 10);
    }
}
