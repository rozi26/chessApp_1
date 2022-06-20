package com.example.learnchess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ((TextView)findViewById(R.id.PMAT1)).setText(data.getPMAName(coim.getPMANum(getApplicationContext())));
        updateStaff(findViewById(R.id.s1),coim.getAnimationOn(getApplicationContext()),"  animations");
        updateStaff(findViewById(R.id.s2),coim.getSuggestions(getApplicationContext()),"suggestions");
        updateStaff(findViewById(R.id.s4),coim.getUIvibration(getApplicationContext())," UI vibration");
        updateStaff(findViewById(R.id.w1),coim.getSizeCurrect(getApplicationContext()),"   board fill");
        updateStaff(findViewById(R.id.w2),coim.getShowHint(getApplicationContext()),"hint button");
        updateStaff(findViewById(R.id.z1),coim.getWhiteStart(getApplicationContext()),"white start");
        ((TextView)findViewById(R.id.PMAT3)).setText("sound " + (coim.getUISoundNum(getApplicationContext()) + 1));

        final int whoStart = coim.getWhoStart(getApplicationContext());
        if(whoStart == -1)
            ((Button)findViewById(R.id.youStart)).setTextColor(Color.WHITE);
        else if(whoStart == 0)
            ((Button)findViewById(R.id.randomStart)).setTextColor(Color.WHITE);
        else
            ((Button)findViewById(R.id.botStart)).setTextColor(Color.WHITE);


        final int load = coim.getVarLoad(getApplicationContext());
        SeekBar seekBar1 = findViewById(R.id.seekBar1);
        TextView seekBar1Text = findViewById(R.id.varPower);
        seekBar1Text.setText("vibration power " + load + "%");
        seekBar1.setProgress(load);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                coim.setVarLoad(seekBar1.getProgress(),getApplicationContext());
                seekBar1Text.setText("vibration power " + seekBar1.getProgress() + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        if(coim.getEveryMoveVar(getApplicationContext()))
            ((Button)findViewById(R.id.eatOnly)).setTextColor(Color.BLACK);
        else
            ((Button)findViewById(R.id.everyMove)).setTextColor(Color.BLACK);
        start = false;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        final int length = findViewById(R.id.buttomMenu).getWidth() / 3;
        findViewById(R.id.botStart).getLayoutParams().width = length;
        findViewById(R.id.youStart).getLayoutParams().width = length;
        findViewById(R.id.randomStart).getLayoutParams().width = length;
        findViewById(R.id.botStart).requestLayout();
        findViewById(R.id.youStart).requestLayout();
        findViewById(R.id.randomStart).requestLayout();
    }

    boolean start = true;
    public void menuBottomClick(View v)
    {
        data.playUIClickSound(getApplicationContext());
        if(v.equals(findViewById(R.id.learnB)) || v.equals(findViewById(R.id.lernT)))
            startActivity(new Intent(settings.this,lessenPage.class));
        else if(v.equals(findViewById(R.id.botsB)) || v.equals(findViewById(R.id.bott)))
            startActivity(new Intent(settings.this,botspage.class));
        else if(v.equals(findViewById(R.id.staticT)) || v.equals(findViewById(R.id.staticB)))
            startActivity(new Intent(settings.this,stats.class));
        else if(v.equals(findViewById(R.id.homeB)) || v.equals(findViewById(R.id.homeT)))
            startActivity(new Intent(settings.this,menu.class));
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
    void moveRight(View b,View a)
    {
        b.setVisibility(View.INVISIBLE);
        a.setVisibility(View.VISIBLE);
        if(coim.getAnimationOn(getApplicationContext()))
        {
            a.startAnimation(AnimationUtils.loadAnimation(this,R.anim.lefttoright));
            b.startAnimation(AnimationUtils.loadAnimation(this,R.anim.righttoleft));
        }
    }
    void moveLeft(View b,View a)
    {
        b.setVisibility(View.INVISIBLE);
        a.setVisibility(View.VISIBLE);
       if(coim.getAnimationOn(getApplicationContext()))
       {
           a.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromleft));
           b.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromright));
       }
    }
    void setAllBlack(View instad)
    {
        ((TextView)findViewById(R.id.sb1)).setTextColor(Color.BLACK);
        ((TextView)findViewById(R.id.sb2)).setTextColor(Color.BLACK);
        ((TextView)findViewById(R.id.sb3)).setTextColor(Color.BLACK);
        ((TextView)findViewById(R.id.sb4)).setTextColor(Color.BLACK);
        ((TextView)instad).setTextColor(Color.WHITE);
    }
    View getByChar(char a)
    {
        if(a == 'a')
            return findViewById(R.id.UIScrool);
        else if(a == 'b')
            return findViewById(R.id.BordScrool);
        else if(a == 'c')
            return findViewById(R.id.BotsScrool);
        else if(a == 'd')
            return findViewById(R.id.OtherScrool);
        return findViewById(R.id.titleLine);
    }
    char correctPage = 'a';
    public void moveToUI(View v)
    {
        if(correctPage != 'a')
        {
            setAllBlack(v);
            moveRight(getByChar(correctPage),findViewById(R.id.UIScrool));
            correctPage = 'a';
        }
    }
    public void moveToBoard(View v)
    {

        if(correctPage != 'b')
        {
            setAllBlack(v);
            if(correctPage == 'a')
                moveLeft(getByChar(correctPage),findViewById(R.id.BordScrool));
            else
                moveRight(getByChar(correctPage),findViewById(R.id.BordScrool));
            correctPage = 'b';
        }
    }
    public void moveToBots(View v)
    {
        if(correctPage != 'c')
        {
            setAllBlack(v);
            if(correctPage == 'd')
                moveRight(getByChar(correctPage),findViewById(R.id.BotsScrool));
            else
                moveLeft(getByChar(correctPage),findViewById(R.id.BotsScrool));
            correctPage = 'c';
        }
    }
    public void moveToOther(View v)
    {
        if(correctPage != 'd')
        {
            setAllBlack(v);
            moveLeft(getByChar(correctPage),findViewById(R.id.OtherScrool));
            correctPage = 'd';
        }
    }
    void updateStaff(View v,boolean TOF,String text)
    {
        Switch s = (Switch)v;
        /*int length = text.length();
        for(int i = length; i < 13; i++)
        {
            text = " " + text;
        }*/
        if(TOF)
        {
            s.setText(text + " on");
            s.setChecked(true);
        }
        else {
            s.setText(text + " off");
            s.setChecked(false);
        }

        if(!start)
            data.playUIClickSound(getApplicationContext());
    }
    public void PMAC(View v)
    {
        TextView t1 = findViewById(R.id.PMAT1);
        TextView t2 = findViewById(R.id.PMAT2);
        int num = coim.getPMANum(getApplicationContext());
        if(v.equals(findViewById(R.id.p1L)))
        {
            t2.setText(t1.getText().toString());
            if(num == 0)
                coim.addPMANum(7,getApplicationContext());
            else
                coim.addPMANum(-1,getApplicationContext());
            t1.setText(data.getPMAName(coim.getPMANum(getApplicationContext())));
            if(coim.getAnimationOn(getApplicationContext()))
            {
                t2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.righttoleft));
                t1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.lefttoright));
            }
        }
        else
        {
            t2.setText(t1.getText().toString());
            if(num == 7)
                coim.addPMANum(-7,getApplicationContext());
            else
                coim.addPMANum(1,getApplicationContext());
            t1.setText(data.getPMAName(coim.getPMANum(getApplicationContext())));
            if(coim.getAnimationOn(getApplicationContext()))
            {
                t2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromright));
                t1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromleft));
            }
        }
    }
    public void setUIClickSound(View v)
    {
        TextView t1 = findViewById(R.id.PMAT3);
        TextView t2 = findViewById(R.id.PMAT4);
        int num = coim.getUISoundNum(getApplicationContext());
        if(v.equals(findViewById(R.id.p2L)))
        {
            t2.setText(t1.getText().toString());
            if(num == -1)
                coim.addUISoundNum(4,getApplicationContext());
            else
                coim.addUISoundNum(-1,getApplicationContext());
            final int number = coim.getUISoundNum(getApplicationContext());
            if(number == -1) {
                t1.setText("off");
            }
            else
                t1.setText("sound " + (coim.getUISoundNum(getApplicationContext()) + 1));
            if(coim.getAnimationOn(getApplicationContext()))
            {
                t2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.righttoleft));
                t1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.lefttoright));
            }
        }
        else
        {
            t2.setText(t1.getText().toString());
            if(num == 3)
                coim.addUISoundNum(-4,getApplicationContext());
            else
                coim.addUISoundNum(1,getApplicationContext());
            final int number = coim.getUISoundNum(getApplicationContext());
            if(number == -1) {
                t1.setText("off");
            }
            else
                t1.setText("sound " + (coim.getUISoundNum(getApplicationContext()) + 1));
            if(coim.getAnimationOn(getApplicationContext()))
            {
                t2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromright));
                t1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromleft));
            }
        }
    }
    public void playUIClickSound(View v)
    {
        data.playUIClickSound(getApplicationContext());
    }
    public void setAnimationOn(View v)
    {
        coim.setAnimationOn(!coim.getAnimationOn(getApplicationContext()),getApplicationContext());
        updateStaff(findViewById(R.id.s1),coim.getAnimationOn(getApplicationContext()),"  animations");
        if(!coim.getAnimationOn(getApplicationContext()))
        {
            coim.addPMANum(-coim.getPMANum(getApplicationContext()),getApplicationContext());
            ((TextView)findViewById(R.id.PMAT1)).setText(data.getPMAName(coim.getPMANum(getApplicationContext())));
        }
        else if(coim.getPMANum(getApplicationContext()) == 0)
        {
            coim.addPMANum(1,getApplicationContext());
            ((TextView)findViewById(R.id.PMAT1)).setText(data.getPMAName(coim.getPMANum(getApplicationContext())));
        }
    }
    public void setSuggestions(View v)
    {
        coim.setSuggestions(!coim.getSuggestions(getApplicationContext()),getApplicationContext());
        updateStaff(findViewById(R.id.s2),coim.getSuggestions(getApplicationContext()),"suggestions");
    }
    public void setUIVibration(View v)
    {
        coim.setUIvibration(!coim.getUIvibration(getApplicationContext()),getApplicationContext());
        updateStaff(findViewById(R.id.s4),coim.getUIvibration(getApplicationContext())," UI vibration");
    }
    public void setSizeCurrect(View v)
    {
        coim.setSizeCurrect(!coim.getSizeCurrect(getApplicationContext()),getApplicationContext());
        updateStaff(findViewById(R.id.w1),coim.getSizeCurrect(getApplicationContext()),"   board fill");
    }
    public void setShowHint(View v)
    {
        coim.setShowHint(!coim.getShowHint(getApplicationContext()),getApplicationContext());
        updateStaff(findViewById(R.id.w2),coim.getShowHint(getApplicationContext()),"hint button");
    }
    public void setEMV(View v)
    {
        data.playUIClickSound(getApplicationContext());
        Button b1 = findViewById(R.id.eatOnly);
        Button b2 = findViewById(R.id.everyMove);
        if(v.equals(b1))
        {
            coim.setEveryMoveVar(false,getApplicationContext());
            b1.setTextColor(Color.WHITE);
            b2.setTextColor(Color.BLACK);
        }
        else
        {
            coim.setEveryMoveVar(true,getApplicationContext());
            b2.setTextColor(Color.WHITE);
            b1.setTextColor(Color.BLACK);
        }
    }
    public void setWhoStart(View v)
    {
        Button b1 = findViewById(R.id.youStart);
        Button b2 = findViewById(R.id.randomStart);
        Button b3 = findViewById(R.id.botStart);
        b1.setTextColor(Color.BLACK);
        b2.setTextColor(Color.BLACK);
        b3.setTextColor(Color.BLACK);
        ((Button)v).setTextColor(Color.WHITE);
        if(v.equals(b1))
            coim.setWhoStart(-1,getApplicationContext());
        else if(v.equals(b2))
            coim.setWhoStart(0,getApplicationContext());
        else
            coim.setWhoStart(1,getApplicationContext());
    }
    public void setWhiteStart(View v)
    {
        coim.setWhiteStart(!coim.getWhiteStart(getApplicationContext()),getApplicationContext());
        updateStaff(findViewById(R.id.z1),coim.getWhiteStart(getApplicationContext()),"white start");
    }
    public void resatApp(View v)
    {
        Button b = (Button)v;
        if(b.getText().toString().equals("are you sure"))
        {
            coim.firstEnter(true,getApplicationContext());
            coim.setStartLevel('E',getApplicationContext());
            startActivity(new Intent(settings.this,MainActivity.class));
        }
        else
            b.setText("are you sure");
    }
}