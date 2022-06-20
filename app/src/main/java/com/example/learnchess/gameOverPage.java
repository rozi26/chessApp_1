package com.example.learnchess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class gameOverPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_page);
        TextView title = findViewById(R.id.title);
        String text = coim.getEndMessesge(getApplicationContext());
        title.setText(text);
        bot = levels.getBotByName(coim.getBotName(getApplicationContext()));
        if(text.equals("you win"))
        {
            if(!coim.getLesOn(getApplicationContext()) ) {
                if(data.getOrgOrg(getApplicationContext()).equals(data.getDefultOrg()))
                    coim.addIntByName(bot.getName() + "W",1,getApplicationContext());
                else if(data.getOrgOrg(getApplicationContext()).equals("960"))
                    coim.addIntByName(bot.getName() + "W960",1,getApplicationContext());
            }
            ImageView x = findViewById(R.id.backImage);
            ImageView y = findViewById(R.id.saveWin);
            x.setForeground(y.getForeground());
            findViewById(R.id.watchGame).setVisibility(View.VISIBLE);;
        }
        else if(!coim.getLesOn(getApplicationContext())) {
            findViewById(R.id.watchGame).setVisibility(View.VISIBLE);
            if(data.getOrgOrg(getApplicationContext()).equals(data.getDefultOrg()))
                coim.addIntByName(bot.getName() + "L",1,getApplicationContext());
            else if(data.getOrgOrg(getApplicationContext()).equals("960"))
                coim.addIntByName(bot.getName() + "L960",1,getApplicationContext());
        }
    }
    bot bot;
    public void tryAgain(View view)
    {
        data.playUIClickSound(getApplicationContext());
        startActivity(new Intent(gameOverPage.this,lessonbord.class));
        overridePendingTransition(R.anim.fromleft,R.anim.fromright);
    }
    public void goToMenu(View v)
    {
        data.playUIClickSound(getApplicationContext());
        if(coim.getLesOn(getApplicationContext()))
            startActivity(new Intent(gameOverPage.this,lessenPage.class));
        else
            startActivity(new Intent(gameOverPage.this,botspage.class));
        overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("in game " + coim.getInGame(getApplicationContext()));
        if(coim.getInGame(getApplicationContext()))
        {
            startActivity(new Intent(gameOverPage.this,lessonbord.class));
        }
        if(coim.getLesOn(getApplicationContext()))
            overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
        if(!coim.getGameOverPageEnter(getApplicationContext()))
        {
            coim.setGameOverPageEnter(true,getApplicationContext());
            startActivity(new Intent(gameOverPage.this,gameOverPage.class));
            overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
        }
        else
            coim.setGameOverPageEnter(false,getApplicationContext());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    public void watchGame(View v)
    {
        data.playUIClickSound(getApplicationContext());
        coim.setSaveBordCode(coim.getSave(getApplicationContext()),getApplicationContext());
        startActivity(new Intent(gameOverPage.this,FreeBord.class));
        overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
    }
}