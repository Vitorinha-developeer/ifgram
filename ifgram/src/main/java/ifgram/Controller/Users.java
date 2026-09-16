package ifgram.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("users")

public class Users {

    @GetMapping

    public String getUser(){

        return "Olá, Chamei o get";
    }

    @PostMapping

    public String postUser(){

        return "Chamei o endpoint com o post";
    }

    @DeleteMapping

    public String deleteUser(){

        return "Chamei o delete";
    }

    @PutMapping

    public String putUser (){

        return "Chamei o put";
    }
}
