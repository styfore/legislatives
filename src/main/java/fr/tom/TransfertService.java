package fr.tom;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import static fr.tom.Bloc.*;

@Service
public class TransfertService {


	public int nombreVoixTransferee(Candidat candidat, List<Candidat> candidatsQualifies){
		Tendance tendance =candidat.getBloc().getTendance();
		switch (tendance){
			case GAUCHE -> transfertGauche(candidat, candidatsQualifies);
			case CENTRE -> transfertCentre(candidat, candidatsQualifies);
			case DROITE -> transfertDroite(candidat, candidatsQualifies);
			case EXTREME_DROITE -> transfertExtremeDroite(candidat, candidatsQualifies);
		}
		return 0;
	}


	private void transfertGauche(Candidat candidat, List<Candidat> candidatsQualifies) {

	}

	private void transfertCentre(Candidat candidat, List<Candidat> candidatsQualifies) {
	}

	private void transfertDroite(Candidat candidat, List<Candidat> candidatsQualifies) {
	}

	private void transfertExtremeDroite(Candidat candidat, List<Candidat> candidatsQualifies) {
	}

}
