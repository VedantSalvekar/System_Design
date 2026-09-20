class ParkingSpot {
    private String spotId;
    private SpotSize size;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    ParkingSpot(String spotId, SpotSize size) {
        this.spotId = spotId;
        this.size = size;
        this.isOccupied = false;
    }

    String getSpotId() {
        return spotId;
    }

    SpotSize getSize() {
        return size;
    }

    boolean isAvailable() {
        return !isOccupied;
    }

    void parkVehicle(Vehicle v) {
        this.parkedVehicle = v;
        this.isOccupied = true;
    }

    void removeVehicle() {
        this.parkedVehicle = null;
        this.isOccupied = false;
    }
}
