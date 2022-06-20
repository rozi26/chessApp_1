package com.example.learnchess;

public class gameruls {
    private static boolean left = false;
    private static boolean right = false;
    private static boolean up = false;
    private static boolean down = false;
    private static  char[] setColors()
    {
        char[] colors = new char[65];
        boolean black = false;
        for(int i = 1; i < 65; i++)
        {
            if(black)
                colors[i] = 'x';
            else
                colors[i] = 'q';
            black = !black;
            if(i % 8 == 0)
                black = !black;
        }
        return colors;
    }
    private static void setDor(int loc)
    {
        left = loc % 8 == 1;
        right = loc % 8 == 0;
        up = loc < 9;
        down = loc > 56;
    }
    public static char[] runMove(int loc,char[] what)
    {
        setDor(loc);
        char[] colors = setColors();
        if(!up)
        {
            for(int i = loc - 8; i > 0; i -= 8)
            {
                if(data.isWhite(what[i])) {
                    colors[i] = 'o';
                    break;
                }
                else if(data.isBlack(what[i]))
                {
                    colors[i] = 'g';
                    break;
                }
                else
                    colors[i] = 'y';
            }
        }
        if(!down)
        {
            for(int i = loc + 8; i < 65; i += 8)
            {
                if(data.isWhite(what[i])) {
                    colors[i] = 'o';
                    break;
                }
                else if(data.isBlack(what[i]))
                {
                    colors[i] = 'g';
                    break;
                }
                else
                    colors[i] = 'y';
            }
        }
        if(!right)
        {
            for(int i = loc + 1; i % 8 != 1; i++)
            {
                if(data.isWhite(what[i])) {
                    colors[i] = 'o';
                    break;
                }
                else if(data.isBlack(what[i]))
                {
                    colors[i] = 'g';
                    break;
                }
                else
                    colors[i] = 'y';
            }
        }
        if(!left)
        {
            for(int i = loc - 1; i % 8 != 0; i--)
            {
                if(data.isWhite(what[i])) {
                    colors[i] = 'o';
                    break;
                }
                else if(data.isBlack(what[i]))
                {
                    colors[i] = 'g';
                    break;
                }
                else
                    colors[i] = 'y';
            }
        }
        return colors;
    }
    public static char[] whiteSolMove(int loc,char[] what)
    {
        setDor(loc);
        char[] colors = setColors();
        if(!up && what[loc - 8] == 'n')
        {
            colors[loc - 8] = 'y';
            if(loc <= 56 && loc > 48 && what[loc - 16] == 'n')
                colors[loc - 16] = 'y';
        }
        if(!right && !up && data.isBlack(what[loc - 7]))
            colors[loc - 7] = 'g';
        else if(!right && !up && data.isWhite(what[loc - 7]))
            colors[loc - 7] = 'o';
        if(!left && !up && data.isBlack(what[loc - 9]))
            colors[loc - 9] = 'g';
        else if(!left && !up && data.isWhite(what[loc - 9]))
            colors[loc - 9] = 'o';
        return colors;
    }
    public static char[] blackSolMove(int loc,char[] what)
    {
        setDor(loc);
        char[] colors = setColors();
        if(!down && what[loc + 8] == 'n')
        {
            colors[loc + 8] = 'y';
            if(loc <= 16 && loc > 8 && what[loc + 16] == 'n')
                colors[loc + 16] = 'y';
        }
        if(!right && !down && data.isBlack(what[loc + 9]))
            colors[loc + 9] = 'g';
        else if(!right && !down && what[loc + 9] != 'n')
            colors[loc + 9] = 'o';
        if(!left && !down && data.isBlack(what[loc + 7]))
            colors[loc + 7] = 'g';
        else if(!left && !down && what[loc + 7] != 'n')
            colors[loc + 7] = 'o';
        return colors;
    }
    public static char[] hoursMove(int loc,char[] what)
    {
        setDor(loc);
        char[] colors = setColors();
        if(loc > 17 && !left)
        {
            if(what[loc - 17] == 'n')
                colors[loc - 17] = 'y';
            else if(data.isBlack(what[loc - 17]))
                colors[loc - 17] = 'g';
            else
                colors[loc - 17] = 'o';
        }
        if(loc > 16 && !right)
        {
            if(what[loc - 15] == 'n')
                colors[loc - 15] = 'y';
            else if(data.isBlack(what[loc - 15]))
                colors[loc - 15] = 'g';
            else
                colors[loc - 15] = 'o';
        }
        if(!(loc % 8 == 1 || loc % 8 == 2) && !up)
        {
            if(what[loc - 10] == 'n')
                colors[loc - 10] = 'y';
            else if(data.isBlack(what[loc - 10]))
                colors[loc - 10] = 'g';
            else
                colors[loc - 10] = 'o';
        }
        if(!(loc % 8 == 7 || loc % 8 == 0) && !up)
        {
            if(what[loc - 6] == 'n')
                colors[loc - 6] = 'y';
            else if(data.isBlack(what[loc - 6]))
                colors[loc - 6] = 'g';
            else
                colors[loc - 6] = 'o';
        }
        if(!(loc % 8 == 1 || loc % 8 == 2) && !down)
        {
            if(what[loc + 6] == 'n')
                colors[loc + 6] = 'y';
            else if(data.isBlack(what[loc + 6]))
                colors[loc + 6] = 'g';
            else
                colors[loc + 6] = 'o';
        }
        if(!(loc % 8 == 0 || loc % 8 == 7) && !down)
        {
            if(what[loc + 10] == 'n')
                colors[loc + 10] = 'y';
            else if(data.isBlack(what[loc + 10]))
                colors[loc + 10] = 'g';
            else
                colors[loc + 10] = 'o';
        }
        if(loc < 49 && !left)
        {
            if(what[loc + 15] == 'n')
                colors[loc + 15] = 'y';
            else if(data.isBlack(what[loc + 15]))
                colors[loc + 15] = 'g';
            else
                colors[loc + 15] = 'o';
        }
        if(loc < 49 && !right)
        {
            if(what[loc + 17] == 'n')
                colors[loc + 17] = 'y';
            else if(data.isBlack(what[loc + 17]))
                colors[loc + 17] = 'g';
            else
                colors[loc + 17] = 'o';
        }
        return colors;
    }
    public static char[] bisMove(int loc,char[] what)
    {
        setDor(loc);
        char[] colors = setColors();
        for(int i = loc + 7; i < 65; i+= 7)
        {
            if(i % 8 == 0)
                break;
            else
            {
                if(data.isWhite(what[i])) {
                    colors[i] = 'o';
                    break;
                }
                else if(data.isBlack(what[i]))
                {
                    colors[i] = 'g';
                    break;
                }
                else
                    colors[i] = 'y';
            }
        }
        for(int i = loc + 9; i < 65; i+= 9)
        {
            if(i % 8 == 1)
                break;
            else
            {
                if(data.isWhite(what[i])) {
                    colors[i] = 'o';
                    break;
                }
                else if(data.isBlack(what[i]))
                {
                    colors[i] = 'g';
                    break;
                }
                else
                    colors[i] = 'y';
            }
        }
        for(int i = loc - 7; i > 0; i-= 7)
        {
            if(i % 8 == 1)
                break;
            else
            {
                if(data.isWhite(what[i])) {
                    colors[i] = 'o';
                    break;
                }
                else if(data.isBlack(what[i]))
                {
                    colors[i] = 'g';
                    break;
                }
                else
                    colors[i] = 'y';
            }
        }
        for(int i = loc - 9; i > 0; i-= 9)
        {
            if(i % 8 == 0)
                break;
            else
            {
                if(data.isWhite(what[i])) {
                    colors[i] = 'o';
                    break;
                }
                else if(data.isBlack(what[i]))
                {
                    colors[i] = 'g';
                    break;
                }
                else
                    colors[i] = 'y';
            }
        }
        return colors;
    }
    public static char[] queenMove(int loc,char[] what)
    {
        setDor(loc);
        char[] b = runMove(loc,what);
        char[] a = bisMove(loc,what);
        for(int i = 1; i < 65; i++)
        {
            if((a[i] == 'x' || a[i] == 'q') && b[i] != 'x' && b[i] != 'q')
                a[i] = b[i];
        }
        return a;
    }
    public static char[] kingMove(int loc,char[] what)
    {
        setDor(loc);
        char[] colors = setColors();
        if(!up)
        {
            if(what[loc - 8] == 'n')
                colors[loc - 8] = 'y';
            else if(data.isBlack(what[loc - 8]))
                colors[loc - 8] = 'g';
            else if(what[loc] - 8 != 'n')
                colors[loc - 8] = 'o';
        }
        if(!right)
        {
            if(what[loc + 1] == 'n')
                colors[loc + 1] = 'y';
            else if(data.isBlack(what[loc + 1]))
                colors[loc + 1] = 'g';
            else if(what[loc] + 1 != 'n')
                colors[loc + 1] = 'o';
            if(!down)
            {
                if(what[loc + 9] == 'n')
                    colors[loc + 9] = 'y';
                else if(data.isBlack(what[loc + 9]))
                    colors[loc + 9] = 'g';
                else if(what[loc] + 9 != 'n')
                    colors[loc + 9] = 'o';
            }
            if(!up)
            {
                if(what[loc - 7] == 'n')
                    colors[loc - 7] = 'y';
                else if(data.isBlack(what[loc - 7]))
                    colors[loc - 7] = 'g';
                else if(what[loc] - 7 != 'n')
                    colors[loc - 7] = 'o';
            }
        }
        if(!down)
        {
            if(what[loc + 8] == 'n')
                colors[loc + 8] = 'y';
            else if(data.isBlack(what[loc + 8]))
                colors[loc + 8] = 'g';
            else if(what[loc] + 8 != 'n')
                colors[loc + 8] = 'o';
        }
        if(!left)
        {
            if(what[loc - 1] == 'n')
                colors[loc - 1] = 'y';
            else if(data.isBlack(what[loc - 1]))
                colors[loc - 1] = 'g';
            else if(what[loc] - 1 != 'n')
                colors[loc - 1] = 'o';
            if(!down)
            {
                if(what[loc + 7] == 'n')
                    colors[loc + 7] = 'y';
                else if(data.isBlack(what[loc + 7]))
                    colors[loc + 7] = 'g';
                else if(what[loc] + 7 != 'n')
                    colors[loc + 7] = 'o';
            }
            if(!up)
            {
                if(what[loc - 9] == 'n')
                    colors[loc - 9] = 'y';
                else if(data.isBlack(what[loc - 9]))
                    colors[loc - 9] = 'g';
                else if(what[loc] - 9 != 'n')
                    colors[loc - 9] = 'o';
            }
        }
        return colors;
    }
    public static char[] empty()
    {
        return setColors();
    }
}
