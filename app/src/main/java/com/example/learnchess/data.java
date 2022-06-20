package com.example.learnchess;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Vibrator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.system.Os;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class data {
    private static MediaPlayer player;

    public static String getTimeMessege() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat;
        String date = "";
        simpleDateFormat = new SimpleDateFormat("h:mm a");
        date += simpleDateFormat.format(calendar.getTime());
        int Time = Integer.parseInt(Character.toString(date.charAt(0)));
        if (date.charAt(1) != ':')
            Time += Integer.parseInt(Character.toString(date.charAt(1))) + 9;
        if (date.charAt(date.length() - 2) == 'P')
            Time += 12;
        if(Time == 24)
            Time = 12;
        System.out.println("date " + date);
        System.out.println("hour " + Time);
        if (Time < 6 || Time > 22)
            return "good night";
        else if (Time <= 12)
            return "good morning";
        else if (Time < 18)
            return "good afternoon";
        else
            return "good evening";
    }
    public static String getTime()
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String data = simpleDateFormat.format(calendar.getTime());
        data += "T";
        SimpleDateFormat simpleDateFormat2;
        simpleDateFormat2 = new SimpleDateFormat("h:mm a");
        data += simpleDateFormat2.format(calendar.getTime());
        return  data;
    }
    public static boolean isWhite(char a) {
        return (a == 'a' || a == 'b' || a == 'c' || a == 'd' || a == 'e' || a == 'f');
    }

    public static boolean isBlack(char a) {
        return (a != 'n' && !isWhite(a));
    }
    public static boolean isBlackBlock(int num)
    {
        boolean black = false;
        for(int i = 1; i < 65; i++)
        {
            if(i == num)
                return black;
            black = !black;
            if(i % 8 == 0)
                black = !black;
        }
        return false;
    }
    public static ImageView NumToPic(int num, Activity a) {
        switch (num)
        {
            case 1:return a.findViewById(R.id.a1);
            case 2:return a.findViewById(R.id.a2);
            case 3:return a.findViewById(R.id.a3);
            case 4:return a.findViewById(R.id.a4);
            case 5:return a.findViewById(R.id.a5);
            case 6:return a.findViewById(R.id.a6);
            case 7:return a.findViewById(R.id.a7);
            case 8:return a.findViewById(R.id.a8);
            case 9:return a.findViewById(R.id.b1);
            case 10:return a.findViewById(R.id.b2);
            case 11:return a.findViewById(R.id.b3);
            case 12:return a.findViewById(R.id.b4);
            case 13:return a.findViewById(R.id.b5);
            case 14:return a.findViewById(R.id.b6);
            case 15:return a.findViewById(R.id.b7);
            case 16:return a.findViewById(R.id.b8);
            case 17:return a.findViewById(R.id.c1);
            case 18:return a.findViewById(R.id.c2);
            case 19:return a.findViewById(R.id.c3);
            case 20:return a.findViewById(R.id.c4);
            case 21:return a.findViewById(R.id.c5);
            case 22:return a.findViewById(R.id.c6);
            case 23:return a.findViewById(R.id.c7);
            case 24:return a.findViewById(R.id.c8);
            case 25:return a.findViewById(R.id.d1);
            case 26:return a.findViewById(R.id.d2);
            case 27:return a.findViewById(R.id.d3);
            case 28:return a.findViewById(R.id.d4);
            case 29:return a.findViewById(R.id.d5);
            case 30:return a.findViewById(R.id.d6);
            case 31:return a.findViewById(R.id.d7);
            case 32:return a.findViewById(R.id.d8);
            case 33:return a.findViewById(R.id.e1);
            case 34:return a.findViewById(R.id.e2);
            case 35:return a.findViewById(R.id.e3);
            case 36:return a.findViewById(R.id.e4);
            case 37:return a.findViewById(R.id.e5);
            case 38:return a.findViewById(R.id.e6);
            case 39:return a.findViewById(R.id.e7);
            case 40:return a.findViewById(R.id.e8);
            case 41:return a.findViewById(R.id.f1);
            case 42:return a.findViewById(R.id.f2);
            case 43:return a.findViewById(R.id.f3);
            case 44:return a.findViewById(R.id.f4);
            case 45:return a.findViewById(R.id.f5);
            case 46:return a.findViewById(R.id.f6);
            case 47:return a.findViewById(R.id.f7);
            case 48:return a.findViewById(R.id.f8);
            case 49:return a.findViewById(R.id.g1);
            case 50:return a.findViewById(R.id.g2);
            case 51:return a.findViewById(R.id.g3);
            case 52:return a.findViewById(R.id.g4);
            case 53:return a.findViewById(R.id.g5);
            case 54:return a.findViewById(R.id.g6);
            case 55:return a.findViewById(R.id.g7);
            case 56:return a.findViewById(R.id.g8);
            case 57:return a.findViewById(R.id.h1);
            case 58:return a.findViewById(R.id.h2);
            case 59:return a.findViewById(R.id.h3);
            case 60:return a.findViewById(R.id.h4);
            case 61:return a.findViewById(R.id.h5);
            case 62:return a.findViewById(R.id.h6);
            case 63:return a.findViewById(R.id.h7);
            default:return a.findViewById(R.id.h8);
        }
    }

    public static int PicToNum(ImageView i, Activity a) {
        if (i == null)
            return 0;
        else if (i.equals(a.findViewById(R.id.a1)))
            return 1;
        else if (i.equals(a.findViewById(R.id.a2)))
            return 2;
        else if (i.equals(a.findViewById(R.id.a3)))
            return 3;
        else if (i.equals(a.findViewById(R.id.a4)))
            return 4;
        else if (i.equals(a.findViewById(R.id.a5)))
            return 5;
        else if (i.equals(a.findViewById(R.id.a6)))
            return 6;
        else if (i.equals(a.findViewById(R.id.a7)))
            return 7;
        else if (i.equals(a.findViewById(R.id.a8)))
            return 8;
        else if (i.equals(a.findViewById(R.id.b1)))
            return 9;
        else if (i.equals(a.findViewById(R.id.b2)))
            return 10;
        else if (i.equals(a.findViewById(R.id.b3)))
            return 11;
        else if (i.equals(a.findViewById(R.id.b4)))
            return 12;
        else if (i.equals(a.findViewById(R.id.b5)))
            return 13;
        else if (i.equals(a.findViewById(R.id.b6)))
            return 14;
        else if (i.equals(a.findViewById(R.id.b7)))
            return 15;
        else if (i.equals(a.findViewById(R.id.b8)))
            return 16;
        else if (i.equals(a.findViewById(R.id.c1)))
            return 17;
        else if (i.equals(a.findViewById(R.id.c2)))
            return 18;
        else if (i.equals(a.findViewById(R.id.c3)))
            return 19;
        else if (i.equals(a.findViewById(R.id.c4)))
            return 20;
        else if (i.equals(a.findViewById(R.id.c5)))
            return 21;
        else if (i.equals(a.findViewById(R.id.c6)))
            return 22;
        else if (i.equals(a.findViewById(R.id.c7)))
            return 23;
        else if (i.equals(a.findViewById(R.id.c8)))
            return 24;
        else if (i.equals(a.findViewById(R.id.d1)))
            return 25;
        else if (i.equals(a.findViewById(R.id.d2)))
            return 26;
        else if (i.equals(a.findViewById(R.id.d3)))
            return 27;
        else if (i.equals(a.findViewById(R.id.d4)))
            return 28;
        else if (i.equals(a.findViewById(R.id.d5)))
            return 29;
        else if (i.equals(a.findViewById(R.id.d6)))
            return 30;
        else if (i.equals(a.findViewById(R.id.d7)))
            return 31;
        else if (i.equals(a.findViewById(R.id.d8)))
            return 32;
        else if (i.equals(a.findViewById(R.id.e1)))
            return 33;
        else if (i.equals(a.findViewById(R.id.e2)))
            return 34;
        else if (i.equals(a.findViewById(R.id.e3)))
            return 35;
        else if (i.equals(a.findViewById(R.id.e4)))
            return 36;
        else if (i.equals(a.findViewById(R.id.e5)))
            return 37;
        else if (i.equals(a.findViewById(R.id.e6)))
            return 38;
        else if (i.equals(a.findViewById(R.id.e7)))
            return 39;
        else if (i.equals(a.findViewById(R.id.e8)))
            return 40;
        else if (i.equals(a.findViewById(R.id.f1)))
            return 41;
        else if (i.equals(a.findViewById(R.id.f2)))
            return 42;
        else if (i.equals(a.findViewById(R.id.f3)))
            return 43;
        else if (i.equals(a.findViewById(R.id.f4)))
            return 44;
        else if (i.equals(a.findViewById(R.id.f5)))
            return 45;
        else if (i.equals(a.findViewById(R.id.f6)))
            return 46;
        else if (i.equals(a.findViewById(R.id.f7)))
            return 47;
        else if (i.equals(a.findViewById(R.id.f8)))
            return 48;
        else if (i.equals(a.findViewById(R.id.g1)))
            return 49;
        else if (i.equals(a.findViewById(R.id.g2)))
            return 50;
        else if (i.equals(a.findViewById(R.id.g3)))
            return 51;
        else if (i.equals(a.findViewById(R.id.g4)))
            return 52;
        else if (i.equals(a.findViewById(R.id.g5)))
            return 53;
        else if (i.equals(a.findViewById(R.id.g6)))
            return 54;
        else if (i.equals(a.findViewById(R.id.g7)))
            return 55;
        else if (i.equals(a.findViewById(R.id.g8)))
            return 56;
        else if (i.equals(a.findViewById(R.id.h1)))
            return 57;
        else if (i.equals(a.findViewById(R.id.h2)))
            return 58;
        else if (i.equals(a.findViewById(R.id.h3)))
            return 59;
        else if (i.equals(a.findViewById(R.id.h4)))
            return 60;
        else if (i.equals(a.findViewById(R.id.h5)))
            return 61;
        else if (i.equals(a.findViewById(R.id.h6)))
            return 62;
        else if (i.equals(a.findViewById(R.id.h7)))
            return 63;
        else/* if(i.equals(a.findViewById(R.id.h8)))/**/
            return 64;
    }

    private static boolean isWhiteBlock(int loc) {
        final int num = loc;
        boolean black = false;
        for (int i = 1; i < 65; i++) {
            if (i == num)
                return !black;
            black = !black;
            if (i % 8 == 0)
                black = !black;
        }
        return true;
    }

    public static void setImage(ImageView i, char a,int num,boolean botStart,Context context) {
        if(botStart && coim.getWhiteStart(context))
            a = whiteIsBLack(a);
        final boolean white = isWhiteBlock(num);
        if (a == 'a') {
            if (white)
                i.setImageResource(R.mipmap.whitesolwhite);
            else
                i.setImageResource(R.mipmap.whitesolblack);
        } else if (a == 'b') {
            if (white)
                i.setImageResource(R.mipmap.whitehorsewhite);
            else
                i.setImageResource(R.mipmap.whitehorseblack);
        } else if (a == 'c') {
            if (white)
                i.setImageResource(R.mipmap.whitebiswhite);
            else
                i.setImageResource(R.mipmap.whitebisblack);
        } else if (a == 'd') {
            if (white)
                i.setImageResource(R.mipmap.whiterunwhite);
            else
                i.setImageResource(R.mipmap.whiterunblack);
        } else if (a == 'e') {
            if (white)
                i.setImageResource(R.mipmap.whitequeenwhite);
            else
                i.setImageResource(R.mipmap.whitequeenblack);
        } else if (a == 'f') {
            if (white)
                i.setImageResource(R.mipmap.whitekingwhite);
            else
                i.setImageResource(R.mipmap.whitekingblack);
        } else if (a == 'g') {
            if (white)
                i.setImageResource(R.mipmap.blacksolwhite);
            else
                i.setImageResource(R.mipmap.blacksolblack);
        } else if (a == 'h') {
            if (white)
                i.setImageResource(R.mipmap.blackhorsewhite);
            else
                i.setImageResource(R.mipmap.blackhorseblack);
        } else if (a == 'i') {
            if (white)
                i.setImageResource(R.mipmap.blackbiswhite);
            else
                i.setImageResource(R.mipmap.blackbisblack);
        } else if (a == 'j') {
            if (white)
                i.setImageResource(R.mipmap.blackrunwhite);
            else
                i.setImageResource(R.mipmap.blackrunblack);
        } else if (a == 'k') {
            if (white)
                i.setImageResource(R.mipmap.blackqueenwhite);
            else
                i.setImageResource(R.mipmap.blackqueenblack);
        } else if (a == 'l') {
            if (white)
                i.setImageResource(R.mipmap.blackkingwhite);
            else
                i.setImageResource(R.mipmap.blackkingblack);
        } else if (a == 'n')
            i.setImageDrawable(null);

    }
    private static char whiteIsBLack(char a)
    {
        if(a == 'a')
            return 'g';
        if(a == 'b')
            return 'h';
        if(a == 'c')
            return 'i';
        if(a == 'd')
            return 'j';
        if(a == 'e')
            return 'k';
        if(a == 'f')
            return 'l';
        if(a == 'g')
            return 'a';
        if(a == 'h')
            return 'b';
        if(a == 'i')
            return 'c';
        if(a == 'j')
            return 'd';
        if(a == 'k')
            return 'e';
        if(a == 'l')
            return 'f';
        return 'n';
    }
    public static void setColor(ImageView i, char to,char kind,boolean botStart,int num)
    {
        if (to == 'g' && isBlack(kind))
        {
            char a = kind;
            if(botStart)
                {
                    if (a == 'g')
                        i.setImageResource(R.mipmap.whitesolgreen);
                    else if (a == 'h')
                        i.setImageResource(R.mipmap.whitehorsegreen);
                    else if (a == 'i')
                        i.setImageResource(R.mipmap.whitebisgreen);
                    else if (a == 'j')
                        i.setImageResource(R.mipmap.whiterungreen);
                    else if (a == 'k')
                        i.setImageResource(R.mipmap.whitequeengreen);
                    else if (a == 'l')
                        i.setImageResource(R.mipmap.whitekinggreen);
            }
            else
            {
                if (a == 'g')
                    i.setImageResource(R.mipmap.blacksolgreen);
                else if (a == 'h')
                    i.setImageResource(R.mipmap.blackhorsegreen);
                else if (a == 'i')
                    i.setImageResource(R.mipmap.blackbisgreen);
                else if (a == 'j')
                    i.setImageResource(R.mipmap.blackrungreen);
                else if (a == 'k')
                    i.setImageResource(R.mipmap.blackqueengreen);
                else if (a == 'l')
                    i.setImageResource(R.mipmap.blackkinggreen);
                else
                    System.out.println("location " + kind + " a is unknown = " + a + " (this is error/////////}////////////////////////////////////////////////////////////////////////)");
            }
        }
        else
        {
            if (to == 'y') {
                if (isWhiteBlock(num))
                    i.setImageResource(R.mipmap.graywhite);
                else
                    i.setImageResource(R.mipmap.grayblack);
            } else if (to == 'r')
                i.setBackgroundColor(Color.RED);
            else if (to == 'b')
                i.setBackgroundColor(Color.BLUE);
            else if (to == 'z')
                i.setBackgroundColor(Color.GRAY);
            else if (to == 'x')
                i.setBackgroundColor(Color.BLACK);
            else if (to == 'q')
                i.setBackgroundColor(Color.WHITE);
            else
                i.setBackgroundColor(Color.LTGRAY);
        }
    }

    public static char[] doWhiteMove(int loc, char[] what) {
        final char kind = what[loc];
        if (kind == 'a')
            return (gameruls.whiteSolMove(loc, what));
        else if (kind == 'b')
            return (gameruls.hoursMove(loc, what));
        else if (kind == 'c')
            return (gameruls.bisMove(loc, what));
        else if (kind == 'd')
            return (gameruls.runMove(loc, what));
        else if (kind == 'e')
            return (gameruls.queenMove(loc, what));
        else if (kind == 'f')
            return (gameruls.kingMove(loc, what));
        else
            return gameruls.empty();
    }

    public static char[] doBlackMove(int loc, char[] what) {
        final char kind = what[loc];
        if (kind == 'g')
            return (gameruls.blackSolMove(loc, what));
        else if (kind == 'h')
            return (gameruls.hoursMove(loc, what));
        else if (kind == 'i')
            return (gameruls.bisMove(loc, what));
        else if (kind == 'j')
            return (gameruls.runMove(loc, what));
        else if (kind == 'k')
            return (gameruls.queenMove(loc, what));
        else if (kind == 'l')
            return (gameruls.kingMove(loc, what));
        else
            return gameruls.empty();
    }

    public static int getToolScore(char a) {
        if (a == 'a')
            return 4;
        else if (a == 'b')
            return 10;
        else if (a == 'c')
            return 10;
        else if (a == 'd')
            return 13;
        else if (a == 'e')
            return 24;
        else if (a == 'f')
            return 301;
        else if (a == 'g')
            return 5;
        else if (a == 'h')
            return 11;
        else if (a == 'i')
            return 11;
        else if (a == 'j')
            return 14;
        else if (a == 'k')
            return 25;
        else if (a == 'l')
            return 200;
        else {
            System.out.println("char is " + a + " (int tooScore) return 0");
            return 0;
        }
    }
    public static void getCoimReport(Context context)
    {
        System.out.println("print ");
        System.out.println("start of game report by date:");
        System.out.println("first play: " + coim.getFirstEnter(context));
        System.out.println("levelS: " + coim.getStartLevelS(context));
        System.out.println("level: " + coim.getStartLevel(context));
        System.out.println("lesRe: " + coim.getLesNumRm(context));
        System.out.println("lesOn: " + coim.getLesOn(context));
        System.out.println("lesNum: " + coim.getLes(context));
        System.out.println("botName: " + coim.getBotName(context));
        System.out.println("end messege: " + coim.getEndMessesge(context));
        System.out.println("onMenu: " + coim.getOnMenu(context));
        System.out.println("show level in lessen page: " + coim.getDataLevelShow(context));
        System.out.println("save start:");
        System.out.println(coim.getSave(context));
        System.out.println("save end successful");
        System.out.println("unDoNum: " + coim.getUnDo(context));
        System.out.println("UI page moving animation: " + coim.getPMANum(context));
        System.out.println("animation: " + coim.getAnimationOn(context));
        System.out.println("bot turns: " + coim.getBotTurns(context));
        System.out.println("all turns time: " + coim.getToAveageTurnTime(context));
        System.out.println("user time: " + coim.getUserTime(context));
        System.out.println("start saves (there " + coim.getNumberOfSaves(context) + "):");
        for(int i = 1; i < 51; i++)
        {
            System.out.println("start for save" + i + "SS:");
            System.out.println(coim.getStringByName("save" + i + "SS",context));
        }
        System.out.println("end saves");
        System.out.println("start orgs:");
        for(int i = 1; i < 11; i++)
        {
            System.out.println("i is " + i + ": " + coim.getStringByName("startOrgSaver" + i,context));
        }
        System.out.println("end orgs");
    }
    public static boolean canCasel(char[] what) {
        return canRightCasel(what) || canLeftCasel(what);
    }

    public static boolean canRightCasel(char[] what) {
        return (what[64] == 'd' && what[63] == 'n' && what[62] == 'n' && what[61] == 'f');
    }

    public static boolean canLeftCasel(char[] what) {
        return (what[57] == 'd' && what[58] == 'n' && what[59] == 'n' && what[60] == 'n' && what[61] == 'f');
    }


    //code stafe
    public static void addCode(moveSave m, Context context) {
        String add = "";
        add += intToString(m.getFrom());
        add += intToString(m.getTo());
        add += m.getEatKind();
        add += boolToChar(m.getBecomeQueen());
        add += "N";
        coim.addSave(add, context);
    }
    public static moveSave[] getCode(Context context) {
        //getCoimReport(context);
        final String save = coim.getSave(context);
        System.out.println(save);
        moveSave[] re = new moveSave[500];
        String collect = "";
        int moveSaveAdd = 0;
        boolean start = false;
        for(int i = 0; i < save.length(); i++)
        {
            char a = save.charAt(i);
            if(start)
            {
                if(a == 'N')
                {
                    re[moveSaveAdd] = stringToMoveSave(collect);
                    collect = "";
                    moveSaveAdd++;
                }
                else if(a != 'S')
                    collect += a;
            }
            else if(a == 'S' && save.charAt(i + 1) != 't' && save.charAt(i + 1) != 'S')
                start = true;
        }
        return re;
    }
    public static void removeLastMove(Context context)
    {
        StringBuilder sb = new StringBuilder(coim.getSave(context));
        sb.deleteCharAt(sb.length() - 1);
        for(int i = sb.length() - 1; i > 0; i--)
        {
            char a = sb.charAt(i);
            if(a == 'N')
                break;
            else
               sb.deleteCharAt(i);
        }
        coim.setSave(sb.toString(),context);
    }

    private static moveSave stringToMoveSave(String s)
    {
        byte i = 0;
        int from;
        int to;
        from = charsToInt(s.charAt(0), s.charAt(1));
        to = charsToInt(s.charAt(2),s.charAt(3));
        return new moveSave(from,to,s.charAt(4),charToBool(s.charAt(5)));
    }


    private static String intToString(int i)
    {
        String s = Integer.toString(i);
        if(s.length() == 1)
            s = "0" + s;
        return s;
    }
    private static char boolToChar(boolean b)
    {
        if(b)
            return 'T';
        return 'F';
    }
    private static boolean charToBool(char c)
    {
        if(c == 'T')
            return true;
        return false;
    }
    private static int charsToInt(char _a,char _b)
    {
        String a = Character.toString(_a);
        String b = Character.toString(_b);
        return Integer.parseInt(a + b);
    }
    public static void makeOrenge(ImageView i,char a)
    {
        if(a == 'a')
            i.setImageResource(R.mipmap.whitesolorenge);
        else if(a == 'b')
            i.setImageResource(R.mipmap.whitehorseorenge);
        else if(a == 'c')
            i.setImageResource(R.mipmap.whitebisorenge);
        else if(a == 'd')
            i.setImageResource(R.mipmap.whiterunorenge);
        else if(a == 'e')
            i.setImageResource(R.mipmap.whitequeenorenge);
        else if(a == 'f')
            i.setImageResource(R.mipmap.whitekingorenge);
    }
    public static void deadSol(char kind,Activity a,boolean botStart)
    {
        if(botStart)
            kind = whiteIsBLack(kind);
        if(kind == 'a')
        {
            ImageView i1 = a.findViewById(R.id.EBsol1);
            ImageView i2 = a.findViewById(R.id.EBsol2);
            ImageView i3 = a.findViewById(R.id.EBsol3);
            ImageView i4 = a.findViewById(R.id.EBsol4);
            ImageView i5 = a.findViewById(R.id.EBsol5);
            ImageView i6 = a.findViewById(R.id.EBsol6);
            ImageView i7 = a.findViewById(R.id.EBsol7);
            ImageView i8 = a.findViewById(R.id.EBsol8);
            if(i1.getDrawable()  == null)
                i1.setImageResource(R.mipmap.whitesolgray);
            else if(i2.getDrawable() == null)
                i2.setImageResource(R.mipmap.whitesolgray);
            else if(i3.getDrawable() == null)
                i3.setImageResource(R.mipmap.whitesolgray);
            else if(i4.getDrawable() == null)
                i4.setImageResource(R.mipmap.whitesolgray);
            else if(i5.getDrawable() == null)
                i5.setImageResource(R.mipmap.whitesolgray);
            else if(i6.getDrawable() == null)
                i6.setImageResource(R.mipmap.whitesolgray);
            else if(i7.getDrawable() == null)
                i7.setImageResource(R.mipmap.whitesolgray);
            else
                i8.setImageResource(R.mipmap.whitesolgray);
        }
        else if(kind == 'b')
        {
            ImageView i1 = a.findViewById(R.id.EBhours1);
            ImageView i2 = a.findViewById(R.id.EBhours2);
            if(i1.getDrawable() == null)
                i1.setImageResource(R.mipmap.whitehoursgray);
            else
                i2.setImageResource(R.mipmap.whitehoursgray);
        }
        else if(kind == 'c')
        {
            ImageView i1 = a.findViewById(R.id.EBbis1);
            ImageView i2 = a.findViewById(R.id.EBbis2);
            if(i1.getDrawable() == null)
                i1.setImageResource(R.mipmap.whitebisgray);
            else
                i2.setImageResource(R.mipmap.whitebisgray);
        }
        else if(kind == 'd')
        {
            ImageView i1 = a.findViewById(R.id.EBrun1);
            ImageView i2 = a.findViewById(R.id.EBrun2);
            if(i1.getDrawable() == null)
                i1.setImageResource(R.mipmap.whiterungray);
            else
                i2.setImageResource(R.mipmap.whiterungray);
        }
        else if(kind == 'e')
        {
            ImageView i1 = a.findViewById(R.id.EBqueen);
            i1.setImageResource(R.mipmap.whitequeengray);
        }
        else if(kind == 'g')
        {
            ImageView i1 = a.findViewById(R.id.EWsol1);
            ImageView i2 = a.findViewById(R.id.EWsol2);
            ImageView i3 = a.findViewById(R.id.EWsol3);
            ImageView i4 = a.findViewById(R.id.EWsol4);
            ImageView i5 = a.findViewById(R.id.EWsol5);
            ImageView i6 = a.findViewById(R.id.EWsol6);
            ImageView i7 = a.findViewById(R.id.EWsol7);
            ImageView i8 = a.findViewById(R.id.EWsol8);
            if(i1.getDrawable()  == null)
                i1.setImageResource(R.mipmap.blacksolgray);
            else if(i2.getDrawable() == null)
                i2.setImageResource(R.mipmap.blacksolgray);
            else if(i3.getDrawable() == null)
                i3.setImageResource(R.mipmap.blacksolgray);
            else if(i4.getDrawable() == null)
                i4.setImageResource(R.mipmap.blacksolgray);
            else if(i5.getDrawable() == null)
                i5.setImageResource(R.mipmap.blacksolgray);
            else if(i6.getDrawable() == null)
                i6.setImageResource(R.mipmap.blacksolgray);
            else if(i7.getDrawable() == null)
                i7.setImageResource(R.mipmap.blacksolgray);
            else
                i8.setImageResource(R.mipmap.blacksolgray);
        }
        else if(kind == 'h')
        {
            ImageView i1 = a.findViewById(R.id.EWhours1);
            ImageView i2 = a.findViewById(R.id.EWhours2);
            if(i1.getDrawable() == null)
                i1.setImageResource(R.mipmap.blackhorsegray);
            else
                i2.setImageResource(R.mipmap.blackhorsegray);
        }
        else if(kind == 'j')
        {
            ImageView i1 = a.findViewById(R.id.EWrun1);
            ImageView i2 = a.findViewById(R.id.EWrun2);
            if(i1.getDrawable() == null)
                i1.setImageResource(R.mipmap.blackrungray);
            else
                i2.setImageResource(R.mipmap.blackrungray);
        }
        else if(kind == 'i')
        {
            ImageView i1 = a.findViewById(R.id.EWbis1);
            ImageView i2 = a.findViewById(R.id.EWbis2);
            if(i1.getDrawable() == null)
                i1.setImageResource(R.mipmap.blackbisgray);
            else
                i2.setImageResource(R.mipmap.blackbisgray);
        }
        else if(kind == 'k')
        {
            ImageView i = a.findViewById(R.id.EWqueen);
            i.setImageResource(R.mipmap.blackqueengray);
        }
    }
    public static void removeTop(char kind,Activity a)
    {
        if(kind == 'a')
        {
            ImageView i1 = a.findViewById(R.id.EBsol1);
            ImageView i2 = a.findViewById(R.id.EBsol2);
            ImageView i3 = a.findViewById(R.id.EBsol3);
            ImageView i4 = a.findViewById(R.id.EBsol4);
            ImageView i5 = a.findViewById(R.id.EBsol5);
            ImageView i6 = a.findViewById(R.id.EBsol6);
            ImageView i7 = a.findViewById(R.id.EBsol7);
            ImageView i8 = a.findViewById(R.id.EBsol8);
            if(i8.getDrawable() != null)
                i8.setImageDrawable(null);
            else if(i7.getDrawable() != null)
                i7.setImageDrawable(null);
            else if(i6.getDrawable() != null)
                i6.setImageDrawable(null);
            else if(i5.getDrawable() != null)
                i5.setImageDrawable(null);
            else if(i4.getDrawable() != null)
                i4.setImageDrawable(null);
            else if(i3.getDrawable() != null)
                i3.setImageDrawable(null);
            else if(i2.getDrawable() != null)
                i2.setImageDrawable(null);
            else
                i1.setImageDrawable(null);
        }
        else if(kind == 'b')
        {
            ImageView i1 = a.findViewById(R.id.EBhours1);
            ImageView i2 = a.findViewById(R.id.EBhours2);
            if(i2.getDrawable() == null)
                i1.setImageDrawable(null);
            else
                i2.setImageDrawable(null);
        }
        else if(kind == 'c')
        {
            ImageView i1 = a.findViewById(R.id.EBbis1);
            ImageView i2 = a.findViewById(R.id.EBbis2);
            if(i2.getDrawable() == null)
                i1.setImageDrawable(null);
            else
                i2.setImageDrawable(null);
        }
        else if(kind == 'd')
        {
            ImageView i1 = a.findViewById(R.id.EBrun1);
            ImageView i2 = a.findViewById(R.id.EBrun2);
            if(i2.getDrawable() == null)
                i1.setImageDrawable(null);
            else
                i2.setImageDrawable(null);
        }
        else if(kind == 'e')
        {
            ImageView i1 = a.findViewById(R.id.EBqueen);
            i1.setImageDrawable(null);
        }
        else if(kind == 'g')
        {
            ImageView i1 = a.findViewById(R.id.EWsol1);
            ImageView i2 = a.findViewById(R.id.EWsol2);
            ImageView i3 = a.findViewById(R.id.EWsol3);
            ImageView i4 = a.findViewById(R.id.EWsol4);
            ImageView i5 = a.findViewById(R.id.EWsol5);
            ImageView i6 = a.findViewById(R.id.EWsol6);
            ImageView i7 = a.findViewById(R.id.EWsol7);
            ImageView i8 = a.findViewById(R.id.EWsol8);
            if(i8.getDrawable() != null)
                i8.setImageDrawable(null);
            else if(i7.getDrawable() != null)
                i7.setImageDrawable(null);
            else if(i6.getDrawable() != null)
                i6.setImageDrawable(null);
            else if(i5.getDrawable() != null)
                i5.setImageDrawable(null);
            else if(i4.getDrawable() != null)
                i4.setImageDrawable(null);
            else if(i3.getDrawable() != null)
                i3.setImageDrawable(null);
            else if(i2.getDrawable() != null)
                i2.setImageDrawable(null);
            else
                i1.setImageDrawable(null);
        }
        else if(kind == 'h')
        {
            ImageView i1 = a.findViewById(R.id.EWhours1);
            ImageView i2 = a.findViewById(R.id.EWhours2);
            if(i2.getDrawable() == null)
                i1.setImageDrawable(null);
            else
                i2.setImageDrawable(null);
        }
        else if(kind == 'i')
        {
            ImageView i1 = a.findViewById(R.id.EWbis1);
            ImageView i2 = a.findViewById(R.id.EWbis2);
            if(i2.getDrawable() == null)
                i1.setImageDrawable(null);
            else
                i2.setImageDrawable(null);
        }
        else if(kind == 'j')
        {
            ImageView i1 = a.findViewById(R.id.EWrun1);
            ImageView i2 = a.findViewById(R.id.EWrun2);
            if(i2.getDrawable() == null)
                i1.setImageDrawable(null);
            else
                i2.setImageDrawable(null);
        }
        else if(kind == 'k')
        {
            ImageView i1 = a.findViewById(R.id.EWqueen);
            i1.setImageDrawable(null);
        }
    }
    public static void addToList(String add,Context context)
    {
        coim.addNumberOfSaves(context);
        System.out.println("add to list " + add + "////////////////////////////////////////////////////////////////////");
        final int num = coim.getNumberOfSaves(context);
        if(num == 51)
        {
            for(int i = 1; i < 50; i++)
            {
                coim.setStringByName("save" + i + "SS",coim.getStringByName("save" + (i + 1) + "SS",context),context);
            }
            coim.setStringByName("save50SS",add,context);
            coim.setNumberOfSaves(50,context);
            System.out.println("add to list " + (num - 1) + " (need to be 50) by spaicel");
        }
        else
        {
            coim.setStringByName("save" + num + "SS",add,context);
            System.out.println("add to list number " + num + " by normal");
        }
    }

    public static String getDefultOrg()
    {
        return "jhiklihjggggggggnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnaaaaaaaadbcefcbd";
    }
    public static void markQuastion(final String text,Activity a,char[] what,int turn)
    {
        final int num = Integer.parseInt(text.substring(1,3));
        int mark;
        if(what[num] == text.charAt(3))
            mark = Integer.parseInt(text.substring(4,6));
        else
            mark = Integer.parseInt(text.substring(6,8));
        //``````1```````````````````````````````````1qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq`qqqSystem.out.println("num " + num + " (is " + what[num] + ") == " + text.charAt(3) + " mark: " + mark);
        makeOrenge(NumToPic(mark,a),what[mark]);
    }
    public static void normalOrengeMark(String text,Activity a,char[] what,int turn)
    {
        final int num = Integer.parseInt(text.substring((turn - 1) * 2,(turn - 1) * 2 + 2));
        data.makeOrenge(NumToPic(num,a),what[num]);
    }
    private static void play(int u, Context context)
    {
        if(coim.getSound(context))
        {
            SoundPool player;
            player = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
            final int sound = player.load(context,u,1);
            player.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
                @Override
                public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                    player.play(sound,1,1,1,0,1);
                }
            });
        }
    }
    public static void  playModeSound1(Context context)
    {
        play(R.raw.move1,context);
    }
    public static void playMoveSound2(Context context)
    {
        play(R.raw.move2,context);
    }
    public static void  playModeSound1R(Context context)
    {
        play(R.raw.move1r,context);
    }
    public static void playMoveSound2R(Context context)
    {
        play(R.raw.move2r,context);
    }


    public static void moveSaveCalculation(moveSave m,char kind, Context context,long time)
    {
        if(m.getEatKind() != 'n') {
            coim.addUserEat(context);
            coim.addIntByName(kind + "saverE",1,context);
        }
        coim.addIntByName(kind + "saver",1,context); // for favorit tool
        coim.addUserMove(context);
        coim.addUserTime(time,context);
        if(m.getBecomeQueen())
            coim.addPromotion(context);
        if(m.getFrom() % 8 < 5 && m.getFrom() % 8 != 0 && m.getTo() % 8 < 5 && m.getTo() % 8 != 0)
            coim.addLeftSide(context);
        else if((m.getFrom() % 8 > 4 || m.getFrom() % 8 == 0) && (m.getTo() % 8 > 4 || m.getTo() % 8 == 0))
            coim.addRightSide(context);
    }
    public static void addToTimeCalculation(long time,Context context)
    {
        coim.add1BotTurn(context);
        coim.addToAverageTurnTime(time,context);
    }
    public static String getToolNameByChar(char a)
    {
        if(a == 'a')
            return "Pawn";
        else if(a == 'b')
            return "Knight";
        else if(a == 'c')
            return "Bishop";
        else if(a == 'd')
            return "Rook";
        else if(a == 'e')
            return "Queen";
        else if(a == 'f')
            return "King";
        return a + " is unKnown";
    }
    public static String getPMAName(final int x)
    {
        if(x == 0)
            return "off";
        else if(x == 1)
            return "default";
        else if(x == 2)
            return "bottom to top";
        else if(x == 3)
            return "top to bottom";
        else if(x == 4)
            return "right to left";
        else if(x == 5 )
            return "left to right";
        else if(x == 6)
            return "dimming";
        else if(x == 7)
            return "zoom";
        return x + "error";
    }
    public static void playUIClickSound(Context context)
    {
        coim.setLastOnlineData(getTime(),context);
        if(coim.getUIvibration(context))
        {
            Vibrator v = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(Vibrator.VIBRATION_EFFECT_SUPPORT_YES);
        }
        final int num = coim.getUISoundNum(context);
        if(num == 0)
            play(R.raw.uiclick3,context);
        else if(num == 1)
            play(R.raw.uiclick2,context);
        else if(num == 2)
            play(R.raw.uiclick4,context);
        else if(num == 3)
            play(R.raw.uiclick1,context);
    }
    public static void moveVar(boolean eat,Context context)
    {
        Vibrator v = (Vibrator)context.getSystemService(Context.VIBRATOR_SERVICE);
        final int load = coim.getVarLoad(context) / 4;
        if(eat)
            v.vibrate(load);
        else if(coim.getEveryMoveVar(context))
            v.vibrate(load / 2);
    }
    public static boolean oneIn(int onIn)
    {
        Random random = new Random();
        return random.nextInt(onIn) == 0;
    }
    public static int numberBetween(int max)
    {
        Random random = new Random();
        return random.nextInt(max) + 1;
    }
    public static boolean blackStart(String save)
    {
        for(int i = 1; i < save.length(); i++)
        {
            char a = save.charAt(i);
            char b = save.charAt(i - 1);
            if(a == 'S' && a == b)
                return true;
        }
        return false;
    }
    public static String niceOrderForInt(int num)
    {
        String number = Integer.toString(num);
        String newNumber = "";
        int count = 0;
        for(int i =  number.length() - 1; i > -1; i--)
        {
            char a = number.charAt(i);
            if(count == 3)
            {
                newNumber = "," + newNumber;
                count = 1;
            }
            else
                count++;
            newNumber = a + newNumber;
        }
        return newNumber;
    }
    public static void addOrg(String org,Context context)
    {
        final int orgNum = coim.getOrgNum(context) + 1;
        if(orgNum != 11)
        {
            coim.setStringByName("startOrgSaver" + orgNum,org,context);
            coim.addOrgNum(1,context);
        }
    }
    public static String getChees960Bord()
    {
        String org = "nnnnnnnnggggggggnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnaaaaaaaannnnnnnn";
        StringBuilder newOrg = new StringBuilder(org);
        int[] alradyWas = new int[8];
        Random random = new Random();
        for(int i = 0; i < 8;i++)
        {
             int num = random.nextInt(8) + 1;
             while (true)
             {
                 if(inTheArray(num,alradyWas))
                     num = (num == 8)?1:(num + 1);
                 else
                     break;
             }
             alradyWas[i] = num;
             newOrg.setCharAt(0 + i,intToCharFor960Chess(num,false));
             newOrg.setCharAt(56 + i,intToCharFor960Chess(num,true));
        }
        boolean thereWasBis = false;
        int bis1Loc = 0;
        int bis2Loc = 0;
        boolean thereKing = false;
        boolean thereTower = false;
        for(int i = 0; i < 8; i++)
        {
            if(i == 4)
            {
                if(thereKing && !thereTower)
                    thereKing = false;
                if(thereTower && !thereKing)
                    thereTower = false;
            }
            if(newOrg.charAt(i) == 'i')
            {
                if(thereWasBis)
                    bis2Loc = i;
                else
                {
                    bis1Loc = i;
                    thereWasBis = true;
                }
            }
            else if(newOrg.charAt(i) == 'l')
                thereKing = true;
            else if(newOrg.charAt(i) == 'j')
                thereTower = true;
        }
        if((bis1Loc % 2 == bis2Loc % 2) || !thereKing || !thereTower)
        {
            return getChees960Bord();
        }
        return newOrg.toString();
    }
    public static boolean inTheArray(int in,int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            if(in == array[i])
                return true;
        }
        return false;
    }
    private static char intToCharFor960Chess(int num,boolean white)
    {
        num--;
        if(white)
        {
            if(num == 0 || num == 1)return 'b';
            if(num == 2 || num == 3)return 'c';
            if(num == 4 || num == 5)return 'd';
            if(num == 6)return 'e';
            else return 'f';
        }
        else
        {
            if(num == 0 || num == 1)return 'h';
            if(num == 2 || num == 3)return 'i';
            if(num == 4 || num == 5)return 'j';
            if(num == 6)return 'k';
            else return 'l';
        }
    }
    public static String getOrgName(Context context)
    {
        final String org = coim.getOrg(context);
        String name = "";
        for(int i = 0; i < org.length(); i++)
        {
            char a = org.charAt(i);
            if(a == '#')
                break;
            else
                name += a;
        }
        return "  " + name + "  ";
    }
    public static String getOrgOrg(Context context)
    {
        return getOrgOrg(coim.getOrg(context));
    }
    public static String getOrgOrg(String org)
    {
        boolean start = false;
        String orgn = "";
        for(int i = 0; i < org.length(); i++)
        {
            char a = org.charAt(i);
            if(a == '@')
                start = true;
            else if(start)
                orgn += a;
        }
        return orgn;
    }
    public static String getCodeOrg(final String code)
    {
        boolean start = false;
        String saveCode = "";
        for(int i = 0; i < code.length(); i++)
        {
            char a = code.charAt(i);
            if(a == 'S' && code.charAt(i + 1) != 't')
                break;
            else if(start)
                saveCode += a;
            if(a == '@')
                start = true;
        }
        return saveCode;
    }
    public static int getStartLevelMinus(Context context)
    {
        char startLevel = coim.getRealStartLevel(context);
        if(startLevel == 'n')
            return 30;
        if(startLevel == 'h')
            return 60;
        return 0;
    }
    public static void setSize(int length,final int hight,Activity a,Context context)
    {
        if(coim.getSizeCurrect(context))
        {
            for(int i = 1; i < 65; i++)
            {
                ImageView x = NumToPic(i,a);
                x.getLayoutParams().height = length / 8;
                x.getLayoutParams().width = length / 8;
                x.requestLayout();
            }
        }
    }
    public static int toolLeft(char[] what,boolean white)
    {
        int count = 0;
        for(int i = 1; i < 65; i++)
        {
            if(white && isWhite(what[i]))
                count++;
            else if(!white && isBlack(what[i]))
                count++;
        }
        return count;
    }
    public static int locOpisade(int num)
    {
        return (7 - (num / 8)) * 8 + (num % 8);
    }
    public static void toolReversers(char[] tools)
    {
        char[] newTools = new char[64];
        for(int i = 0; i < 64; i++)
        {
            newTools[i] = tools[locOpisade(i)];
            if(newTools[i] < 103)
                newTools[i] = (char)((int)(newTools[i]) + 6);
            else if(newTools[i] != 'n')
                newTools[i] = (char)((int)(newTools[i]) - 6);
        }
        System.arraycopy(newTools, 0, tools, 0, 64);
    }

}
