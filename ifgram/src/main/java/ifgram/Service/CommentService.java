package ifgram.Service;

import ifgram.Repository.CommentRepository;
import ifgram.Repository.PostRepository;
import ifgram.Repository.UserRepository;
import org.springframework.stereotype.Service;

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
}



