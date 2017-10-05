package com.prabhav.play;


import java.util.List;

/**
 * Created by BOSS on 05-Jul-17.
 */

public class AddScores {

    int image;
    String scoresID;
    String scoresTeamA;
    String scoresTeamB;
    String scoresDate;
    String scoresGameName;
    String scoresTeamAName;
    String scoresTeamBName;
    String scoresComment;

    public AddScores(){

    }

    public AddScores(int image, String scoresTeamA, String scoresTeamB, String scoresDate) {
        this.image = image;
        this.scoresTeamA = scoresTeamA;
        this.scoresTeamB = scoresTeamB;
        this.scoresDate = scoresDate;
    }

    public AddScores(int image, String scoresID, String scoresTeamA, String scoresTeamB, String scoresDate, String scoresGameName, String scoresTeamAName, String scoresTeamBName, String scoresComment) {
        this.image = image;
        this.scoresID = scoresID;
        this.scoresTeamA = scoresTeamA;
        this.scoresTeamB = scoresTeamB;
        this.scoresDate = scoresDate;
        this.scoresGameName = scoresGameName;
        this.scoresTeamAName = scoresTeamAName;
        this.scoresTeamBName = scoresTeamBName;
        this.scoresComment = scoresComment;
    }


    public int getImage() {
        return image;
    }

    public String getScoresID() {
        return scoresID;
    }

    public String getScoresTeamA() {
        return scoresTeamA;
    }

    public String getScoresTeamB() {
        return scoresTeamB;
    }

    public String getScoresDate() {
        return scoresDate;
    }

    public String getScoresGameName() {
        return scoresGameName;
    }

    public String getScoresTeamAName() {
        return scoresTeamAName;
    }

    public String getScoresTeamBName() {
        return scoresTeamBName;
    }

    public String getScoresComment() {
        return scoresComment;
    }
}
