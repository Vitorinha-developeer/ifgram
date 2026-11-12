package ifgram.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CommentRequest(

    @NotBlank(message = "Este campo deve estar preenchido e não pode estar em branco")
    String texto,

   @Size(max = 500)
   Long postId,


    @NotNull
    Long autorId
){}
