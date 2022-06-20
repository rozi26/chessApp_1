package com.example.learnchess;

public class moveSave {
    private final int from;
    private final int to;
    private final char eatKind;
    private final boolean becomeQueen;
    public moveSave(moveSave other)
    {
        from = other.getFrom();
        to = other.getTo();
        eatKind = other.getEatKind();
        becomeQueen = other.getBecomeQueen();
    }
    public moveSave(int _from, int _to,char _eatKind,boolean _becomeQueen)
    {
        from = _from;
        to = _to;
        eatKind = _eatKind;
        becomeQueen = _becomeQueen;
    }
    public moveSave(boolean leftCastel)
    {
        from = 67;
        to = 67;
        eatKind = 'n';
        becomeQueen = leftCastel;
    }
    public int getFrom()
    {
        return from;
    }
    public int getTo()
    {
        return to;
    }
    public char getEatKind()
    {
        return eatKind;
    }
    public boolean getBecomeQueen()
    {
        return becomeQueen;
    }
}
