package com.javamaster3000.ticktacktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button startgame,outgame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startgame = (Button) findViewById(R.id.iniciarJuego);
        startgame.setOnClickListener(this);

        outgame =(Button) findViewById(R.id.salirjuego);
        outgame.setOnClickListener(this);

        outgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View salir) {
                System.exit(0);
            }
        });


    }

    @Override
    public void onClick(View view) {
    switch(view.getId()){
        case R.id.iniciarJuego:
            Intent otraVentana= new Intent (MainActivity.this,Juego.class);
            startActivity(otraVentana);
    }


    }
}