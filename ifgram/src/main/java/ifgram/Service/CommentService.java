package ifgram.Service;

import ifgram.DTOs.CommentRequest;
import ifgram.DTOs.CommentResponse;
import ifgram.Model.ModelComent;
import ifgram.Model.Post;
import ifgram.Model.Users;
import ifgram.Repository.CommentRepository;
import ifgram.Repository.PostRepository;
import ifgram.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service

public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postrepository;
    private final UserRepository userRepository;

    public CommentService (CommentRepository commentRepository, PostRepository postRepository, UserRepository
                           userRepository){

        this.commentRepository=commentRepository;
        this.postrepository=postRepository;
        this.userRepository=userRepository;
    }

    public CommentResponse criarComentario(CommentRequest request) {

        Post post = postrepository.findById(request.postId()).orElse(null);

        Users autor = userRepository.findById(request.autorId()).orElse(null);

        if (post == null || autor == null) {
            return null;
        }

        ModelComent comentario = new ModelComent();

        comentario.setTexto(request.texto());

        comentario.setCriadoEm(LocalDateTime.now());

        comentario.setPost(post);

        comentario.setAutor(autor);

        ModelComent salvo = commentRepository.save(comentario);

        return CommentResponse.from(salvo);
    }

    public List<CommentResponse> listarPorPost(Long postId) {

        List<ModelComent> comentarios = commentRepository.findByPostIdOrderByCriadoEmAsc(postId);

        List<CommentResponse> resposta = new ArrayList<>();

        for (ModelComent comentario : comentarios) {

            resposta.add(CommentResponse.from(comentario));
        }

        return resposta;
    }

    public List<CommentResponse> listarPorAutor(Long autorId) {

        List<ModelComent> comentarios = commentRepository.findByAutorId(autorId);

        List<CommentResponse> resposta = new ArrayList<>();

        for (ModelComent comentario : comentarios) {

            resposta.add(CommentResponse.from(comentario));
        }

        return resposta;
    }

    public Long contarPorPost(Long postId) {

        return commentRepository.countByPostId(postId);
    }

    public boolean deletarComentario(Long id) {

        if (commentRepository.existsById(id)) {

            commentRepository.deleteById(id);

            return true;
        }
        return false;
    }
}




