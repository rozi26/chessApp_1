package com.example.learnchess;

import android.util.Log;
import android.view.Choreographer;
import android.widget.ImageView;

import java.util.Random;

public class scoreRandomize {
    private moveSave[] list = new moveSave[100];
    private int MoveSaveLength = 0;
    private double scoreLimit = -1000;
    private int RandomizeUsees;
    public void addMoveSave(int _from,int _to, char _toKind,boolean _becomeQueen, int Score)
    {
        if(MoveSaveLength < 100)
        {
            if(Score == scoreLimit)
            {
                //System.out.println("add new one in randomize " + RandomizeUsees + " wite score of " + Score);
                list[MoveSaveLength] = new moveSave(_from,_to,_toKind,_becomeQueen);
                MoveSaveLength++;
            }
            else if(Score > scoreLimit) {
                Clear(Score);
                list[MoveSaveLength] = new moveSave(_from,_to,_toKind,_becomeQueen);
                MoveSaveLength++;
            }
            /*else
                Log.d("chackHighsetScore error", "the score " + Score + " is smaller them the correct score " + scoreLimit);*/
        }
        else
            Log.d("addMoveSave error", "add move save got over flow he have " + (MoveSaveLength + 1) + " and he have limit of 50 place");
        reportIfMoveSaveLengthError();
    }

    private void Clear(double newScore)
    {
        reportIfMoveSaveLengthError();
        //Log.d("privet clear", "got socre " + newScore + " and the correct score is " + scoreLimit + " so the program do self clear");
        list = new moveSave[100];
        MoveSaveLength = 0;
        scoreLimit = newScore;
    }
    public void fullClear()
    {
        reportIfMoveSaveLengthError();
        list = new moveSave[100];
        MoveSaveLength = 0;
        scoreLimit = -1000;
        //System.out.println("full clear secsses (MoveSaveLength = " + MoveSaveLength + " score limit = " + scoreLimit + " )");

    }
    Random rand = new Random();
    public moveSave getRandom()
    {
        reportIfMoveSaveLengthError();
        RandomizeUsees++;
        //System.out.println("report using getRandom in the " + RandomizeUsees + " time");
        try
        {
            int r = rand.nextInt(MoveSaveLength);
            return list[r];
        }
        catch (Exception e)
        {
            Log.d("no choise choos", "will reutrn te first move because random bug (MoveSaveLength: " + MoveSaveLength + " scoreLimit: " + scoreLimit + " (use " + RandomizeUsees + " times))");
            return list[0];
        }
    }
    private void reportIfMoveSaveLengthError()
    {
        int num = 0;
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] != null)
                num++;
        }
        if(num != MoveSaveLength)
            System.out.println("error  MoveSaveLength don't equal to num  MoveSaveLength = " + MoveSaveLength + " num = " + num + "Mark///Mark///Mark///Mark///Mark///Mark///Mark///Mark///Mark///Mark///Mark");
    }
}
