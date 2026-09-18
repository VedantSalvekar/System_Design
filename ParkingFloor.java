import java.util.List;

class ParkingFloor {
    private int floorNumber;
    private List<ParkingSpot> spots;

    ParkingFloor(int floorNumber, List<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.spots = spots;
    }

    int getFloorNumber() {
        return floorNumber;
    }

    ParkingSpot findAvailableSpot(SpotSize size) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getSize() == size) {
                return spot;
            }
        }
        return null;
    }
}
