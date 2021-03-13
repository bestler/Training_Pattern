package s02.truck;

import java.util.ArrayList;
import java.util.List;

public class Fleet {
    List<Truck> trucks;

    public Fleet() {
        trucks = new ArrayList<>();
    }

    public void addTruck(Truck truck){
        trucks.add(truck);
    }

    public List<Truck> getTrucks() {
        return trucks;
    }
}
