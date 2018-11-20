package car.dealership;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Employee {
    private String name;
    private List<Car> soldCar;
    private int employeeID;
    private static Random r = new Random();

    public int getEmployeeID() {
        return employeeID;
    }

    public Employee(String name) {
        this.name = name;
        this.employeeID = r.ints(10, 499).findFirst().getAsInt();
    }

    public List<Car> getSoldCar() {
        return soldCar;
    }

    public void addSoldCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("null value.");
        }
        if (soldCar == null) {
            soldCar = new ArrayList<Car>();
        }
        soldCar.add(car);
    }
}
