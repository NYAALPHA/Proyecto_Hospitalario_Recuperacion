package com.elsilencio.Auth;

import com.elsilencio.Trabajador.trabajadorEntity;
import com.elsilencio.Trabajador.trabajadorRepository;
import com.elsilencio.Excepciones.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private trabajadorRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String login(LoginRequestDTO dto) {
        // 1. Buscar al trabajador por su login
        trabajadorEntity trabajador = repository.findByLogin(dto.getLogin())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        // 2. Comparar la contraseña escrita con la encriptada en la BD
        if (passwordEncoder.matches(dto.getPassword(), trabajador.getPassword())) {
            return "Login exitoso. ¡Bienvenido " + trabajador.getNombre() + "!";
            // Nota: Más adelante aquí generaremos el Token JWT
        } else {
            throw new RuntimeException("Contraseña incorrecta");
        }
    }
}
