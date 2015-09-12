package com.richpolissystems.android.saintseya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

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
}
