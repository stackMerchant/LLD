public class Main {
    public static void main(String[] args) {
        System.out.println("=== Start Application ===");

        // Initialize parking lot
        ParkingLot parkingLot = ParkingLot.getInstance();

        // Initialize vehicles
        Vehicle vehicle1 = new Vehicle("VEHICLE_1");
        Vehicle vehicle2 = new Vehicle("VEHICLE_2");
        Vehicle vehicle3 = new Vehicle("VEHICLE_3");
        Vehicle vehicle4 = new Vehicle("VEHICLE_4");

        // Operations
        parkingLot.parkVehicle(vehicle1); // Parked vehicle1
        parkingLot.parkVehicle(vehicle2); // Parked vehicle2
        parkingLot.parkVehicle(vehicle2); // Trying to park vehicle2 again will give error
        parkingLot.parkVehicle(vehicle3); // Parked vehicle3, lot will be full here
        parkingLot.parkVehicle(vehicle4); // Will not park vehicle4 as lot is full
        parkingLot.unParkVehicle(vehicle4); // Will not un park vehicle4 as it is not present in lot
        parkingLot.unParkVehicle(vehicle2); // vehicle2 will be removed
        parkingLot.parkVehicle(vehicle4); // vehicle4 will be parked now

        // Display all spots
        parkingLot.getAvailability();

        System.out.println("=== End Application ===");
    }
}