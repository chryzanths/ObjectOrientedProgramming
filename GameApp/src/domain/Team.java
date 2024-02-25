package domain;

public class Team extends Warrior
{
    private String teamID;
    private String teamName;
    private Integer totalKills;


    public Team() {
        super();
    }


    public String getTeamID() {
        return teamID;
    }

    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getTotalKills() {
        return totalKills;
    }

    public void setTotalKills(Integer totalKills) {
        this.totalKills = totalKills;
    }

    @Override
    public Integer bulletsLeft()
    {
        return null;
    }

    @Override
    public Integer arrowsLeft() {
        return null;
    }

    @Override
    public Integer bombsLeft() {
        return null;
    }

    @Override
    public Warrior[] setWarriorList() {
        return new Warrior[0];
    }


}

