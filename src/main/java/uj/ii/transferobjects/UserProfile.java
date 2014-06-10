package uj.ii.transferobjects;

public class UserProfile {

    private String user;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String office;
    private String phone;
    private String officeHours;
    private String mainInterests;
    private String cv;

    public UserProfile() {
    }
    
    public UserProfile(String login, String firstName, String lastName) {
        this.user = login;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public UserProfile(String login, String firstName, String lastName,
            String email, String address, String office, String phone, String officeHours,
            String mainInterests, String cv) {
        this.user = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.office = office;
        this.phone = phone;
        this.officeHours = officeHours;
        this.mainInterests = mainInterests;
        this.cv = cv;
    }

    public String getLogin() {
        return user;
    }

    public void setLogin(String login) {
        this.user = login;
    }
    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the office
     */
    public String getOffice() {
        return office;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return the officeHours
     */
    public String getOfficeHours() {
        return officeHours;
    }

    /**
     * @return the mainInterests
     */
    public String getMainInterests() {
        return mainInterests;
    }

    /**
     * @return the cv
     */
    public String getCv() {
        return cv;
    }
}
