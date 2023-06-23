package com.theoahga.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(authenticationService.register(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
    if(authenticationResponse == null){
      return ResponseEntity.status(203).build();
    }
    return ResponseEntity.ok(authenticationResponse);
  }

  @GetMapping("/ping")
  public ResponseEntity<Object> ping(
  ) {
    return ResponseEntity.ok().build();
  }
}
