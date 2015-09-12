package com.richpolissystems.android.saintseya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, MyOnItemClickListener{

    private List<Saga> mySagas = new ArrayList<>();
    public static final String TAG = "Sagas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void cambiarPoster(int poster) {
        ContenidoFragment contenidoFragment = (ContenidoFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_contenido);

        contenidoFragment.setImagePoster(poster);
    }

    private boolean estaElSegundoFragmentoVisible() {
        return getSupportFragmentManager().findFragmentById(R.id.fragment_contenido) != null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Saga saga= ((Saga)parent.getItemAtPosition(position));

        if (estaElSegundoFragmentoVisible()){
            this.cambiarPoster(saga.getPoster());
        }else{
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("poster",saga.getPoster());
            startActivity(intent);
        }


    }

    @Override
    public void onItemClick(int position) {

        Toast.makeText(this, position + " de SagaList", Toast.LENGTH_SHORT).show();
        Saga saga = this.mySagas.get(position);

        Log.d(TAG, "Se dio click en " + position);

        if (estaElSegundoFragmentoVisible()){
            this.cambiarPoster(saga.getPoster());
        }else{
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("poster",saga.getPoster());
            startActivity(intent);
        }

    }

    public List<Saga> getSagaList(){

        if(mySagas.size()==0){
            for (int i = 0; i < 10; i++) {
                mySagas.add(new Saga("Torneo Galactico", "Torneo por la armadura dorada de Sagitario", R.drawable.cz_torneo_galactico));
                mySagas.add(new Saga("Las 12 Casas", "La lucha contra los caballeros dorados, los mas fuertes ",R.drawable.cz_12_casas));
                mySagas.add(new Saga("Asgad", "La lucha contra los dioses de Asgard",R.drawable.cz_asgard));
                mySagas.add(new Saga("Poseidon", "Lucha contra los caballeros de Poseidon", R.drawable.cz_poseidon));
                mySagas.add(new Saga("Hades", "Una nueva guerra santa esta por empezar", R.drawable.cz_hades));
            }
        }

        Log.d(TAG, "Obteniendo las sagas " + mySagas.size() );

        return mySagas;
    }
}
