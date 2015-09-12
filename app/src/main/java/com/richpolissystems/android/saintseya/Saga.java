package com.richpolissystems.android.saintseya;

/**
 * Created by richpolis on 10/09/15.
 */
public class Saga  {
    private String saga;
    private String descripcion;
    private int poster = 0;

    public Saga(String saga, String descripcion, int poster) {
        this.saga = saga;
        this.descripcion = descripcion;
        this.poster = poster;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getSaga() {
        return saga;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
