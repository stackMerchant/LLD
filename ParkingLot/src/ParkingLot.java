import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    static ParkingLot instance;
    private List<ParkingSpot> parkingSpots;

    // Make parking lot singleton
    public static ParkingLot getInstance() {
        return instance == null ? new ParkingLot() : instance;
    }

    // Constructor
    private ParkingLot () {
        parkingSpots = new ArrayList<>();
        parkingSpots.add(new ParkingSpot(1));
        parkingSpots.add(new ParkingSpot(2));
        parkingSpots.add(new ParkingSpot(3));
    }

    void parkVehicle(Vehicle vehicle) {
        // Check if already present
        for (ParkingSpot p: parkingSpots) {
            if (!p.isAvailable() && p.parkedVehicle.plateNumber.equals(vehicle.plateNumber)) {
                System.out.println(vehicle.plateNumber + ", already parked at: " + p.id);
                return;
            }
        }

        // Park at first available spot
        for (ParkingSpot p: parkingSpots) {
            if (p.parkVehicle(vehicle)) {
                System.out.println(vehicle.plateNumber + ", parked at: " + p.id);
                return;
            }
        }

        // If not able to park anywhere, then parking is full
        System.out.println("Parking full");
    }

    void unParkVehicle(Vehicle vehicle) {
        for (ParkingSpot p: parkingSpots) {
            if (p.unParkVehicle(vehicle)) {
                System.out.println(vehicle.plateNumber + ", removed from spot: " + p.id);
                return;
            }
        }
        System.out.println(vehicle.plateNumber + " is not in lot");
    }

    void getAvailability() {
        System.out.println("** Parked Vehicles **");
        for (ParkingSpot p: parkingSpots) {
            if (p.isAvailable()) {
                System.out.println("Spot: " + p.id + " is free");
            } else {
                System.out.println("Spot: " + p.id + " is occupied by: " + p.parkedVehicle.plateNumber);
            }
        }
    }

}
