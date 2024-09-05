import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>( );
    }
    public  void addcar(Car car){
        cars.add(car);
    }
    public  void addCustomer(Customer customer){
        customers.add(customer);
    }
    public void rentcar(Car car,Customer customer,int days){
        if(car.isAvailable()){
            car.rent();
            rentals.add(new Rental(car,customer,days));
        } else{
            System.out.println("Car is not available for rent");
        }
    }
    public void returncar(Car car){
        car.returncar();
        Rental rentalTOremove = null;
        for(Rental rental : rentals ){
            if(rental.getCar()== car){
                rentalTOremove = rental;
                break;
            }
        }
        if(rentalTOremove != null){
            rentals.remove(rentalTOremove);
        }
        else {
            System.out.println("Car was not rented");
        }
    }

    public void menu (){

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("====== Car Rental Sysstem =====");
            System.out.println("1. Rent a Car ");
            System.out.println("2. Return a Car ");
            System.out.println("3. Exit");
            System.out.println("Enter Your choice ");

            int choice = sc.nextInt();
            sc.nextLine();


            if(choice == 1){
                System.out.println("==== Rent a Car ====");
                System.out.println("Enter Your Name ");
                String CustomerName = sc.nextLine();

                System.out.println("Available cars :");
                for (Car car : cars){
                    if(car.isAvailable()){
                        System.out.println(car.getcarid()+ "->" + car.getBrand() + " "+ car.getmodel());
                    }
                }
                System.out.println(" Enter the car ID you want to rent ");
                String carId =sc.nextLine();
                System.out.println("Enter the number of days for rental ");
                int rentaldays = sc.nextInt();
                sc.nextLine();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), CustomerName);
                addCustomer(newCustomer);

                Car selectedCar = null;
                for(Car car: cars){
                    if(car.getcarid().equals(carId)&& car.isAvailable()){
                        selectedCar = car;
                        break;
                    }

                }
                if(selectedCar != null){
                    double totalprice = selectedCar.calculatedprice(rentaldays);
                    System.out.println("=== Rental Information \n");
                    System.out.println("Customer Id : "+ newCustomer.getCustomerId());
                    System.out.println("Customer Name : "+newCustomer.getName());
                    System.out.println("Car : "+selectedCar.getBrand()+" "+selectedCar.getmodel());
                    System.out.println("Rental Days : "+rentaldays);
                    System.out.printf("Total Price: $%.2f%n", totalprice);

                    System.out.println("\n Confirm Rental (Y/N) : ");
                    String Confirm = sc.nextLine();

                    if(Confirm.equalsIgnoreCase("Y")){
                        rentcar(selectedCar,newCustomer,rentaldays);
                        System.out.println("\n Car rented Succesfully");
                    }else{
                        System.out.println("\n Rental Cancelled");
                    }

                    }else{
                    System.out.println("\n Invalid car selection or car not available for rental");

                }

            } else if (choice== 2){
                System.out.println(("\n === Return a Car "));
                System.out.println("Enter the car Id You want to return :");
                String carId = sc.nextLine();
                Car cartoreturn = null;
                for (Car car: cars){
                    if(car.getcarid().equals(carId)&& !car.isAvailable()){
                        cartoreturn  = car;
                        break;
                    }
                }
                if(cartoreturn != null){
                    Customer customer = null;
                    for(Rental rental : rentals){
                        if(rental.getCar()== cartoreturn){
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if(customer != null){
                        returncar(cartoreturn);
                        System.out.println("Car returned by "+customer.getName());
                    } else{
                        System.out.println("Car was not rented or rental information is missing");
                    }
                }else{
                        System.out.println("Invalid car ID or car is not rented");
                    }
                } else if (choice== 3 ) {
                break;

            } else{
                System.out.println("Invalid choice. please enter a valid option");
        }

        }
        System.out.println("\n THank You for chosing Car Rental System !");

    }

}
