package com.example.learnchess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class orgsaver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orgsaver);
        String startOrg = coim.getOrg(getApplicationContext());
        buttonsAnimation(startOrg);
        if(startOrg.equals(""))
            setByOrg("default arrangement#default$T@" + data.getDefultOrg(),true);
        else
            setByOrg(startOrg,true);
        for(int i = 1; i < 11; i++) {
            final String order = coim.getStringByName("startOrgSaver" + i, getApplicationContext());
            if (order.equals(""))
            {
                RelativeLayout r = getRealtiveByInt(i);
                r.getLayoutParams().height = 0;
                r.requestLayout();
            }
            else {
                if(i == 10)
                    findViewById(R.id.addWorld).setVisibility(View.INVISIBLE);
                setBlock(getTV(i, 1), getTV(i, 2), getTV(i, 3), order);
            }
        }
    }
    String lastOrg = "";
    void setByOrg(final String org,boolean first)
    {
        if(!org.equals(lastOrg) || data.getOrgOrg(org).equals("960"))
        {
            if(!first) // the animations
            {
                for(int i = 1; i < 65; i++)
                {
                    data.NumToPic(i,orgsaver.this).startAnimation(AnimationUtils.loadAnimation(this,R.anim.fadein));
                }
                buttonsAnimation(org);
            }
            boolean start = false;
            String realOrg = "";
            for(int i = 0; i < org.length(); i++)
            {
                char a = org.charAt(i);
                if(start)
                    realOrg += a;
                else if(a == '@')
                    start = true;
            }
            if(realOrg.equals("960"))
                realOrg = data.getChees960Bord();
            for(int i = 1; i < 65; i++)
            {
                data.setImage(data.NumToPic(i,orgsaver.this),realOrg.charAt(i - 1),i,false,getApplicationContext());
            }
            setBlock(getTV(0,1),getTV(0,2),getTV(0,3),org);
            lastOrg = org;
        }

    }
    TextView getTV(int num,int index)
    {
        switch (num)
        {
            case(0):
                if(index == 1)return findViewById(R.id.t01);
                else if(index == 2) return findViewById(R.id.t02);
                else return findViewById(R.id.t03);
            case(1):
                if(index == 0)return findViewById(R.id.t10);
                else if(index == 1)return findViewById(R.id.t11);
                else if(index == 2)return findViewById(R.id.t12);
                else return findViewById(R.id.t13);
            case(2):
                if(index == 0)return findViewById(R.id.t20);
                else if(index == 1)return findViewById(R.id.t21);
                else if(index == 2)return findViewById(R.id.t22);
                else return findViewById(R.id.t23);
            case(3):
                if(index == 0)return findViewById(R.id.t30);
                else if(index == 1)return findViewById(R.id.t31);
                else if(index == 2)return findViewById(R.id.t32);
                else return findViewById(R.id.t33);
            case(4):
                if(index == 0)return findViewById(R.id.t40);
                else if(index == 1)return findViewById(R.id.t41);
                else if(index == 2)return findViewById(R.id.t42);
                else return findViewById(R.id.t43);
            case(5):
                if(index == 0)return findViewById(R.id.t50);
                else if(index == 1)return findViewById(R.id.t51);
                else if(index == 2)return findViewById(R.id.t52);
                else return findViewById(R.id.t53);
            case(6):
                if(index == 0)return findViewById(R.id.t60);
                else if(index == 1)return findViewById(R.id.t61);
                else if(index == 2)return findViewById(R.id.t62);
                else return findViewById(R.id.t63);
            case(7):
                if(index == 0)return findViewById(R.id.t70);
                else if(index == 1)return findViewById(R.id.t71);
                else if(index == 2)return findViewById(R.id.t72);
                else return findViewById(R.id.t63);
            case(8):
                if(index == 0)return findViewById(R.id.t80);
                else if(index == 1)return findViewById(R.id.t81);
                else if(index == 2)return findViewById(R.id.t82);
                else return findViewById(R.id.t83);
            case(9):
                if(index == 0)return findViewById(R.id.t90);
                else if(index == 1)return findViewById(R.id.t91);
                else if(index == 2)return findViewById(R.id.t92);
                else return findViewById(R.id.t93);
            case(10):
                if(index == 0)return findViewById(R.id.t100);
                else if(index == 1)return findViewById(R.id.t101);
                else if(index == 2)return findViewById(R.id.t102);
                else return findViewById(R.id.t103);
        }
        return null;
    }
    RelativeLayout getRealtiveByInt(int num)
    {
        switch (num)
        {
            case 1:return findViewById(R.id.t10);
            case 2:return findViewById(R.id.t20);
            case 3:return findViewById(R.id.t30);
            case 4:return findViewById(R.id.t40);
            case 5:return findViewById(R.id.t50);
            case 6:return findViewById(R.id.t60);
            case 7:return findViewById(R.id.t70);
            case 8:return findViewById(R.id.t80);
            case 9:return findViewById(R.id.t90);
            default:return findViewById(R.id.t100);
        }
    }
    int getRealtiveToInt(View v)
    {
        if(v.equals(findViewById(R.id.t10)))
            return 1;
        else if(v.equals(findViewById(R.id.t20)))
            return 2;
        else if(v.equals(findViewById(R.id.t30)))
            return 3;
        else if(v.equals(findViewById(R.id.t40)))
            return 4;
        else if(v.equals(findViewById(R.id.t50)))
            return 5;
        else if(v.equals(findViewById(R.id.t60)))
            return 6;
        else if(v.equals(findViewById(R.id.t70)))
            return 7;
        else if(v.equals(findViewById(R.id.t80)))
            return 8;
        else if(v.equals(findViewById(R.id.t90)))
            return 9;
        else
            return 10;
    }
    void setBlock(TextView nameT,TextView timeT,TextView goalT,final String org)
    {
        String name = "";
        String time = "";
        boolean eatKindToWin = false;
        boolean nameEnd = false;
        for(int i = 0; i < org.length(); i++)
        {
            char a = org.charAt(i);
            if(a == '#')
                nameEnd = true;
            else if(a == '$')
            {
                eatKindToWin = org.charAt(i + 1) == 'T';
                break;
            }
            else if(nameEnd)
                time += a;
            else
                name += a;
        }
        nameT.setText("name: " + name);
        timeT.setText("created by: " + time);
        if(eatKindToWin)
            goalT.setText("goal: eat the king");
        else
            goalT.setText("goal: have tools");
    }
    public void setOrg(View v)
    {
        final int org = getRealtiveToInt(v);
        setByOrg(coim.getStringByName("startOrgSaver" + org,getApplicationContext()),false);
        coim.setOrg(coim.getStringByName("startOrgSaver" + org,getApplicationContext()),getApplicationContext());
    }
    void buttonsAnimation(String org)
    {
        View t1 = findViewById(R.id.edit);
        View t2 = findViewById(R.id.delete2);
        System.out.println("org is made by system " + madeBySystem(org) + " last org made by system " + madeBySystem(lastOrg) + "\n org is: " + org + "\n last org is: " + lastOrg);
        if(madeBySystem(org) && !madeBySystem(lastOrg))
        {
            t1.setClickable(false);
            t2.setClickable(false);
            t1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.righttoleft));
            t2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.righttoleft));
            t1.setVisibility(View.INVISIBLE);
            t2.setVisibility(View.INVISIBLE);
        }
        else if(!madeBySystem(org) && madeBySystem(lastOrg))
        {
            t1.setClickable(true);
            t2.setClickable(true);
            t1.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromleft));
            t2.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromleft));
            t1.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
        }
    }
    boolean madeBySystem(String org)
    {
        return (org.equals(coim.getStringByName("startOrgSaver1",getApplicationContext())) || org.equals(coim.getStringByName("startOrgSaver2",getApplicationContext())));
    }
    public void select(View v)
    {
        startActivity(new Intent(orgsaver.this,botspage.class));
        if(coim.getAnimationOn(getApplicationContext()))
            overridePendingTransition(R.anim.fromleft,R.anim.fromright);
    }
    public void delete(View v)
    {
        boolean delete = false;
        for(int i = 1; i < 11; i++)
        {
            if(delete)
            {
                coim.setStringByName("startOrgSaver" + i,coim.getStringByName("startOrgSaver" + (i + 1),getApplicationContext()),getApplicationContext());
            }
            if(coim.getStringByName("startOrgSaver" + i,getApplicationContext()).equals(coim.getOrg(getApplicationContext())))
            {
                coim.setStringByName("startOrgSaver" + i,"",getApplicationContext());
                delete = true;
                i--;
            }
        }
        coim.setOrg(coim.getStringByName("startOrgSaver1",getApplicationContext()),getApplicationContext());
        startActivity(new Intent(orgsaver.this,orgsaver.class));
        if(coim.getAnimationOn(getApplicationContext()))
            overridePendingTransition(R.anim.fromleft,R.anim.fromright);
        coim.setStringByName("startOrgSaver10","",getApplicationContext());
    }
    public void edit(View v)
    {
        coim.setBordCreateEnter(true,getApplicationContext());
        coim.setCreatOrgStart(coim.getOrg(getApplicationContext()),getApplicationContext());
        startActivity(new Intent(orgsaver.this,createorg.class));
        if(coim.getAnimationOn(getApplicationContext()))
            overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
    }
    public void createNew(View v)
    {
        coim.setBordCreateEnter(true,getApplicationContext());
        coim.setCreatOrgStart("",getApplicationContext());
        startActivity(new Intent(orgsaver.this,createorg.class));
        if(coim.getAnimationOn(getApplicationContext()))
            overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
    }

    public void pasteWorld(View v)
    {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clipData = clipboard.getPrimaryClip();
        clipData.addItem(clipData.getItemAt(0));
        String paste = clipboard.getPrimaryClip().toString();
        String orger = "";
        boolean start = false;
        for(int i = 0; i < paste.length(); i++)
        {
            if(start)
            {
                if(paste.charAt(i) == '}')
                    break;
                else
                {
                    orger += paste.charAt(i);
                }
            }
            else if(paste.charAt(i) == ':' && paste.charAt(i -1) == 'T')
                start = true;

        }
        System.out.println("paste this \"" + orger + "\"");
        if(orger.length() == 0)
            Toast.makeText(orgsaver.this,"copy game arrangement and then paste here",Toast.LENGTH_LONG).show();
        else if(orger.length() != 69 || orger.charAt(0) != 'P' || orger.charAt(1) != 'A' || orger.charAt(2) != 'S' || orger.charAt(3) != 'T' || orger.charAt(4) != 'E')
            Toast.makeText(orgsaver.this,"game arrangement is wrong",Toast.LENGTH_LONG).show();
        else
        {
            coim.setBordCreateEnter(true,getApplicationContext());
            coim.setCreatOrgStart(orger,getApplicationContext());
            startActivity(new Intent(orgsaver.this,createorg.class));
            if(coim.getAnimationOn(getApplicationContext()))
                overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        coim.setBordCreateEnter(false,getApplicationContext());
    }
}