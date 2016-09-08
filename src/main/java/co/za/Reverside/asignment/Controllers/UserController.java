package co.za.Reverside.asignment.Controllers;

import co.za.Reverside.asignment.DTO.UserDTO;
import co.za.Reverside.asignment.Domain.User;
import co.za.Reverside.asignment.Domain.UserOTP;
import co.za.Reverside.asignment.Responses.Responce;
import co.za.Reverside.asignment.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by tha on 2016/09/01.
 */
@RequestMapping(value="/User")
@RestController
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    /**
     * Save User
     * @param userDTO
     */

    @RequestMapping(value="/save",method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> save( @RequestBody UserDTO userDTO)
    {
        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Double otpPin= Math.floor(100000 + Math.random()*900000);
        User user1=new User(userDTO);
        List<UserOTP> userOTP2=new ArrayList<>();
        UserOTP userOTP = new UserOTP(otpPin,format.format(date));
        userOTP2.add(userOTP);

        User user=userService.findByEmail(userDTO.getEmail());
          if(user1 == null)
          {
              return new ResponseEntity<>(new Responce("You please fill in your  your details"),HttpStatus.OK);
          }
        else if(user1 != null)
        {
            user1.setUserOTPs(userOTP2);
            userService.save(user1);


            return new ResponseEntity<>(new Responce("You have successfully registered",otpPin,false),HttpStatus.OK);

        }
        else
            return new ResponseEntity<>(new Responce(user,"inserted email exist try to insert different one",true),HttpStatus.OK);

    }

    /**
     * Find All
     * @return
     */

    @RequestMapping(value="",method = RequestMethod.GET)
    public List<User> findAll()
    {
        return userService.findAll();
    }

    /**
     * Find By Email
     * @param
     * @return
     */
    @RequestMapping(value="/email",method = RequestMethod.POST)
    public User findByEmail(@RequestBody UserDTO userDTO)
    {
        User user=userService.findByEmail(userDTO.getEmail());
        if(user!=null)
        {
            return user;
        }
        else{
            return null;}
    }

    /**
     * Find One
     * @param userId
     * @return
     */
    @RequestMapping(value = "/findOne/{id}",method = RequestMethod.GET)
    public  User findOne(@PathVariable("id") Long userId)
    {
        return userService.findOne(userId);
    }
    /**
     * Update
     * @param userDTO
     * @return
     */

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public  ResponseEntity<?> update(@RequestBody UserDTO userDTO)
    {
        User user=userService.findByEmail(userDTO.getEmail());

            user.setEmail(userDTO.getEmail());
            user.setCellnumber(userDTO.getCellnumber());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());

            userService.update(user);
            return new ResponseEntity<>(new Responce("You have successfully updated your profile",false),HttpStatus.OK);


    }

    /**
     * Login

     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public  ResponseEntity<?> login(@RequestBody UserDTO userDTO)
    {
        User user= new User();
        user=userService.findByEmail(userDTO.getEmail());

        if(user !=null)
        {
            if(user.getPassword().equals(userDTO.getPassword()))
            {
                return new ResponseEntity<>(new Responce(user,"Welcome",false),HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<>(new Responce("Your User Name or password is incorrect",true),HttpStatus.OK);
            }

        }
        else
        {
                return new ResponseEntity<>(new Responce("Your User Name or password is incorrect",true),HttpStatus.OK);
        }

    }
    @RequestMapping(value="/otpValidate", method = RequestMethod.POST)
    public ResponseEntity<?> otpValidate(@RequestBody UserDTO userDTO) {
        Date date = new Date();

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Double otpCode = null;
        String otpDate = null;


        User user = userService.findByEmail(userDTO.getEmail());


        if (user == null) {

            return new ResponseEntity<>(new Responce("Invalid Email",true), HttpStatus.OK);

        }
        else
        {
            List<UserOTP> userOTPs = user.getUserOTPs();
            if (userOTPs.size() > 0){
                for (UserOTP userOTP : userOTPs) {
                    otpCode = userOTP.getOtpCode();
                    otpDate = userOTP.getOtpDate();
                }


                if (!otpCode.equals(userDTO.getOtpCode())) {
                    //if Otp is not found BAD for response is equal to true and FOUND for being found or not is False
                    return new ResponseEntity<>(new Responce("Your OTP code is not valid", true, false), HttpStatus.OK);
                } else {
                    String dateStart = otpDate;
                    String dateStop = format.format(date);

                    Date d1 = null;
                    Date d2 = null;

                    try {
                        d1 = format.parse(dateStart);
                        d2 = format.parse(dateStop);

                        long diff = d2.getTime() - d1.getTime();

                        long diffSeconds = diff / 1000 % 60;
                        long diffMinutes = diff / (60 * 1000) % 60;
                        long diffHours = diff / (60 * 60 * 1000) % 24;
                        long diffDays = diff / (24 * 60 * 60 * 1000);

                        if (diffMinutes > 2) {
                            //if Otp is not found BAD for response is equal to true and FOUND for being found or not is true
                            return new ResponseEntity<>(new Responce("Your OTP code Verification is Old request a new one", true, true), HttpStatus.OK);
                        } else
                            //if Otp is not found BAD for response is equal to false and FOUND for being found or not is true
                            return new ResponseEntity<>(new Responce("Thank you now you can login", false, true), HttpStatus.OK);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
    }
        return null;
    }

}
