package com.example.learnchess;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.TimerTask;

public class lessonbord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessonbord);
        onCreat();
    }
    void onCreat()
    {
        createrd = true; // if created
        if(!coim.getInGame(getApplicationContext()) && !coim.getLesOn(getApplicationContext())) /*if its new game choose who start*/
            botStart = coim.getWhoStart(getApplicationContext()) == 1 || (coim.getWhoStart(getApplicationContext()) == 0 && data.oneIn(2));
        System.out.println("in game "+ coim.getInGame(getApplicationContext()));
        onEnterAnimationComplete();
        TextView messin = findViewById(R.id.needTo);
        bot = levels.getBotByName(coim.getBotName(getApplicationContext()));
        if(coim.getLesOn(getApplicationContext())) {
            lev = levels.getFromLevelList(coim.getLes(getApplicationContext()),getApplicationContext());
            messin.setText(lev.getMessin());
        }
        else {
            lev = levels.getFromLevelList(-1,getApplicationContext());
            messin.setText("win " + bot.getName());
        }
        if(lev.getHint())
        {
            if(coim.getShowHint(getApplicationContext()))
            {
                Button factButton = findViewById(R.id.factButton);
                factButton.setText("hint");
                factButton.setVisibility(View.VISIBLE);
            }
            else
                findViewById(R.id.factButton).setVisibility(View.INVISIBLE);
        }
        ((Button)findViewById(R.id.unDoNum)).setText(coim.getUnDo(getApplicationContext()) + "");
        startOrg(lev.getStartOrder());
        if(botStart)
            botTurn();
        clearColor();
        turnsLeft = lev.getTurnLimit();
        if(turnsLeft == -1)
        {
            findViewById(R.id.moveleft).setVisibility(View.INVISIBLE);
            findViewById(R.id.factButton).setVisibility(View.INVISIBLE);
            findViewById(R.id.factText).setVisibility(View.INVISIBLE);
            findViewById(R.id.blackeat).setVisibility(View.VISIBLE);
            findViewById(R.id.whiteeat).setVisibility(View.VISIBLE);
        }
        else
        {
            TextView turnL = findViewById(R.id.moveleft);
            turnL.setText("moves left " + turnsLeft);
        }
        newFact(findViewById(R.id.factButton));
        if(coim.getAnimationOn(getApplicationContext()))
            ((ViewGroup)findViewById(R.id.page)).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        if(data.canCasel(what))
        {
            Button casel = findViewById(R.id.casel);
            casel.setVisibility(View.VISIBLE);
        }
        if(coim.getInGame(getApplicationContext()) && !coim.getLesOn(getApplicationContext()))
        {
            moveSave[] m = data.getCode(getApplicationContext());
            if(m[0] != null)
            {
                System.out.println("active creat review ");
                review(data.getCode(getApplicationContext()));
                findViewById(R.id.quitOrStay).setVisibility(View.VISIBLE);
                findViewById(R.id.quitOrStay).startAnimation(AnimationUtils.loadAnimation(this,R.anim.lefttoright));
                canPlay = false;
            }
            else {
                coim.setInGame(false,getApplicationContext());
                startActivity(new Intent(lessonbord.this, menu.class));
            }
        }
        else if(!coim.getLesOn(getApplicationContext())) {
            String s = "S";
            if(botStart)
                s = "SS";
            coim.setSave(data.getTime() + "W" + bot.getName() + "@" + lev.getStartOrder() + s, getApplicationContext());
        }
        if(coim.getLesOn(getApplicationContext())) // set back and forward button to invisible
        {
            findViewById(R.id.unDoLogo).setVisibility(View.INVISIBLE);
            findViewById(R.id.unDoNum).setVisibility(View.INVISIBLE);
        }
        if(lev.getFa().equals(""))
        {
            Button factButton = findViewById(R.id.faButton);
            factButton.setText("");
            factButton.setForeground(findViewById(R.id.saveLogoKeeper).getForeground());

        }
        else
            findViewById(R.id.faButton).getLayoutParams().width = 0;
        botTurnTime = System.currentTimeMillis();
    }
    boolean botStart = false;
    boolean createrd = false;
    boolean setSize = false;
    level lev;
    bot bot;
    long botTurnTime;
    int turnsLeft;
    int factCount = 1;
    boolean canPlay = true;
    boolean hintOn = false;
    int currectTurn = 0;
    int realTurn = 0;
    public void newFact(View v)
    {
        if(coim.getLesOn(getApplicationContext()) && canPlay)
        {
            if(lev.getHint())
            {
                if(factCount != 1)
                {
                    if(turnsLeft == lev.getTurnLimit())
                    {
                        data.normalOrengeMark(lev.getWith(),lessonbord.this,what,1);
                    }
                    else if(turnsLeft == lev.getTurnLimit() - 1)
                    {
                        if(lev.getWith2().equals(""))
                        {
                            data.normalOrengeMark(lev.getWith(),lessonbord.this,what,2);
                        }
                        else
                            data.markQuastion(lev.getWith2(),lessonbord.this,what,2);
                    }
                    else if(turnsLeft == lev.getTurnLimit() - 2)
                    {
                        if(lev.getWith3().equals(""))
                        {
                            data.normalOrengeMark(lev.getWith(),lessonbord.this,what,3);
                        }
                        else
                            data.markQuastion(lev.getWith3(),lessonbord.this,what,3);
                    }
                    else if(turnsLeft == lev.getTurnLimit() - 3)
                    {
                        data.normalOrengeMark(lev.getWith(),lessonbord.this,what,4);
                    }
                }
                else {
                    findViewById(R.id.factText).setVisibility(View.INVISIBLE);
                    factCount++;
                }
            }
            else
            {
                if(lev.getTurnLimit() != -1)
                {
                    v.setVisibility(View.GONE);
                    v.setVisibility(View.VISIBLE);
                }
                if(turnsLeft != -1)
                {
                    if(lev.getWith().equals(""))
                    {
                        TextView t1 = findViewById(R.id.factText);
                        Button t2 = findViewById(R.id.factButton);
                        t1.setVisibility(View.INVISIBLE);
                        t2.setVisibility(View.INVISIBLE);
                    }
                    else
                    {
                        TextView fact = findViewById(R.id.factText);
                        if(factCount == 1)
                            fact.setText(lev.getWith());
                        else if(factCount == 2)
                            fact.setText(lev.getWith2());
                        else
                            fact.setText(lev.getWith3());
                        fact.startAnimation(AnimationUtils.loadAnimation(this,R.anim.lefttoright));
                        //findViewById(R.id.factButton).startAnimation(AnimationUtils.loadAnimation(this,R.anim.sample_anim));
                        factCount++;
                        if(factCount == 4 || (factCount == 3 && lev.getWith3().equals("")))
                            factCount = 1;
                        if(factCount == 2 && lev.getWith2().equals(""))
                        {
                            findViewById(R.id.factButton).setVisibility(View.INVISIBLE);
                            factCount = 1;
                        }
                    }
                }
            }
        }
        else
            findViewById(R.id.factButton).setVisibility(View.INVISIBLE);
    }
    public void faClick(View v)
    {
        data.playUIClickSound(getApplicationContext());
        String org = ""; for(int i = 1; i < 65; i++){ org += what[i];}
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("EditText","PASTE" + org);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(lessonbord.this,"game arrangement copied",Toast.LENGTH_LONG).show();
        for(int i = 1; i < 65; i++)
        {
            NumToPic(i).startAnimation(AnimationUtils.loadAnimation(this,R.anim.blink_anim));
        }
    }
    void startOrg(String text)
    {
        System.out.println("start org " + text);
        for(int i = 1; i <= text.length(); i++)
        {
            char a = text.charAt(i - 1);
            setImage(NumToPic(i),a);
        }
    }
    void clearColor()
    {
        boolean black = false;
        for(int i = 1; i < 65; i++)
        {
            if(!botTurn)
            {
                if(colors[i] == 'y') {
                    NumToPic(i).setImageDrawable(null);
                }
                if(colors[i] == 'g' && data.isBlack(what[i]))
                    setImage(NumToPic(i),what[i]);
            }
            if(black)
                setColor(NumToPic(i),'x');
            else
                setColor(NumToPic(i),'q');
            black = !black;
            if(i % 8 == 0)
                black = !black;
        }
    }
    char getColor(ImageView i)
    {
        return colors[PicToNum(i)];
    }
    char[] what = new char[65];
    char[] colors = new char[65];
    boolean botTurn = false;
    int PicToNum(ImageView i)
    {
        return data.PicToNum(i,lessonbord.this);
    }
    ImageView NumToPic(int i)
    {
        return data.NumToPic(i,lessonbord.this);
    }
    boolean isWhiteBlock(ImageView im)
    {
        final int num = PicToNum(im);
        boolean black = false;
        for(int i = 1; i < 65; i++)
        {
            if(i == num)
                return !black;
            black = !black;
            if(i % 8 == 0)
                black = !black;
        }
        return true;
    }
    void setImage(ImageView i,char to)
    {
        if(!botTurn)
            data.setImage(i,to,PicToNum(i),botStart,getApplicationContext());
        what[PicToNum(i)] = to;
    }
    void setColor(ImageView i,char to)
    {
       if(!botTurn)
           data.setColor(i,to,what[PicToNum(i)],botStart && coim.getWhiteStart(getApplicationContext()),PicToNum(i));
        colors[PicToNum(i)] = to;
    }
    void setColors(char[] _colors)
    {
        for(int i = 1; i < 65; i++)
        {
            if(_colors[i] != 'x' && _colors[i] != 'q')
                setColor(NumToPic(i),_colors[i]);
        }
    }
    ImageView mark = null;
    public void blockClick(View v)
    {
        if(canPlay)
        {
            if(!setSize )
                setSize();
            boolean over = false;
            TextView t1 = findViewById(R.id.data1);
            final ImageView i = (ImageView)v;
            if(mark != null && mark.equals(i)) {
                clearColor();
                mark = null;
            }
            else
            {
                final int num = PicToNum(i);
                t1.setText("color: " + colors[num] + " kind " + what[num] + " num " + num);
                if((getColor(i) == 'x' || getColor(i) == 'q' || getColor(i) == 'o') && what[num] != 'n')
                {
                    clearColor();
                    doWhiteMove(i);
                    mark = i;
                }
                else if(colors[num] == 'y' || colors[num] == 'g')
                {
                    System.out.println("do (mark = " + PicToNum(mark) + " )");
                    doMove(new moveSave(PicToNum(mark),num,what[num],(what[PicToNum(mark)] == 'a' && num < 9)),true,System.currentTimeMillis() - botTurnTime);
                    clearColor();
                    over = true;
                }
            }

            if(over && canPlay)
            {
                hintOn = false;
                if(!coim.getLesOn(getApplicationContext())) {
                    findViewById(R.id.backButton).setVisibility(View.VISIBLE);
                    findViewById(R.id.unDoNum).setVisibility(View.VISIBLE);
                    findViewById(R.id.unDoLogo).setVisibility(View.VISIBLE);
                }
                if(!coim.getLesOn(getApplicationContext()))
                    coim.setInGame(true,getApplicationContext());
                scanQueen();
                turnsLeft--;
                clearColor();
                TextView turnL = findViewById(R.id.moveleft);
                turnL.setText("moves left " + turnsLeft);
                if(lessonOver(true))
                    end();
                botTurn();
                if(turnsLeft == 0 && canPlay)
                {
                    coim.setEndmessege("you out of turns",getApplicationContext());
                    gameOver();
                }
            }
        }
    }
    void end()
    {
        canPlay = false;
        if(coim.getLesOn(getApplicationContext()))
        {
            Button b = findViewById(R.id.nextLevel);
            b.setVisibility(View.VISIBLE);
            if(coim.getAnimationOn(getApplicationContext()))
                b.startAnimation(AnimationUtils.loadAnimation(this,R.anim.lefttoright));
            TextView t4 = findViewById(R.id.moveleft);
            t4.setVisibility(View.INVISIBLE);
        }
        else
        {
            boolean win = false;
            for(int i = 1; i < 65; i++)
            {
                if(what[i] == 'f') {
                    win = true;
                    break;
                }
            }
            final Context c = getApplicationContext();
            if(win) {
                if(!coim.getLesOn(getApplicationContext()))
                {
                    coim.setSave("QW" + coim.getSave(c),c);
                    data.addToList(coim.getSave(c),c);
                }
                coim.setEndmessege("you win", getApplicationContext());
            }
            else {
                if(!coim.getLesOn(getApplicationContext()))
                {
                    coim.setSave("QL" + coim.getSave(c),c);
                    data.addToList(coim.getSave(c),c);
                }
                coim.setEndmessege("you lose", getApplicationContext());
            }
            coim.setInGame(false,getApplicationContext());
            startActivity(new Intent(lessonbord.this, gameOverPage.class));
            overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
        }
    }
    void doWhiteMove(ImageView i)
    {
        setColors(data.doWhiteMove(PicToNum(i),what));
    }
    void doWhiteMove(int i)
    {
        setColors(data.doWhiteMove(i,what));
    }
    void doBlackMove(ImageView i)
    {
        setColors(data.doBlackMove(PicToNum(i),what));
    }
    void doBlackMove(int i)
    {
        setColors(data.doBlackMove(i,what));
    }
    moveSave saveLastMoveSave = null;
    void doMove(moveSave m,boolean byUser,long time)
    {
       try {
           data.moveVar(m.getEatKind() != 'n',getApplicationContext());
           if(byUser && !coim.getLesOn(getApplicationContext()))
               data.moveSaveCalculation(m,what[m.getFrom()],getApplicationContext(),time);
           else if(!coim.getLesOn(getApplicationContext()))
               data.addToTimeCalculation(time,getApplicationContext());
           currectTurn++;
           realTurn++;
           if(!coim.getLesOn(getApplicationContext()))
               data.addCode(m,getApplicationContext());
           System.out.println("move from " + m.getFrom() + " to " + m.getTo() + " eat kind " + m.getEatKind() + " because queen is " + m.getBecomeQueen());
           if(m.getEatKind() != 'n') {
               data.playMoveSound2(getApplicationContext());
               data.deadSol(m.getEatKind(), lessonbord.this,botStart);/**/
           }
           else
               data.playModeSound1(getApplicationContext());
           //saveLastMoveSave = new moveSave(m);
           botTurn = false;
           setImage(NumToPic(m.getTo()),what[m.getFrom()]);
           setImage(NumToPic(m.getFrom()),'n');
           if(isWhiteBlock(NumToPic(m.getTo())))
               colors[m.getTo()] = 'q';
           else
               colors[m.getTo()] = 'x';
           makeGray = NumToPic(m.getFrom());
       }
       catch (Exception e)
       {
           System.out.println("m is null (error report by Move)///////////////////////////////////////////////////////////");
       }
    }
    ImageView makeGray = null;
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
    boolean lessonOver(boolean beforeBot)
    {
        allWhite();
        boolean lose = true;
        if(lev.isKindExist())
        {
            if(findLoc('f') == 0)
            {
                clearColor();
                coim.setEndmessege("your king died",getApplicationContext());
                Context c = getApplicationContext();
                coim.setSave("QL" + coim.getSave(c),c);
                data.addToList(coim.getSave(c),c);
                gameOver();
                return false;
            }
        }
        for(int i = 1; i < 65; i++)
        {
            if(colors[i] == 'y' || colors[i] == 'g')
            {
                lose = false;
                break;
            }
        }
        clearColor();
        if(lose)
        {
            coim.setEndmessege("you can't move",getApplicationContext());
            coim.setInGame(false,getApplicationContext());
            startActivity(new Intent(lessonbord.this,gameOverPage.class));
            overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
            return false;
        }
        String check = lev.getEndOrder();
        if(check.charAt(0) == 'X' && check.charAt(1) == 'X')
        {
            char find1 = check.charAt(2);
            char find2 = check.charAt(3);
            for(int i = 1; i < 65; i++)
            {
                if(what[i] == find1 || what[i] == find2)
                    return false;
            }
            return true;
        }
        else if(check.charAt(0) == 'X')
        {
            char find = check.charAt(1);
            for(int i = 1; i < 65; i++)
            {
                if(what[i] == find)
                    return false;
            }
            return true;
        }
        else if(check.equals("MT"))
        {
           if(beforeBot)
               return mat();
           else {
               for (int i = 1; i < 65; i++) {
                   if (what[i] == 'f')
                       return false;
               }
               if (!coim.getLesOn(getApplicationContext())) {
                   coim.setEndmessege("your king died", getApplicationContext());
                   coim.setSave("QL" + coim.getSave(getApplicationContext()), getApplicationContext());
                   data.addToList(coim.getSave(getApplicationContext()), getApplicationContext());
                   gameOver();
                   return false;
               }
               return false;
           }
        }
        else if(check.equals("TE"))
        {
            clearColor();
            allBlack();
            final boolean getEat = colors[findLoc('f')] == 'o';
            clearColor();
            if(turnsLeft == 0 && !getEat)
                return true;
            return false;
        }
        else if(check.charAt(0) == 'T')
        {
            char a = check.charAt(1);
            if(a == '1')
            {
                char b = check.charAt(2);
                byte bCount = 0;
                for(int i = 1; i < 65; i++)
                {
                    if(what[i] == b)
                        bCount++;
                }
                return bCount == 1;
            }
            else
            {
                for(int i = 1; i < 65; i++)
                {
                    if(what[i] == a)
                        return true;
                }
                return false;
            }
        }
        else if(check.equals("CH"))
        {
            allWhite();
            for(int i = 1; i < 65; i++)
            {
                if(what[i] == 'l' && colors[i] == 'g')
                {
                    clearColor();
                    return true;
                }
            }
            clearColor();
            return false;
        }
        else
        {
            for(int i = 1; i < 65; i++)
            {
                if(what[i] != check.charAt(i - 1))
                    return false;
            }
            return true;
        }
    }
    boolean mat()
    {
        int loc = 0;
        for(int i = 1; i < 65; i++)
        {
            if(what[i] == 'l')
            {
                loc = i;
                break;
            }
        }
        if(loc == 0) {
            return false;
        }
        boolean noTrate = false;
        /*allWhite();
        if(colors[loc] != 'g') {
            System.out.println("no mat because no trhet to king"); // if the
            clearColor();
            return false;
        }
        else
        {/**/
            clearColor();
            botTurn = true;
            boolean don = false;
            for(int i = 1; i < 65; i++)
            {
                if(data.isBlack(what[i]))
                {
                    boolean didIt = true;
                    for(int g = 1; g < 65; g++)
                    {
                        if(didIt)
                        {
                            clearColor();
                            doBlackMove(i);
                        }
                        if(colors[g] == 'y' || colors[g] == 'o')
                        {
                            didIt = true;
                            clearColor();
                            final char moveToSave = what[g]; // simolation start
                            setImage(NumToPic(g), what[i]);// simolation start
                            setImage(NumToPic(i), 'n');// simolation start
                            allWhite();
                            setImage(NumToPic(i),what[g]); // simoalte end
                            setImage(NumToPic(g),moveToSave); // simoalte end
                            if(moveToSave == 'f') // because eat the white king its auto win
                            {
                                clearColor();
                                botTurn = false;
                                return false;
                            }
                            boolean marker;
                            if(what[i] == 'l')
                                marker = colors[g] != 'g';
                            else
                                marker = colors[loc] != 'g';
                            if(marker) {
                                clearColor();
                                botTurn = false;
                                return false;
                            }
                        }
                    }
                }
            }
        /*}*/
        clearColor();
        botTurn = false;
        return true;
    }
    void gameOver()
    {
        coim.setInGame(false,getApplicationContext());
        startActivity(new Intent(lessonbord.this,gameOverPage.class));
        overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
    }
    void botTurn()
    {
        if(lev.getAIon() && canPlay)
        {
            //final long startTime = System.currentTimeMillis();
            botTurn = true;
            mHandler = new Handler();
                mHandler.post(mUpdate);
        }
    }
    void moveBot()
    {
        final long startTime = System.currentTimeMillis();
        AI a = new AI(bot.getLevelLimit());
        int[] move = a.doAI(what,false,0,bot.isAgresive());
        moveSave m = new moveSave(move[0],move[1],what[move[1]],move[2] == 4);
        doMove(m,false,(int)(System.currentTimeMillis() - startTime));
    }
    boolean[] getWhoCanEat()
    {
        clearColor();
        boolean[] save = new boolean[65];
        for(int i = 1; i < 65; i++)
        {
            save[i] = false;
        }
        for(int i = 1; i < 65; i++)
        {
            doWhiteMove(NumToPic(i));
        }
        for(int i = 1; i < 65; i++)
        {
            if(colors[i] == 'g')
                save[i] = true;
        }
        clearColor();
        return save;
    }
    public void goNextLevel(View view)
        {
        coim.addLes(1, getApplicationContext());
        coim.setInGame(false,getApplicationContext());
        startActivity(new Intent(lessonbord.this, lessonbord.class));
        overridePendingTransition(R.anim.lefttoright, R.anim.righttoleft);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(lev.getNum() != coim.getLes(getApplicationContext()) && coim.getLesOn(getApplicationContext())) {
            startActivity(new Intent(lessonbord.this, lessenPage.class));
            overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
        }
       /* else if(!coim.getInGame(getApplicationContext()) && !coim.getLesOn(getApplicationContext()))
        {
            findViewById(R.id.quitOrStay).setVisibility(View.INVISIBLE);
            startOrg("jhiklihjggggggggnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnaaaaaaaadbcefcbd");
        }*/
        if(coim.getLesOn(getApplicationContext()))
        {
            if(lessonOver(true)  && lev.getEndOrder().equals("MT") /**/)
                end();
            if(turnsLeft == 0)
            {
                startActivity(new Intent(lessonbord.this, lessonbord.class));
                overridePendingTransition(R.anim.fromleft,R.anim.fromright);
            }
        }
    }
    void WriteGameReport()
    {
        for(int i = 1; i < 65; i++)
        {
            System.out.print(colors[i]);
        }
        System.out.println();
        for(int i = 1; i < 65; i++)
        {
            System.out.print(what[i]);
        }
        System.out.println();
    }
    void reloadWhat()
    {
        System.out.print("reload");
        botTurn = false;
        for(int i = 1; i < 65; i++)
        {
            if(what[i] != 'n')
                setImage(NumToPic(i),what[i]);
        }
    }
    char[] saveColors = new char[65];
    void saveColor(boolean first)
    {
        if(first)
        {
            for(int i = 1; i < 65; i++)
            {
                saveColors[i] = colors[i];
            }
        }
        else
        {
            for(int i = 1; i < 65; i++)
            {
                setColor(NumToPic(i),saveColors[i]);
            }
        }
    }
    void unDo(moveSave m)
    {
        if(m.getTo() != 67)
        {
            if(m.getBecomeQueen()) {
                if(m.getTo() > 56)
                    setImage(NumToPic(m.getFrom()),'g');
                else
                    setImage(NumToPic(m.getFrom()),'a');
            }
            else
                setImage(NumToPic(m.getFrom()),what[m.getTo()]);
            setImage(NumToPic(m.getTo()),m.getEatKind());
            if(m.getEatKind() != 'n') {
                data.playMoveSound2R(getApplicationContext());
                if(canPlay)
                    data.removeTop(m.getEatKind(), lessonbord.this);
            }
            else if (canPlay)
                data.playModeSound1R(getApplicationContext());
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
    void refrshTry()
    {
        /*RelativeLayout page = findViewById(R.id.page);
        page.setVisibility(View.GONE);
        page.setVisibility(View.VISIBLE);*/
    }
    int getToolScore(char a)
    {
        if(bot.isAgresive())
            return data.getToolScore(a) + 2;
        else
            return data.getToolScore(a);
    }
    int getEatByWhite(int loc,int startFrom)
    {
        for(int i = startFrom; i < 65; i++)
        {
            if(data.isWhite(what[i]))
            {
                clearColor();
                doWhiteMove(i);
                if(colors[loc] == 'g') {
                    clearColor();
                    return i;
                }
               /*else
                    System.out.println(i + " don't eat " + loc + " ("  + startFrom + ")");/**/
            }
        }
        return 0;
    }
    int getEatByBlack(int loc)
    {
        for(int i = 1; i < 65; i++)
        {
            if(data.isBlack(what[i]))
            {
                clearColor();
                doBlackMove(i);
                if(colors[loc] == 'g') {
                    clearColor();
                    return i;
                }
            }
        }
        return 0;
    }
    void allWhite()
    {
        for(int i = 1 ; i < 65; i++)
        {
            if(data.isWhite(what[i]))
                doWhiteMove(i);
        }
    }
    void allBlack()
    {
        for(int i = 1; i < 65; i++)
        {
            if(data.isBlack(what[i]))
                doBlackMove(i);
        }
    }
    int fakeEatFromWhite(final int oneThatEat,final int getEat)
    {
        clearColor();
        allBlack();
        if(colors[getEat] == 'g') {
            clearColor();
            int save;
            if (getToolScore(what[oneThatEat]) >= getToolScore(what[getEat]))
            {
                return  getToolScore(what[getEat]);

            }
            else
                return getToolScore(what[oneThatEat]);
        }
        else {
            clearColor();
            return 0;
        }
    }
    boolean fakeEatFromBlack(final int oneThatEat,char eatKind) // after simolation
    {
        clearColor();
        allWhite();
        if(colors[oneThatEat] == 'g')
        {
            clearColor();
            return getToolScore(what[oneThatEat]) > getToolScore(eatKind);
        }
        else {
            clearColor();
            return false;
        }
    }
    public void castelClick(View view)
    {
        if(canPlay)
        {
            currectTurn++;
            realTurn++;
            clearColor();
            if(data.canRightCasel(what))
            {
                data.addCode(new moveSave(false),getApplicationContext());
                setImage(NumToPic(61),'n');
                setImage(NumToPic(62),'d');
                setImage(NumToPic(63),'f');
                setImage(NumToPic(64),'n');
            }
            else
            {
                data.addCode(new moveSave(true),getApplicationContext());
                setImage(NumToPic(57),'n');
                setImage(NumToPic(59),'f');
                setImage(NumToPic(60),'d');
                setImage(NumToPic(61),'n');
            }
            view.setVisibility(View.INVISIBLE);
            turnsLeft--;
            TextView turnL = findViewById(R.id.moveleft);
            turnL.setText("moves left " + turnsLeft);
            if(lessonOver(true))
                end();
            else if(turnsLeft == 0)
            {
                coim.setEndmessege("you out of turns",getApplicationContext());
                gameOver();
            }
            if(lev.getAIon())
                botTurn();
        }
        else
            view.setVisibility(View.INVISIBLE);
    }
    void doMoveSaveWithoutMark(moveSave m)
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
            if(what[m.getTo()] != 'n')
                data.deadSol(what[m.getTo()],lessonbord.this,botStart);
            setImage(NumToPic(m.getTo()),what[m.getFrom()]);
            setImage(NumToPic(m.getFrom()),'n');
            scanQueen();
        }
    }
    void review(moveSave[] m) {
        if (data.blackStart(coim.getSave(getApplicationContext())))
            botStart = true;
        startOrg(data.getCodeOrg(coim.getSave(getApplicationContext())));
        System.out.println("save is " + coim.getSave(getApplicationContext()));
        for(int i = 0; i < m.length; i++)
        {
            if(m[i] == null) {
                realTurn = i;
                currectTurn = i;
                break;
            }
            else
            {
                doMoveSaveWithoutMark(m[i]);
            }
        }
    }





    public void stayClick(View view)
    {
        setSize();
        findViewById(R.id.backButton).setVisibility(View.VISIBLE);
        findViewById(R.id.unDoNum).setVisibility(View.VISIBLE);
        findViewById(R.id.unDoLogo).setVisibility(View.VISIBLE);
        coim.setOnMenu(false,getApplicationContext());
        coim.setInGame(true,getApplicationContext());
        RelativeLayout r = findViewById(R.id.quitOrStay);
        r.setVisibility(View.GONE);
        canPlay = true;
    }
    public void quitLevel(View view)
    {
        //count lose
        if(lev.getStartOrder().equals(data.getDefultOrg()))
            coim.addIntByName(bot.getName() + "L",1,getApplicationContext());
        else if(data.getOrgOrg(getApplicationContext()).equals("960"))
            coim.addIntByName(bot.getName() + "L960",1,getApplicationContext());
        coim.setInGame(false,getApplicationContext());
        coim.setSave("QQ" + coim.getSave(getApplicationContext()),getApplicationContext());
        data.addToList(coim.getSave(getApplicationContext()),getApplicationContext());
        coim.setSave("",getApplicationContext());
        if(coim.getOnMenu(getApplicationContext()))
            startActivity(new Intent(lessonbord.this,menu.class));
        else
        {
            if(coim.getLesOn(getApplicationContext()))
                startActivity(new Intent(lessonbord.this,lessenPage.class));
            else
                startActivity(new Intent(lessonbord.this,botspage.class));
        }
        overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
    }


    //sizetihng
    void setSize()
    {
        setSize = true;
        data.setSize(findViewById(R.id.length).getWidth(),findViewById(R.id.hight).getHeight(),lessonbord.this,getApplicationContext());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(!coim.getInGame(getApplicationContext()))
            setSize();
    }
    public void simBack(View v)
    {
        canPlay = false;
        realTurn--;
        moveSave[] m = data.getCode(getApplicationContext());
        unDo(m[realTurn]);
        findViewById(R.id.forwardButton).setVisibility(View.VISIBLE);
        findViewById(R.id.forwardButton2).setVisibility(View.VISIBLE);
        if(realTurn == 0)
            findViewById(R.id.backButton).setVisibility(View.INVISIBLE);
    }
    public void simForward(View v)
    {
        if(currectTurn != realTurn)
        {
            moveSave[] m = data.getCode(getApplicationContext());
            doMoveSaveWithoutMark(m[realTurn]);
            realTurn++;
            if(currectTurn == realTurn) {
                canPlay = true;
                findViewById(R.id.forwardButton).setVisibility(View.INVISIBLE);
                findViewById(R.id.forwardButton2).setVisibility(View.INVISIBLE);
            }
            findViewById(R.id.backButton).setVisibility(View.VISIBLE);
        }
    }
    public void simForward2(View v)
    {
        moveSave[] m = data.getCode(getApplicationContext());
        while (realTurn < currectTurn)
        {
            doMoveSaveWithoutMark(m[realTurn]);
            realTurn++;
        }
        canPlay = true;
        findViewById(R.id.forwardButton).setVisibility(View.INVISIBLE);
        findViewById(R.id.forwardButton2).setVisibility(View.INVISIBLE);
        findViewById(R.id.backButton).setVisibility(View.VISIBLE);
    }
    public void unDoClick(View v)
    {
        if(canPlay && currectTurn > 1 && coim.getUnDo(getApplicationContext()) != 0)
        {
            clearColor();
            coim.addUnDo(1,getApplicationContext());
            ((Button)findViewById(R.id.unDoNum)).setText(coim.getUnDo(getApplicationContext()) + "");
            moveSave[] m = data.getCode(getApplicationContext());
            unDo(m[currectTurn - 1]);
            unDo(m[currectTurn - 2]);
            currectTurn -= 2;
            realTurn -= 2;
            data.removeLastMove(getApplicationContext());
            data.removeLastMove(getApplicationContext());
            if(currectTurn < 2) {
                coim.setInGame(false, getApplicationContext());
                coim.setSave(data.getTime() + "W" + bot.getName() + "S", getApplicationContext());
                findViewById(R.id.unDoLogo).setVisibility(View.INVISIBLE);
                findViewById(R.id.unDoNum).setVisibility(View.INVISIBLE);
                findViewById(R.id.backButton).setVisibility(View.INVISIBLE);
            }
            else if(coim.getAnimationOn(getApplicationContext()))
                findViewById(R.id.unDoLogo).startAnimation(AnimationUtils.loadAnimation(this,R.anim.rotartonce));
            if(data.canCasel(what))
                findViewById(R.id.casel).setVisibility(View.VISIBLE);
        }
    }




    boolean kingInDanger = false;
    boolean isKingInDanger()
    {
        allWhite();
        final boolean D = colors[findLoc('l')] == 'g';
        clearColor();
        return D;
    }
    private Handler mHandler;
    private Runnable mUpdate = new Runnable() {
        public void run() {
            if(canPlay)
            {
                canPlay = false;
                kingInDanger = isKingInDanger();
                moveBot();
                botTurn = false;
                scanQueen();
                reloadWhat();
                saveColor(true);
                scanQueen();
                if(lessonOver(false))
                    end();
                setColor(makeGray,'z');
                if(data.canCasel(what))
                {
                    Button casel = findViewById(R.id.casel);
                    casel.setVisibility(View.VISIBLE);
                }
                else
                    findViewById(R.id.casel).setVisibility(View.INVISIBLE);
                botTurnTime = System.currentTimeMillis();
                canPlay = true;
            }

        }
    };
    int findLoc(char kind)
    {
        int loc = 0;
        for(int i = 1; i < 65; i++)
        {
            if(what[i] == kind) {
                return i;
            }
        }
        return loc;
    }
    boolean thereWhiteMate(final int WhiteKingLoc) // if there white mate (huavy)
    {
        if(WhiteKingLoc == 0)
            return false;
        for(int i = 1; i < 65; i++) // for each white tool
        {
            if(data.isWhite(what[i])) // if the tool is white
            {
                boolean didIt = true;
                for(int g = 1; g < 65; g++)
                {
                    if(didIt)
                    {
                        clearColor();
                        doWhiteMove(i);
                        didIt = false;
                    }
                    if(colors[g] == 'y' || colors[g] == 'g')
                    {
                        final char saveTo = what[g];
                        setImage(NumToPic(g),what[i]);
                        setImage(NumToPic(i),'n');
                        didIt = true;
                        clearColor();
                        allBlack();
                        setImage(NumToPic(i),what[g]);
                        setImage(NumToPic(g),saveTo);
                        if((what[i] == 'f' && colors[g] != 'o') || (what[i] != 'f' && colors[WhiteKingLoc] != 'o'))
                        {
                            //System.out.println("can move from " + i + "-> " + g);
                            clearColor();
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    boolean WhiteWillCanMakeMat()// chack if the white can make mate (havey)
    {
        for(int i = 1; i < 65; i++)
        {
            if(data.isWhite(what[i]))
            {
                boolean didIt = true;
                for(int g = 1; g < 65; g++)
                {
                    if(didIt)
                    {
                        didIt = false;
                        clearColor();
                        doWhiteMove(i);
                    }
                    if(colors[g] == 'y' || colors[g] == 'g') {
                        didIt = true;
                        //start simolate
                        final char moveToKind = what[g];
                        setImage(NumToPic(g), what[i]);
                        setImage(NumToPic(i), 'n');
                        if(isKingInDanger() && mat())
                        {
                            setImage(NumToPic(i),what[g]);
                            setImage(NumToPic(g),moveToKind);
                            return true;
                        }
                        //simolation end
                        setImage(NumToPic(i),what[g]);
                        setImage(NumToPic(g),moveToKind);
                    }
                }
            }
        }
        clearColor();
        return false;
    }
}