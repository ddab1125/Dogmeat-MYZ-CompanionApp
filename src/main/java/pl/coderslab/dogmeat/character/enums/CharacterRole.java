package pl.coderslab.dogmeat.character.enums;


public enum CharacterRole {

    ENFORCER("Osiłek"),
    GEARHEAD("Monter"),
    STALKER("Szperacz"),
    FIXER("Macher"),
    DOG_HANDLER("Psiarz"),
    CHRONICLER("Kronikarz"),
    BOSS("Szef"),
    GRUNT("Robol");

    private final String roleName;
    CharacterRole(String string) {
        this.roleName = string;
    }

    public String getRoleName() {
        return roleName;
    }
}
