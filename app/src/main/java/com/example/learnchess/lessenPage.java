package com.example.learnchess;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class lessenPage extends AppCompatActivity {

    final boolean activate = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessen_page);
        currectLevel = levels.getFromLevelList(coim.getLes(getApplicationContext()),getApplicationContext());
        if(coim.getAnimationOn(getApplicationContext()))
            ((ViewGroup)findViewById(R.id.page)).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        TextView title = findViewById(R.id.title);
        title.setText("lesson " + ((coim.getLes(getApplicationContext())) - data.getStartLevelMinus(getApplicationContext())));
        if(coim.getDataLevelShow(getApplicationContext())) {
            dataOff = false;
            showMoreDate();
        }
        if(currectLevel.isCanSkip())
            findViewById(R.id.skip).setVisibility(View.VISIBLE);

        if(activate == false)
        {
            findViewById(R.id.main).setVisibility(View.INVISIBLE);
            findViewById(R.id.offMenu).setVisibility(View.VISIBLE);
        }
    }
    boolean dataOff = true;
    level currectLevel;
    public void lessenClick(View v)
    {
        TextView data1 = findViewById(R.id.data1);
        TextView data2 = findViewById(R.id.data2);
        TextView data3 = findViewById(R.id.data3);
        if(dataOff)
        {
            showMoreDate();
        }
        else
        {
            int size = 14;
            data1.setTextSize(size);
            data2.setTextSize(size);
            data3.setTextSize(size);
            data1.setText("");
            data2.setText("");
            data3.setText("");
        }
        coim.setDataLevelShow(dataOff,getApplicationContext());
        dataOff = !dataOff;
    }
    void showMoreDate()
    {
        TextView data1 = findViewById(R.id.data1);
        TextView data2 = findViewById(R.id.data2);
        TextView data3 = findViewById(R.id.data3);
        int size = 28;
        data1.setTextSize(size);
        data2.setTextSize(size);
        data3.setTextSize(size);
        String level;
        char charLevel = coim.getStartLevel(getApplicationContext());
        if(charLevel == 'e')
            level = "beginner";
        else if(charLevel == 'n')
            level = "intermediate";
        else
            level = "expert";
        data2.setText("lesson level: " + level);
        Button startB = findViewById(R.id.startB);
        if(currectLevel.getAbout().equals(""))
        {
            data1.setText("this lesson will be ready soon");
            data2.setVisibility(View.INVISIBLE);
            startB.setVisibility(View.INVISIBLE);
        }
        else
        {
            data1.setText("about: " + currectLevel.getAbout());
            data2.setVisibility(View.VISIBLE);
            startB.setVisibility(View.VISIBLE);

        }
        //data3.setText(""currectLevel.getWith());
    }
    public void menuBottomClick(View v)
    {
        data.playUIClickSound(getApplicationContext());
        if(v.equals(findViewById(R.id.homeB)) || v.equals(findViewById(R.id.homeT)))
            startActivity(new Intent(lessenPage.this,menu.class));
        else if(v.equals(findViewById(R.id.botsB)) || v.equals(findViewById(R.id.botT)))
            startActivity(new Intent(lessenPage.this,botspage.class));
        else if(v.equals(findViewById(R.id.staticB)) || v.equals(findViewById(R.id.staticT)))
            startActivity(new Intent(lessenPage.this,stats.class));
        else if(v.equals(findViewById(R.id.settingB)) || v.equals(findViewById(R.id.settingT)))
            startActivity(new Intent(lessenPage.this,settings.class));
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
    public void startLevel(View v)
    {
        data.playUIClickSound(getApplicationContext());
        coim.setInGame(false,getApplicationContext());
        coim.setLesOn(true,getApplicationContext());
        startActivity(new Intent(lessenPage.this,lessonbord.class));
        overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
    }
    public void skipClick(View v)
    {
        data.playUIClickSound(getApplicationContext());
        TextView t = findViewById(R.id.skip);
        if(t.getText().equals("are you sure"))
        {
            coim.addLes(1,getApplicationContext());
            startActivity(new Intent(lessenPage.this,lessenPage.class));
            overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
        }
        else
        {
            t.setTextSize(28);
            t.setText("are you sure");
        }
    }

    public void useBeta(View v)
    {
        findViewById(R.id.offMenu).setVisibility(View.INVISIBLE);
        findViewById(R.id.main).setVisibility(View.VISIBLE);
    }
}