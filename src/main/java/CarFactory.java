public class CarFactory {
    private final RandomNumberFactory factory = new RandomNumberFactory();
    public void makeCar(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            Car car = new Car();
            GameStarter.carList.add(car);
        }
    }

    public double insertRandomNumber() {
        return factory.makeRandomNumber();
    }
}
