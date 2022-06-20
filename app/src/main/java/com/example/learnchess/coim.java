package com.example.learnchess;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;

public class coim {
    //this class made for save deta
    private static void setInt(String name, int to, Context context) {
        SharedPreferences sp = context.getSharedPreferences("userlevel", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(name, to);
        editor.commit();
    }
    private static void addInt(String name,int add,Context context)
    {
        setInt(name,getInt(name,context) + add,context);
    }

    private static void setBoll(String name, boolean to, Context context) {
        SharedPreferences sp = context.getSharedPreferences("userlevel", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(name, to);
        editor.commit();
    }

    private static void addString(String name, String to, Context context) {
        SharedPreferences sp = context.getSharedPreferences("userlevel", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(name, (getString(name, context) + to));
        editor.commit();
    }

    private static void setString(String name, String to, Context context) {
        SharedPreferences sp = context.getSharedPreferences("userlevel", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(name, to);
        editor.commit();
    }

    private static String getString(String name, Context context) {
        SharedPreferences sp = context.getSharedPreferences("userlevel", Context.MODE_PRIVATE);
        return sp.getString(name, "");
    }

    private static int getInt(String name, Context context) {
        SharedPreferences sp = context.getSharedPreferences("userlevel", Context.MODE_PRIVATE);
        return sp.getInt(name, 0);
    }

    private static boolean getBool(String name, Context context) {
        SharedPreferences sp = context.getSharedPreferences("userlevel", Context.MODE_PRIVATE);
        return sp.getBoolean(name, true);
    }
    private static void setLong(String name,long to,Context context)
    {
        SharedPreferences sp = context.getSharedPreferences("userlevel", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(name, to);
        editor.commit();
    }
    private static void addLong(String name,long add,Context context)
    {
        setLong(name,getLong(name,context) + add,context);
    }
    private static long getLong(String name,Context context)
    {
        SharedPreferences sp = context.getSharedPreferences("userlevel", Context.MODE_PRIVATE);
        return sp.getLong(name, 0l);
    }



    public static void setRealStartLevel(char to,Context context)
    {
        if(!coim.getFirstEnter(context))
            setString("realStartLevel",Character.toString(to),context);
    }
    public static char getRealStartLevel(Context context)
    {
        return getString("realStartLevel",context).charAt(0);
    }
    public static Character getStartLevel(Context context) {
        return getString("mainLevel", context).charAt(0);
    }

    public static String getStartLevelS(Context context) {
        return getString("mainLevel", context);
    }

    public static void setStartLevel(Character level, Context context) {
        setString("mainLevel", Character.toString(level), context);
    }

    public static void firstEnter(boolean to,Context context) {
        setBoll("FE", to, context);
    }

    public static boolean getFirstEnter(Context context) {
        return !getBool("FE", context);
    }

    public static void addLesRm(int add, Context context) {
        setInt("lesRm", getInt("lesRm", context) + add + 10, context);
    }

    public static int getLesNumRm(Context context) {
        return getInt("lesRm", context) + 10;
    }

    public static void addLes(int add, Context context) {
        setInt("les", getInt("les", context) + add, context);
        if (getLes(context) == 31)
            setStartLevel('n', context);
        else if (getLes(context) == 61)
            setStartLevel('h', context);
    }

    public static void setLes(int to, Context context) {
        setInt("les", to, context);
    }

    public static int getLes(Context context) {
        return getInt("les", context) + 1;
    }

    public static void setDataLevelShow(boolean on, Context context) {
        setBoll("DataLevelShow", on, context);
    }

    public static boolean getDataLevelShow(Context context) {
        return getBool("DataLevelShow", context);
    }

    public static void setEndmessege(String messege, Context context) {
        setString("endMessege", messege, context);
    }

    public static String getEndMessesge(Context context) {
        return getString("endMessege", context);
    }

    public static void setLesOn(boolean to, Context context) {
        setBoll("lesOn", to, context);
    }

    public static boolean getLesOn(Context context) {
        return getBool("lesOn", context);
    }

    public static void setBotName(String to, Context context) {
        setString("botName", to, context);
    }

    public static String getBotName(Context context) {
        String get = getString("botName", context);
        if (get.equals(""))
            return "Steve";
        else
            return get;
    }

    public static void setInGame(boolean to, Context context) {
        setBoll("inGame", !to, context);
    }

    public static boolean getInGame(Context context) {
        return !getBool("inGame", context);
    }

    public static void setOnMenu(boolean to, Context context) {
        setBoll("onMenu", to, context);
    }

    public static boolean getOnMenu(Context context) {
        return getBool("onMenu", context);
    }

    //save
    public static void setSave(String to, Context context) {
        setString("save", to, context);
    }

    public static void addSave(String add, Context context) {
        setString("save", getString("save", context) + add, context);
    }

    public static String getSave(Context context) {
        return getString("save", context);
    }
    //end of saver


    public static void setIntByName(String name, int to, Context context) {
        setInt(name, to, context);
    }

    public static void addIntByName(String name, int add, Context context) {
        setInt(name, getIntByName(name, context) + add, context);
    }

    public static int getIntByName(String name, Context context) {
        return getInt(name, context);
    }

    public static void setStringByName(String name, String to, Context context) {
        setString(name, to, context);
    }

    public static String getStringByName(String name, Context context) {
        return getString(name, context);
    }

    public static void addNumberOfSaves(Context context) {
        setInt("numberOfSavers", getNumberOfSaves(context) + 1, context);
    }

    public static void setNumberOfSaves(int to, Context context) {
        setInt("numberOfSavers", to, context);
    }

    public static int getNumberOfSaves(Context context) {
        return getInt("numberOfSavers", context);
    }

    public static void addUnDo(int add, Context context) {
        setInt("unDo", getUnDo(context) + add - 5, context);
    }

    public static int getUnDo(Context context) {
        return getInt("unDo", context) + 5;
    }

    public static void setSaveBordCode(String to, Context context) {
        setString("saveBordCode", to, context);
    }

    public static String getSaveBordCode(Context context) {
        return getString("saveBordCode", context);
    }

    public static void setSound(boolean to, Context context) {
        setBoll("sound", to, context);
    }

    public static boolean getSound(Context context) {
        return getBool("sound", context);
    }

    public static void addRightSide(Context context) {
        setIntByName("rightSide", getRightSide(context) + 1, context);
    }

    public static void setRightSide(int to, Context context) {
        setIntByName("rightSide", to, context);
    }

    public static int getRightSide(Context context) {
        return getIntByName("rightSide", context);
    }

    public static void addLeftSide(Context context) {
        setIntByName("leftSide", getLeftSide(context) + 1, context);
    }

    public static void setLeftSide(int to, Context context) {
        setIntByName("leftSide", to, context);
    }

    public static int getLeftSide(Context context) {
        return getIntByName("leftSide", context);
    }

    public static void setAnimationOn(boolean to, Context context) {
        setBoll("animOn", to, context);
    }

    public static boolean getAnimationOn(Context context) {
        return getBool("animOn", context);
    }

    public static void setSuggestions(boolean to, Context context) {
        setBoll("Suggestions", to, context);
    }

    public static boolean getSuggestions(Context context) {
        return getBool("Suggestions", context);
    }

    public static void addPMANum(int add, Context context) {
        setInt("PMA", getPMANum(context) - 1 + add, context);
    }

    public static int getPMANum(Context context) {
        return getInt("PMA", context) + 1;
    }

    public static void setUIvibration(boolean to, Context context) {
        setBoll("UIvibration", !to, context);
    }

    public static boolean getUIvibration(Context context) {
        return !getBool("UIvibration", context);
    }

    public static void addUISoundNum(int add, Context context) {
        setInt("UISoundNum", getUISoundNum(context) + add, context);
    }

    public static int getUISoundNum(Context context) {
        return getInt("UISoundNum", context);
    }

    public static void setSizeCurrect(boolean to, Context context) {
        setBoll("sizeCurrecrt", to, context);
    }

    public static boolean getSizeCurrect(Context context) {
        return getBool("sizeCurrecrt", context);
    }

    public static void setShowHint(boolean to, Context context) {
        setBoll("showHint", to, context);
    }

    public static boolean getShowHint(Context context) {
        return getBool("showHint", context);
    }

    public static void setEveryMoveVar(boolean to, Context context) {
        setBoll("EMV", !to, context);
    }

    public static boolean getEveryMoveVar(Context context) {
        return !getBool("EMV", context);
    }

    public static void setVarLoad(int to, Context context) {
        setInt("varLoad", to - 50, context);
    }

    public static int getVarLoad(Context context) {
        return getInt("varLoad", context) + 50;
    }

    public static void setWhoStart(int to, Context context) {
        setInt("whoStart", to, context);
    }

    public static int getWhoStart(Context context) {
        return getInt("whoStart", context);
    }

    public static void setWhiteStart(boolean to, Context context) {
        setBoll("whiteStart", to, context);
    }

    public static boolean getWhiteStart(Context context) {
        return getBool("whiteStart", context);
    }

    public static void add1BotTurn(Context context) {
        setInt("BotTurns", getBotTurns(context) + 1, context);
    }

    public static int getBotTurns(Context context) {
        return getInt("BotTurns", context);
    }

    public static void addToAverageTurnTime(long add, Context context) {
        setLong("AVGBT", getToAveageTurnTime(context) + add, context);
    }

    public static long getToAveageTurnTime(Context context) {
        return getLong("AVGBT", context);
    }

    public static void addUserMove(Context context)
    {
        addInt("userMoves",1,context);
    }

    public static int getUserMove(Context context)
    {
        return getInt("userMoves",context);
    }

    public static void addUserEat(Context context)
    {
        addInt("userEats",1,context);
    }
    public static int getUserEats(Context context)
    {
        return getInt("userEats",context);
    }
    public static void addUserTime(long add,Context context)
    {
       addLong("userTime",add,context);
       System.out.println(add + "get long " + getLong("userTime",context));
    }
    public static long getUserTime(Context context)
    {
        return getLong("userTime",context);
    }
    public static void addPromotion(Context context)
    {
        addInt("Promotion",1,context);
    }
    public static int getPromotion(Context context)
    {
        return getInt("Promotion",context);
    }
    public static void setOrg(String to,Context context)
    {
        setString("startOrgS",to,context);
    }
    public static String getOrg(Context context)
    {
        return getString("startOrgS",context);
    }
    public static void addOrgNum(int add,Context context)
    {
        addInt("startOrgN",add,context);
    }
    public static int getOrgNum(Context context)
    {
        return getInt("startOrgN",context);
    }
    public static void setCreatOrgStart(String to,Context context)
    {
        setString("createOrgStart",to,context);
    }
    public static String getCreateOrgStart(Context context)
    {
        return getString("createOrgStart",context);
    }
    public static void setBordCreateEnter(boolean to,Context context)
    {
        setBoll("BordCreateEnter",to,context);
    }
    public static boolean getBordCreateEnter(Context context)
    {
        return getBool("BordCreateEnter",context);
    }
    public static void setGameOverPageEnter(boolean to,Context context)
    {
        setBoll("GameOverPageEnter",!to,context);
    }
    public static boolean getGameOverPageEnter(Context context)
    {
        return !getBool("GameOverPageEnter",context);
    }
    public static void setErrorNumber(int to,Context context)
    {
        setInt("error",to,context);
    }
    public static int getErrorNumber(Context context)
    {
        return getInt("error",context);
    }
    public static void setLastOnlineData(String to,Context context)
    {
        setString("LastOnlineData",to,context);
    }
    public static String getLastOnlineData(Context context)
    {
        return getString("LastOnlineData",context);
    }
}
