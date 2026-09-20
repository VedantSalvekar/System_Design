abstract class Vehicle {
    private String licensePlate;
    private VehicleType type;

    Vehicle(String licensePlate, VehicleType type){
        this.licensePlate = licensePlate;
        this.type = type;
    }
    VehicleType getType(){
        return type;
    }
    String getLicensePlate(){
        return licensePlate;
    }
}
class Car extends Vehicle{
    Car(String plate) {super(plate, VehicleType.CAR);}
}
class Bike extends Vehicle{
    Bike(String plate) {super(plate, VehicleType.BIKE);}
}
class Truck extends Vehicle{
    Truck(String plate) {super(plate, VehicleType.TRUCK);}
}