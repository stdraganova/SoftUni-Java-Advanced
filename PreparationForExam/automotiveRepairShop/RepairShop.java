package JavaAdvanced.PreparationForExam.automotiveRepairShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepairShop {
    private List<Vehicle> vehicles;
    private int capacity;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle){
        if (this.vehicles.size() < capacity){
            this.vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin){
        return this.vehicles.removeIf(vehicle -> vehicle.getVIN().equals(vin));
    }

    public int getCount(){
        return vehicles.size();
    }

    public Vehicle getLowestMileage(){
        Vehicle vehicle = this.vehicles.stream().min(Comparator.comparing(Vehicle::getMileage)).get();

        return vehicle;
    }

    public String report(){
        StringBuilder sb = new StringBuilder();
        sb.append("Vehicles in the preparatory:");

        for (Vehicle vehicle : this.vehicles){
            sb.append(System.lineSeparator());
            sb.append(vehicle);
        }

        return sb.toString();
    }
}
