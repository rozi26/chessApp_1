package com.example.learnchess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.animation.LayoutTransition;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("fafdsefesrf////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
        setContentView(R.layout.activity_main);
        ((ViewGroup)findViewById(R.id.page)).getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        TextView t = findViewById(R.id.Iam);
        t.setText("I am");
        Button b = findViewById(R.id.donw);
        b.setVisibility(View.INVISIBLE);
        String getLevel = coim.getStartLevelS(getApplicationContext());
        if(!getLevel.equals(""))
            startActivity(new Intent(MainActivity.this,menu.class));
    }
    char level = 'N';
    public void chooseClick(View v)
    {
        Animation a = AnimationUtils.loadAnimation(this,R.anim.cancelsize);
        RelativeLayout r1 = findViewById(R.id.start);
        RelativeLayout r2 = findViewById(R.id.mid);
        RelativeLayout r3 = findViewById(R.id.hard);
         r1.startAnimation(a);
        r2.startAnimation(a);
        r3.startAnimation(a);/**/
        RelativeLayout r = (RelativeLayout)v;
        TextView title = findViewById(R.id.Iam);
        title.setVisibility(View.GONE);
        title.setVisibility(View.VISIBLE);
        r.setVisibility(View.GONE);
        r.setVisibility(View.VISIBLE);
        if(r.equals(findViewById(R.id.mid))) {
            level = 'n';
            title.setText("I am intermediate");
        }
        else if(r.equals(findViewById(R.id.hard))) {
            level = 'h';
            title.setText("I am expert");
        }
        else {
            level = 'e';
            title.setText("I am beginner");
        }
        if(hider)
        {
            Button b = findViewById(R.id.donw);
            b.setVisibility(View.VISIBLE);
            b.startAnimation(AnimationUtils.loadAnimation(this,R.anim.lefttoright));
            hider = false;
        }
    }
    boolean hider = true;
    public void startPlay(View v)
    {
        //add the defualts orgs
        data.addOrg("default arrangement#default$T@" + data.getDefultOrg(),getApplicationContext());
        coim.setOrg("default arrangement#default$T@" + data.getDefultOrg(),getApplicationContext());
        data.addOrg("chees 960#default$T@" + "960",getApplicationContext());
        //data.addOrg("test bord1#you$f@" + "jnnnnnhjnnnngnnnnnnnnennnnnndgnnbnngnnnnnnnlnnnnnnnnnnnndbnnfnnn",getApplicationContext());
        TextView t = findViewById(R.id.Iam);
        coim.setRealStartLevel(level,getApplicationContext());
        coim.setStartLevel(level,getApplicationContext());
        coim.firstEnter(false,getApplicationContext());
        if(level == 'n')
            coim.setLes(30,getApplicationContext());
        else if(level == 'h')
            coim.setLes(60,getApplicationContext());
        else
            coim.setLes(0,getApplicationContext());
        startActivity(new Intent(MainActivity.this,menu.class));
        overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        final int length = findViewById(R.id.length).getWidth() / 3;
        findViewById(R.id.mid).getLayoutParams().width = length;
        findViewById(R.id.mid).requestLayout();
        findViewById(R.id.hard).getLayoutParams().width = length;
        findViewById(R.id.hard).requestLayout();
        findViewById(R.id.start).getLayoutParams().width = length;
        findViewById(R.id.start).requestLayout();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(coim.getFirstEnter(getApplicationContext()))
        {
            startActivity(new Intent(MainActivity.this,menu.class));
            overridePendingTransition(R.anim.noanim,R.anim.noanim);
        }
    }
}