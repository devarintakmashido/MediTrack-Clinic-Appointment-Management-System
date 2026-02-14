package meditrack.Entity;


public abstract class Person {

    private final String personId;
    private String name;
    private String email;
    private String phoneNumber;

    public Person(String personId, String name, String email, String phoneNumber) {
        this.personId = personId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



}