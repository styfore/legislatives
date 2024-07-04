package fr.tom;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static fr.tom.Bloc.*;

@Service
public class TransfertService {

	private final static double ABSTENTION_GAUCHE = 0.9;

	public int nombreVoixTransferee(Candidat donneur, List<Candidat> candidatsQualifies){
		Tendance tendance =donneur.getBloc().getTendance();
		candidatsQualifies.sort(Comparator.comparingInt(Candidat::getNbVoix).reversed());
		switch (tendance){
			case GAUCHE -> transfertGauche(donneur, candidatsQualifies);
			case CENTRE -> transfertCentre(donneur, candidatsQualifies);
			case DROITE -> transfertDroite(donneur, candidatsQualifies);
			case EXTREME_DROITE -> transfertExtremeDroite(donneur, candidatsQualifies);
		}
		return 0;
	}


	private boolean autoTransfert(Candidat donneur, Candidat qualifie){
		if (qualifie.equals(donneur)){
			qualifie.setNbVoixSecondTour(qualifie.getNbVoixSecondTour() + (int)(donneur.getNbVoix()));
			return true;
		}
		return false;
	}

	private void transfertGauche(Candidat donneur, List<Candidat> candidatsQualifies) {
		int nbVoixRestante = donneur.getNbVoix();
		boolean contientRn = candidatsQualifies.stream().anyMatch(Candidat::isExtremeDroite);
		Iterator<Candidat> iterator = candidatsQualifies.iterator();
		while (nbVoixRestante > 0 && iterator.hasNext()){
			Candidat candidat = iterator.next();
			if (candidat.equals(donneur)){
				candidat.setNbVoixSecondTour((int) (candidat.getNbVoixSecondTour() +nbVoixRestante*ABSTENTION_GAUCHE));
				nbVoixRestante = 0;
			} else {
				// TODO faire une carte des parts, si doublons de tendance on garde le plus haut
			}
		}
	}

	private void transfertCentre(Candidat candidat, List<Candidat> candidatsQualifies) {
	}

	private void transfertDroite(Candidat candidat, List<Candidat> candidatsQualifies) {
	}

	private void transfertExtremeDroite(Candidat candidat, List<Candidat> candidatsQualifies) {
	}

}
