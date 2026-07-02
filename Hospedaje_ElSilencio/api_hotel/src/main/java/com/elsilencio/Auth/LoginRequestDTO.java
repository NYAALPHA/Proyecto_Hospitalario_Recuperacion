package com.elsilencio.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {
    @NotBlank(message = "El usuario es obligatorio")
    private String login;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;

        // Getters y setters
    public String getLogin() {
        return login; 
    }
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
