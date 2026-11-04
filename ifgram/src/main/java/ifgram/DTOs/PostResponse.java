package ifgram.DTOs;

import ifgram.Model.Post;

import java.time.LocalDateTime;

public record PostResponse(Long id, Long autorId, String imagemURL, String legenda, LocalDateTime criadoEm,
                           String autorNome) {

    public static PostResponse from (Post post){

        return new UserResponse(post.getId(), post.getAutor().getNome(), post.getImagemURL(), post
    }
}
