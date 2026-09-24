import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
 

enum VehicleType {HATCHBACK, SEDAN, SUV, BIKE}
enum VehicleStatus {AVAILABLE, BOOKED, UNDER_MAINENANCE}
enum ReservationStatus {PENDING, CONFIRMED, ACTIVE, COMPLETED, CANCELLED}

//VEHICLE

class Vehicle{
    private String id;
    private VehicleType type;
    private String model;
    private String reg;
    private double rate;
    private VehicleStatus status;

    Vehicle(String id, VehicleType type, String model, String reg, double rate){
        this.id = id;
        this.type = type;
        this.model = model;
        this.reg = reg;
        this.rate = rate;
        this.status = VehicleStatus.AVAILABLE;
    }
    String getId(){return id;}
    VehicleType getType() { return type; }
    String getModel() { return model; }
    double getDailyRate() { return rate; }
    VehicleStatus getStatus() { return status; }
    void setStatus(VehicleStatus status) { this.status = status; }
 
    public String toString() { return model + " (" + reg + ")"; }
}

//USER
class User{
    private String id;
    private String name;
    private String licenseNum;
     
    User(String id, String name, String licenseNum){
        this.id = id;
        this.name = name;
        this.licenseNum = licenseNum;
    }
    String getId(){return id;}
    String getName(){return name;}
}

//VIM
class Vim{
    private List<Vehicle> vehicles = new ArrayList<>();

    void addVehicle(Vehicle v){
        vehicles.add(v);
    }

    List<Vehicle> getVehicleByType(VehicleType type){
        List<Vehicle> res = new ArrayList<>();
        for(Vehicle v : vehicles){
            if(v.getType() == type && v.getStatus() == VehicleStatus.AVAILABLE){
                res.add(v);
            }
        }
        return res;
    }
}

//LOCATION
class Location{
    private String address;
    private Vim inventory;

    Location (String address){
        this.address = address;
        this.inventory = new Vim();
    }
    String getAddress(){
        return address;
    }
    Vim getInventory() {
        return inventory;
    }
}

//RESERVATION
class Reservation{
    private String id;
    private User user;
    private Vehicle vehicle;
    private Location pickUpLocation;
    private LocalDate startDate;
    private LocalDate endDate;
    private ReservationStatus status;

      Reservation(User user, Vehicle vehicle, Location pickupLocation, LocalDate startDate, LocalDate endDate) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.user = user;
        this.vehicle = vehicle;
        this.pickUpLocation = pickupLocation;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = ReservationStatus.CONFIRMED;
    }
 
    String getId() { return id; }
    User getUser() { return user; }
    Vehicle getVehicle() { return vehicle; }
    LocalDate getStartDate() { return startDate; }
    LocalDate getEndDate() { return endDate; }
    ReservationStatus getStatus() { return status; }
    void setStatus(ReservationStatus status) { this.status = status; }
}
//BILL & PAYMENT
class Bill{
    private String id;
    private Reservation reservation;
    private double totalAmnt;

    Bill(Reservation r){
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.reservation = r;
        this.totalAmnt = calculateAmount();
    }
    double calculateAmount(){
        return 0.0;
    }
    double getTotalAmount(){return totalAmnt;}
}

class Payment{
    private String id;
    private Bill bill;
    private String status;
    private LocalDateTime timestamp;

    Payment(Bill bill){
        this.id = UUID.randomUUID().toString().substring(0,8);
        this.bill = bill;
        this.status = "SUCCESS";
        this.timestamp = LocalDateTime.now();
    }
    public String toString(){
         return "Payment " + id + " | $" + bill.getTotalAmount() + " | " + status;
    }
}

class Store {
    private List<Location> locs = new ArrayList<>();
    private List<Reservation> res = new ArrayList<>();

    void addLocation(Location l) {
        locs.add(l);
    }
    void addReservation(Reservation r) {
        res.add(r);
    }
 List<Reservation> getReservationsForVehicle(Vehicle vehicle) {
        List<Reservation> result = new ArrayList<>();
        for (Reservation r : res) {
            if (r.getVehicle() == vehicle && r.getStatus() != ReservationStatus.CANCELLED) {
                result.add(r);
            }
        }
        return result;
    }

}

//VEHICLE RENTAL SYSTEM
class VehicleRentalSystem {
    private Store store;
 
    VehicleRentalSystem(Store store) {
        this.store = store;
    }
 
    List<Vehicle> searchVehicles(Location location, VehicleType type, LocalDate start, LocalDate end) {
        List<Vehicle> candidates = location.getInventory().getVehicleByType(type);
 
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : candidates) {
            if (isVehicleFreeForDates(v, start, end)) {
                result.add(v);
            }
        }
        return result;
    }
 
    private boolean isVehicleFreeForDates(Vehicle vehicle, LocalDate start, LocalDate end) {
      
        return true;
    }
 
    Reservation createReservation(User user, Vehicle vehicle, Location location, LocalDate start, LocalDate end) {
   
        return null;
    }
 
    Bill completeRental(Reservation reservation) {
        
        return null;
    }
}

//MAIN

public class CarRentalSystem{
    public static void main (String[] args){
        Store store = new Store();

        Location cork = new Location("City Centre");
        cork.getInventory().addVehicle(new Vehicle("V1", VehicleType.SEDAN, "BMW M5","C-111",45.0));
        cork.getInventory().addVehicle(new Vehicle("V2", VehicleType.SEDAN, "AUDI Q5","C-311",55.0));
        store.addLocation(cork);

        VehicleRentalSystem system = new VehicleRentalSystem(store);
        User vedant = new User("U1","Vedant","LIC-1112");

        LocalDate start = LocalDate.of(2026, 10, 1);
        LocalDate end = LocalDate.of(2026, 10, 4);

        List<Vehicle> available = system.searchVehicles(cork, VehicleType.SEDAN, start, end);
        System.out.println("Available sedans: " + available);
 
        if (!available.isEmpty()) {
            Reservation reservation = system.createReservation(vedant, available.get(0), cork, start, end);
            System.out.println("Reservation created: " + reservation);
 
            Bill bill = system.completeRental(reservation);
            System.out.println("Bill: " + (bill == null ? "null (TODO not implemented yet)" : "$" + bill.getTotalAmount()));
        }

    }
}
