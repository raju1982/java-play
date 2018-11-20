package car.dealership;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Customer {

    private String name;
    private int customerID;
    private List<Car> purchasedCar;
    private static Random r = new Random();

    public String getName() {
        return name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public Customer(String name) {
        this.name = name;
        this.customerID = r.ints(500, 6000).findFirst().getAsInt();
    }

    public void addPurchasedCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("null value.");
        }
        if (purchasedCar == null) {
            purchasedCar = new ArrayList<Car>();
        }
        purchasedCar.add(car);
    }

    public List<Car> getPurchasedCar() {
        return purchasedCar;
    }

}
