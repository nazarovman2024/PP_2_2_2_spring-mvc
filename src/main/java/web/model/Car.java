package web.model;

public class Car {
    private static long counter = 0;
    private long id;
    private String model;
    private int series;

    public Car() {}
    public Car(String model, int series) {
        this.id = counter++;
        this.model = model;
        this.series = series;
    }

    public long getId() { return id; }

    public String getModel() { return model; }

    public int getSeries() { return series; }
}
