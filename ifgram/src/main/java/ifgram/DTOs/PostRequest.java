package ifgram.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PostRequest(

    @NotBlank (message = "Este campo é obrigatório e não pode estar em branco")

    String imagemURL,

    @Size(max = 300)

    String legenda,

    @NotNull
    Long autorId

){}
