package car.dealership;

import org.testng.Assert;

import java.util.*;

import static org.testng.Assert.*;

public class Car {
    private String vin;
    private String make;
    private String model;

    public Car(String make, String model, String vin) {
        this.vin = vin;
        this.make = make;
        this.model = model;
    }

    public String getVin() {
        return this.vin;
    }

    public String getMake() {
        return this.make;
    }

    @Override
    public String toString() {
        return String.format("make : %s , model : %s, vin : %s", make, model, vin);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car)) {
            return false;
        }
        Car tmp = (Car) obj;
        if (this.getVin().equalsIgnoreCase(tmp.getVin())) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Car fit = new Car("Honda", "Fit", "1vnm678");
        System.out.println(fit);
        Car fito = new Car("Monda", "Lit", "1vnm678");
        System.out.println(fit.equals(fito));
        Assert.assertEquals(fit, fito);

        Comparator<Car> fido = new Comparator<Car>() {
            @Override
            public int compare(Car a, Car b) {
                return a.getMake().compareTo(b.getMake());
            }
        };

        Comparator<Car> reverseFido = new Comparator<Car>() {
            @Override
            public int compare(Car a, Car b) {
                return b.getMake().compareTo(a.getMake());
            }
        };

        Car[] lot = new Car[]{fit, fito};
        //in order to print array use Arrays.tostring
        System.out.println(Arrays.toString(lot));
        Arrays.sort(lot, fido);
        System.out.println(Arrays.toString(lot));
        Arrays.sort(lot, reverseFido);
        System.out.println(Arrays.toString(lot));

        //conbvert array into collection
        List<Car> carLot = Arrays.asList(lot);
        //collections are printed correctly
        System.out.println(carLot);
        Collections.sort(carLot, fido);
        System.out.println(carLot);
    }
}