class Main {

    public static void main(String[] args) {
        CarRentalSystem rentalSystem= new CarRentalSystem();
        Car car1 = new Car("Cus101","Audi ","A200d",5000);
        rentalSystem.addcar(car1);
        Car car2 = new Car("Cus102","Honda ","Verna",2500);
        rentalSystem.addcar(car2);
        Car car3 = new Car("Cus103","Alto ","400",1000);
        rentalSystem.addcar(car3);
    }

}
