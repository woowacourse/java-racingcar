public class CarFactory {

    public void makeCar(int carNumber) {
        for (int i = 0; i < carNumber; i++) {
            Car car = new Car();
            GameStarter.carList.add(car);
        }
    }
}
