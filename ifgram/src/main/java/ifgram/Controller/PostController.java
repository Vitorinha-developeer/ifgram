package ifgram.Controller;

import ifgram.DTOs.PostRequest;
import ifgram.DTOs.PostResponse;
import ifgram.Service.PostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("post")


public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> listarFeed() {
        return ResponseEntity.ok(postService.listarFeed());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> buscarPorId(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(postService.buscarPorId(id));
    }

    @GetMapping("/autor/{autorId}")
    public ResponseEntity<List<PostResponse>> listarPorAutor(@PathVariable Long autorId) {
        return ResponseEntity.ok(postService.listarPorAutor(autorId));
    }

    @PostMapping
    public ResponseEntity<?> criar(@Valid @RequestBody PostRequest request) {
        try {
            PostResponse novoPost = postService.criar(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoPost);
        } catch (org.springframework.web.server.ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getReason());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) throws Exception {
        postService.deletar(id);
        return ResponseEntity.noContent().build();
    }


}
