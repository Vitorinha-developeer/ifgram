package ifgram.DTOs;

import ifgram.Model.ModelComent;

import java.time.LocalDateTime;

public record CommentResponse(Long id, String texto, LocalDateTime criadoEm,
                              ifgram.Model.Post autorNome, ifgram.Model.Post postId) {

    public static CommentResponse from (ModelComent comment){

        return new CommentResponse (comment.getId(), comment.getTexto(), comment.getCriadoEm(),
                comment.getAutor(), comment.getPost());
    }
}
