package fr.tom;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Candidat {

    @Id
    public String idCandidat;
    public int candidat;
    public String codeCirco;
    public int inscrits;
    public int abstentions;
    public int votants;
    public int blancs;
    public int nuls;
    public int exprimes;
    public String nom;
    @Enumerated(EnumType.STRING)
    public Bloc bloc;
    public int nbVoix;
    @Enumerated(EnumType.STRING)
    public Etat elu;
}
