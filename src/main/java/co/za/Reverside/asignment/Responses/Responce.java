package co.za.Reverside.asignment.Responses;

import co.za.Reverside.asignment.Domain.User;

/**
 * Created by tha on 2016/09/05.
 */
public class Responce {

    private String Response;
    private Boolean bad;
    private Double otpCode;
    private Boolean found;

    public Boolean getFound() {
        return found;
    }

    public void setFound(Boolean found) {
        this.found = found;
    }

    public Double getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(Double otpCode) {
        this.otpCode = otpCode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    public  Responce(){}
    public Responce(String Response,Boolean bad){
        this.Response=Response;
        this.bad= bad;

    }
    public Responce(String Response){
        this.Response=Response;

    }
    public Responce(User user,String response, Boolean bad){
        this.user=user;
        this.Response=response;
        this.bad=bad;
    }
    public Responce(String response, Double otpCode,Boolean bad){
        this.otpCode=otpCode;
        this.Response=response;
        this.bad=bad;
    }
    public Responce(String response,Boolean bad,Boolean found){
        this.Response=response;
        this.bad=bad;
        this.found=found;
    }
    public Boolean getBad() {
        return bad;
    }

    public void setBad(Boolean bad) {
        this.bad = bad;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }
}
