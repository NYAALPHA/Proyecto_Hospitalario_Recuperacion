package com.elsilencio;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.elsilencio.Trabajador.trabajadorEntity;
import com.elsilencio.Trabajador.trabajadorEstadoEnum;
import com.elsilencio.Trabajador.trabajadorRepository;
import com.elsilencio.Persona.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
    CommandLineRunner initDatabase(trabajadorRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Revisamos si ya existe el usuario "admin" para no duplicarlo cada vez
            if (repository.findByLogin("admin").isEmpty()) {
                
                trabajadorEntity admin = new trabajadorEntity();
                admin.setNombre("Admin");
                admin.setApaterno("Hotel");
                admin.setAmaterno("Silencio");
                admin.setTipoDocumento(personaTipoDocumentoEnum.DNI); // Ajusta según tu Enum
                admin.setNumDocumento("00000000");
				admin.setSueldo(new BigDecimal(1500.00));
                admin.setLogin("admin");
                
                // IMPORTANTE: Encriptamos la clave "admin123"
                admin.setPassword(passwordEncoder.encode("admin123"));
                
                admin.setAcceso("Administrador");
                admin.setEstado(trabajadorEstadoEnum.ACTIVO);
                
                repository.save(admin);
                
                System.out.println("--------------------------------------------------");
                System.out.println("USUARIO INICIAL CREADO:");
                System.out.println("Login: admin");
                System.out.println("Password: admin123");
                System.out.println("--------------------------------------------------");
            }
        };
    }
}
