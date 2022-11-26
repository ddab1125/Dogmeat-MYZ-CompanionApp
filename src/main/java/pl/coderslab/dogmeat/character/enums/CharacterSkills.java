package pl.coderslab.dogmeat.character.enums;

public enum CharacterSkills {
    ENDURE(CharacterAttributes.STRENGTH),
    FORCE(CharacterAttributes.STRENGTH),
    FIGHT(CharacterAttributes.STRENGTH),
    SNEAK(CharacterAttributes.AGILITY),
    MOVE(CharacterAttributes.AGILITY),
    SHOOT(CharacterAttributes.AGILITY),
    SCOUT(CharacterAttributes.WITS),
    COMPREHEND(CharacterAttributes.WITS),
    KNOWTHEZONE(CharacterAttributes.WITS),
    SENSEEMOTION(CharacterAttributes.EMPATHY),
    MANIPULATE(CharacterAttributes.EMPATHY),
    HEAL(CharacterAttributes.EMPATHY);

    private final String mainAttribute;
    CharacterSkills(CharacterAttributes mainAttribute) {
        this.mainAttribute = mainAttribute.name();
    }
}


