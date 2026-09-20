import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingFloor> floors;

    private ParkingLot() {
        floors = new ArrayList<>();
    }

    static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    ParkingSpot findSpot(Vehicle vehicle) {
        SpotSize reqSize = mapVehicleSize(vehicle.getType());
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.findAvailableSpot(reqSize);
            if (spot != null) {
                return spot;
            }
        }
        return null;
    }

    private SpotSize mapVehicleSize(VehicleType type) {
        switch (type) {
            case BIKE: return SpotSize.SMALL;
            case CAR: return SpotSize.MEDIUM;
            case TRUCK: return SpotSize.LARGE;
            default: throw new IllegalArgumentException();
        }
    }

    static void resetForTesting() {
        instance = null;
    }
}
