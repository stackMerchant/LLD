public class ParkingSpot {
    Integer id;
    Vehicle parkedVehicle;

    ParkingSpot(Integer _id) {
        id = _id;
        parkedVehicle = null;
    }

    boolean isAvailable() {
        return parkedVehicle == null;
    }

    boolean parkVehicle(Vehicle vehicle) {
        if (!isAvailable()) return false;
        parkedVehicle = vehicle;
        return true;
    }

    boolean unParkVehicle(Vehicle vehicle) {
        // If spot is free or parked vehicle is different
        if (isAvailable() || !vehicle.plateNumber.equals(parkedVehicle.plateNumber)) return false;
        // Un park vehicle
        parkedVehicle = null;
        return true;
    }

}
