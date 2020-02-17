import java.util.Arrays;

public class Contacto<E extends Comparable<? super E>> {

    int phoneNumber1, phoneNumber2;
    String contactName;

    public Contacto() {
        this.contactName = null;
        this.phoneNumber1 = 0;
        this.phoneNumber1 = 0;
    }

    public Contacto(String name, int phoneNumber1) {
        this.contactName = name;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber1 = 0;
    }

    public Contacto(String name, int phoneNumber1, int phoneNumber2) {
        this.contactName = name;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber1 = phoneNumber2;
    }

    public int getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(int phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public int getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(int phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}
