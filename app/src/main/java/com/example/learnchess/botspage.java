package com.example.learnchess;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class botspage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_botspage);
        if(coim.getAnimationOn(getApplicationContext()))
            ((ViewGroup)findViewById(R.id.r2)).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
    }
    public void menuBottomClick(View v)
    {
        data.playUIClickSound(getApplicationContext());
        if(v.equals(findViewById(R.id.homeB)) || v.equals(findViewById(R.id.homeT)))
            startActivity(new Intent(botspage.this,menu.class));
        else if(v.equals(findViewById(R.id.learnB)) || v.equals(findViewById(R.id.lernT)))
            startActivity(new Intent(botspage.this,lessenPage.class));
        else if(v.equals(findViewById(R.id.staticB)) || v.equals(findViewById(R.id.staticT)))
            startActivity(new Intent(botspage.this,stats.class));
        else if(v.equals(findViewById(R.id.settingB)) || v.equals(findViewById(R.id.settingT)))
            startActivity(new Intent(botspage.this,settings.class));
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
    String last = "NON";
    public void chooseBot(View v)
    {
        data.playUIClickSound(getApplicationContext());
        ImageView i = (ImageView)v;
        //idinfai each image
        if(i.equals(findViewById(R.id.mika)))
            coim.setBotName("Mika",getApplicationContext());
        else if(i.equals(findViewById(R.id.steve)))
            coim.setBotName("Steve",getApplicationContext());
        else if(i.equals(findViewById(R.id.jong)))
            coim.setBotName("Jong",getApplicationContext());
        else if(i.equals(findViewById(R.id.john)))
            coim.setBotName("John",getApplicationContext());
        else if(i.equals(findViewById(R.id.teresa)))
            coim.setBotName("Teresa",getApplicationContext());
        bot bot = levels.getBotByName(coim.getBotName(getApplicationContext()));
        LayoutTransition page = ((ViewGroup) findViewById(R.id.page2)).getLayoutTransition();
        if(coim.getAnimationOn(getApplicationContext()))
            page.enableTransitionType(LayoutTransition.CHANGING);
        TextView t1 = findViewById(R.id.scoreText);
        TextView t2 = findViewById(R.id.levelText);
        TextView t3 = findViewById(R.id.styleText);
        if(coim.getAnimationOn(getApplicationContext()))
        {
            t1.setVisibility(View.GONE);
            t2.setVisibility(View.GONE);
            t3.setVisibility(View.GONE);
            t1.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
            t3.setVisibility(View.VISIBLE);
        }
        t1.setTextSize(44);
        t2.setTextSize(44);
        t3.setTextSize(42);
        t1.setText("name: " + bot.getName());
        t2.setText("level: " + bot.getLevelLimit());
        if(bot.isAgresive())
            t3.setText("behavior: aggressive");
        else
            t3.setText("behavior: defensive");
        Button b = findViewById(R.id.startGame);
        int buttonHeight = 250;
        String plusText = "";
        if(bot.getName().equals("Jong"))
        {
            plusText = "(beta)";
            buttonHeight = 350;
        }
        b.getLayoutParams().height = buttonHeight;


        b.requestLayout();
        Button b2 = findViewById(R.id.startGame2);
        b2.setText(b.getText());
        b.setText("play with " + bot.getName() + " " + plusText);
        if(!shown)
        {
            shown = true;
            b.setVisibility(View.VISIBLE);
            if(coim.getAnimationOn(getApplicationContext()))
                b.startAnimation(AnimationUtils.loadAnimation(this,R.anim.lowtolow));
        }else if(!bot.getName().equals(last) && coim.getAnimationOn(getApplicationContext()))
        {
            changeByAnimation(b2,b,getNameScore(bot.getName()) < getNameScore(last));
        }
        ImageView s = findViewById(R.id.showImage);
        if(coim.getAnimationOn(getApplicationContext()))
        {
            b.setVisibility(View.GONE);
            b.setVisibility(View.VISIBLE);
            ImageView s2 = findViewById(R.id.showImage2);
            s2.setForeground(s.getForeground());
            if(!last.equals(bot.getName()))
                changeByAnimation(s2,s,getNameScore(bot.getName()) < getNameScore(last));
            //System.out.println("last report for bot " + bot.getName() + " get " + getNameScore(bot.getName()) + " for last " + last + " get " + getNameScore(last));
        }
        s.setForeground(i.getForeground());
        last = bot.getName();
    }
    boolean shown = false;
    public void startGame(View view)
    {
        coim.setLesOn(false,getApplicationContext());
        startActivity(new Intent(botspage.this,lessonbord.class));
        if(coim.getAnimationOn(getApplicationContext()))
            overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
    }
    void changeByAnimation(View old,View frash,boolean right)
    {
        Animation a;
        Animation b;
        if(right)
        {
            a = AnimationUtils.loadAnimation(this,R.anim.righttoleft);
            b = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        }
        else
        {
            a = AnimationUtils.loadAnimation(this,R.anim.fromright);
            b = AnimationUtils.loadAnimation(this,R.anim.fromleft);
        }
        old.startAnimation(a);
        frash.startAnimation(b);
    }
    int getNameScore(String name)
    {
        if(name.equals("Mika"))
            return 1;
        else if(name.equals("John"))
            return 2;
        else if(name.equals("Steve"))
            return 3;
        else if(name.equals("Teresa"))
            return 4;
        else if(name.equals("Jong"))
            return 5;
        else
            return 0;
    }
    @Override
    protected void onResume() {
        super.onResume();
        ((Button)findViewById(R.id.goOrg)).setText(data.getOrgName(getApplicationContext()));
        if(coim.getInGame(getApplicationContext()) && !coim.getLesOn(getApplicationContext()))
        {
            startActivity(new Intent(botspage.this,lessonbord.class));
            overridePendingTransition(R.anim.noanim,R.anim.noanim);
        }
    }
    public void goToOrgSet(View v)
    {
        startActivity(new Intent(botspage.this,orgsaver.class));
        if(coim.getAnimationOn(getApplicationContext()))
            overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
    }
}