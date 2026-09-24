package ifgram.Controller;

import ifgram.DTOs.UserRequest;
import ifgram.DTOs.UserResponse;
import ifgram.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("users")

public class Users {

    private final UserService service;

    public Users (UserService service){

        this.service=service;
    }

    @GetMapping

    public String getUser(){

        return "Olá, Chamei o get";
    }

    @PostMapping

    public UserResponse criar(@Valid @RequestBody UserRequest request){

        return service.criar(request);
    }

    @DeleteMapping

    public String deleteUser(){

        return "Chamei o delete";
    }

    @PutMapping

    public String putUser (){

        return "Chamei o put";
    }
}
