package ui;

import dao.TeamDA;
import dao.WarriorDA;
import domain.Team;
import domain.Warrior;

import java.io.FileNotFoundException;

public class TeamReport
{
    public TeamReport() throws FileNotFoundException
    {
        TeamDA teamDA = new TeamDA();

        Team team = new Team();

        String result = new String();
        for (Team teamList : team.getTeamList())
        {
            result += "Team ID: " + team.getTeamID().toString()
                    + "\n" + "Team name: " + team.getTeamName().toString()
                    + "\n" + "Total kill: " + team.getTotalKills().intValue()
                    + "\n\n";

            for(Warrior warrior: team.setWarriorList());
            {
                result += team.getWarriorCode().toString() + team.bulletsLeft() + " has " + team.getWeapon() + " and killed " + team.getNoOfKills() + "\t"
                        + team.getWarriorCode().toString() + team.arrowsLeft() + " has " + team.getWeapon() + " and killed " + team.getNoOfKills() + "\t\n"
                        + team.getWarriorCode().toString() + team.bombsLeft() + " has " + team.getWeapon() + " and killed " + team.getNoOfKills() + "\n\n";

            }
            System.out.println(result);

        }
    }

    public static void main(String[] args) throws FileNotFoundException
    {
        new TeamReport();


    }
}
