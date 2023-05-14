package com.example.onlineshop.Data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class Articulo implements Parcelable {
    private final String image;
    private final String nombre;
    private final int precio;

    public Articulo(String image, String nombre, int precio){
        this.image = image;
        this.nombre = nombre;
        this.precio = precio;
    }

    protected Articulo(Parcel in) {
        image = in.readString();
        nombre = in.readString();
        precio = in.readInt();
    }

    public static final Creator<Articulo> CREATOR = new Creator<Articulo>() {
        @Override
        public Articulo createFromParcel(Parcel in) {
            return new Articulo(in);
        }

        @Override
        public Articulo[] newArray(int size) {
            return new Articulo[size];
        }
    };

    public Drawable getImage(Context context) {
        int resourceId = context.getResources().getIdentifier(image, "drawable", context.getPackageName());
        return ContextCompat.getDrawable(context, resourceId);
    }

    public String getNombre() {
        return nombre;
    }

    public String getprecio() {
        return String.valueOf(precio);
    }

    @NonNull
    @Override
    public String toString() {
        return "Articulo{" +
                "image='" + image + '\'' +
                ",nombre='" + nombre + '\'' +
                ",precio='" + precio + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(nombre);
        dest.writeInt(precio);
    }
}
