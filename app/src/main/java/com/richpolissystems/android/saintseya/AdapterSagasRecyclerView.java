package com.richpolissystems.android.saintseya;

import android.content.Context;
import android.speech.RecognizerIntent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by richpolis on 12/09/15.
 */
public class AdapterSagasRecyclerView extends RecyclerView.Adapter<AdapterSagasRecyclerView.ViewHolder>{
    private List<Saga> sagaList;
    private LayoutInflater inflater;
    private MyOnItemClickListener myOnItemClickListener;
    public static final String TAG = "Sagas";


    public AdapterSagasRecyclerView(Context context, List<Saga> sagaList) {
        this.sagaList = sagaList;

        inflater = LayoutInflater.from(context);

        Log.d(TAG, "Creando objeto AdapterSagasRecyclerView");
    }

    public void setMyOnItemClickListener(MyOnItemClickListener myOnItemClickListener) {
        this.myOnItemClickListener = myOnItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.listitem_saga2, parent, false);

        ViewHolder viewHolder = new ViewHolder(view, R.id.imgItemPoster, R.id.txtItemSaga, R.id.txtItemDescripcion);

        Log.d(TAG, "Entrando a onCreateViewHolder");

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Saga saga = sagaList.get(position);

        holder.setSaga(saga.getSaga());
        holder.setDescripcion(saga.getDescripcion());
        holder.setImagen(saga.getPoster());

        Log.d(TAG, "Entrando a onBindViewHolder");

    }

    @Override
    public int getItemCount() {
        return sagaList.size();
    }

    public void addItem(Saga hero){
        sagaList.add(hero);

        notifyItemInserted(sagaList.size() - 1);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgItemPoster;
        TextView txtItemSaga;
        TextView txtItemDescripcion;


        public ViewHolder(View itemView, int idImgItemPoster, int idTxtItemSaga, int idTxtItemDescripcion) {

            super(itemView);

            itemView.setOnClickListener(this);

            imgItemPoster = (ImageView) itemView.findViewById(idImgItemPoster);
            txtItemSaga = (TextView) itemView.findViewById(idTxtItemSaga);
            txtItemDescripcion = (TextView) itemView.findViewById(idTxtItemDescripcion);

            Log.d(TAG,"Creando objecto ViewHolder");

        }

        public void setImagen(int resourceImage) {
            imgItemPoster.setImageResource(resourceImage);
        }

        public void setSaga(String saga) {
            txtItemSaga.setText(saga);
        }

        public void setDescripcion(String descripcion) {
            txtItemDescripcion.setText(descripcion);
        }


        @Override
        public void onClick(View view) {
            myOnItemClickListener.onItemClick(getAdapterPosition());
        }
    }
}
