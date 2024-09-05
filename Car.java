public class Car {

    private String carid;
    private String Brand;
    private String Model;;
    private  double basepriceperday;
    private boolean isAvailable;


    public Car(String carid,String Brand,String Model,double basepriceperday){
        this.carid= carid;
        this.Brand= Brand;
        this.Model= Model;
        this.basepriceperday= basepriceperday;
        this.isAvailable= true;

    }
    public String getcarid(){
        return carid;
    }
    public String getmodel(){
        return Model;
    }
    public String getBrand(){
        return Brand;
    }
    public double calculatedprice(int rentalDays){
        return rentalDays*basepriceperday;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent(){
        isAvailable= false;
    }
    public void returncar(){
        isAvailable= true;
    }

}
