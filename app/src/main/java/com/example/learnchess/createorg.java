package com.example.learnchess;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class createorg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createorg);
        for(int i = 1; i < 65; i++)
        {
            NumToPic(i).setVisibility(View.INVISIBLE);
        }
        String startText = coim.getCreateOrgStart(getApplicationContext());
        System.out.println(startText + " ///////////////////////////////////////////////////////////////");
        if(startText.equals("")) {
            edit = false;
            startOrg("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        }
        else if(startText.charAt(0) == 'P' && startText.charAt(1) == 'A' && startText.charAt(2) == 'S' && startText.charAt(3) == 'T' && startText.charAt(4) == 'E')
        {
            edit = false;

        }


        EditText e = findViewById(R.id.chooseName);
        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!e.getText().toString().equals(""))
                {
                    StringBuilder sb = new StringBuilder(e.getText().toString());
                    for(int i = 0; i < sb.length(); i++)
                    {
                        if(sb.charAt(i) == '@' || sb.charAt(i) == '#' || sb.charAt(i) == '$') {
                            sb.deleteCharAt(i);
                            e.setText(sb.toString());
                            break;
                        }
                    }
                    if(sb.toString().equals("chess 960") || sb.toString().equals("default arrangement"))
                        e.setText("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    boolean edit = true;
    int num = 0;
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        String startText = coim.getCreateOrgStart(getApplicationContext());
        if(!startText.equals(""))
        {
            if(startText.charAt(0) == 'P' && startText.charAt(1) == 'A' && startText.charAt(2) == 'S' && startText.charAt(3) == 'T' && startText.charAt(4) == 'E')
                startText = startText.substring(5);
            if(!startText.equals("")) {
                System.out.println("start text = \"" + startText + "\"");
                showBord();
                startOrg(startText);
                chackIfGood();
            }
        }

    }

    void setImage(ImageView i, char kind)
    {
        data.setImage(i,kind,PicToNum(i),false,getApplicationContext());
        what[PicToNum(i)] = kind;
    }
    void setSize()
    {
        if(coim.getSizeCurrect(getApplicationContext()))
        {
            int length = findViewById(R.id.length2).getWidth() / 8;
            int hight = findViewById(R.id.hight2).getHeight() / 8;
            if(hight < length)
                length = hight - 20;
            for(int i = 1; i < 65; i++)
            {
                ImageView x = NumToPic(i);
                x.getLayoutParams().height = length;
                x.getLayoutParams().width = length;
                x.requestLayout();
            }
        }
    }
    void startOrg(String set)
    {
        if(set.length() != 64)
            set = data.getOrgOrg(set);
        System.out.println("set is '" + set + ")");
        for(int i = 1; i < 65; i++)
        {
            setImage(NumToPic(i),set.charAt(i - 1));
        }
    }
    char[] what = new char[65];
    boolean first = true;
    boolean canNextLevel = false;
    ImageView NumToPic(int num)
    {
        return data.NumToPic(num,createorg.this);
    }
    int PicToNum(ImageView v){return data.PicToNum(v,createorg.this);}
    char tool = 'N';
    void showBord()
    {
        findViewById(R.id.next).setVisibility(View.VISIBLE);
        findViewById(R.id.next).setAlpha(0.4f);
        findViewById(R.id.next).startAnimation(AnimationUtils.loadAnimation(this,R.anim.lefttoright));
        setSize();
        first = false;
        for(int i = 1; i < 65; i++)
        {
            ImageView x = NumToPic(i);
            x.setVisibility(View.VISIBLE);
            x.startAnimation(AnimationUtils.loadAnimation(this,R.anim.sample_anim));
        }
    }
    public void selectTool(View y)
    {
        ImageView v = (ImageView)y;
        data.playUIClickSound(getApplicationContext());
        if(first)
            showBord();
        findViewById(R.id.whitesol).setForeground(findViewById(R.id.savewhitesolDG).getForeground());
        findViewById(R.id.whitehours).setForeground(findViewById(R.id.savewhitehoursDG).getForeground());
        findViewById(R.id.whitebis).setForeground(findViewById(R.id.savewhitebisDG).getForeground());
        findViewById(R.id.whiterun).setForeground(findViewById(R.id.savewhiterunDG).getForeground());
        findViewById(R.id.whitequeen).setForeground(findViewById(R.id.savewhitequeenDG).getForeground());
        findViewById(R.id.whiteking).setForeground(findViewById(R.id.savewhitekingDG).getForeground());
        findViewById(R.id.blacksol).setForeground(findViewById(R.id.saveblacksolDG).getForeground());
        findViewById(R.id.blackhours).setForeground(findViewById(R.id.saveblackhoursDG).getForeground());
        findViewById(R.id.blackbis).setForeground(findViewById(R.id.saveblackbisDG).getForeground());
        findViewById(R.id.blackrun).setForeground(findViewById(R.id.saveblackrunDG).getForeground());
        findViewById(R.id.blackqueen).setForeground(findViewById(R.id.saveblackqueenDG).getForeground());
        findViewById(R.id.blackking).setForeground(findViewById(R.id.saveblackingDG).getForeground());
        findViewById(R.id.redX).setForeground(findViewById(R.id.saveredxdarkgray).getForeground());
        if(v.equals(findViewById(R.id.whitesol))) {
            tool = 'a';
            v.setForeground(findViewById(R.id.savewhitesolY).getForeground());
        }
        else if(v.equals(findViewById(R.id.whitehours))){tool = 'b';v.setForeground(findViewById(R.id.savewhitehoursY).getForeground());}
        else if(v.equals(findViewById(R.id.whitebis))){tool = 'c';v.setForeground(findViewById(R.id.savewhitebisY).getForeground());}
        else if(v.equals(findViewById(R.id.whiterun))){tool = 'd';v.setForeground(findViewById(R.id.savewhiterunY).getForeground());}
        else if(v.equals(findViewById(R.id.whitequeen))){tool = 'e';v.setForeground(findViewById(R.id.savewhitequeenY).getForeground());}
        else if(v.equals(findViewById(R.id.whiteking))){tool = 'f';v.setForeground(findViewById(R.id.savewhitekingY).getForeground());}
        else if(v.equals(findViewById(R.id.blacksol))){tool = 'g';v.setForeground(findViewById(R.id.saveblacksolY).getForeground());}
        else if(v.equals(findViewById(R.id.blackhours))){tool = 'h';v.setForeground(findViewById(R.id.saveblackhoursY).getForeground());}
        else if(v.equals(findViewById(R.id.blackbis))){tool = 'i';v.setForeground(findViewById(R.id.saveblackbisY).getForeground());}
        else if(v.equals(findViewById(R.id.blackrun))){tool = 'j';v.setForeground(findViewById(R.id.saveblackruny).getForeground());}
        else if(v.equals(findViewById(R.id.blackqueen))){tool = 'k';v.setForeground(findViewById(R.id.saveblackqueenY).getForeground());}
        else if(v.equals(findViewById(R.id.blackking))){tool = 'l';v.setForeground(findViewById(R.id.saveblackingY).getForeground());}
        else if(v.equals(findViewById(R.id.redX))){tool = 'n';v.setForeground(findViewById(R.id.saveredxyellow).getForeground());}
        else tool = 'N';
    }
    ImageView charToImageView(char a)
    {
        switch (a)
        {
            case 'a':return findViewById(R.id.whitesol);
            case 'b':return findViewById(R.id.whitehours);
            case 'c':return findViewById(R.id.whitebis);
            case 'd':return findViewById(R.id.whiterun);
            case 'e':return findViewById(R.id.whitequeen);
            case 'f':return findViewById(R.id.whiteking);
            case 'g':return findViewById(R.id.blacksol);
            case 'h':return findViewById(R.id.blackhours);
            case 'i':return findViewById(R.id.blackbis);
            case 'j':return findViewById(R.id.blackrun);
            case 'k':return findViewById(R.id.blackqueen);
            case 'l':return findViewById(R.id.blackking);
            default:return null;
        }
    }


    public void blockClick(View v)
    {
        ImageView i = (ImageView)v;
        if(can(i))
        {
            i.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fadein));
            setImage(i,tool);
        }
        chackIfGood();
    }
    boolean there(char kind)
    {
        for(int i = 1; i < 65; i++)
        {
            if(what[i] == kind)
                return true;
        }
        return false;
    }
    void deleteAll(char fromKind)
    {
        for(int i = 1; i < 65; i++)
        {
            if(what[i] == fromKind)
                setImage(NumToPic(i),'n');
        }
    }
    boolean can(ImageView i)
    {
        final int loc = PicToNum(i);
        if(tool == 'a' && loc < 9)
            return false;
        if(tool == 'g' && loc > 56)
            return false;


        return true;
    }
    void chackIfGood()
    {
        View next = findViewById(R.id.next);
        if(there('f') && there('l'))
        {
            if(!canNextLevel)
            {
                next.setAlpha(1f);
                next.startAnimation(AnimationUtils.loadAnimation(this,R.anim.makefullalpha));
            }
            canNextLevel = true;
        }
        else
        {
            if(canNextLevel)
            {
                next.setAlpha(0.4f);
                next.startAnimation(AnimationUtils.loadAnimation(this,R.anim.make04apha));
            }
            canNextLevel = false;
        }
    }
    boolean firstStep = true;
    boolean comeBack = false;
    public void nextStep(View v) {
        if (canNextLevel)
        {
            if(firstStep && !edit)
            {
                findViewById(R.id.bord).requestLayout();
                moveAway(findViewById(R.id.bord));
                moveAway(findViewById(R.id.selectTool));
                firstStep = false;
                ((TextView)findViewById(R.id.stepX)).setText("step2");
                ((TextView)findViewById(R.id.stepO)).setText("choose name");
                ((TextView)findViewById(R.id.selctyourtool)).setText("");
                findViewById(R.id.chooseName).setVisibility(View.VISIBLE);
                findViewById(R.id.chooseName).startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromleft));
                findViewById(R.id.previus).setVisibility(View.VISIBLE);
                findViewById(R.id.previus).startAnimation(AnimationUtils.loadAnimation(this,R.anim.fromleft));
                if(!comeBack)
                {
                    int i = 1;
                    for(i = 1; i < 11; i++)
                    {
                        if(coim.getStringByName("startOrgSaver" + i,getApplicationContext()).equals(""))
                            break;
                    }
                    ((EditText)findViewById(R.id.chooseName)).setText("organization " + i);
                    oldText = ((EditText)findViewById(R.id.chooseName)).getText().toString();
                }
            }
            else {

                String whatS = "";
                for(int i = 1; i < 65; i++)
                {
                    whatS += what[i];
                }
                if (edit) {
                    int i;
                    final String org = coim.getOrg(getApplicationContext());
                    for (i = 1; i < 11; i++) {
                        if (org.equals(coim.getStringByName("startOrgSaver" + i, getApplicationContext())))
                            break;
                    }
                    String newText = "";
                    for (int x = 0; x < org.length() - 64; x++)
                    {
                        newText += org.charAt(x);
                    }
                    newText += whatS;
                    coim.setStringByName("startOrgSaver" + i,newText,getApplicationContext());
                    coim.setOrg(newText,getApplicationContext());
                }
                else
                {
                    EditText e  =findViewById(R.id.chooseName);
                    String code = e.getText().toString() + "#you$T@" + whatS;
                    int i = 1;
                    for(i = 1; i < 11; i++)
                    {
                        if(coim.getStringByName("startOrgSaver" + i,getApplicationContext()).equals(""))
                            break;
                    }
                    coim.setStringByName("startOrgSaver" + i,code,getApplicationContext());
                }
                coim.setBordCreateEnter(false,getApplicationContext());
                startActivity(new Intent(createorg.this,orgsaver.class));
                if(coim.getAnimationOn(getApplicationContext()))
                    overridePendingTransition(R.anim.fromleft,R.anim.fromright);
            }
        }
    }
    void moveAway(View v)
    {
        Animation a = AnimationUtils.loadAnimation(this,R.anim.fromright);
        v.startAnimation(a);
        v.setVisibility(View.INVISIBLE);
    }
    void moveBack(View v)
    {
        Animation a = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        v.setVisibility(View.VISIBLE);
        v.startAnimation(a);
    }
    public void preStep(View v)
    {
        firstStep = true;
        comeBack = true;
        moveBack(findViewById(R.id.bord));
        moveBack(findViewById(R.id.selectTool));
        ((TextView)findViewById(R.id.stepX)).setText("step1");
        ((TextView)findViewById(R.id.stepO)).setText("create your bord organization");
        ((TextView)findViewById(R.id.selctyourtool)).setText("select tool");
        findViewById(R.id.chooseName).setVisibility(View.INVISIBLE);
        findViewById(R.id.chooseName).startAnimation(AnimationUtils.loadAnimation(this,R.anim.righttoleft));
        v.setVisibility(View.INVISIBLE);
        v.startAnimation(AnimationUtils.loadAnimation(this,R.anim.righttoleft));
    }
    String oldText = "";

    @Override
    protected void onResume() {
        super.onResume();
        if(!coim.getBordCreateEnter(getApplicationContext()))
        {
            startActivity(new Intent(createorg.this,orgsaver.class));
            if(coim.getAnimationOn(getApplicationContext()))
                overridePendingTransition(R.anim.fromleft,R.anim.fromright);
        }
    }
}