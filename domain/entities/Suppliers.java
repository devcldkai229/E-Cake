package devcldkai.kaipizzas.domain.entities;

public class Suppliers {

    private Integer id;

    private String companyName;

    private String address;

    private String phoneNumber;

    public Suppliers(){}

    public Suppliers(String companyName, String address, String phoneNumber) {
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
