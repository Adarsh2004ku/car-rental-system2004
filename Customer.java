public class Customer {
    private String customerId;
    private String name;


    public Customer(String customeid,String name){
        this.customerId= customeid;
        this.name = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}
