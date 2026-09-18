class ParkingSpot{
    private String spotId;
    private SpotSize size;
    private boolean isOccupied;
    private Vehicle parkedVehicle;

    ParkingSpot(String spotId, SpotSize size){
        this.spotId = spotId;
        this.size = size;
        this.isOccupied = false;
    }
    boolean isAvailable(){return !isOccupied;}

    void parkVehicle(Vehicle v){
        this.parkedVehicle = v;
        this.isOccupied = true;
    }
    void removeVehicle(Vehicle v){
        this.parkedVehicle = null;
        this.isOccupied = false;
    }
}