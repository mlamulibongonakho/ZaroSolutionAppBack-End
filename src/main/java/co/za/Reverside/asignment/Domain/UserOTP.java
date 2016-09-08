package co.za.Reverside.asignment.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by User on 9/7/2016.
 */
@Entity
public class UserOTP {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String otpDate;
    private Double otpCode;
    public UserOTP()
    {
    }
    public UserOTP(Double otpCode)
    {
        this.otpCode=otpCode;
    }
    public UserOTP(Double otpCode,String otpDate)
    {
        this.otpCode=otpCode;
        this.otpDate=otpDate;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOtpDate() {
        return otpDate;
    }

    public void setOtpDate(String otpDate) {
        this.otpDate = otpDate;
    }
    public Double getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(Double otpCode) {
        this.otpCode = otpCode;
    }

}
