package fr.tom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@Slf4j
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(CandidatRepository repository) {
        return (args) -> {
            List<Candidat> candidatsElus = repository.findAllByEluIn(Etat.OUI);
            List<Candidat> candidatsQualifies = repository.findAllByEluIn(Etat.QUALIF);
            Map<C>

            log.info("coucou {}", candidats.size());
            log.info("candidatsElus {}", candidatsElus.size());
        };
    }
}