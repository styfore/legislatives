package fr.tom;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = {"idCandidat"})

public class Candidat {

    @Id
    private String idCandidat;
    private int candidat;
    private String codeCirco;
    private int inscrits;
    private int abstentions;
    private int votants;
    private int blancs;
    private int nuls;
    private int exprimes;
    private String nom;
    @Enumerated(EnumType.STRING)
    private Bloc bloc;
    private int nbVoix;
    @Enumerated(EnumType.STRING)
    private Etat elu;

    @Transient
    private int nbVoixSecondTour;


    public boolean isElu(){
        return Etat.OUI.equals(elu);
    }
    public boolean isQualif(){
        return Etat.QUALIF.equals(elu);
    }

    public boolean isGauche(){
        return Tendance.GAUCHE.equals( getTendance());
    }
    public boolean isCentre(){
        return Tendance.CENTRE.equals( getTendance());
    }
    public boolean isDroite(){
        return Tendance.DROITE.equals( getTendance());
    }
    public boolean isExtremeDroite(){
        return Tendance.EXTREME_DROITE.equals( getTendance());
    }

    public Tendance getTendance(){
        return  bloc.getTendance();
    }

}
