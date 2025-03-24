package devcldkai.kaipizzas.domain.entities;

import java.sql.Date;
import java.util.UUID;

public class Accounts {
    private String id;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    private Double pointRewards;

    private Date dateOfBirth;

    private String phone;

    private String about;

    private String imageUrl;

    private Integer roleId;

    private String status;

    public Accounts() {
        this.id = UUID.randomUUID().toString();
        this.roleId = 2;
        this.imageUrl = "avatar_def.svg";
        this.pointRewards = 0.0;
    }

    public Accounts(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
        this.id = UUID.randomUUID().toString();
        this.roleId = 2;
        this.imageUrl = "avatar_def.svg";
        this.pointRewards = 0.0;
    }

    public Accounts(String username, String password, String email, String firstName, String lastName, Date dateOfBirth, String phone) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.id = UUID.randomUUID().toString();
        this.roleId = 2;
        this.imageUrl = "avatar_def.svg";
        this.pointRewards = 0.0;
    }

    public Accounts(String username, String password, String email, String phone, Date dateOfBirth, String firstName, String lastName) {
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.firstName = firstName;
        this.id = UUID.randomUUID().toString();
        this.imageUrl = "avatar_def.svg";
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.pointRewards = 0.0;
        this.roleId = 2;
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getPointRewards() {
        return pointRewards;
    }

    public void setPointRewards(Double pointRewards) {
        this.pointRewards = pointRewards;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "dateOfBirth=" + dateOfBirth +
                ", id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pointRewards=" + pointRewards +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
