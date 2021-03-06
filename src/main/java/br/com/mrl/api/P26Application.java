package br.com.mrl.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.mrl.api.security.entities.Usuario;
import br.com.mrl.api.security.enums.PerfilEnum;
import br.com.mrl.api.security.repositories.UsuarioRepository;
import br.com.mrl.api.utils.SenhaUtils;

@SpringBootApplication
public class P26Application {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(P26Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			Usuario usuario = new Usuario();
			usuario.setEmail("usuario@email.com");
			usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
			usuario.setSenha(SenhaUtils.geraBCrypt("123456"));
			this.usuarioRepository.save(usuario);
			
			Usuario admin = new Usuario();
			admin.setEmail("admin@email.com");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(SenhaUtils.geraBCrypt("123456"));
			this.usuarioRepository.save(admin);
			
		};
	}

}
