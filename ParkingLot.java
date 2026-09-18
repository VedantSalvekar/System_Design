class ParkingLot{
    private static ParkingLot instance;
    private List<ParkingFloor> floors;

    private ParkingLot(){
        floors = new ArrayList<>();
    }
    static ParkingLot getInstance(){
        if(instance == null) instance = new ParkingLot();
        return instance;
    }
    ParkingSpot findSpot(Vehicle vehicle){
        SpotSize requiredSize = mapVehicleSize(vehicle.getType());
        for(ParkingFloor floor : floors){
            ParkingSpot spot = floor.findAvailableSpot(requiredSize);
            if(spot != null){
                return spot;
            }
        }
        return null;
    }
    private SpotSize mapVehicleSize(VehicleType type){
        switch(type){
            case CAR: return SpotSize.MEDIUM;
            case BIKE: return SpotSize.SMALL;
            case TRUCK: return SpotSize.LARGE;
            default: throw new IllegalArgumentException();
        }
    }
}