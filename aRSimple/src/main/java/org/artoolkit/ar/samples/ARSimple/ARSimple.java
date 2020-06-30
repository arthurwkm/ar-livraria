package org.artoolkit.ar.samples.ARSimple;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.artoolkit.ar.base.ARActivity;
import org.artoolkit.ar.base.camera.CaptureCameraPreview;
import org.artoolkit.ar.base.rendering.ARRenderer;

import java.util.ArrayList;
import java.util.List;


/**
 * A very simple example of extending ARActivity to create a new AR application.
 */
public class ARSimple extends ARActivity {

    MediaPlayer musicaFrevo;
    MediaPlayer musicaMaracatu;
    MediaPlayer musicaBaiao;

    MediaPlayer audioApresnt;
    MediaPlayer audioTutorial;
    MediaPlayer audioUltimaTela;

    MediaPlayer audioIndic_paco_do_frevo;
    MediaPlayer audioIntrod_paco_do_frevo;
    MediaPlayer audioProcure_objt_passist_de_frevo;
    MediaPlayer audioConquista_paco_do_frevo;

    MediaPlayer audioIndic_malakoff;
    MediaPlayer audioIntrod_malakoff;
    MediaPlayer audioProcure_obj_obs_astro;
    MediaPlayer audioConquista_torre_malakoff;

    MediaPlayer audioIndic_cais_sertao;
    MediaPlayer audioIntrod_cais_sertao;
    MediaPlayer audioProcure_obj_cangaceiro;
    MediaPlayer audioConquista_cais_sertao;

    MediaPlayer audioIndic_marcozero;
    MediaPlayer audioIntrod_marcozero;
    MediaPlayer audioProcure_obj_desc_rec;
    MediaPlayer audioConquista_marcozero;

    List musicList = new ArrayList<>();

    private int currentMarker;
    public boolean navegation = false;
    public boolean isTagFound;
    public boolean mapaTutorial = false;
    public boolean jafoiachievment[] = new boolean[4];
    public boolean jafoidestino[] = new boolean [4];

    RelativeLayout r0;
    RelativeLayout r1;
    RelativeLayout r2;
    RelativeLayout r3;
    RelativeLayout r4;
    RelativeLayout r5;

    boolean rotaescolhidamarcozero=false;
    boolean rotaescolhidamalakoff=false;
    boolean rotaescolhidacais=false;
    boolean rotaescolhidafrevo=false;

    boolean visitacomaudio=false;
    boolean visitaguiada=false;

    public int pontosvisitados;

    Button marcozeroachievment;
    Button caisachievment;
    Button frevoachievment;
    Button malakoffachievment;
    Button infocais;
    Button infomarcozero;
    Button infofrevo;
    Button infomalakoff;
    Button infocaisaudio;
    Button infomarcozeroaudio;
    Button infofrevoaudio;
    Button infomalakoffaudio;
    ImageView m;

    boolean marcozero;
    boolean cais;
    boolean malakoff;
    boolean frevo;

    boolean bool=false;

    boolean mostrarinfo=false;


    //    LOCALIZAÇÃO
    private LocationManager locationManager;
    private LocationListener locationListener;

