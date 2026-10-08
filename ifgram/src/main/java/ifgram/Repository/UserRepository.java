package ifgram.Repository;

import ifgram.Model.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <Users, Long> {

    boolean existsByEmail(String email);

    Optional<Users> findByEmail(String Email);

    List<Users> findByNomeContainingIgnoreCase (String trecho);

    @Query ("Select u from Users u where u.email like concat ('%', :dominio)")

    List<Users> doDominio (String dominio);

}
