package co.za.Reverside.asignment.DTO;

import co.za.Reverside.asignment.Domain.User;

import java.io.Serializable;

/**
 * Created by tha on 2016/09/03.
 */
public class UserDTO implements Serializable{

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String firstName;
    private String lastName;
    private String email;
    private String cellnumber;
    private  String gender;
    private Double otpCode;

    public Double getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(Double otpCode) {
        this.otpCode = otpCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public UserDTO(){}
    public UserDTO(String firstName, String lastName, String email, String cellnumber, String password,String gender){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.cellnumber=cellnumber;
        this.password=password;
        this.gender=gender;


    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellnumber() {
        return cellnumber;
    }

    public void setCellnumber(String cellnumber) {
        this.cellnumber = cellnumber;
    }

}
