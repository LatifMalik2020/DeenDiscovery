package com.provisionTechAdvisors.DeenDiscovery.controller;


import com.provisionTechAdvisors.DeenDiscovery.DTO.UserDTO;
import com.provisionTechAdvisors.DeenDiscovery.model.User;
import com.provisionTechAdvisors.DeenDiscovery.service.UserService;
import jakarta.validation.Valid;
import jdk.jshell.spi.ExecutionControl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserDTO userDto) {
        logger.info("Registering user with information: {}", userDto);
        try {
            User registeredUser = userService.registerNewUserAccount(userDto);
            return ResponseEntity.ok("User registered successfully with ID: " + registeredUser.getId().toString());
        } catch (ExecutionControl.UserException e) {
            logger.error("Registration error: {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            logger.error("Internal error: {}", e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
//    private final UserService userService;
////    private final AuthenticationManager authenticationManager;
////    private final JwtTokenProvider jwtTokenProvider;
//
//    public UserController(UserService userService /* AuthenticationManager authenticationManager*/ ) {
//        this.userService = userService;
////        this.authenticationManager = authenticationManager;
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
//        User user = new User(signUpRequest.getUsername(), signUpRequest.getPassword(), signUpRequest.getEmail());
//        userService.createUser(user);
//        return new ResponseEntity<>(new ApiResponse(true, "User registered successfully"), HttpStatus.CREATED);
//    }
////
////    @PostMapping("/signin")
////    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
////        Authentication authentication = authenticationManager.authenticate(
////                new UsernamePasswordAuthenticationToken(
////                        loginRequest.getUsername(),
////                        loginRequest.getPassword()
////                )
////        );
////
////        SecurityContextHolder.getContext().setAuthentication(authentication);
////        String jwt = jwtTokenProvider.generateToken(authentication);
////        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
////    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getUserById(@PathVariable Long id) {
//        return userService.findUserById(id)
//                .map(user -> ResponseEntity.ok(user))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
//        return userService.updateUser(id, user)
//                .map(updatedUser -> ResponseEntity.ok(updatedUser))
//                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
//        return userService.deleteUser(id)
//                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping("/me")
//    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserPrincipal currentUser) {
//        return ResponseEntity.ok(currentUser);
//    }
//
//    // ... other methods and classes ...

}
