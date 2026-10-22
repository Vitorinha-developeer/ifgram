package ifgram.Controller;

import ifgram.DTOs.UserRequest;
import ifgram.DTOs.UserResponse;
import ifgram.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("users")

public class Users {

    private final UserService service;

    public Users (UserService service){

        this.service=service;
    }

    @GetMapping

    public List<UserResponse> getUsers(){
        List<UserResponse>listaUsuarios=service.buscarTodosUsuarios();
        return listaUsuarios;
    }

    @PostMapping

    public UserResponse postUser (UserRequest request) throws Exception{

        UserResponse userResponse = service.criar(request);

        return userResponse;
    }

    @DeleteMapping

    public String deleteUser(UserRequest request) throws Exception{

        service.deletarUsuario(request);

        return "Usuário Deletado com sucesso";

    }

    @PutMapping

    public UserResponse UpdateUser (UserRequest request) throws Exception{

        return service.atalizarUsuario(request);
    }
}