    @Override
    public void onResume() {
        super.onResume();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_FULLSCREEN);
        findViewById(R.id.topLayout).setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_FULLSCREEN);
        findViewById(R.id.topLayout).setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_FULLSCREEN);

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_FULLSCREEN);
        findViewById(R.id.topLayout).setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE | View.SYSTEM_UI_FLAG_FULLSCREEN);

        musicaFrevo = MediaPlayer.create(this, R.raw.frevo);
        musicList.add(musicaFrevo);
        musicaMaracatu = MediaPlayer.create(this, R.raw.maracatu);
        musicList.add(musicaMaracatu);
        musicaBaiao = MediaPlayer.create(this, R.raw.asabranca);
        musicList.add(musicaBaiao);

        audioApresnt = MediaPlayer.create(this, R.raw.apresentacao);
        musicList.add(audioApresnt);
        audioTutorial = MediaPlayer.create(this, R.raw.tutorial);
        musicList.add(audioTutorial);
        audioUltimaTela = MediaPlayer.create(this, R.raw.ultima_tela);
        musicList.add(audioUltimaTela);

        audioIndic_paco_do_frevo = MediaPlayer.create(this, R.raw.indic_paco_do_frevo);
        musicList.add(audioIndic_paco_do_frevo);
        audioIntrod_paco_do_frevo = MediaPlayer.create(this, R.raw.introd_paco_do_frevo);
        musicList.add(audioIntrod_paco_do_frevo);
        audioProcure_objt_passist_de_frevo = MediaPlayer.create(this, R.raw.procure_objt_passist_de_frevo);
        musicList.add(audioProcure_objt_passist_de_frevo);
        audioConquista_paco_do_frevo = MediaPlayer.create(this, R.raw.conquista_paco_do_frevo);
        musicList.add(audioConquista_paco_do_frevo);

        audioIndic_malakoff = MediaPlayer.create(this, R.raw.indic_malakoff);
        musicList.add(audioIndic_malakoff);
        audioIntrod_malakoff = MediaPlayer.create(this, R.raw.introd_malakoff);
        musicList.add(audioIntrod_malakoff);
        audioProcure_obj_obs_astro = MediaPlayer.create(this, R.raw.procure_obj_obs_astro);
        musicList.add(audioProcure_obj_obs_astro);
        audioConquista_torre_malakoff = MediaPlayer.create(this, R.raw.conquista_torre_malakoff);
        musicList.add(audioConquista_torre_malakoff);

        audioIndic_cais_sertao = MediaPlayer.create(this, R.raw.indic_cais_sertao);
        musicList.add(audioIndic_cais_sertao);
        audioIntrod_cais_sertao = MediaPlayer.create(this, R.raw.introd_cais_sertao);
        musicList.add(audioIntrod_cais_sertao);
        audioProcure_obj_cangaceiro = MediaPlayer.create(this, R.raw.procure_obj_cangaceiro);
        musicList.add(audioProcure_obj_cangaceiro);
        audioConquista_cais_sertao = MediaPlayer.create(this, R.raw.conquista_cais_sertao);
        musicList.add(audioConquista_cais_sertao);

        audioIndic_marcozero = MediaPlayer.create(this, R.raw.indic_marcozero);
        musicList.add(audioIndic_marcozero);
        audioIntrod_marcozero = MediaPlayer.create(this, R.raw.introd_marcozero);
        musicList.add(audioIntrod_marcozero);
        audioProcure_obj_desc_rec = MediaPlayer.create(this, R.raw.procure_obj_desc_rec);
        musicList.add(audioProcure_obj_desc_rec);
        audioConquista_marcozero = MediaPlayer.create(this, R.raw.conquista_marcozero);
        musicList.add(audioConquista_marcozero);

        marcozeroachievment = (Button) findViewById(R.id.marcozeroachievment);
        caisachievment = (Button) findViewById(R.id.caisachievment);
        frevoachievment = (Button) findViewById(R.id.frevoachievment);
        malakoffachievment = (Button) findViewById(R.id.malakoffachievment);
        infocais = (Button) findViewById(R.id.infocais);
        infomarcozero = (Button) findViewById(R.id.infomarcozero);
        infofrevo = (Button) findViewById(R.id.infofrevo);
        infomalakoff = (Button) findViewById(R.id.infomalakoff);
        infocaisaudio = (Button) findViewById(R.id.infocaisaudio);
        infomarcozeroaudio = (Button) findViewById(R.id.infomarcozeroaudio);
        infofrevoaudio = (Button) findViewById(R.id.infofrevoaudio);
        infomalakoffaudio = (Button) findViewById(R.id.infomalakoffaudio);
        m = (ImageView) findViewById(R.id.mascote4);

        jafoidestino[0] = false;//marcozero
        jafoidestino[1] = false;//paço do frevo
        jafoidestino[2] = false;//cais
        jafoidestino[3] = false;//malakoff

        marcozero = false;
        cais = false;
        frevo = false;
        malakoff = false;


        // Acquire a reference to the system Location Manager
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        // Define a listener that responds to location updates
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if (navegation) {
                    if ((location.getLatitude() <= -8.062502) && (location.getLatitude() >= -8.063531) && (location.getLongitude() >= -34.871648) && (location.getLongitude() <= -34.870949)) {
                        if (marcozeroachievment.getVisibility() != marcozeroachievment.VISIBLE) {
                            TextView txt = (TextView) findViewById(R.id.turismo);
                            txt.setText("Você está no Marco Zero!");
                            marcozero = true;
                            cais = false;
                            malakoff = false;
                            frevo = false;
                            if (!visitaguiada) {
                                desaparecer(findViewById(R.id.textoseta));
                            }
                            if (!jafoidestino[0]) {
                                if(visitacomaudio) {
                                    infomarcozeroaudio.setVisibility(infomarcozeroaudio.VISIBLE);
                                }else {
                                    infomarcozero.setVisibility(infomarcozero.VISIBLE);
                                }
                                    findViewById(R.id.mostrarinfo).setVisibility(findViewById(R.id.mostrarinfo).VISIBLE);
                                    findViewById(R.id.seguirvisita).setVisibility(findViewById(R.id.seguirvisita).VISIBLE);
                                    playAudio(infomarcozero);
                                    jafoidestino[0] = true;

                            }
                        }
                    }
//                LOCALIZAÇÃO CESAR
//                (location.getLatitude() <= -8.059503) && (location.getLatitude() >= -8.059900) && (location.getLongitude() >= -34.872900) && (location.getLongitude() <= -34.871825)
                    else if ((location.getLatitude() <= -8.060986) && (location.getLatitude() >= -8.061458) && (location.getLongitude() >= -34.871706) && (location.getLongitude() <= -34.871194)) {
                        if (frevoachievment.getVisibility() != frevoachievment.VISIBLE) {
                            TextView txt = (TextView) findViewById(R.id.turismo);
                            txt.setText("Você está no Paço do Frevo!");
                            marcozero = false;
                            cais = false;
                            malakoff = false;
                            frevo = true;

                            if (!visitaguiada) {
                                desaparecer(findViewById(R.id.textoseta));
                            }

                            if (!jafoidestino[1]) {
                                if(visitacomaudio) {
                                    infofrevoaudio.setVisibility(infofrevoaudio.VISIBLE);
                                }else {
                                    infofrevo.setVisibility(infofrevo.VISIBLE);
                                }
                                    findViewById(R.id.mostrarinfo).setVisibility(findViewById(R.id.mostrarinfo).VISIBLE);
                                    findViewById(R.id.seguirvisita).setVisibility(findViewById(R.id.seguirvisita).VISIBLE);
                                    playAudio(infofrevo);
                                    jafoidestino[1] = true;

                            }
                        }
                    } else if ((location.getLatitude() <= -8.059442) && (location.getLatitude() >= -8.059894) && (location.getLongitude() >= -34.870165) && (location.getLongitude() <= -34.869607)) {
                        if (caisachievment.getVisibility() != caisachievment.VISIBLE) {
                            TextView txt = (TextView) findViewById(R.id.turismo);
                            txt.setText("Você está no Cais do Sertão!");
                            marcozero = false;
                            cais = true;
                            malakoff = false;
                            frevo = false;
                            if (!visitaguiada) {
                                desaparecer(findViewById(R.id.textoseta));
                            }
                            if (!jafoidestino[2]) {
                                if(visitacomaudio) {
                                    infocaisaudio.setVisibility(infocaisaudio.VISIBLE);
                                }else {
                                    infocais.setVisibility(infocais.VISIBLE);
                                }
                                    findViewById(R.id.mostrarinfo).setVisibility(findViewById(R.id.mostrarinfo).VISIBLE);
                                    findViewById(R.id.seguirvisita).setVisibility(findViewById(R.id.seguirvisita).VISIBLE);
                                    playAudio(infocais);
                                    jafoidestino[2] = true;

                            }
                        }
                    } else if ((location.getLatitude() <= -8.060296) && (location.getLatitude() >= -8.061054) && (location.getLongitude() >= -34.871261) && (location.getLongitude() <= -34.870596)) {
                        if (malakoffachievment.getVisibility() != malakoffachievment.VISIBLE) {
                            TextView txt = (TextView) findViewById(R.id.turismo);
                            txt.setText("Você está na Torre Malakoff!");
                            marcozero = false;
                            cais = false;
                            malakoff = true;
                            frevo = false;
                            if (!visitaguiada) {
                                desaparecer(findViewById(R.id.textoseta));
                            }
                            if (!jafoidestino[3]) {
                                if(visitacomaudio) {
                                    infomalakoffaudio.setVisibility(infomalakoffaudio.VISIBLE);
                                }else {
                                    infomalakoff.setVisibility(infomalakoff.VISIBLE);
                                }
                                    findViewById(R.id.mostrarinfo).setVisibility(findViewById(R.id.mostrarinfo).VISIBLE);
                                    findViewById(R.id.seguirvisita).setVisibility(findViewById(R.id.seguirvisita).VISIBLE);
                                    playAudio(infomalakoff);
                                    jafoidestino[3] = true;

                            }
                        }
                    } else {
//                        TextView txt = (TextView) findViewById(R.id.turismo);
//                        txt.setText(location.getLatitude() + " " + location.getLongitude());
                        findViewById(R.id.mostrarinfo).setVisibility(findViewById(R.id.mostrarinfo).INVISIBLE);
                        findViewById(R.id.seta).setVisibility(findViewById(R.id.seta).VISIBLE);
                        findViewById(R.id.textoseta).setVisibility(findViewById(R.id.textoseta).VISIBLE);
                        findViewById(R.id.ignorarconquista).setVisibility(findViewById(R.id.ignorarconquista).INVISIBLE);
                    }
                }

            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };

        // Register the listener with the Location Manager to receive location updates
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);

        final Handler handler = new Handler();
        isTagFound = false;
        final Runnable r = new Runnable() {
            public void run() {
                if (isTagFound) {
                    displayView(currentMarker);
                } else {
                    displayView(-1);
                }
                handler.postDelayed(this, 1);
            }
        };
        handler.postDelayed(r, 1);
        //----------------------------------------------------------------------------------------
        jafoiachievment[0] = false;//marcozeroachievment
        jafoiachievment[1] = false;//caisachievment
        jafoiachievment[2] = false;//frevoachievment
        jafoiachievment[3] = false;//malakoffachievment

        jafoidestino[0]=false;//marcozero
        jafoidestino[1]=false;//paço do frevo
        jafoidestino[2]=false;//cais
        jafoidestino[3]=false;//malakoff

        pontosvisitados=0;

        bool=false;
        //----------------------------------------------------------------------------------------
        r0 = (RelativeLayout) findViewById(R.id.tela0);
        r1 = (RelativeLayout) findViewById(R.id.tela1);
        r2 = (RelativeLayout) findViewById(R.id.tela2);
        r3 = (RelativeLayout) findViewById(R.id.tela3);
        r4 = (RelativeLayout) findViewById(R.id.tela4);
        r5 = (RelativeLayout) findViewById(R.id.tela5);
        r0.setVisibility(r0.VISIBLE);
        r1.setVisibility(r1.INVISIBLE);
        r2.setVisibility(r2.INVISIBLE);
        r3.setVisibility(r3.INVISIBLE);
        r4.setVisibility(r4.INVISIBLE);
        r5.setVisibility(r5.INVISIBLE);

    }

    //--------------------------------------------------------------------------------------------------

    public void proximaTela0(View view) {
        r0 = (RelativeLayout) findViewById(R.id.tela0);
        r1 = (RelativeLayout) findViewById(R.id.tela1);
        r0.setVisibility(r0.INVISIBLE);
        r1.setVisibility(r1.VISIBLE);
        if (!audioApresnt.isPlaying()) {
            pauseAllPlayingMusic();
            audioApresnt.start();
        }
    }

    public void proximaTela1(View view) {
        pauseAllPlayingMusic();
        r1 = (RelativeLayout) findViewById(R.id.tela1);
        r2 = (RelativeLayout) findViewById(R.id.tela2);
        r1.setVisibility(r1.INVISIBLE);
        r2.setVisibility(r2.VISIBLE);
        if(view==findViewById(R.id.proximo1audio)){
            visitacomaudio=true;
            playAudio(view);
            desativarTexto(view);
        }else{
            ativarTexto(view);
        }
    }

    public void proximaTela2(View view) {
        pauseAllPlayingMusic();
        r2 = (RelativeLayout) findViewById(R.id.tela2);
        r3 = (RelativeLayout) findViewById(R.id.tela3);
        r2.setVisibility(r2.INVISIBLE);
        r3.setVisibility(r3.VISIBLE);
        ativarVisitaGuiada(view);
        if(visitacomaudio){
            playAudio(view);
        }
    }

    public void proximaTela3(View view) {
        pauseAllPlayingMusic();
        r3 = (RelativeLayout) findViewById(R.id.tela3);
        r4 = (RelativeLayout) findViewById(R.id.tela4);
        r3.setVisibility(r3.INVISIBLE);
        r4.setVisibility(r4.VISIBLE);
        navegation = true;

    }
    //--------------------------------------------------------------------------------------------------
    public void ignorarConquista(View view){
        findViewById(R.id.seta).setVisibility(findViewById(R.id.seta).VISIBLE);
        findViewById(R.id.textoseta).setVisibility(findViewById(R.id.textoseta).VISIBLE);
        findViewById(R.id.ignorarconquista).setVisibility(findViewById(R.id.ignorarconquista).INVISIBLE);
        if(visitaguiada) {
            pontosvisitados++;
            visitaGuiada();
        }

    }
    //--------------------------------------------------------------------------------------------------
    public void desaparecerInfo(View view){
        if(findViewById(R.id.infomarcozero).getVisibility()==findViewById(R.id.infomarcozero).VISIBLE||
                findViewById(R.id.infomarcozeroaudio).getVisibility()==findViewById(R.id.infomarcozeroaudio).VISIBLE){
           view.setVisibility(view.INVISIBLE);
            if(visitacomaudio) {
                infomarcozeroaudio.setVisibility(infomarcozeroaudio.INVISIBLE);
            }else{
                infomarcozero.setVisibility(infomarcozero.INVISIBLE);
            }
            findViewById(R.id.mostrarinfo).setVisibility(findViewById(R.id.mostrarinfo).VISIBLE);
            findViewById(R.id.seta).setVisibility(findViewById(R.id.seta).INVISIBLE);
            findViewById(R.id.textoseta).setVisibility(findViewById(R.id.textoseta).INVISIBLE);
            if(!mostrarinfo) {
                findViewById(R.id.ignorarconquista).setVisibility(findViewById(R.id.ignorarconquista).VISIBLE);
            }
            mostrarinfo=false;
            pauseAllPlayingMusic();
            audioProcure_obj_desc_rec.start();
        }else if(findViewById(R.id.infocais).getVisibility()==findViewById(R.id.infocais).VISIBLE||
                findViewById(R.id.infocaisaudio).getVisibility()==findViewById(R.id.infocaisaudio).VISIBLE){
            view.setVisibility(view.INVISIBLE);
            if(visitacomaudio) {
                infocaisaudio.setVisibility(infocaisaudio.INVISIBLE);
            }else{
                infocais.setVisibility(infocais.INVISIBLE);
            }
            findViewById(R.id.mostrarinfo).setVisibility(findViewById(R.id.mostrarinfo).VISIBLE);
            findViewById(R.id.seta).setVisibility(findViewById(R.id.seta).INVISIBLE);
            findViewById(R.id.textoseta).setVisibility(findViewById(R.id.textoseta).INVISIBLE);
            if(!mostrarinfo) {
                findViewById(R.id.ignorarconquista).setVisibility(findViewById(R.id.ignorarconquista).VISIBLE);
            }
            mostrarinfo=false;
            pauseAllPlayingMusic();
            audioProcure_obj_cangaceiro.start();
        }else if(findViewById(R.id.infomalakoff).getVisibility()==findViewById(R.id.infomalakoff).VISIBLE||
                findViewById(R.id.infomalakoffaudio).getVisibility()==findViewById(R.id.infomalakoffaudio).VISIBLE){
            view.setVisibility(view.INVISIBLE);
            if(visitacomaudio) {
                infomalakoffaudio.setVisibility(infomalakoffaudio.INVISIBLE);
            }else{
                infomalakoff.setVisibility(infomalakoff.INVISIBLE);
            }
            findViewById(R.id.mostrarinfo).setVisibility(findViewById(R.id.mostrarinfo).VISIBLE);
            findViewById(R.id.seta).setVisibility(findViewById(R.id.seta).INVISIBLE);
            findViewById(R.id.textoseta).setVisibility(findViewById(R.id.textoseta).INVISIBLE);
            if(!mostrarinfo) {
                findViewById(R.id.ignorarconquista).setVisibility(findViewById(R.id.ignorarconquista).VISIBLE);
            }
            mostrarinfo=false;
            pauseAllPlayingMusic();
            audioProcure_obj_obs_astro.start();
        }else if(findViewById(R.id.infofrevo).getVisibility()==findViewById(R.id.infofrevo).VISIBLE||
                findViewById(R.id.infofrevoaudio).getVisibility()==findViewById(R.id.infofrevoaudio).VISIBLE){
            view.setVisibility(view.INVISIBLE);
            if(visitacomaudio) {
                infofrevoaudio.setVisibility(infofrevoaudio.INVISIBLE);
            }else{
                infofrevo.setVisibility(infofrevo.INVISIBLE);
            }
            findViewById(R.id.mostrarinfo).setVisibility(findViewById(R.id.mostrarinfo).VISIBLE);
            findViewById(R.id.seta).setVisibility(findViewById(R.id.seta).INVISIBLE);
            findViewById(R.id.textoseta).setVisibility(findViewById(R.id.textoseta).INVISIBLE);
            if(!mostrarinfo) {
                findViewById(R.id.ignorarconquista).setVisibility(findViewById(R.id.ignorarconquista).VISIBLE);
            }
            mostrarinfo=false;
            pauseAllPlayingMusic();
            audioProcure_objt_passist_de_frevo.start();
        }
    }

    public void mostrarInfo(View view){
        if(marcozero){
            if(visitacomaudio) {
                infomarcozeroaudio.setVisibility(infomarcozeroaudio.VISIBLE);
            }else{
                infomarcozero.setVisibility(infomarcozero.VISIBLE);
            }
            findViewById(R.id.seguirvisita).setVisibility(findViewById(R.id.seguirvisita).VISIBLE);
            mostrarinfo=true;
            playAudio(infomarcozero);

        } else if (cais) {
            if(visitacomaudio) {
                infocaisaudio.setVisibility(infocaisaudio.VISIBLE);
            }else{
                infocais.setVisibility(infocais.VISIBLE);
            }
            findViewById(R.id.seguirvisita).setVisibility(findViewById(R.id.seguirvisita).VISIBLE);
            mostrarinfo=true;
            playAudio(infocais);
        }else if (malakoff) {
            if(visitacomaudio) {
                infomalakoffaudio.setVisibility(infomalakoffaudio.VISIBLE);
            }else{
                infomalakoff.setVisibility(infomalakoff.VISIBLE);
            }
            findViewById(R.id.seguirvisita).setVisibility(findViewById(R.id.seguirvisita).VISIBLE);
            mostrarinfo=true;
            playAudio(infomalakoff);
        } else if (frevo) {
            if(visitacomaudio) {
                infofrevoaudio.setVisibility(infofrevoaudio.VISIBLE);
            }else{
                infofrevo.setVisibility(infofrevo.VISIBLE);
            }
            findViewById(R.id.seguirvisita).setVisibility(findViewById(R.id.seguirvisita).VISIBLE);
            mostrarinfo=true;
            playAudio(infofrevo);
        }
    }

    //-------------------------------------------------------------------------------------------------

    public void playAudio(View view){
        if(visitacomaudio){
            if (view == findViewById(R.id.proximo1audio)||view == findViewById(R.id.desativartexto2)) {
                findViewById(R.id.balaoapresentacao2).setVisibility(findViewById(R.id.balaoapresentacao2).INVISIBLE);
                findViewById(R.id.balao3pontos2).setVisibility(findViewById(R.id.balao3pontos2).VISIBLE);
                findViewById(R.id.balaoapresentacao3).setVisibility(findViewById(R.id.balaoapresentacao3).INVISIBLE);
                findViewById(R.id.balao3pontos3).setVisibility(findViewById(R.id.balao3pontos3).VISIBLE);
                if (!audioTutorial.isPlaying()) {
                    pauseAllPlayingMusic();
                    audioTutorial.start();
                    findViewById(R.id.balaoapresentacao2).setVisibility(findViewById(R.id.balaoapresentacao2).INVISIBLE);
                }
            } else if (view == findViewById(R.id.visitaguiada)||view == findViewById(R.id.desativartexto3)) {
                if (!audioIndic_paco_do_frevo.isPlaying()) {
                    pauseAllPlayingMusic();
                    audioIndic_paco_do_frevo.start();
                    findViewById(R.id.balaoapresentacao2).setVisibility(findViewById(R.id.balaoapresentacao2).INVISIBLE);
                }
            } else if (view == findViewById(R.id.infomarcozero)) {
                if (!audioIntrod_marcozero.isPlaying()) {
                    pauseAllPlayingMusic();
                    audioIntrod_marcozero.start();
                }
            } else if (view == findViewById(R.id.infocais)) {
                if (!audioIntrod_cais_sertao.isPlaying()) {
                    pauseAllPlayingMusic();
                    audioIntrod_cais_sertao.start();
                }
            } else if (view == findViewById(R.id.infomalakoff)) {
                if (!audioIntrod_malakoff.isPlaying()) {
                    pauseAllPlayingMusic();
                    audioIntrod_malakoff.start();
                }
            } else if (view == findViewById(R.id.infofrevo)) {
                if (!audioIntrod_paco_do_frevo.isPlaying()) {
                    pauseAllPlayingMusic();
                    audioIntrod_paco_do_frevo.start();
                }
            }
        }
    }
    //--------------------------------------------------------------------------------------------------
    public void criarRotas(View view){
        findViewById(R.id.seguirrota).setVisibility(View.VISIBLE);
        if(view==findViewById(R.id.destinomarcozero)){
            findViewById(R.id.tela5).setBackgroundResource(R.drawable.rotamarcozero);
            rotaescolhidamarcozero=true;
            rotaescolhidacais=false;
            rotaescolhidamalakoff=false;
            rotaescolhidafrevo=false;
        }else if(view==findViewById(R.id.destinocais)){
            findViewById(R.id.tela5).setBackgroundResource(R.drawable.rotacais);
            rotaescolhidamarcozero=false;
            rotaescolhidacais=true;
            rotaescolhidamalakoff=false;
            rotaescolhidafrevo=false;
        }else if(view==findViewById(R.id.destinomalakoff)){
            findViewById(R.id.tela5).setBackgroundResource(R.drawable.rotamalakoff);
            rotaescolhidamarcozero=false;
            rotaescolhidacais=false;
            rotaescolhidamalakoff=true;
            rotaescolhidafrevo=false;
        }else if(view==findViewById(R.id.destinofrevo)){
            findViewById(R.id.tela5).setBackgroundResource(R.drawable.rotafrevo);
            rotaescolhidamarcozero=false;
            rotaescolhidacais=false;
            rotaescolhidamalakoff=false;
            rotaescolhidafrevo=true;
        }
    }

    public void seguirRota(View view){
        findViewById(R.id.mapa4).setBackgroundResource(R.drawable.desativarmapa);
        desaparecer(findViewById(R.id.desativarvisitaguiada));
        findViewById(R.id.ativarvisitaguiada).setVisibility(findViewById(R.id.ativarvisitaguiada).VISIBLE);
        desativarVisitaGuiada(view);
        mapaTutorial=false;
        findViewById(R.id.textoseta).setVisibility(findViewById(R.id.textoseta).VISIBLE);
        visitaguiada=false;
        if(rotaescolhidamarcozero){
            findViewById(R.id.textoseta).setBackgroundResource(R.drawable.textomarcozero);
            rotaescolhidamarcozero=false;
        }else if(rotaescolhidacais){
            findViewById(R.id.textoseta).setBackgroundResource(R.drawable.textocais);
            rotaescolhidacais=false;
        }else if(rotaescolhidamalakoff){
            findViewById(R.id.textoseta).setBackgroundResource(R.drawable.textomalakoff);
            rotaescolhidamalakoff=false;
        }else if(rotaescolhidafrevo){
            findViewById(R.id.textoseta).setBackgroundResource(R.drawable.textofrevo);
            rotaescolhidafrevo=false;
        }
        desaparecer(findViewById(R.id.seguirrota));
        voltarMapa(findViewById(R.id.seguirrota));
    }
    //--------------------------------------------------------------------------------------------------
    public void ativarTexto(View view){
        visitacomaudio=false;
        findViewById(R.id.balaoapresentacao2).setVisibility(findViewById(R.id.balaoapresentacao2).VISIBLE);
        findViewById(R.id.balao3pontos2).setVisibility(findViewById(R.id.balao3pontos2).INVISIBLE);
        findViewById(R.id.balaoapresentacao3).setVisibility(findViewById(R.id.balaoapresentacao3).VISIBLE);
        findViewById(R.id.balao3pontos3).setVisibility(findViewById(R.id.balao3pontos3).INVISIBLE);
        findViewById(R.id.ativartexto).setVisibility(findViewById(R.id.ativartexto).INVISIBLE);
        findViewById(R.id.desativartexto).setVisibility(findViewById(R.id.desativartexto).VISIBLE);
        findViewById(R.id.ativartexto2).setVisibility(findViewById(R.id.ativartexto2).INVISIBLE);
        findViewById(R.id.desativartexto2).setVisibility(findViewById(R.id.desativartexto2).VISIBLE);
        findViewById(R.id.ativartexto3).setVisibility(findViewById(R.id.ativartexto3).INVISIBLE);
        findViewById(R.id.desativartexto3).setVisibility(findViewById(R.id.desativartexto3).VISIBLE);
        pauseAllPlayingMusic();
    }
    public void desativarTexto(View view){
        findViewById(R.id.balaoapresentacao2).setVisibility(findViewById(R.id.balaoapresentacao2).INVISIBLE);
        findViewById(R.id.balao3pontos2).setVisibility(findViewById(R.id.balao3pontos2).VISIBLE);
        findViewById(R.id.balaoapresentacao3).setVisibility(findViewById(R.id.balaoapresentacao3).INVISIBLE);
        findViewById(R.id.balao3pontos3).setVisibility(findViewById(R.id.balao3pontos3).VISIBLE);
        findViewById(R.id.ativartexto).setVisibility(findViewById(R.id.ativartexto).VISIBLE);
        findViewById(R.id.desativartexto).setVisibility(findViewById(R.id.desativartexto).INVISIBLE);
        findViewById(R.id.ativartexto2).setVisibility(findViewById(R.id.ativartexto2).VISIBLE);
        findViewById(R.id.desativartexto2).setVisibility(findViewById(R.id.desativartexto2).INVISIBLE);
        findViewById(R.id.ativartexto3).setVisibility(findViewById(R.id.ativartexto3).VISIBLE);
        findViewById(R.id.desativartexto3).setVisibility(findViewById(R.id.desativartexto3).INVISIBLE);
        visitacomaudio = true;
//        playAudio(view);
    }
    public void ativarVisitaGuiada(View view){
        findViewById(R.id.ativarvisitaguiada).setVisibility(findViewById(R.id.ativarvisitaguiada).INVISIBLE);
        findViewById(R.id.desativarvisitaguiada).setVisibility(findViewById(R.id.desativarvisitaguiada).VISIBLE);
        findViewById(R.id.textoseta).setVisibility(findViewById(R.id.textoseta).VISIBLE);
        visitaguiada=true;
        visitaGuiada();
    }
    public void desativarVisitaGuiada(View view){
        findViewById(R.id.desativarvisitaguiada).setVisibility(findViewById(R.id.desativarvisitaguiada).INVISIBLE);
        findViewById(R.id.ativarvisitaguiada).setVisibility(findViewById(R.id.ativarvisitaguiada).VISIBLE);
        visitaguiada=false;
        desaparecer(findViewById(R.id.textoseta));
    }
    //--------------------------------------------------------------------------------------------------
    public void visitaGuiada(){
        findViewById(R.id.mapa4).setBackgroundResource(R.drawable.mapa);
        ImageView textoseta=(ImageView)findViewById(R.id.textoseta);
        if(pontosvisitados==0){
            textoseta.setBackgroundResource(R.drawable.textofrevo);
        }else if(pontosvisitados==1){
            textoseta.setBackgroundResource(R.drawable.textomalakoff);
            if(!audioIndic_malakoff.isPlaying()){
                pauseAllPlayingMusic();
                audioIndic_malakoff.start();
            }
        }else if(pontosvisitados==2){
            textoseta.setBackgroundResource(R.drawable.textocais);
            if(!audioIndic_cais_sertao.isPlaying()){
                pauseAllPlayingMusic();
                audioIndic_cais_sertao.start();
            }
        }else if(pontosvisitados==3){
            textoseta.setBackgroundResource(R.drawable.textomarcozero);
            if(!audioIndic_marcozero.isPlaying()){
                pauseAllPlayingMusic();
                audioIndic_marcozero.start();
            }
        }else{
            findViewById(R.id.fimdavisita).setVisibility(findViewById(R.id.fimdavisita).VISIBLE);
            if(!audioUltimaTela.isPlaying()){
                pauseAllPlayingMusic();
                audioUltimaTela.start();
            }
        }
        visitaguiada=true;
    }
    //--------------------------------------------------------------------------------------------------
    public void desaparecer(View view) {
        view.setVisibility(view.INVISIBLE);
        if(view==findViewById(R.id.marcozeroachievment)){
            ignorarConquista(view);
        }else if(view==findViewById(R.id.caisachievment)){
            ignorarConquista(view);
        }else if(view==findViewById(R.id.malakoffachievment)){
            ignorarConquista(view);
        }else if(view==findViewById(R.id.frevoachievment)){
            ignorarConquista(view);
        }
    }
    //--------------------------------------------------------------------------------------------------
    public void acessarMapa(View view) {
        r4 = (RelativeLayout) findViewById(R.id.tela4);
        r5 = (RelativeLayout) findViewById(R.id.tela5);
        r4.setVisibility(r4.INVISIBLE);
        r5.setVisibility(r5.VISIBLE);
        navegation = false;
        pauseAllPlayingMusic();
    }

    public void acessarMapa2(View view) {
        r2 = (RelativeLayout) findViewById(R.id.tela2);
        r5 = (RelativeLayout) findViewById(R.id.tela5);
        r2.setVisibility(r2.INVISIBLE);
        r5.setVisibility(r5.VISIBLE);
        navegation = false;
        mapaTutorial = true;
        pauseAllPlayingMusic();
    }

    public void voltarMapa(View view) {
        if (mapaTutorial&&view!=findViewById(R.id.seguirrota)) {
            r2 = (RelativeLayout) findViewById(R.id.tela2);
            r5 = (RelativeLayout) findViewById(R.id.tela5);
            r2.setVisibility(r2.VISIBLE);
            r5.setVisibility(r5.INVISIBLE);
            mapaTutorial = false;
            if(visitacomaudio){
             playAudio(findViewById(R.id.proximo1audio));
            }
        } else {
            r4 = (RelativeLayout) findViewById(R.id.tela4);
            r5 = (RelativeLayout) findViewById(R.id.tela5);
            r4.setVisibility(r4.VISIBLE);
            r5.setVisibility(r5.INVISIBLE);
            if(visitacomaudio) {
                playAudio(findViewById(R.id.proximo3));
            }
            navegation = true;
        }
    }
    //--------------------------------------------------------------------------------------------------
    public void pauseAllPlayingMusic() {
        for (int i = 0; i < musicList.size(); i++) {
            MediaPlayer mp = (MediaPlayer) musicList.get(i);
            if (mp.isPlaying()) {
                mp.pause();
            }
        }
    }
