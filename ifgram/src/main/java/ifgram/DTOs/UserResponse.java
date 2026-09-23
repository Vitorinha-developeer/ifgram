package ifgram.DTOs;

import org.apache.catalina.User;  //Apagar o apache

public record UserResponse(Long id, String nome, String email){

    public static UserResponse from (User user){

        return new UserResponse (user.getNome(), user.getId(), user.getEmail());
    }
}
