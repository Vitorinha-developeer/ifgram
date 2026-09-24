package ifgram.Service;

import ifgram.DTOs.UserRequest;
import ifgram.DTOs.UserResponse;
import ifgram.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service

public class UserService {

    private final UserRepository repository;

    //Injeção de dependências pelo construtor

    public UserService (UserRepository repository){

        this.repository=repository;
    }

    @Transactional
    public UserResponse criar(UserRequest request){

        // regra de negócio: O email não pode repetir

        if (repository.existsByEmail(request.email())){

            throw new EmailDuplicadoException (request.email());
        }

        User salvo = repository.save(new User(request.nome(), request.email()));

        return UserResponse.from(salvo);
    }
}
