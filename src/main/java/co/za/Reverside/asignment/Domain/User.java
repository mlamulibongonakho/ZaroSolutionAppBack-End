package co.za.Reverside.asignment.Domain;

import co.za.Reverside.asignment.DTO.UserDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by tha on 2016/09/01.
 */
@Entity
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String cellnumber;
    private String password;
    private String gender;

    @OneToMany(cascade =CascadeType.PERSIST)
    public List<UserOTP> userOTPs;

    public List<UserOTP> getUserOTPs() {
        return userOTPs;
    }

    public void setUserOTPs(List<UserOTP> userOTPs) {
        this.userOTPs = userOTPs;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User(){}
    public User(UserDTO userDTO)
    {
        this.firstName= userDTO.getFirstName();
        this.lastName=userDTO.getLastName();
        this.email=userDTO.getEmail();
        this.cellnumber=userDTO.getCellnumber();
        this.password=userDTO.getPassword();
        this.gender=userDTO.getGender();

    }
    public User(String firstName,String lastName,String email,String cellnumber)
    {
        this.firstName= firstName;
        this.lastName=lastName;
        this.email=email;
        this.cellnumber=cellnumber;

    }
    public String getCellnumber() {
        return cellnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCellnumber(String cellnumber) {
        this.cellnumber = cellnumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
