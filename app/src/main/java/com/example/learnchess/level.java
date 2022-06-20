package com.example.learnchess;

import android.app.Activity;
import android.content.Context;

public class level {
    final private String about;
    private String startOrder;
    private String endOrder;
    final private String with;
    final private String with2;
    final private String with3;
    final private String messin;
    final private String fa;
    final private boolean AIon;
    final private boolean hint;
    final private int turnLimit;
    final private int num;
    final private boolean kindExist;
    final private boolean canSkip;
    public level(String _about, String _with, String _startOrder, String _endOrder, String _messin, int _turnLimit, boolean _AIon, String _with2, String _with3, int _num, boolean _hint,boolean _kindE,boolean _canSkip,String _fa, Context context)
    {
        if(_startOrder.length() != 64)
        {
           try {
               System.out.println("crash because " + startOrder.length() + " or " + endOrder.length() + " != 64");
               double d;
               d = 4 / 0;
           }
           catch (Exception e)
           {
               System.out.println("error this level don't exist so go to empty bord////////////////////////////////////");
           }
        }
        about = _about;
        with = _with;
        startOrder = _startOrder;
        endOrder = _endOrder;
        messin = _messin;
        turnLimit = _turnLimit;
        AIon = _AIon;
        with2 = _with2;
        with3 = _with3;
        num = _num;
        hint = _hint;
        fa = _fa;
        kindExist = _kindE;
        canSkip = _canSkip;
    }
    public String getAbout()
    {
        return about;
    }
    public String getStartOrder()
    {
        return startOrder;
    }
    public String getEndOrder()
    {
        return endOrder;
    }
    public String getWith()
    {
        return with;
    }
    public String getMessin()
    {
        return messin;
    }
    public int getTurnLimit()
    {
        return turnLimit;
    }
    public boolean getAIon()
    {
        return AIon;
    }
    public String getWith2()
    {
        return with2;
    }
    public String getWith3()
    {
        return with3;
    }
    public int getNum()
    {
        return num;
    }
    public boolean getHint()
    {
        return hint;
    }
    public boolean isKindExist()
    {
        return kindExist;
    }
    public boolean isCanSkip()
    {
        return canSkip;
    }
    public String getFa()
    {
        return fa;
    }
}
