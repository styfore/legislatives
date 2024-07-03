package fr.tom;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CandidatRepository  extends ListCrudRepository<Candidat, String> {

    List<Candidat> findAllByEluIn(Etat... etats);
}
