package com.example.learnchess;

import android.content.Context;

public class  levels {
    public static level getFromLevelList(int level, Context context)
    {
        String a = ""; // about
        String fact1 = ""; // with
        String fact2 = ""; // with2
        String fact3 = ""; // with 3
        String c = ""; // start order
        String d = ""; // end order
        String e = ""; // for messin
        String fa = ""; // for fa;
        int limit = -1; // for turnlimit
        boolean AI = false;
        boolean hint = false;
        boolean kinsExist = false;
        boolean calSteve = true;
        boolean canSkip = false;
        if(level == -1)
        {
            c = data.getOrgOrg(context);
            if(c.equals("960"))
                c = data.getChees960Bord();
            d = "MT";
            limit = -1;
            e = "win the game";
            AI = true;
            kinsExist = true;
            calSteve = false;
        }
        else if(level == 1)
        {
            a = "learn to move with Rook";
            fact1 = "rook can move only in straight line";
            fact2 = "in empty bord rook can get to any square in two moves";
            fact3 = "at the beginning of any chess game the rook is the only tool that isn't protected";
            c = "nnnnnnnnnnnnnngnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnndnnnnnnnnnnnnnn";
            d = "Xg";
            e = "eat the black pawn";
            limit = 2;
        }
        else if(level == 2)
        {
            a = "learn to move with Bishop";
            fact1 = "bishop can move only in diagonal lines";
            fact2 = "the bishop is on one color the whole game";
            fact3 = "";
            c = "nnnnnnnnnngnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnncnnnnnnnnnnnnnn";
            d = "Xg";
            e = "eat the black pawn";
            limit = 2;
        }
        else if(level == 3)
        {
            a = "learn to move with Knight";
            fact1 = "knight move two squares vertically and one square horizontally or two squares horizontally and one square vertically";
            fact2 = "knight is the only tool that can jump over other tools";
            fact3 = "knight is the only one who can threaten a queen without the queen threatening him";
            c = "nnnngnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnbnnnnnnnnnnnnnnnnnnnnn";
            d = "Xg";
            e = "eat the black pawn";
            limit = 3;
        }
        else if(level == 4)
        {
            a = "learn to move with Queen";
            fact1 = "queen move like rook and bishop combining";
            fact2 = "when queen is in the middle and the bord is empty queen cam get to more than 40% of the blocks";
            c = "nnnnnnngnngnnnnnnnnnnnnnnnnnnnnnnnnennnnnnnnnnnnnnnnnnngnnnnnnnn";
            d = "Xg";
            e = "eat the black pawns";
            limit = 3;
        }
        else if(level == 5)
        {
            a = "learn to move with pawn";
            fact1 = "pawn move one block forward";
            fact2 = "if pawn is in the second line he can move two blocks forward";
            fact3 = "if pawn get to the last line he become queen";
            c = "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnannnnnnnnnnn";
            d = "Xa";
            e = "reach to the last line";
            limit = 5;
        }
        else if(level == 6)
        {
            a = "learn to eat with pawn";
            fact1 = "pawn eat one block forward diagonally";
            fact2 = "pawn is the only tool that does not eat as he moves";
            c = "nnnknnnnnnnnnnnnnnnnnnnnnnnngnnnnnnnnnnnnnnnngnnnnnnannnnnnnnnnn";
            d = "Xk";
            e = "eat the black queen";
            limit = 6;
        }
        else if(level == 7)
        {
            a = "learn to move with king";
            fact1 = "king can move the every block that linked to him";
            fact2 = "if your king get capture you lose";
            c = "nnnnnnnnnnngnfnnnnnannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn";
            d = "Xa";
            e = "get queen";
            limit = 5;
        }
        else if(level == 8)
        {
            a = "how to do check";
            fact1 = "check its when the other player king's is under threat of capture";
            c = "lnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnen";
            d = "CH";
            e = "make check";
            limit = 1;
        }
        else if(level == 9)
        {
            a = "how to do mate";
            fact1 = "mate is when there check and after every move there still be check (the king will capture no matter what)";
            fact2 = "when someone do mate he win";
            d = "MT";
            c = "nlnnnnnnnnnnnnndnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnndnnnnnnnnn";
            e = "make mate";
            limit = 1;
        }
        else if(level == 10)
        {
            a = "learn to castling";
            c = "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnndnnnfnnn";
            d = "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnfdnnnn";
            e = "do left castling";
            fact1 = "castling is special move the can be done if the king and rook are in they starting block and there is nothing between them";
            fact2 = "in left castling the rook go one block to the left from the original location of the king and the king one block left from the new location of the rook";
            limit = 1;
        }
        else if(level == 11)
        {
            a = "learn to castling";
            c = "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnfnnd";
            d = "nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnndfn";
            e = "do right castling";
            fact1 = "castling is special move the can be done if the king and rook are in they starting block and there is nothing between them";
            fact2 = "in right castling the rook go one block to the right from the original location of the king and the king one block right from the new location of the rook";
            limit = 1;
            coim.setBotName("Steve",context);
        }
        else if(level == 12)
        {
            a = "learn to play ageist bot";
            c = "nnnnnnnnannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnngnnnnnnnnnnnnnnnn";
            d = "XXgk";
            e = "eat the black tool";
            fact1 = "you are playing ageist bot";
            limit = 3;
            AI = true;
        }
        else if(level == 13)
        {
            fact1 = "you are play ageist bot";
            a = "make math to bot";
            AI = true;
            c = "nnnnlnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnndbcefcbd";
            d = "MT";
            e = "make mate";
            limit = 100;
            kinsExist = true;
        }
        else if(level == 14)
        {
            a = "make math to bot";
            c = "nnnnlnnnggggggggnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnndbcefcbd";
            d = "MT";
            e = "make mate";
            limit = 100;
            kinsExist = true;
            AI = true;
        }
        else if(level == 15)
        {
            a = "learn to castling";
            c = "jnnnnnhjnnnngnnnnnnnnennnnnndgnnbnngnnnnnnnlnnnnnnnnnnnndbnnfnnn";
            d = "MT";
            e = "make mate with Castling";
            limit = 2;
            AI = true;
            kinsExist = true;
            hint = true;
            fact1 = "58";
        }
        else if(level == 16)
        {
            a = "mate practice";
            c = "nnnlnnnnnnnnnennnnnnnnnnnnnnnnnnnnnbnnnnnnnnnnnnnnnnnnnnnnnnnnnn";
            d = "MT";
            limit = 2;
            hint = true;
            fact1 = "3614";
            AI = true;
            e = "make mate";
        }
        else if(level == 17)
        {
            a = "end game practice";
            c = "nnnnnnnnnnnnknnnnannnnnnnannnnnnannnannnnnnnnnnnnnnnnnnnnnnnnnn";
            d = "Te";
            limit = 4;
            hint = true;
            fact1 = "2734";
            AI = true;
            e = "get queen";
        }
        else if(level == 18)
        {
            a = "mate practice";
            c = "nndnnnnnnnnnnnnnnnnniinnnnnnnnnnnnnnnncnennnndnnnnnlnnjnnfnnnnnj";
            d = "MT";
            limit = 2;
            hint = true;
            kinsExist = true;
            fact1 = "0341";
            AI = true;
            e = "make mate";
        }
        else if(level == 19)
        {
            a = "game practice";
            c = "nnnhlhnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnndcbefbcd";
            d = "MT";
            limit = 100;
            kinsExist = true;
            AI = true;
            e = "make mate";
        }
        else if(level == 20)
        {
            a = "game practice";
            c = "nnnilinnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnndcbefbcd";
            d = "MT";
            limit = 100;
            kinsExist = true;
            AI = true;
            e = "make mate";
        }
        else if(level == 21)
        {
            a = "mate practice";
            c = "nlnnnnnnnggnnnnnnnnnnhgnnncnnnnnfannnnnnnnaknnnnnannnjnndnnnnnnd";
            d = "MT";
            limit = 4;
            hint = true;
            kinsExist = true;
            fact1 = "64080706";
            fact2 = "64080504";
            AI = true;
            e = "make mate";
        }
        else if(level == 22)
        {
            a = "mate practice";
            c = "nnnnnnlnnnnnnnnnnnnnnnnnnnnnnnnnnnnennnnnnncnnnnnnnnnnnnfnnnnnnn";
            d = "MT";
            limit = 2;
            hint = true;
            kinsExist = true;
            fact1 = "4436";
            AI = true;
            e = "make mate";
        }
        else if(level == 23)
        {
            a = "game practice";
            c = "nnnjljnnnnnnjnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnndddddnnnnnfnnn";
            d = "MT";
            limit = 100;
            kinsExist = true;
            AI = true;
            e = "make mate";
        }
        else if(level == 24)
        {
            a = "mate practice";
            c = "jnnnnnncnngggnncinnnnnbdnnklnngndnngnnnnnannnnnnannnnnbnnfnnnnnn";
            d = "MT";
            limit = 2;
            hint = true;
            kinsExist = true;
            fact1 = "2355";
            AI = true;
            e = "make mate";
        }
        else if(level == 25)
        {
            a = "defense practice";
            c = "jnnnlnnnnnnnnnnnnnnnnnnnnnnbnnnnnnnnnnnnnnnnnnnnnnnnnnnjnnnfnnnn";
            d = "T1j";
            limit = 2;
            hint = true;
            kinsExist = true;
            fact1 = "2811";
            AI = true;
            e = "save the king";
        }
        else if(level == 26)
        {
            a = "game against Mika";
            c = "nhinlihnggggggggnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnaaaaaaaadbcefcbd";
            limit = -1;
            kinsExist = true;
            d = "MT";
            AI = true;
            e = "win Mika";
            callMika(context);
        }
        else if(level == 27)
        {
            a = "mate practice";
            c = "nnnnnnnnlnnnnnnnnnnnnnnnafnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn";
            limit = 25;
            kinsExist = true;
            d = "MT";
            AI = true;
            e = "do mate";
        }
        else if(level == 28)
        {
            a = "game against Mika";
            c = "jhinlihjggggggggnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnaaaaaaaadbcefcbd";
            limit = -1;
            kinsExist = true;
            d = "MT";
            AI = true;
            callMika(context);
            e = "win Mika";
        }
        else if(level == 29)
        {
            a = "mate practice";
            c = "nndnnnnnnnnjnnlnnnnnjnnnnnnnndnnnnnnnnnnnnnnnnnnnnnnnnnnnnnfnnnn";
            limit = -1;
            kinsExist = true;
            d = "MT";
            AI = true;
            e = "do mate";
        }
        else if(level == 30)
        {
            a = "game against Mika";
            c = data.getDefultOrg();
            limit = -1;
            kinsExist = true;
            d = "MT";
            AI = true;
            calSteve = false;
            callMika(context);
            e = "win Mika";
        }
        else if(level == 31)
        {
            a = "mate practice";
            c = "nnnnnnnljkgngnnnbinnnnnnnnnnnannnnnnnnnngennannanncnnnanbfndnnnn";
            d = "MT";
            limit = 2;
            AI = true;
            hint = true;
            fact1 =  "3060";
            e = "make mate";
        }
        else if(level == 32)
        {
            c = "jhiklihjgnngggngnngnnnnnngnannanngannnnnnnnnnnnnannnanaadbcendfn";
            d = "MT";
            AI = true;
            kinsExist = true;
            hint = true;
            fact1 = "286028";
            limit = 3;
            a = "mate practice";
            e = "make mate";
        }
        else if(level == 33)
        {
            a = "temptation practice";
            c = "nnnnnkijnlnnnnnnbnnnnngnaaenninnnnnnnnncngnnnnannnnnnnnjfnnnnndn";
            d = "MT";
            kinsExist = true;
            AI = true;
            e = "make mate";
            limit = 2;
            //hint = true;
            //fact1 = "27";
            fact2 = "F01l1718";
        }
        else if(level == 34)
        {
            c = "nnnnnjnnnnnnnnnnnnnnnnnnnnnnnnnnnbggnnnnlgnnnnnnjnnfnnnnnnnnnnnn";
            a = "survival practice";
            d = "TE";
            limit = 3;
            kinsExist = true;
            AI = true;
            e = "Survive for three turns";
            hint = true;
            fact1 = "345251";
        }
        else if(level == 35)
        {
            c = "nnnnnnlnnnknnggnnnnnnnngnnnnnnnnnncjnbhnnnnnnnnnnaannaandnnnndfn";
            a = "mate practice";
            d = "MT";
            AI = true;
            kinsExist = true;
            e = "make mate";
            limit = 3;
            hint = true;
            fact1 = "355701";
        }
        else if(level == 36)
        {
            a = "knight practice";
            c = "nnnhlhnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnbbbnnnnnbfbnnn";
            d = "MT";
            kinsExist = true;
            AI = true;
            fact1 = "if you want you can skip this lesson";
            calSteve = false;
            callJone(context);
            e = "make mate";
            limit = -1;
            canSkip = true;
        }
        else if(level == 37)
        {
            c = "nnnnnnbjnnlanggnennnnnnnnnnajnnhnnanncnnnnnnnnknnnnannndnnfdnnnn";
            d = "MT";
            AI = true;
            kinsExist = true;
            e = "make mate";
            a = "mate practice";
            hint = true;
            limit = 3;
            fact1 = "170119";
            fact2 = "F04l1912";
        }
        else if(level == 38)
        {
            c = "nnnnnnniennnbnnbgnnnnngnjnnannngnnnjnlnnnhnnnadnnnnaannannnncfnn";
            d = "MT";
            AI = true;
            limit = 4;
            kinsExist = true;
            e = "make mate";
            a = "mate practice";
            hint = true;
            fact1 = "53450011";
            fact3 = "F20l1309";
        }
        else if(level == 39)
        {
            c = "nnnnnnnnnnnnnknnnnnnnnnnjnnnnnnnhnngnnnnnnfgnnnnnnnnnnnnnnnnnnnn";
            AI  = true;
            kinsExist = true;
            a = "survival practice";
            d = "TE";
            limit = 4;
            e = "Survive for four turns";
        }
        else if(level == 40)
        {
            c = data.getDefultOrg();
            AI = true;
            calSteve = false;
            callJone(context);
            a = "game against John";
            d = "MT";
            kinsExist = true;
            limit = -1;
            e = "win John";
        }
        else if(level == 41)
        {
            c = "jninlnjnnggnnnnngnnnggnnhnnnbnnnanaaannacnbnnnnnnnannnannnnennfn";
            AI = true;
            e = "make mate";
            a = "mate practice";
            d = "MT";
            kinsExist = true;
            limit = 3;
            hint = true;
            fact1 = "603214";
        }
        else if(level == 42)
        {
            c = "nlnnjnnnnnnnnninannnnnnncnnnnnnnnnbnnanannnnabaeannnnnndfcnnnnnn";
            AI = true;
            a = "mate practice";
            e = "make mate";
            d = "MT";
            kinsExist = true;
            fact1 = "464812";
            fact2 = "F13j3548";
            canSkip = true;
        }
        else if(level == 43)
        {
            c = "knnnnnnknnnnnnnnnnnnnnnnnnnnfnnnnnnnnnnnnnnnnnnnnnnnnnnnknnnnnnj";
            d = "TE";
            AI = true;
            limit = 3;
            kinsExist = true;
            canSkip = true;
            a = "survival practice";
            e = "Survive for three turns";
        }
        else if(level == 44)
        {
            c = "nnjnncnihnnnnnninnnnnnngnlngangnnnnnnaennafnnancnnbannandnnnnnnn";
            d = "MT";
            kinsExist = true;
            AI = true;
            hint = true;
            fact1 = "39485751";
            limit = 4;
            a = "mate practice";
            e = "make mate";
        }
        else if(level == 45)
        {
            c = "ndnnnnnnnnnnnnnannnnnnafnnjnnnnnnnnnnnbnnninnjnnnnnnnnnnlnnnnnnn";
            d = "MT";
            kinsExist = true;
            AI = true;
            hint = true;
            limit = 15;
            fact1 = "2316";
            a = "planning practice";
            e = "make mate";
        }
        else if(level == 46)
        {
            c = "jinnnnndngnnnlnnnngggbnnnnnnnnennnahanncnnnananngfnnnndbnnnnncnn";
            d = "MT";
            kinsExist = true;
            AI = true;
            limit = 6;
            hint = true;
            fact1 = "50433124";
            a = "mate practice";
            e = "make mate";
        }
        else if(level == 47)
        {
            c = "jnnnninjgnknnnlgnnnnengnnnnnannnnncanannnaanninnannnnnnadncnfndn";
            d = "MT";
            kinsExist = true;
            AI = true;
            limit = 4;
            hint = true;
            fact1 = "386321";
            a = "mate practice";
            e = "make mate";
        }
        if(AI && calSteve)
            callMika(context);
        
        return new level(a,fact1,c,d,e,limit,AI,fact2,fact3,level,hint,kinsExist,canSkip,fa,context);
    }






    public static bot getBotByName(String name)
    {
        byte levelLimit;
        boolean agresive = false;
        if(name.equals("Mika"))
        {
            levelLimit = 1;
            agresive = true;
        }
        else if(name.equals("Steve"))
        {
            levelLimit = 3;
        }
        else if(name.equals("Jong"))
        {
            levelLimit = 5;
        }
        else if(name.equals("Teresa"))
        {
            levelLimit = 4;
            agresive = true;
        }
        else if(name.equals("John"))
        {
            levelLimit = 2;
            agresive = true;
        }
        else
        {
            levelLimit = Byte.parseByte(Character.toString(name.charAt(0)));
            if(name.charAt(1) == 'T')
                agresive = true;
            name = "bot";
        }
        return new bot(levelLimit,name,agresive);
    }


    static void callSteve(Context context)
    {
        coim.setBotName("Steve",context);
    }
    static void callMika(Context context)
    {
        coim.setBotName("Mika",context);
    }
    static void callJone(Context context)
    {
        coim.setBotName("John",context);
    }
    static void callTeresa(Context context)
    {
        coim.setBotName("Teresa",context);
    }
    static void callJong(Context context)
    {
        coim.setBotName("Jong",context);
    }
}
