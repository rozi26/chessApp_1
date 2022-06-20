package com.example.learnchess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class FreeBord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_bord);
        context = getApplicationContext();
        final String saveSave = coim.getSave(getApplicationContext());
        coim.setSave(coim.getSaveBordCode(context),context);
        final String code = coim.getSave(context);
        botStart = data.blackStart(code);
        if(code.equals("")) {
            coim.setErrorNumber(1,getApplicationContext());
            startActivity(new Intent(FreeBord.this,menu.class));
            if(coim.getAnimationOn(getApplicationContext()))
                overridePendingTransition(R.anim.fromleft,R.anim.fromright);
        }
        else
            startOrg(data.getCodeOrg(code));
        winner = code.charAt(1);
        for(int i = 0; i < code.length(); i++)
        {
            if(code.charAt(i) == 'N')
                lastTurn++;
        }
        System.out.println("save: " + coim.getSave(context) +"/////////////////////////////////////////////////////////////////");
        m = data.getCode(context);
        coim.setSave(saveSave,context);
    }
    boolean botStart = false;
    Context context;
    char winner = 'E';
    char[] what = new char[65];
    moveSave[] m;
    int lastTurn = 0;
    int realTurn = 0;
    public void blockClick(View v){}
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        setSize();
    }
    ImageView NumToPic(int num)
    {
        return data.NumToPic(num,FreeBord.this);
    }
    int PicToNum(ImageView v)
    {
        return data.PicToNum(v,FreeBord.this);
    }
    void setImage(ImageView i,char kind)
    {
        data.setImage(i,kind,PicToNum(i),botStart,getApplicationContext());
        what[PicToNum(i)] = kind;
    }
    void setSize()
    {
        data.setSize(findViewById(R.id.length).getWidth(),findViewById(R.id.hight).getHeight(),FreeBord.this,getApplicationContext());
    }
    void startOrg(String text)
    {
        for(int i = 1; i <= text.length(); i++)
        {
            char a = text.charAt(i - 1);
            setImage(NumToPic(i),a);
        }
    }
    boolean endShow = false;
    boolean youLeftOn = false;
    public void goForWard(View v)
    {
        if(realTurn != lastTurn)
        {
            doForward((m[realTurn]));
            realTurn++;
            if(realTurn == lastTurn)
            {
                if(winner == 'W')
                {
                    endShow = true;
                    int loc = 0;
                    for(int i = 1; i < 65; i++)
                    {
                        if(what[i] == 'l')
                        {
                            loc = i;
                            break;
                        }
                    }
                    if(data.isBlackBlock(loc)) {
                        if(botStart)
                            NumToPic(loc).setImageResource(R.mipmap.whitekingblackr);
                        else
                            NumToPic(loc).setImageResource(R.mipmap.blackkingblackr);
                    }
                    else {
                        if(botStart)
                            NumToPic(loc).setImageResource(R.mipmap.whitekingwhiter);
                        else
                            NumToPic(loc).setImageResource(R.mipmap.blackkingwhiter);
                    }
                }
                else if(winner == 'Q')
                {
                    youLeftOn = true;
                    markWhiteKing();
                    TextView t = findViewById(R.id.youLeft);
                    t.setVisibility(View.VISIBLE);
                    if(coim.getAnimationOn(getApplicationContext()))
                        t.startAnimation(AnimationUtils.loadAnimation(this,R.anim.lefttoright));
                }
            }
            else if(realTurn == lastTurn - 1 && winner == 'L')
            {
                markWhiteKing();
            }
        }
    }
    public void goBack(View v)
    {
        if(realTurn != 0)
        {
            realTurn--;
            unDo(m[realTurn]);
            if(endShow)
                reloadWhat();
            if(youLeftOn)
            {
                TextView t = findViewById(R.id.youLeft);
                t.setVisibility(View.INVISIBLE);
                if(coim.getAnimationOn(getApplicationContext()))
                    t.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromright));
                reloadWhat();
                youLeftOn = false;
            }
            if(realTurn == lastTurn - 1 && winner == 'L')
                markWhiteKing();
        }
    }
    void unDo(moveSave m)
    {
        if(m.getTo() != 67)
        {
            if(m.getBecomeQueen()) {
                if(m.getTo() > 56)
                    setImage(NumToPic(m.getTo()),'g');
                else
                    setImage(NumToPic(m.getTo()),'a');
            }
            setImage(NumToPic(m.getFrom()),what[m.getTo()]);
            setImage(NumToPic(m.getTo()),m.getEatKind());
            if(m.getEatKind() == 'n')
                data.playModeSound1R(getApplicationContext());
            else
                data.playMoveSound2R(getApplicationContext());
        }
        else
        {
            if(m.getBecomeQueen())
            {
                setImage(NumToPic(57),'d');
                setImage(NumToPic(59),'n');
                setImage(NumToPic(60),'n');
                setImage(NumToPic(61),'f');
            }
            else
            {
                setImage(NumToPic(61),'f');
                setImage(NumToPic(62),'n');
                setImage(NumToPic(63),'n');
                setImage(NumToPic(64),'d');
            }
        }
    }
    void doForward(moveSave m)
    {
        if(m.getFrom() == 67) // castel (67 is castel code)
        {
            if(m.getBecomeQueen())
            {
                setImage(NumToPic(57),'n');
                setImage(NumToPic(59),'f');
                setImage(NumToPic(60),'d');
                setImage(NumToPic(61),'n');
            }
            else
            {
                setImage(NumToPic(61),'n');
                setImage(NumToPic(62),'d');
                setImage(NumToPic(63),'f');
                setImage(NumToPic(64),'n');
            }
        }
        else
        {
            setImage(NumToPic(m.getTo()),what[m.getFrom()]);
            setImage(NumToPic(m.getFrom()),'n');
            if(m.getEatKind() == 'n')
                data.playModeSound1(getApplicationContext());
            else
                data.playMoveSound2(getApplicationContext());
            scanQueen();
        }
    }
    void scanQueen()
    {
        for(int i = 1; i < 9; i++)
        {
            if(what[i] == 'a')
                setImage(NumToPic(i),'e');
        }
        for(int i = 57; i < 65; i++)
        {
            if(what[i] == 'g')
                setImage(NumToPic(i),'k');
        }
    }
    void reloadWhat()
    {
        for(int i = 1; i < 65; i++)
        {
            setImage(NumToPic(i),what[i]);
        }
    }
    void markWhiteKing()
    {
        endShow = true;
        int loc = 0;
        for(int i = 1; i < 65; i++)
        {
            if(what[i] == 'f')
            {
                loc = i;
                break;
            }
        }
        if(data.isBlackBlock(loc)) {
            if(botStart)
                NumToPic(loc).setImageResource(R.mipmap.blackkingblackr);
            else
                NumToPic(loc).setImageResource(R.mipmap.whitekingblackr);
        }
        else {
            if(botStart)
                NumToPic(loc).setImageResource(R.mipmap.blackkingwhiter);
            else
                NumToPic(loc).setImageResource(R.mipmap.whitekingwhiter);
        }
    }

    public void backToGameList(View v)
    {
        data.playUIClickSound(getApplicationContext());
        startActivity(new Intent(FreeBord.this,gamelist.class));
        if(coim.getAnimationOn(getApplicationContext()))
            overridePendingTransition(R.anim.fromleft,R.anim.fromright);
    }
}