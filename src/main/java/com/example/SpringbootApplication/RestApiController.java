package com.example.SpringbootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    //    Using Path variables
    @GetMapping("/hello/{name}/{last}/{dob}")
    public String helloName(@PathVariable String name,
                            @PathVariable String last,
                            @PathVariable String dob) {
        return "Hello, " + name + " " + last + " ! Your date of birth is " + dob + ".";

    }

//    Using Query Parameters
    @GetMapping("/hello1")
    public String helloFullName(@RequestParam String name,
                                @RequestParam String last,
                                @RequestParam String dob) {

        return "Hello, " + name + " " + last + "! Your date of birth is " + dob + ".";
    }


    @PostMapping("/v1/createCustomer")
    public ResponseEntity<ApiResponse> createCustomer(@RequestBody PostDto postDto, UserDao userDao) {
        try {
            // Insert the user into the database
            User user = new User(0, postDto.getName(), postDto.getEmail());
            userDao.insert(user);

            // Prepare and return the response
            ApiResponse response = new ApiResponse("Customer created successfully", userDao.getById(5));
            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Failed to create customer", null));
        }

    }

    @PostMapping("/v1/createCustomer2")
    public ResponseEntity create(@RequestBody PostDto postDto,UserDao userDao){
        //insert in database
        try{
            User user=new User(0, postDto.getName(),postDto.getEmail());
            userDao.insert(user);
            ApiResponse response=new ApiResponse("customer created success ",user);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse("Failed to create customer", null));

        }

    }


    @PutMapping("/put1")
    public ResponseEntity<String> put(
            @RequestHeader("clienttype") String clientType,
            @RequestBody UserDto user) {

        if (clientType.length() != 4) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("clienttype must be exactly 4 characters long");
        }

        String response = "PUT UPDATE DONE, " + user.getFirstName() + "!" + user.getLastName() + "!" + user.getAge() + "! clientType: " + clientType;
        return ResponseEntity.ok(response);
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/get-todo")
    public ResponseEntity<String> getTodo(){
        String url1="https://jsonplaceholder.typicode.com/todos/1";
        ResponseEntity<String> response=restTemplate.getForEntity(url1,String.class);
        return ResponseEntity.ok(response.getBody());
    }

}
