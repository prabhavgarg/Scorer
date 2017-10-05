package com.prabhav.play;

public class Word {
    private String mGameName;
    private int mGameImage;
    Word(String gameName,int gameImage)
    {
        mGameImage=gameImage;
        mGameName=gameName;
    }
    public int getGameImage()
    {
        return mGameImage;
    }
    public String getGameName()
    {
        return mGameName;
    }
}