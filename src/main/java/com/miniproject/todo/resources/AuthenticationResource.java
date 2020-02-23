package com.miniproject.todo.resources;

import com.miniproject.todo.model.AuthenticationRequest;
import com.miniproject.todo.model.AuthenticationResponse;
import com.miniproject.todo.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil JwtTokenUtil;

    @RequestMapping(value = "/authenticate",method = {RequestMethod.POST})
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
            final UserDetails userDetails= userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
            final String authToken=JwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new AuthenticationResponse(true,"",authToken));
        }catch (BadCredentialsException ex){
            AuthenticationResponse response=new AuthenticationResponse();
            response.setSuccess(false);
            response.setErrormsg("Invalid username or password");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }catch (Exception ex){
            AuthenticationResponse response=new AuthenticationResponse();
            response.setSuccess(false);
            response.setErrormsg("Server Failure error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }
}
