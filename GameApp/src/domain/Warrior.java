package domain;

public abstract class Warrior
{
    private String warriorCode;
    private String weapon;
    private Integer noOfKills;

    public Warrior(String warriorCode, String weapon, Integer noOfKills)
    {
        this.warriorCode = warriorCode;
        this.weapon = weapon;
        this.noOfKills = noOfKills;

    }

    public Warrior() {
    }

    public String getWarriorCode() {
        return warriorCode;
    }

    public void setWarriorCode(String warriorCode) {
        this.warriorCode = warriorCode;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public Integer getNoOfKills() {
        return noOfKills;
    }

    public void setNoOfKills(Integer noOfKills) {
        this.noOfKills = noOfKills;
    }

    public abstract Integer bulletsLeft();
    public abstract Integer arrowsLeft();
    public abstract Integer bombsLeft();


    public void setWarriorList(Object warriorList) {
    }


    public Team[] getTeamList() { return setTeamList();
    }

    public Team[] setTeamList() {
        return new Team[0];
    }

    public abstract Warrior[] setWarriorList();
    {}
}
