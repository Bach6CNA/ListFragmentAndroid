package com.richpolissystems.android.saintseya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by richpolis on 10/09/15.
 */
public class AdapterSagas extends ArrayAdapter<Saga> {

    private Saga[] datos = null;

    public AdapterSagas(Context context, int resource, Saga[] datos) {
        super(context, resource, datos);
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_saga2, null);

        TextView lbSaga = (TextView)item.findViewById(R.id.txtItemSaga);
        lbSaga.setText(datos[position].getSaga());

        TextView lbDescripcion = (TextView)item.findViewById(R.id.txtItemDescripcion);
        lbDescripcion.setText(datos[position].getDescripcion());

        ImageView img = (ImageView)item.findViewById(R.id.imgItemPoster);
        img.setImageResource(datos[position].getPoster());

        return(item);
    }



}
