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


    public boolean isElu(){
        return Etat.OUI.equals(elu);
    }
    public boolean isQualif(){
        return Etat.QUALIF.equals(elu);
    }


}
