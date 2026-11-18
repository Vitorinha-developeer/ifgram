package ifgram.DTOs;

import ifgram.Model.ModelComent;
import ifgram.Model.Post;


import java.time.LocalDateTime;

public record CommentResponse(Long id, String texto, LocalDateTime criadoEm,
                              ifgram.Model.Users autorNome, ifgram.Model.Post postId) {

    public static CommentResponse from (ModelComent comment){

        return new CommentResponse (comment.getId(), comment.getTexto(), comment.getCriadoEm(),
                Post.getAutor(), comment.getPost());
    }
}
