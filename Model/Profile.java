package edu.neumont.oop.Model;

import java.util.Arrays;

public class Profile {
    private int[] battleshipWinLossRecord;
    private int[] checkersWinLossRecord;
    private String name;

    public Profile(String name){
        this.name = name;
        battleshipWinLossRecord = new int[] {0,0};
        checkersWinLossRecord = new int[] {0,0,0};
    }

    public void updateBattleshipWinLoss(boolean won){
        if(won){
            battleshipWinLossRecord[0]++;
        } else {
            battleshipWinLossRecord[1]++;
        }
    }

    public void updateCheckersWinLoss(boolean won, boolean tied){
        if(won){
            checkersWinLossRecord[0]++;
        } else if(!tied) {
            checkersWinLossRecord[1]++;
        } else {
            checkersWinLossRecord[2]++;
        }
    }

    public String getBattleshipWinLossString(){
        return battleshipWinLossRecord[0] + "-" + battleshipWinLossRecord[1];
    }

    public String getCheckersWinLossString(){
        return checkersWinLossRecord[0] + "-" + checkersWinLossRecord[1] + "-" + checkersWinLossRecord[2];
    }

    @Override
    public String toString() { //untested, this may not function as intended
        return "Profile{" +
                "battleshipWinLossRecord=" + Arrays.toString(battleshipWinLossRecord) +
                ", checkersWinLossRecord=" + Arrays.toString(checkersWinLossRecord) +
                ", name='" + name + '\'' +
                '}';
    }
}
