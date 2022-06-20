package com.example.learnchess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import static com.example.learnchess.R.drawable.yellowjoen;
import static java.lang.Character.toLowerCase;

public class stats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
//        ((ViewGroup)findViewById(R.id.page)).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        context = getApplicationContext();
        setYou();
        setRealYou();
    }
    boolean you = false;
    Context context;
    public void menuBottomClick(View v)
    {
        data.playUIClickSound(getApplicationContext());
        if(v.equals(findViewById(R.id.homeB)) || v.equals(findViewById(R.id.homeT)))
            startActivity(new Intent(stats.this,menu.class));
        else if(v.equals(findViewById(R.id.learnB)) || v.equals(findViewById(R.id.lernT)))
            startActivity(new Intent(stats.this,lessenPage.class));
        else if(v.equals(findViewById(R.id.botsB)) || v.equals(findViewById(R.id.botT)))
            startActivity(new Intent(stats.this,botspage.class));
        else if(v.equals(findViewById(R.id.settingB)) || v.equals(findViewById(R.id.settingT)))
            startActivity(new Intent(stats.this,settings.class));
        final int num = coim.getPMANum(getApplicationContext());
        if(num == 0)
            overridePendingTransition(R.anim.noanim,R.anim.noanim);
        else if(num == 1)
            overridePendingTransition(R.anim.lowtolow,R.anim.lowtoup);
        else if(num == 2)
            overridePendingTransition(R.anim.lowtolow,R.anim.lowtoup2);
        else if(num == 3)
            overridePendingTransition(R.anim.uptoup,R.anim.uptolow);
        else if(num == 4)
            overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
        else if(num == 5)
            overridePendingTransition(R.anim.fromleft,R.anim.fromright);
        else if(num == 6)
            overridePendingTransition(R.anim.dimingup,R.anim.dimingdown);
        else if(num == 7)
            overridePendingTransition(R.anim.zoomfull,R.anim.zoomnun);
    }

    public void statsClick(View v)
    {
        if(you)
        {
            ScrollView r = findViewById(R.id.statsS);
            r.setVisibility(View.VISIBLE);
            if(coim.getAnimationOn(getApplicationContext()))
                r.startAnimation(AnimationUtils.loadAnimation(this,R.anim.lefttoright));
            ScrollView r2 = findViewById(R.id.youS);
            r2.setVisibility(View.INVISIBLE);
            if(coim.getAnimationOn(getApplicationContext()))
                r2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.righttoleft));
        }
        you = false;
        TextView t = (TextView)v;
        TextView t2 = findViewById(R.id.youT);
        t.setTextColor(Color.WHITE);
        t2.setTextColor(Color.BLACK);
    }
    public void youClick(View v)
    {
        if(!you)
        {
            ScrollView r = findViewById(R.id.statsS);
            r.setVisibility(View.INVISIBLE);
           if(coim.getAnimationOn(getApplicationContext()))
               r.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromright));
            ScrollView r2 = findViewById(R.id.youS);
            r2.setVisibility(View.VISIBLE);
            if(coim.getAnimationOn(getApplicationContext()))
                r2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromleft));
        }
        you = true;
        TextView t = (TextView)v;
        TextView t2 = findViewById(R.id.statsT);
        t.setTextColor(Color.WHITE);
        t2.setTextColor(Color.BLACK);
    }
    int getWins(boolean boby)
    {
        String a = "";
        if(boby)
            a = "960";
        int wins = 0;
        wins += coim.getIntByName("MikaW" + a,context);
        wins += coim.getIntByName("SteveW" + a,context);
        wins += coim.getIntByName("JongW" + a,context);
        wins += coim.getIntByName("JohnW" + a,context);
        wins += coim.getIntByName("TeresaW" + a,context);
        return wins;
    }
    int getLose(boolean boby)
    {
        String a = "";
        if(boby)
            a = "960";
        int wins = 0;
        wins += coim.getIntByName("MikaL" + a,context);
        wins += coim.getIntByName("SteveL" + a,context);
        wins += coim.getIntByName("JongL" + a,context);
        wins += coim.getIntByName("JohnL" + a,context);
        wins += coim.getIntByName("TeresaL" + a,context);
        return wins;
    }
    void setYou()
    {
        final int wins = getWins(false);
        final int loses = getLose(false);
        TextView win = findViewById(R.id.Wins);
        TextView lose = findViewById(R.id.Loses);
        win.setText("wins: " + wins);
        lose.setText("loses: " + loses);
        ((TextView)findViewById(R.id.Wins960)).setText("960 chess wins: " + getWins(true));
        ((TextView)findViewById(R.id.Loses960)).setText("960 chees loses: " + getLose(true));
        TextView toWin = findViewById(R.id.chanceToWin);
        int precent = presentToWin(wins,loses);
        toWin.setText("chance to win: " + precent + "%");
    }
    void setRealYou()
    {
        final int lessen = coim.getLes(getApplicationContext());
        TextView level = findViewById(R.id.level);
        if(lessen < 30)
            level.setText("you are: beginner");
        else if(lessen > 60)
            level.setText("you are: expert");
        else
            level.setText("you are: intermediate");
        TextView inlessen = findViewById(R.id.lessens);
        inlessen.setText("you in lesson: " + (lessen - data.getStartLevelMinus(context)));
        TextView remain = findViewById(R.id.rmain);
        remain.setText("remaining lessons: " + (90 - coim.getLes(getApplicationContext())));
        int present = (int)(100 / (90.0 - data.getStartLevelMinus(getApplicationContext())) * (lessen - data.getStartLevelMinus(context)));
        TextView presen = findViewById(R.id.donePre);
        presen.setText("you're done: " + present + "%");
        TextView favoirtBot = findViewById(R.id.favoritBot);
        favoirtBot.setText("favorite bot: " + getFavoirtBot());
        ((TextView)findViewById(R.id.gamesSave)).setText("game list capacity: " + ((coim.getNumberOfSaves(getApplicationContext())) * 2) + "%");
        ((TextView)findViewById(R.id.favoritTool)).setText("favorite tool: " + getFavoritTool());
        ((TextView)findViewById(R.id.favoritSide)).setText("favorite side: " + getFavoritSize());
        if(coim.getBotTurns(getApplicationContext()) == 0)
            ((TextView)findViewById(R.id.AVBT)).setText("average bot move time: unknown");
        else
            ((TextView)findViewById(R.id.AVBT)).setText("average bot move time: " + ((double)(coim.getToAveageTurnTime(getApplicationContext()) / coim.getBotTurns(getApplicationContext())) / 1000.0) + " seconds");
        if(coim.getUserMove(getApplicationContext()) == 0)
            ((TextView)findViewById(R.id.AVUT)).setText("average thinking time: unknown");
        else
            ((TextView)findViewById(R.id.AVUT)).setText("average thinking time: " + (double)(coim.getUserTime(getApplicationContext()) / coim.getUserMove(getApplicationContext()) / 1000.0) + " seconds");
        ((TextView)findViewById(R.id.movesdone)).setText("moves you done: " + (data.niceOrderForInt(coim.getUserMove(getApplicationContext()))));
        ((TextView)findViewById(R.id.eatsdone)).setText("captures you done " + data.niceOrderForInt(coim.getUserEats(getApplicationContext())));
        ((TextView)findViewById(R.id.Promotions)).setText("promotions: " + data.niceOrderForInt(coim.getPromotion(getApplicationContext())));
        ((TextView)findViewById(R.id.chanceToWin960)).setText("(chess 960) chance to win " + presentToWin(getWins(true),getLose(true)) + "%");
    }
    String mark = "";
    public void chooseBot(View i)
    {
        data.playUIClickSound(getApplicationContext());
        ImageView v = (ImageView)i;
        if(coim.getAnimationOn(getApplicationContext()))
            v.startAnimation(AnimationUtils.loadAnimation(this,R.anim.zoomfull));
        ImageView i1 = findViewById(R.id.mika);
        ImageView i2 = findViewById(R.id.john);
        ImageView i3 = findViewById(R.id.steve);
        ImageView i4 = findViewById(R.id.teresa);
        ImageView i5 = findViewById(R.id.jong);
        if(v.equals(i1))
        {
            mark = "Mika";
            i1.setImageResource(R.drawable.yellowmika);
        }
        else if(v.equals(i2))
        {
            mark = "John";
            i2.setImageResource(yellowjoen);
        }
        else if(v.equals(i3))
        {
            mark = "Steve";
            i3.setImageResource(R.drawable.yellowsteve);
        }
        else if(v.equals(i4))
        {
            mark = "Teresa";
            i4.setImageResource(R.drawable.yellowteresa);
        }
        else
        {
            mark = "Jong";
            i5.setImageResource(R.drawable.yellowjong);
        }
        bot namer = levels.getBotByName(mark);
        TextView wins = findViewById(R.id.botWins);
        TextView loses = findViewById(R.id.botLose);
        TextView chace = findViewById(R.id.botchace);
        final int win = coim.getIntByName(mark + "W",context);
        final int lose = coim.getIntByName(mark + "L",context);
        wins.setText(mark + " wins: " + win);
        loses.setText(mark + " loses: " + lose);
        int precent = presentToWin(win,lose);
        chace.setText("chance to win " + mark + ": " + precent + "%");
        if(coim.getAnimationOn(getApplicationContext()))
        {
            wins.setVisibility(View.GONE);
            wins.setVisibility(View.VISIBLE);
            loses.setVisibility(View.GONE);
            loses.setVisibility(View.VISIBLE);
            chace.setVisibility(View.GONE);
            chace.setVisibility(View.VISIBLE);
            findViewById(R.id.faker).setVisibility(View.GONE);
            findViewById(R.id.faker).setVisibility(View.VISIBLE);
        }
    }

    public void goToGameList(View v)
    {
        startActivity(new Intent(stats.this,gamelist.class));
        if(coim.getAnimationOn(getApplicationContext()))
            overridePendingTransition(R.anim.fromleft,R.anim.fromright);
    }
    String getFavoirtBot()
    {
        Context c = getApplicationContext();
        final int mika = coim.getIntByName("MikaL",c) + coim.getIntByName("MikaW",c);
        final int joen = coim.getIntByName("JohnL",c) + coim.getIntByName("JohnW",c);
        final int steve = coim.getIntByName("SteveL",c) + coim.getIntByName("SteveW",c);
        final int taresa = coim.getIntByName("TeresaL",c) + coim.getIntByName("TeresaW",c);
        final int jong = coim.getIntByName("JongL",c) + coim.getIntByName("JongW",c);
        if(mika == 0 && joen == 0 && steve == 0 && taresa == 0 && jong == 0)
            return "unknown";
        if(mika > joen && mika > steve && mika > taresa && mika > jong)
            return "Mika";
        else if(joen > steve && joen > taresa && joen > joen)
            return "John";
        else if(steve > taresa && steve > jong)
            return "Steve";
        else if(taresa > jong)
            return "Teresa";
        else
            return "Jong";
    }
    String getFavoritTool()
    {
        char choose = 'n';
        int max = -1;
        int newMax = 0;
        for(int i = 65; i <= 70; i++)
        {
            char c = (char)i;
            c = toLowerCase(c);
            newMax = coim.getIntByName(c + "saver",getApplicationContext());
            if(newMax > max) {
                choose = c;
                max = newMax;
            }
        }
        if(max == 0)
            return "unknown";
        return data.getToolNameByChar(choose);
    }
    String getFavoritSize()
    {
        final int right = coim.getRightSide(getApplicationContext());
        final int left = coim.getLeftSide(getApplicationContext());
        if(right == left)
            return "tie";
        else if(right > left)
            return "right";
        return "left";
    }
    public void toolClick(View v)
    {
        char kind = 'f';
        if(v.equals(findViewById(R.id.sol)))
            kind = 'a';
        else if(v.equals(findViewById(R.id.horse)))
            kind = 'b';
        else if(v.equals(findViewById(R.id.bis)))
            kind = 'c';
        else if(v.equals(findViewById(R.id.run)))
            kind = 'd';
        else if(v.equals(findViewById(R.id.queen)))
            kind = 'e';
        TextView t1 = findViewById(R.id.toolData1);
        TextView t2 = findViewById(R.id.toolData2);
        TextView t3 = findViewById(R.id.toolData3);
        final int size = 160;
        v.startAnimation(AnimationUtils.loadAnimation(this,R.anim.zoomfull));
        t1.getLayoutParams().height = size;
        t2.getLayoutParams().height = size;
        t3.getLayoutParams().height = size;
        t1.requestLayout();
        t2.requestLayout();
        t3.requestLayout();
        t1.setText("tool name: " + data.getToolNameByChar(kind));
        t2.setText("tool moves: " + coim.getIntByName(kind + "saver",context));
        t3.setText("tool eats: " + coim.getIntByName(kind + "saverE",context));
        t1.setVisibility(View.GONE);
        t2.setVisibility(View.GONE);
        t3.setVisibility(View.GONE);
        t1.setVisibility(View.VISIBLE);
        t2.setVisibility(View.VISIBLE);
        t3.setVisibility(View.VISIBLE);
        v.setVisibility(View.GONE);
        v.setVisibility(View.VISIBLE);
    }
    int presentToWin(double wins,int loses)
    {
        if(wins == 0)
            return 0;
        double answer = (wins / (loses + wins) * 100);
        return (int)(answer);
    }
}