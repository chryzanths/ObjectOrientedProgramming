package dao;

import domain.Team;
import domain.Warrior;

import java.io.*;
import java.util.*;

// program for accessing teamInfo.csv
public class TeamDA
{
    private List<Team> teamList = new ArrayList<>();

    public TeamDA() throws FileNotFoundException
    {
        Scanner teamInfo = new Scanner(new FileReader("src/teamInfo.csv"));

        while (teamInfo.hasNext())
        {
            String rowTeam = new String();
            rowTeam = teamInfo.nextLine();

            String[] rowTeamSpecific = new String[2];
            rowTeamSpecific = rowTeam.split(",");

            Team team = new Team();
            team.setTeamID(rowTeamSpecific[0]);
            team.setTeamName(rowTeamSpecific[1]);

            WarriorDA warriorDA = new WarriorDA(team.getTeamID().trim());
            team.setWarriorList(warriorDA.getWarriorList());
            teamList.add(team);
        }


    }
    public Object getTeamList() {
        return teamList;
    }
}
