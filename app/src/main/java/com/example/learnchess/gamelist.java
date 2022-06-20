package com.example.learnchess;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gamelist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamelist);
        for(int i = 1; i < 51; i++)
        {
            showTextByNum(i);
        }
        if(coim.getNumberOfSaves(getApplicationContext()) == 0)
        {
            thereGames = false;
            Button b = findViewById(R.id.deleteAll);
            b.setText("there are no games");
            b.setTextSize(30);
        }
    }
    boolean thereGames = true;
    void showTextByNum(int num) {
        TextView t1;
        TextView t2;
        TextView t3;
        TextView t4;
        Button t5;
        final String text = coim.getStringByName("save" + num + "SS", getApplicationContext());
        num = 51 - num;
        if(true)
        {
            if(num == 1)
            {
                t1 = findViewById(R.id.t1A);
                t2 = findViewById(R.id.t1B);
                t3 = findViewById(R.id.t1C);
                t4 = findViewById(R.id.t1D);
                t5 = findViewById(R.id.t1E);
            }
            else if(num == 2)
            {
                t1 = findViewById(R.id.t2A);
                t2 = findViewById(R.id.t2B);
                t3 = findViewById(R.id.t2C);
                t4 = findViewById(R.id.t2D);
                t5 = findViewById(R.id.t2E);
            }
            else if(num == 3)
            {
                t1 = findViewById(R.id.t3A);
                t2 = findViewById(R.id.t3B);
                t3 = findViewById(R.id.t3C);
                t4 = findViewById(R.id.t3D);
                t5 = findViewById(R.id.t3E);
            }
            else if(num == 4)
            {
                t1 = findViewById(R.id.t4A);
                t2 = findViewById(R.id.t4B);
                t3 = findViewById(R.id.t4C);
                t4 = findViewById(R.id.t4D);
                t5 = findViewById(R.id.t4E);
            }
            else if(num == 5)
            {
                t1 = findViewById(R.id.t5A);
                t2 = findViewById(R.id.t5B);
                t3 = findViewById(R.id.t5C);
                t4 = findViewById(R.id.t5D);
                t5 = findViewById(R.id.t5E);
            }
            else if(num == 6)
            {
                t1 = findViewById(R.id.t6A);
                t2 = findViewById(R.id.t6B);
                t3 = findViewById(R.id.t6C);
                t4 = findViewById(R.id.t6D);
                t5 = findViewById(R.id.t6E);
            }
            else if(num == 7)
            {
                t1 = findViewById(R.id.t7A);
                t2 = findViewById(R.id.t7B);
                t3 = findViewById(R.id.t7C);
                t4 = findViewById(R.id.t7D);
                t5 = findViewById(R.id.t7E);
            }
            else if(num == 8)
            {
                t1 = findViewById(R.id.t8A);
                t2 = findViewById(R.id.t8B);
                t3 = findViewById(R.id.t8C);
                t4 = findViewById(R.id.t8D);
                t5 = findViewById(R.id.t8E);
            }
            else if(num == 9)
            {
                t1 = findViewById(R.id.t9A);
                t2 = findViewById(R.id.t9B);
                t3 = findViewById(R.id.t9C);
                t4 = findViewById(R.id.t9D);
                t5 = findViewById(R.id.t9E);
            }
            else if(num == 10)
            {
                t1 = findViewById(R.id.t10A);
                t2 = findViewById(R.id.t10B);
                t3 = findViewById(R.id.t10C);
                t4 = findViewById(R.id.t10D);
                t5 = findViewById(R.id.t10E);
            }
            else if(num == 11)
            {
                t1 = findViewById(R.id.t11A);
                t2 = findViewById(R.id.t11B);
                t3 = findViewById(R.id.t11C);
                t4 = findViewById(R.id.t11D);
                t5 = findViewById(R.id.t11E);
            }
            else if(num == 12)
            {
                t1 = findViewById(R.id.t12A);
                t2 = findViewById(R.id.t12B);
                t3 = findViewById(R.id.t12C);
                t4 = findViewById(R.id.t12D);
                t5 = findViewById(R.id.t12E);
            }
            else if(num == 13)
            {
                t1 = findViewById(R.id.t13A);
                t2 = findViewById(R.id.t13B);
                t3 = findViewById(R.id.t13C);
                t4 = findViewById(R.id.t13D);
                t5 = findViewById(R.id.t13E);
            }
            else if(num == 14)
            {
                t1 = findViewById(R.id.t14A);
                t2 = findViewById(R.id.t14B);
                t3 = findViewById(R.id.t14C);
                t4 = findViewById(R.id.t14D);
                t5 = findViewById(R.id.t14E);
            }
            else if(num == 15)
            {
                t1 = findViewById(R.id.t15A);
                t2 = findViewById(R.id.t15B);
                t3 = findViewById(R.id.t15C);
                t4 = findViewById(R.id.t15D);
                t5 = findViewById(R.id.t15E);
            }
            else if(num == 16)
            {
                t1 = findViewById(R.id.t16A);
                t2 = findViewById(R.id.t16B);
                t3 = findViewById(R.id.t16C);
                t4 = findViewById(R.id.t16D);
                t5 = findViewById(R.id.t16E);
            }
            else if(num == 17)
            {
                t1 = findViewById(R.id.t17A);
                t2 = findViewById(R.id.t17B);
                t3 = findViewById(R.id.t17C);
                t4 = findViewById(R.id.t17D);
                t5 = findViewById(R.id.t17E);
            }
            else if(num == 18)
            {
                t1 = findViewById(R.id.t18A);
                t2 = findViewById(R.id.t18B);
                t3 = findViewById(R.id.t18C);
                t4 = findViewById(R.id.t18D);
                t5 = findViewById(R.id.t18E);
            }
            else if(num == 19)
            {
                t1 = findViewById(R.id.t19A);
                t2 = findViewById(R.id.t19B);
                t3 = findViewById(R.id.t19C);
                t4 = findViewById(R.id.t19D);
                t5 = findViewById(R.id.t19E);
            }
            else if(num == 20)
            {
                t1 = findViewById(R.id.t20A);
                t2 = findViewById(R.id.t20B);
                t3 = findViewById(R.id.t20C);
                t4 = findViewById(R.id.t20D);
                t5 = findViewById(R.id.t20E);
            }
            else if(num == 21)
            {
                t1 = findViewById(R.id.t21A);
                t2 = findViewById(R.id.t21B);
                t3 = findViewById(R.id.t21C);
                t4 = findViewById(R.id.t21D);
                t5 = findViewById(R.id.t21E);
            }
            else if(num == 22)
            {
                t1 = findViewById(R.id.t22A);
                t2 = findViewById(R.id.t22B);
                t3 = findViewById(R.id.t22C);
                t4 = findViewById(R.id.t22D);
                t5 = findViewById(R.id.t22E);
            }
            else if(num == 23)
            {
                t1 = findViewById(R.id.t23A);
                t2 = findViewById(R.id.t23B);
                t3 = findViewById(R.id.t23C);
                t4 = findViewById(R.id.t23D);
                t5 = findViewById(R.id.t23E);
            }
            else if(num == 24)
            {
                t1 = findViewById(R.id.t24A);
                t2 = findViewById(R.id.t24B);
                t3 = findViewById(R.id.t24C);
                t4 = findViewById(R.id.t24D);
                t5 = findViewById(R.id.t24E);
            }
            else if(num == 25)
            {
                t1 = findViewById(R.id.t25A);
                t2 = findViewById(R.id.t25B);
                t3 = findViewById(R.id.t25C);
                t4 = findViewById(R.id.t25D);
                t5 = findViewById(R.id.t25E);
            }
            else if(num == 26)
            {
                t1 = findViewById(R.id.t26A);
                t2 = findViewById(R.id.t26B);
                t3 = findViewById(R.id.t26C);
                t4 = findViewById(R.id.t26D);
                t5 = findViewById(R.id.t26E);
            }
            else if(num == 27)
            {
                t1 = findViewById(R.id.t27A);
                t2 = findViewById(R.id.t27B);
                t3 = findViewById(R.id.t27C);
                t4 = findViewById(R.id.t27D);
                t5 = findViewById(R.id.t27E);
            }
            else if(num == 28)
            {
                t1 = findViewById(R.id.t28A);
                t2 = findViewById(R.id.t28B);
                t3 = findViewById(R.id.t28C);
                t4 = findViewById(R.id.t28D);
                t5 = findViewById(R.id.t28E);
            }
            else if(num == 29)
            {
                t1 = findViewById(R.id.t29A);
                t2 = findViewById(R.id.t29B);
                t3 = findViewById(R.id.t29C);
                t4 = findViewById(R.id.t29D);
                t5 = findViewById(R.id.t29E);
            }
            else if(num == 30)
            {
                t1 = findViewById(R.id.t30A);
                t2 = findViewById(R.id.t30B);
                t3 = findViewById(R.id.t30C);
                t4 = findViewById(R.id.t30D);
                t5 = findViewById(R.id.t30E);
            }
            else if(num == 31)
            {
                t1 = findViewById(R.id.t31A);
                t2 = findViewById(R.id.t31B);
                t3 = findViewById(R.id.t31C);
                t4 = findViewById(R.id.t31D);
                t5 = findViewById(R.id.t31E);
            }
            else if(num == 32)
            {
                t1 = findViewById(R.id.t32A);
                t2 = findViewById(R.id.t32B);
                t3 = findViewById(R.id.t32C);
                t4 = findViewById(R.id.t32D);
                t5 = findViewById(R.id.t32E);
            }
            else if(num == 33)
            {
                t1 = findViewById(R.id.t33A);
                t2 = findViewById(R.id.t33B);
                t3 = findViewById(R.id.t33C);
                t4 = findViewById(R.id.t33D);
                t5 = findViewById(R.id.t33E);
            }
            else if(num == 34)
            {
                t1 = findViewById(R.id.t34A);
                t2 = findViewById(R.id.t34B);
                t3 = findViewById(R.id.t34C);
                t4 = findViewById(R.id.t34D);
                t5 = findViewById(R.id.t34E);
            }
            else if(num == 35)
            {
                t1 = findViewById(R.id.t35A);
                t2 = findViewById(R.id.t35B);
                t3 = findViewById(R.id.t35C);
                t4 = findViewById(R.id.t35D);
                t5 = findViewById(R.id.t35E);
            }
            else if(num == 36)
            {
                t1 = findViewById(R.id.t36A);
                t2 = findViewById(R.id.t36B);
                t3 = findViewById(R.id.t36C);
                t4 = findViewById(R.id.t36D);
                t5 = findViewById(R.id.t36E);
            }
            else if(num == 37)
            {
                t1 = findViewById(R.id.t37A);
                t2 = findViewById(R.id.t37B);
                t3 = findViewById(R.id.t37C);
                t4 = findViewById(R.id.t37D);
                t5 = findViewById(R.id.t37E);
            }
            else if(num == 38)
            {
                t1 = findViewById(R.id.t38A);
                t2 = findViewById(R.id.t38B);
                t3 = findViewById(R.id.t38C);
                t4 = findViewById(R.id.t38D);
                t5 = findViewById(R.id.t38E);
            }
            else if(num == 39)
            {
                t1 = findViewById(R.id.t39A);
                t2 = findViewById(R.id.t39B);
                t3 = findViewById(R.id.t39C);
                t4 = findViewById(R.id.t39D);
                t5 = findViewById(R.id.t39E);
            }
            else if(num == 40)
            {
                t1 = findViewById(R.id.t40A);
                t2 = findViewById(R.id.t40B);
                t3 = findViewById(R.id.t40C);
                t4 = findViewById(R.id.t40D);
                t5 = findViewById(R.id.t40E);
            }
            else if(num == 41)
            {
                t1 = findViewById(R.id.t41A);
                t2 = findViewById(R.id.t41B);
                t3 = findViewById(R.id.t41C);
                t4 = findViewById(R.id.t41D);
                t5 = findViewById(R.id.t41E);
            }
            else if(num == 42)
            {
                t1 = findViewById(R.id.t42A);
                t2 = findViewById(R.id.t42B);
                t3 = findViewById(R.id.t42C);
                t4 = findViewById(R.id.t42D);
                t5 = findViewById(R.id.t42E);
            }
            else if(num == 43)
            {
                t1 = findViewById(R.id.t43A);
                t2 = findViewById(R.id.t43B);
                t3 = findViewById(R.id.t43C);
                t4 = findViewById(R.id.t43D);
                t5 = findViewById(R.id.t43E);
            }
            else if(num == 44)
            {
                t1 = findViewById(R.id.t44A);
                t2 = findViewById(R.id.t44B);
                t3 = findViewById(R.id.t44C);
                t4 = findViewById(R.id.t44D);
                t5 = findViewById(R.id.t44E);
            }
            else if(num == 45)
            {
                t1 = findViewById(R.id.t45A);
                t2 = findViewById(R.id.t45B);
                t3 = findViewById(R.id.t45C);
                t4 = findViewById(R.id.t45D);
                t5 = findViewById(R.id.t45E);
            }
            else if(num == 46)
            {
                t1 = findViewById(R.id.t46A);
                t2 = findViewById(R.id.t46B);
                t3 = findViewById(R.id.t46C);
                t4 = findViewById(R.id.t46D);
                t5 = findViewById(R.id.t46E);
            }
            else if(num == 47)
            {
                t1 = findViewById(R.id.t47A);
                t2 = findViewById(R.id.t47B);
                t3 = findViewById(R.id.t47C);
                t4 = findViewById(R.id.t47D);
                t5 = findViewById(R.id.t47E);
            }
            else if(num == 48)
            {
                t1 = findViewById(R.id.t48A);
                t2 = findViewById(R.id.t48B);
                t3 = findViewById(R.id.t48C);
                t4 = findViewById(R.id.t48D);
                t5 = findViewById(R.id.t48E);
            }
            else if(num == 49)
            {
                t1 = findViewById(R.id.t49A);
                t2 = findViewById(R.id.t49B);
                t3 = findViewById(R.id.t49C);
                t4 = findViewById(R.id.t49D);
                t5 = findViewById(R.id.t49E);
            }
            else
            {
                t1 = findViewById(R.id.t50A);
                t2 = findViewById(R.id.t50B);
                t3 = findViewById(R.id.t50C);
                t4 = findViewById(R.id.t50D);
                t5 = findViewById(R.id.t50E);
            }

        }
        if(text.equals(""))
        {
            t1.setTextSize(0);
            t2.setTextSize(0);
            t3.setTextSize(0);
            t4.setTextSize(0);
            t5.getLayoutParams().height = 0;
        }
        else
        {
            String botName = "";
            String data = "";
            String time = "";
            String winner;
            char sit = text.charAt(1);
            if(sit == 'Q')
                winner = "you left";
            else if(sit == 'W')
                winner = "you won";
            else
                winner = "you lost";
            int level = 0;
            for (int i = 2; i < text.length(); i++)
            {
                char a = text.charAt(i);
                if(level == 0)
                {
                    if(a == 'T')
                        level++;
                    else
                        data += a;
                }
                else if(level == 1)
                {
                    if(a == 'W')
                        level++;
                    else
                        time += a;
                }
                else
                {
                    if(a == '@')
                        break;
                    else
                        botName += a;
                }
            }
            t1.setText("you vs " + botName);
            t2.setText("date: " + data);
            t3.setText("time: " + time);;
            t4.setText(winner);
        }
    }
    public void showGame(View v)
    {
        Context context = getApplicationContext();
        View b = v;
        if(b.equals(findViewById(R.id.t1E)))
            coim.setSaveBordCode(coim.getStringByName("save50SS",context),context);
        else if(b.equals(findViewById(R.id.t2E)))
            coim.setSaveBordCode(coim.getStringByName("save49SS",context),context);
        else if(b.equals(findViewById(R.id.t3E)))
            coim.setSaveBordCode(coim.getStringByName("save48SS",context),context);
        else if(b.equals(findViewById(R.id.t4E)))
            coim.setSaveBordCode(coim.getStringByName("save47SS",context),context);
        else if(b.equals(findViewById(R.id.t5E)))
            coim.setSaveBordCode(coim.getStringByName("save46SS",context),context);
        else if(b.equals(findViewById(R.id.t6E)))
            coim.setSaveBordCode(coim.getStringByName("save45SS",context),context);
        else if(b.equals(findViewById(R.id.t7E)))
            coim.setSaveBordCode(coim.getStringByName("save44SS",context),context);
        else if(b.equals(findViewById(R.id.t8E)))
            coim.setSaveBordCode(coim.getStringByName("save43SS",context),context);
        else if(b.equals(findViewById(R.id.t9E)))
            coim.setSaveBordCode(coim.getStringByName("save42SS",context),context);
        else if(b.equals(findViewById(R.id.t10E)))
            coim.setSaveBordCode(coim.getStringByName("save41SS",context),context);
        else if(b.equals(findViewById(R.id.t11E)))
            coim.setSaveBordCode(coim.getStringByName("save40SS",context),context);
        else if(b.equals(findViewById(R.id.t12E)))
            coim.setSaveBordCode(coim.getStringByName("save39SS",context),context);
        else if(b.equals(findViewById(R.id.t13E)))
            coim.setSaveBordCode(coim.getStringByName("save38SS",context),context);
        else if(b.equals(findViewById(R.id.t14E)))
            coim.setSaveBordCode(coim.getStringByName("save37SS",context),context);
        else if(b.equals(findViewById(R.id.t15E)))
            coim.setSaveBordCode(coim.getStringByName("save36SS",context),context);
        else if(b.equals(findViewById(R.id.t16E)))
            coim.setSaveBordCode(coim.getStringByName("save35SS",context),context);
        else if(b.equals(findViewById(R.id.t17E)))
            coim.setSaveBordCode(coim.getStringByName("save34SS",context),context);
        else if(b.equals(findViewById(R.id.t18E)))
            coim.setSaveBordCode(coim.getStringByName("save33SS",context),context);
        else if(b.equals(findViewById(R.id.t19E)))
            coim.setSaveBordCode(coim.getStringByName("save32SS",context),context);
        else if(b.equals(findViewById(R.id.t20E)))
            coim.setSaveBordCode(coim.getStringByName("save31SS",context),context);
        else if(b.equals(findViewById(R.id.t21E)))
            coim.setSaveBordCode(coim.getStringByName("save30SS",context),context);
        else if(b.equals(findViewById(R.id.t22E)))
            coim.setSaveBordCode(coim.getStringByName("save29SS",context),context);
        else if(b.equals(findViewById(R.id.t23E)))
            coim.setSaveBordCode(coim.getStringByName("save28SS",context),context);
        else if(b.equals(findViewById(R.id.t24E)))
            coim.setSaveBordCode(coim.getStringByName("save27SS",context),context);
        else if(b.equals(findViewById(R.id.t25E)))
            coim.setSaveBordCode(coim.getStringByName("save26SS",context),context);
        else if(b.equals(findViewById(R.id.t26E)))
            coim.setSaveBordCode(coim.getStringByName("save25SS",context),context);
        else if(b.equals(findViewById(R.id.t27E)))
            coim.setSaveBordCode(coim.getStringByName("save24SS",context),context);
        else if(b.equals(findViewById(R.id.t28E)))
            coim.setSaveBordCode(coim.getStringByName("save23SS",context),context);
        else if(b.equals(findViewById(R.id.t29E)))
            coim.setSaveBordCode(coim.getStringByName("save22SS",context),context);
        else if(b.equals(findViewById(R.id.t30E)))
            coim.setSaveBordCode(coim.getStringByName("save21SS",context),context);
        else if(b.equals(findViewById(R.id.t31E)))
            coim.setSaveBordCode(coim.getStringByName("save20SS",context),context);
        else if(b.equals(findViewById(R.id.t32E)))
            coim.setSaveBordCode(coim.getStringByName("save19SS",context),context);
        else if(b.equals(findViewById(R.id.t33E)))
            coim.setSaveBordCode(coim.getStringByName("save18SS",context),context);
        else if(b.equals(findViewById(R.id.t34E)))
            coim.setSaveBordCode(coim.getStringByName("save17SS",context),context);
        else if(b.equals(findViewById(R.id.t35E)))
            coim.setSaveBordCode(coim.getStringByName("save16SS",context),context);
        else if(b.equals(findViewById(R.id.t36E)))
            coim.setSaveBordCode(coim.getStringByName("save15SS",context),context);
        else if(b.equals(findViewById(R.id.t37E)))
            coim.setSaveBordCode(coim.getStringByName("save14SS",context),context);
        else if(b.equals(findViewById(R.id.t38E)))
            coim.setSaveBordCode(coim.getStringByName("save13SS",context),context);
        else if(b.equals(findViewById(R.id.t39E)))
            coim.setSaveBordCode(coim.getStringByName("save12SS",context),context);
        else if(b.equals(findViewById(R.id.t40E)))
            coim.setSaveBordCode(coim.getStringByName("save11SS",context),context);
        else if(b.equals(findViewById(R.id.t41E)))
            coim.setSaveBordCode(coim.getStringByName("save10SS",context),context);
        else if(b.equals(findViewById(R.id.t42E)))
            coim.setSaveBordCode(coim.getStringByName("save9SS",context),context);
        else if(b.equals(findViewById(R.id.t43E)))
            coim.setSaveBordCode(coim.getStringByName("save8SS",context),context);
        else if(b.equals(findViewById(R.id.t44E)))
            coim.setSaveBordCode(coim.getStringByName("save7SS",context),context);
        else if(b.equals(findViewById(R.id.t45E)))
            coim.setSaveBordCode(coim.getStringByName("save6SS",context),context);
        else if(b.equals(findViewById(R.id.t46E)))
            coim.setSaveBordCode(coim.getStringByName("save5SS",context),context);
        else if(b.equals(findViewById(R.id.t47E)))
            coim.setSaveBordCode(coim.getStringByName("save4SS",context),context);
        else if(b.equals(findViewById(R.id.t48E)))
            coim.setSaveBordCode(coim.getStringByName("save3SS",context),context);
        else if(b.equals(findViewById(R.id.t49E)))
            coim.setSaveBordCode(coim.getStringByName("save2SS",context),context);
        else
            coim.setSaveBordCode(coim.getStringByName("save1SS",context),context);
        data.playUIClickSound(getApplicationContext());
        startActivity(new Intent(gamelist.this,FreeBord.class));
        if(coim.getAnimationOn(getApplicationContext()))
            overridePendingTransition(R.anim.lefttoright,R.anim.righttoleft);
    }
    public void menuBottomClick(View v)
    {
        data.playUIClickSound(getApplicationContext());
        coim.setOnMenu(false,getApplicationContext());
        if(v.equals(findViewById(R.id.learnB)) || v.equals(findViewById(R.id.lernT)))
            startActivity(new Intent(gamelist.this,lessenPage.class));
        else if(v.equals(findViewById(R.id.botsB)) || v.equals(findViewById(R.id.bott)))
            startActivity(new Intent(gamelist.this,botspage.class));
        else if(v.equals(findViewById(R.id.staticT)) || v.equals(findViewById(R.id.staticB)))
            startActivity(new Intent(gamelist.this,stats.class));
        else if(v.equals(findViewById(R.id.homeB)) || v.equals(findViewById(R.id.homeT)))
            startActivity(new Intent(gamelist.this,menu.class));
        else if(v.equals(findViewById(R.id.settingB)) || v.equals(findViewById(R.id.settingT)))
            startActivity(new Intent(gamelist.this,settings.class));
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

    public void deleateAll(View v)
    {
        data.playUIClickSound(getApplicationContext());
       if(thereGames)
       {
           Button b = (Button)v;
           if(b.getText().equals("are you sure"))
           {
               for(int i = 1; i < 51; i++)
               {
                   coim.setStringByName("save" + i + "SS","",getApplicationContext());
               }
               coim.setNumberOfSaves(0,getApplicationContext());
               startActivity(new Intent(gamelist.this,gamelist.class));
           }
           else
               b.setText("are you sure");
       }
       else {
           startActivity(new Intent(gamelist.this, stats.class));
           overridePendingTransition(R.anim.lowtolow,R.anim.lowtoup);
       }
    }
}