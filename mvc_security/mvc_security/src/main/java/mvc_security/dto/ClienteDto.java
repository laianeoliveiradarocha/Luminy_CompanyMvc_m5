package mvc_security.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ClienteDto
{
    private long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "O e-mail não deve estar vazio")
    @Email
    private String email;
    @NotEmpty(message = "A senha não deve estar vazia")
    private String password;
}