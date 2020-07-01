package com.ensas.miniprojet.demo.controller.home;

import com.ensas.miniprojet.demo.model.auth.AuthenticationRequest;
import com.ensas.miniprojet.demo.model.auth.AuthenticationResponse;
import com.ensas.miniprojet.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HomeController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Qualifier("myUserDetailsService")
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @RequestMapping({"/home", "/"})
    public String secureHomePage(){
        return "this is a top secret message !!!";
    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        System.out.println("authentication");
        try{
            System.out.println("inside the try");
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationRequest.getUserName(),
                            authenticationRequest.getPassword()
                    )
            );
            System.out.println("end the try");

        }catch (Exception e){
            throw new UserNotFoundException("Incorrect username or password");
        }
        System.out.println("and of the try");

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUserName());
        final String jwt = jwtUtil.genrateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
