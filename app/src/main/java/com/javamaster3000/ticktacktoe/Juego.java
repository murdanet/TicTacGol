package com.javamaster3000.ticktacktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Juego extends AppCompatActivity implements View.OnClickListener {
    private Chronometer cronometrog;
    private boolean running;
    private long pauseoffset;
    boolean messiGana = false, mbappeGana = false;
    TextView j1, j2;
    int[] ttg = new int[9];
    int random;
    ImageView unog, dosg, tresg, cuatrog, cincog, seisg, sieteg, ochog, nueveg;
    Button salidag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        unog = (ImageView) findViewById(R.id.uno);
        unog.setOnClickListener(this);

        dosg = (ImageView) findViewById(R.id.dos);
        dosg.setOnClickListener(this);

        tresg = (ImageView) findViewById(R.id.tres);
        tresg.setOnClickListener(this);

        cuatrog = (ImageView) findViewById(R.id.cuatro);
        cuatrog.setOnClickListener(this);

        cincog = (ImageView) findViewById(R.id.cinco);
        cincog.setOnClickListener(this);

        seisg = (ImageView) findViewById(R.id.seis);
        seisg.setOnClickListener(this);

        sieteg = (ImageView) findViewById(R.id.siete);
        sieteg.setOnClickListener(this);

        ochog = (ImageView) findViewById(R.id.ocho);
        ochog.setOnClickListener(this);

        nueveg = (ImageView) findViewById(R.id.nueve);
        nueveg.setOnClickListener(this);


        j1 = (TextView) findViewById(R.id.messi);
        j2 = (TextView) findViewById(R.id.mbappe);

        cronometrog = (Chronometer) findViewById(R.id.cronometro);
        cronometrog.setFormat("Time: %");
        cronometrog.setBase(SystemClock.elapsedRealtime());

        salidag = (Button) findViewById(R.id.salida);
        salidag.setOnClickListener(this);

        salidag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View salir) {
                System.exit(0);
            }
        });


    }

    public void iniciar(View i) {
        //Metodo para que una vez se pause y reanudemos continuemos con el cronometro.
        if (!running) {
            cronometrog.setBase(SystemClock.elapsedRealtime() - pauseoffset);
            cronometrog.start();
            j1.setText("Messi");
            j2.setText("Mbappe");
            running = true;


        }

    }

    public void pausarJuego(View p) {

        if (running) {
            cronometrog.stop();
            pauseoffset = SystemClock.elapsedRealtime() - cronometrog.getBase();
            running = false;
        }

    }

    public void resetear(View r) {
        cronometrog.setBase(SystemClock.elapsedRealtime());
        pauseoffset = 0;
        cronometrog.start();
        j1.setText("Messi");
        j2.setText("Mbappe");

        unog.setImageDrawable(null);
        dosg.setImageDrawable(null);
        tresg.setImageDrawable(null);
        cuatrog.setImageDrawable(null);
        cincog.setImageDrawable(null);
        seisg.setImageDrawable(null);
        sieteg.setImageDrawable(null);
        ochog.setImageDrawable(null);
        nueveg.setImageDrawable(null);

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.uno:
                if (ttg[0] == 0) {
                    unog.setImageResource(R.drawable.messicara_low);
                    ttg[0] = 1;
                    ChequeoVictoriaMessi();
                    TurnoDeMbappe();
                }
                break;

            case R.id.dos:
                if (ttg[1] == 0) {
                    dosg.setImageResource(R.drawable.messicara_low);
                    ttg[1] = 1;
                    ChequeoVictoriaMessi();
                    TurnoDeMbappe();
                }
                break;
            case R.id.tres:
                if (ttg[2] == 0) {
                    dosg.setImageResource(R.drawable.messicara_low);
                    ttg[2] = 1;
                    ChequeoVictoriaMessi();
                    TurnoDeMbappe();
                }
                break;

            case R.id.cuatro:
                if (ttg[3] == 0) {
                    dosg.setImageResource(R.drawable.messicara_low);
                    ttg[3] = 1;
                    ChequeoVictoriaMessi();
                    TurnoDeMbappe();
                }
                break;

            case R.id.cinco:
                if (ttg[4] == 0) {
                    dosg.setImageResource(R.drawable.messicara_low);
                    ttg[4] = 1;
                    ChequeoVictoriaMessi();
                    TurnoDeMbappe();
                }
                break;

            case R.id.seis:
                if (ttg[5] == 0) {
                    dosg.setImageResource(R.drawable.messicara_low);
                    ttg[6] = 1;
                    ChequeoVictoriaMessi();
                    TurnoDeMbappe();
                }
                break;

            case R.id.siete:
                if (ttg[6] == 0) {
                    dosg.setImageResource(R.drawable.messicara_low);
                    ttg[6] = 1;
                    ChequeoVictoriaMessi();
                    TurnoDeMbappe();
                }
                break;

            case R.id.ocho:
                if (ttg[7] == 0) {
                    dosg.setImageResource(R.drawable.messicara_low);
                    ttg[7] = 1;
                    ChequeoVictoriaMessi();
                    TurnoDeMbappe();
                }
                break;

            case R.id.nueve:
                if (ttg[8] == 0) {
                    dosg.setImageResource(R.drawable.messicara_low);
                    ttg[8] = 1;
                    ChequeoVictoriaMessi();
                    TurnoDeMbappe();
                }
                break;
        }


    }

    public void TurnoDeMbappe() {
//Metodo para calcular con Random el turno de Mbappe donde caerá
        if (mbappeGana = false) {
            random = (int) (8 * Math.random()) + 1;
            if (ttg[random] == 0) {
                switch (random) {
                    case 0:
                        unog.setImageResource(R.drawable.mpapo_low);break;
                    case 1:
                        dosg.setImageResource(R.drawable.mpapo_low);break;
                    case 2:
                        tresg.setImageResource(R.drawable.mpapo_low);break;
                    case 3:
                        cuatrog.setImageResource(R.drawable.mpapo_low);break;
                    case 4:
                        cincog.setImageResource(R.drawable.mpapo_low);break;
                    case 5:
                        seisg.setImageResource(R.drawable.mpapo_low);break;
                    case 6:
                        sieteg.setImageResource(R.drawable.mpapo_low);break;
                    case 7:
                        ochog.setImageResource(R.drawable.mpapo_low);break;
                    case 8:
                        nueveg.setImageResource(R.drawable.mpapo_low);break;
                }
                //Mbappe ocupará la posición 1, contradiciendo a Leo Messi, pero aquí ponemos al numero 2
                ttg[random] = 2;
                ChequeoVictoriaMessi();
            } else {
                TurnoDeMbappe();
            }
        }

    }

    public void ChequeoVictoriaMessi() {
        if (ttg[0] == 1 && ttg[1] == 1 && ttg[2] == 1) messiGana = true;
        if (ttg[3] == 1 && ttg[4] == 1 && ttg[5] == 1) messiGana = true;
        if (ttg[6] == 1 && ttg[7] == 1 && ttg[8] == 1) messiGana = true;

        if (ttg[5] == 1 && ttg[7] == 1 && ttg[8] == 1) messiGana = true;
        if (ttg[3] == 1 && ttg[4] == 1 && ttg[5] == 1) messiGana = true;
        if (ttg[6] == 1 && ttg[7] == 1 && ttg[8] == 1) messiGana = true;

        if (ttg[0] == 1 && ttg[3] == 1 && ttg[6] == 1) messiGana = true;
        if (ttg[1] == 1 && ttg[4] == 1 && ttg[7] == 1) messiGana = true;
        if (ttg[2] == 1 && ttg[5] == 1 && ttg[8] == 1) messiGana = true;

        if (ttg[6] == 1 && ttg[3] == 1 && ttg[0] == 1) messiGana = true;
        if (ttg[7] == 1 && ttg[4] == 1 && ttg[1] == 1) messiGana = true;
        if (ttg[8] == 1 && ttg[5] == 1 && ttg[2] == 1) messiGana = true;

        if (ttg[8] == 1 && ttg[4] == 1 && ttg[0] == 1) messiGana = true;
        if (ttg[6] == 1 && ttg[4] == 1 && ttg[2] == 1) messiGana = true;
        if (ttg[2] == 1 && ttg[4] == 1 && ttg[6] == 1) messiGana = true;
        if (ttg[0] == 1 && ttg[4] == 1 && ttg[8] == 1) messiGana = true;

        if (messiGana = true) {
            Toast mensaje = Toast.makeText(this, "Gano el mejor de la historia: Leo Messi", Toast.LENGTH_LONG);
            mensaje.show();
            cronometrog.stop();
            borrar();

        }

        if (ttg[0] == 2 && ttg[1] == 2 && ttg[2] == 2) mbappeGana = true;
        if (ttg[3] == 2 && ttg[4] == 2 && ttg[5] == 2) mbappeGana = true;
        if (ttg[6] == 2 && ttg[7] == 2 && ttg[8] == 2) mbappeGana = true;

        if (ttg[5] == 2 && ttg[7] == 2 && ttg[8] == 2) mbappeGana = true;
        if (ttg[3] == 2 && ttg[4] == 2 && ttg[5] == 2) mbappeGana = true;
        if (ttg[6] == 2 && ttg[7] == 2 && ttg[8] == 2) mbappeGana = true;

        if (ttg[0] == 2 && ttg[3] == 2 && ttg[6] == 2) mbappeGana = true;
        if (ttg[1] == 2 && ttg[4] == 2 && ttg[7] == 2) mbappeGana = true;
        if (ttg[2] == 2 && ttg[5] == 2 && ttg[8] == 2) mbappeGana = true;

        if (ttg[6] == 2 && ttg[3] == 2 && ttg[0] == 2) mbappeGana = true;
        if (ttg[7] == 2 && ttg[4] == 2 && ttg[1] == 2) mbappeGana = true;
        if (ttg[8] == 2 && ttg[5] == 2 && ttg[2] == 2) mbappeGana = true;

        if (ttg[8] == 2 && ttg[4] == 2 && ttg[0] == 2) mbappeGana = true;
        if (ttg[6] == 2 && ttg[4] == 2 && ttg[2] == 2) mbappeGana = true;
        if (ttg[2] == 2 && ttg[4] == 2 && ttg[6] == 2) mbappeGana = true;
        if (ttg[0] == 2 && ttg[4] == 2 && ttg[8] == 2) mbappeGana = true;

        if (mbappeGana = true) {
            Toast mensaje = Toast.makeText(this, "Gano el mejor jugador juvenil: Mbappe", Toast.LENGTH_LONG);
            mensaje.show();
            cronometrog.stop();
            borrar();
        }
    }

    public void borrar() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                unog.setImageDrawable(null);
                dosg.setImageDrawable(null);
                tresg.setImageDrawable(null);
                cuatrog.setImageDrawable(null);
                cincog.setImageDrawable(null);
                seisg.setImageDrawable(null);
                sieteg.setImageDrawable(null);
                ochog.setImageDrawable(null);
                nueveg.setImageDrawable(null);


                messiGana = false;
                mbappeGana = false;
                cronometrog.setText("00:00");
                j1.setText("");
                j2.setText("");

                for (int i = 0; i <= 8; i++) {
                    ttg[i] = 0;
                }
            }

        }, 3000);
    }
}
