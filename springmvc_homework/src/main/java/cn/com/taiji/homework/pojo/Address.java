package cn.com.taiji.homework.pojo;

public class Address {
    private String addressname;

    public String getAddressname() {
        return addressname;
    }

    public void setAddressname(String addressname) {
        this.addressname = addressname;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressname='" + addressname + '\'' +
                '}';
    }
}
