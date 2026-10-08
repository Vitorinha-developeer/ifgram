package ifgram.Service;

import ifgram.DTOs.UserRequest;
import ifgram.DTOs.UserResponse;
import ifgram.Repository.UserRepository;
import jakarta.transaction.Transactional;
import ifgram.Model.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class UserService {

    private final UserRepository repository;

    //Injeção de dependências pelo construtor

    public UserService (UserRepository repository){

        this.repository=repository;
    }

    @Transactional
    public UserResponse criar(UserRequest request) throws Exception {

        // regra de negócio: O email não pode repetir

        if (repository.existsByEmail(request.email())){

            throw new Exception(request.email());
        }

        Users salvo = repository.save(new Users(request.nome(), request.email()));

        return UserResponse.from(salvo);
    }

    public List<UserResponse> buscarTodosUsuarios(){

        List<Users>listaUsuarios=repository.findAll();
        List<UserResponse> listaUsuariosResponse = new ArrayList<>();

        for (Users user : listaUsuarios){

            UserResponse userResponse = new UserResponse(user.getId(), user.getNome(), user.getEmail());

            listaUsuariosResponse.add(userResponse);
        }

        return listaUsuariosResponse;

    }
}
