package com.project.pagefaultfinder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void fcfs(View v)
    {
        Intent i = new Intent(this,Main4Activity.class);
        startActivity(i);
    }
    public void lru(View v)
    {
        Intent i = new Intent(this,Main5Activity.class );
        startActivity(i);
    }
    public void opr(View v)
    {
        Intent i = new Intent(this,Main6Activity.class);
        startActivity(i);
    }
    public void next(View v)
    {
        Intent i = new Intent(this,Main7Activity.class);
        startActivity(i);

    }
}
