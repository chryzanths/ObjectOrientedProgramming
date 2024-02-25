package dao;

import domain.Warrior;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// program for accessing teamStatInfo.csv
public class WarriorDA
{
    private List<Warrior> warriorList = new ArrayList<>();

    public WarriorDA(String trim) throws FileNotFoundException
    {
        Scanner teamStatInfo = new Scanner(new FileReader("src/teamStatInfo.csv"));

        while (teamStatInfo.hasNext())
        {
            String rowWarrior = new String();
            rowWarrior = teamStatInfo.nextLine();

            String[] rowWarriorSpecific = new String[4];
            rowWarriorSpecific = rowWarrior.split(",");


            Warrior warrior = new Warrior() {
                @Override
                public Integer bulletsLeft() {
                    return Integer.valueOf(getWarriorCode() + " is using Guns! ");
                }

                @Override
                public Integer arrowsLeft() {
                    return Integer.valueOf(getWarriorCode() + " is using Archery! ");
                }

                @Override
                public Integer bombsLeft() {
                    return Integer.valueOf(getWarriorCode() + " is using Bombs! ");

                }

                @Override
                public Warrior[] setWarriorList() {
                    return new Warrior[0];
                }

            };

            warrior.setWarriorCode(rowWarriorSpecific[1]);
            warrior.setWeapon(rowWarriorSpecific[2]);
            warrior.setNoOfKills(Integer.valueOf(rowWarriorSpecific[3]));

            warriorList.add(warrior);

        }
    }

    public Object getWarriorList() {
        return warriorList;
    }
}
