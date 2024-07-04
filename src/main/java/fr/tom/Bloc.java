package fr.tom;

public enum Bloc {
    EXG, UG, RN, ENS, REC, LR, DIV, DVD, ECO, DVC, DVG, REG, DSV, UXD, UDI, EXD, HOR, SOC, RDG, FI, COM, VEC;

    public Tendance getTendance(){
        return switch  (this){
            case EXG, UG, SOC, FI, ECO, COM, DVG, RDG, VEC -> Tendance.GAUCHE;
            case ENS, DVC, HOR, REC -> Tendance.CENTRE;
            case LR, DVD, DIV, UDI -> Tendance.DROITE;
            case DSV, UXD, EXD, RN, REG -> Tendance.EXTREME_DROITE;
        };
    }

}
