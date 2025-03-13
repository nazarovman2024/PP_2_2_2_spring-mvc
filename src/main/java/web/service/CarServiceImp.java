package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Service
public class CarServiceImp implements CarService {
    private final List<Car> cars;

    public CarServiceImp() {
        AtomicInteger series = new AtomicInteger(1);
        Stream<Car> carStream = Stream.generate(() -> new Car("Car", series.getAndIncrement()))
                .limit(5);

        cars = carStream.toList();
    }

    @Override
    public List<Car> getCars(int count) {
        return count >= 5 ? cars : cars.subList(0, count);
    }
}