//--------------------------------------------------------------------------------------------------
    /**
     * Provide our own SimpleRenderer.
     */
    @Override
    protected ARRenderer supplyRenderer() {
        return new SimpleRenderer(this);
    }

    public void setFoundMarker(boolean isTagFound, int markerID) {
        this.isTagFound = isTagFound;
        this.currentMarker = markerID;
    }
    //--------------------------------------------------------------------------------------------------
    public void displayView(int currentMarker) {
        View view = findViewById(R.id.ignorarconquista);

        if (currentMarker == 0) {
            if (navegation) {
                if (jafoiachievment[0] == false) {
                    marcozeroachievment.setVisibility(marcozeroachievment.VISIBLE);
                    m.setVisibility(m.INVISIBLE);
                    jafoiachievment[0] = true;
                    if(visitacomaudio) {
                        if (!audioConquista_marcozero.isPlaying()) {
                            pauseAllPlayingMusic();
                            audioConquista_marcozero.start();
                        }
                    }
                }
            }
        }
        if (currentMarker == 1) {
            if (navegation) {
                if (!jafoiachievment[1]) {
                    caisachievment.setVisibility(caisachievment.VISIBLE);
                    jafoiachievment[1] = true;
                    m.setVisibility(m.INVISIBLE);
                    if(visitacomaudio) {
                        if (!audioConquista_cais_sertao.isPlaying()) {
                            pauseAllPlayingMusic();
                            audioConquista_cais_sertao.start();
                        }
                    }
                }
            }
        }
        if (currentMarker == 2) {
            if (navegation) {
                if (!jafoiachievment[2]) {
                    frevoachievment.setVisibility(frevoachievment.VISIBLE);
                    jafoiachievment[2] = true;
                    m.setVisibility(m.INVISIBLE);
                    if(visitacomaudio) {
                        if (!audioConquista_paco_do_frevo.isPlaying()) {
                            pauseAllPlayingMusic();
                            audioConquista_paco_do_frevo.start();
                        }
                    }
                }
            }
        }
        if (currentMarker == 3) {
            if (navegation) {
                if (!jafoiachievment[3]) {
                    malakoffachievment.setVisibility(malakoffachievment.VISIBLE);
                    jafoiachievment[3] = true;
                    m.setVisibility(m.INVISIBLE);
                    if(visitacomaudio) {
                        if (!audioConquista_torre_malakoff.isPlaying()) {
                            pauseAllPlayingMusic();
                            audioConquista_torre_malakoff.start();
                        }
                    }
                }
            }
        }
        if (currentMarker == -1) {
            if (marcozeroachievment.getVisibility() != marcozeroachievment.VISIBLE && caisachievment.getVisibility() != caisachievment.VISIBLE
                    && malakoffachievment.getVisibility() != malakoffachievment.VISIBLE && frevoachievment.getVisibility() != frevoachievment.VISIBLE) {
                m.setVisibility(m.VISIBLE);
            }
        }
    }
//--------------------------------------------------------------------------------------------------
    /**
     * Use the FrameLayout in this Activity's UI.
     */
    @Override
    protected FrameLayout supplyFrameLayout() {
        return (FrameLayout) this.findViewById(R.id.mainLayout);
    }


    protected CaptureCameraPreview supplyCameraPreview() {
        CaptureCameraPreview cp = (CaptureCameraPreview) this.findViewById(R.id.camerapreview);
        cp.setCameraEventListener(this);
        return (CaptureCameraPreview) this.findViewById(R.id.camerapreview);

    }

}