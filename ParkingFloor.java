class ParkingFloor{
    private int floorNumber;
    private List<ParkingSpot> spots;

    ParkingFloor(int floorNumber, List<ParkingSpots> spots){
        this.floorNumber = floorNumber;
        this.spots = spots;
    }
    ParkingSpot findAvailableSpot(SpotSize size){
        for(ParkingSpot spot : spots){
            if(spot.isAvailable() == true && spot.getSize() == size){
                return spot;
            }
        }
        return null;
    }
}