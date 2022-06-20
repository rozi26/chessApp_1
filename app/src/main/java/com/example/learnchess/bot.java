package com.example.learnchess;

public class bot {
    private final byte levelLimit;
    private final String name;
    private final boolean agresive;
    public bot(byte _levelLimit, String _name,boolean _agresive)
    {
        levelLimit = _levelLimit;
        name = _name;
        agresive = _agresive;
    }
    public byte getLevelLimit()
    {
        return levelLimit;
    }
    public String getName()
    {
        return name;
    }
    public boolean isAgresive()
    {
        return agresive;
    }
}
