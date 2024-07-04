package fr.tom;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
@Slf4j
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(CandidatRepository repository) {
        return (args) -> {
            List<Candidat> candidats = repository.findAll();
            Map<String, List<Candidat>> circos = new HashMap<>();
            Map<Bloc, Integer> sieges = new HashMap<>();
            for(Candidat candidat : candidats){
                String codeCirco = candidat.getCodeCirco();
                if (!circos.containsKey(codeCirco)){
                    circos.put(codeCirco, new ArrayList<>());
                }
                circos.get(codeCirco).add(candidat);
            }

            for (Map.Entry<String, List<Candidat>> entry : circos.entrySet()){
                jouerSecondTour(entry.getValue());
            }

        };
    }

    private Bloc jouerSecondTour(List<Candidat> candidats) {
        Optional<Candidat> elu = candidats.stream().filter(Candidat::isElu).findFirst();
        if (elu.isPresent()){
            return elu.get().getBloc();
        } else {
            List<Candidat> qualifs = candidats.stream().filter(Candidat::isQualif).toList();
            Map<Candidat, Integer> scores = qualifs.stream().collect(Collectors.toMap(c->c, c -> 0));

            // repartition des voix
            for (Candidat candidat : candidats){
                for (Candidat qualif : qualifs){
                    scores.get(qualif);
                }
            }
            return null;
        }
    }
}