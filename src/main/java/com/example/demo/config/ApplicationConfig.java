package com.example.demo.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ApplicationConfig {
	/**
     * Configura y proporciona una instancia de ModelMapper como un bean.
     *
     * @return Instancia de ModelMapper configurada.
     */
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
	
	// Puedes agregar más métodos de configuración o beans según sea necesario

    // Comentarios adicionales o ajustes según las necesidades
}
