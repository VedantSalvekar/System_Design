class EntryGate{
    Ticket generateTicket(Vehicle vehicle){
        ParkingSpot spot = ParkingLot.getInstance().findSpot(vehicle);
        if(spot == null) throw new RuntimeException("Parking Full");
        spot.parkVehicle(vehicle);
        return new Ticket(vehicle,spot);
    }
}
class ExitGate{
    double processExit(Ticket ticket){
        ticket.getSpot().removeVehicle();
        return calculateFee(ticket);
    }
}