import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class EntryGate {
    Ticket generateTicket(Vehicle vehicle) {
        ParkingSpot spot = ParkingLot.getInstance().findSpot(vehicle);
        if (spot == null) {
            throw new RuntimeException("Parking full for vehicle type: " + vehicle.getType());
        }
        spot.parkVehicle(vehicle);
        Ticket ticket = new Ticket(vehicle, spot);
        System.out.println("EntryGate " + vehicle.getType() + " " + vehicle.getLicensePlate() + " parked at " + spot.getSpotId() + " | ticket=" + ticket.getTicketId());
        return ticket;
    }
}

class ExitGate {
    private double rateFor(VehicleType type) {
        switch (type) {
            case BIKE:  return 1.0;
            case CAR:   return 2.5;
            case TRUCK: return 5.0;
            default: return 0;
        }
    }

    double processExit(Ticket ticket) {
        ticket.getSpot().removeVehicle();

        long minutesParked = ChronoUnit.MINUTES.between(ticket.getEntryTime(), LocalDateTime.now());
        // Round up to at least 1 hour, and round partial hours up too.
        long hours = Math.max(1, (long) Math.ceil(minutesParked / 60.0));

        double fee = hours * rateFor(ticket.getVehicle().getType());
        System.out.println("ExitGate " + ticket.getVehicle().getLicensePlate() + " left spot " + ticket.getSpot().getSpotId() + " | hours=" + hours + " | fee= " + fee);
        return fee;
    }
}
