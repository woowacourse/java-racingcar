import java.util.List;

public interface CarRepositoryInterface {
    void saveCar(Car car);

    void addPosition(String carName);

    int findPositionByName(String name);

    List<String> findNameByPosition(int position);

    int countOfCars();

    List<Integer> positions();

    List<String> carNames();

}
