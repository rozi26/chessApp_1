package com.example.learnchess;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class menu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        coim.setLastOnlineData(data.getTime(),getApplicationContext()); // update that enter to the game
        ImageView backImage = findViewById(R.id.backImage);
        ((ViewGroup)findViewById(R.id.page)).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        TextView t1 = findViewById(R.id.leesenRmain);
        t1.setText("Lessons remained");
        TextView title = findViewById(R.id.title);
        title.setText(data.getTimeMessege());
        Button leesenNum = findViewById(R.id.therlessen);
        leesenNum.setText(coim.getLesNumRm(getApplicationContext()) + "");
        try {
            level = coim.getStartLevel(getApplicationContext());
            if(level != 'e' && level != 'n' && level != 'h')
                startActivity(new Intent(menu.this,MainActivity.class));
        }
        catch (Exception e)
        {
            startActivity(new Intent(menu.this,MainActivity.class));
        }
        if(level == 'e')
            backImage.setForeground(findViewById(R.id.saveEasy).getForeground());
        else if(level == 'n')
            backImage.setForeground(findViewById(R.id.saveMid).getForeground());
        else
            backImage.setForeground(findViewById(R.id.saveHard).getForeground());

    }
    char level;
    boolean dataShow = false;
    public void rmainClick(View view)
    {
        data.playUIClickSound(getApplicationContext());
        TextView t1 = findViewById(R.id.leesenRmain);
        TextView t2 = findViewById(R.id.toNext);
        if(dataShow)
        {
            //t1.setText("");
            t2.setText("");
        }
        else
        {
           // t1.setText("Lessons remained");
            if(level == 'e')
                t2.setText(30 - coim.getLes(getApplicationContext()) + " lessons remained to become intermediate");
            else if(level == 'n')
                t2.setText(60 - coim.getLes(getApplicationContext()) + " lessons remained to become expert");
        }
        dataShow = !dataShow;
        data.getCoimReport(getApplicationContext());
    }
    public void menuBottomClick(View v)
    {
        data.playUIClickSound(getApplicationContext());
        coim.setOnMenu(false,getApplicationContext());
        if(v.equals(findViewById(R.id.learnB)) || v.equals(findViewById(R.id.lernT)))
            startActivity(new Intent(menu.this,lessenPage.class));
        else if(v.equals(findViewById(R.id.botsB)) || v.equals(findViewById(R.id.bott)))
            startActivity(new Intent(menu.this,botspage.class));
        else if(v.equals(findViewById(R.id.staticT)) || v.equals(findViewById(R.id.staticB)))
            startActivity(new Intent(menu.this,stats.class));
        else if(v.equals(findViewById(R.id.settingB)) || v.equals(findViewById(R.id.settingT)))
            startActivity(new Intent(menu.this,settings.class));
        else
            coim.setOnMenu(true,getApplicationContext());
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
    @Override
    protected void onResume() {
        super.onResume();
        if(coim.getInGame(getApplicationContext()) && !coim.getLesOn(getApplicationContext()))
        {
            startActivity(new Intent(menu.this,lessonbord.class));
            overridePendingTransition(R.anim.noanim,R.anim.noanim);
        }
        if(!coim.getFirstEnter(getApplicationContext())) {
            startActivity(new Intent(menu.this, MainActivity.class));
            overridePendingTransition(R.anim.noanim,R.anim.noanim);
        }
        else
            coim.setOnMenu(true,getApplicationContext());
    }
}