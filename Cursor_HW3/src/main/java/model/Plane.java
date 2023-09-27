package model;

public class Plane {
    private String model;
    private String serialNumber;
    private int seats;

    public Plane(String model, String serialNumber, int seats) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.seats = seats;
    }

    public String getModel() {
        return model;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", seats=" + seats +
                '}';
    }
}
