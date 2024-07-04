package fr.tom;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = {"codeCirco"})
public class Circo {
	private String codeCirco;
	private List<Candidat> candidats = new ArrayList<>();

}
