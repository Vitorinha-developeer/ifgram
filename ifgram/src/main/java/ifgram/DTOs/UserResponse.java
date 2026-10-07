package ifgram.DTOs;

import ifgram.Model.Users;

public record UserResponse(Long id, String nome, String email) {

    public static UserResponse from (Users user){

        return new UserResponse(user.getId(), user.getNome(),user.getEmail());
    }

}
