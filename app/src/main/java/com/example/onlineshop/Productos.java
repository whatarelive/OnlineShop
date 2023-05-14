package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.onlineshop.Data.Articulo;
import com.example.onlineshop.Data.ArticuloBD;

import java.util.ArrayList;

public class Productos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        findViewById(R.id.imageButton4).setOnClickListener(v -> navigate(ArticuloBD.abrigo));
        findViewById(R.id.imageButton5).setOnClickListener(v ->navigate(ArticuloBD.blusa));
        findViewById(R.id.imageButton6).setOnClickListener(v ->navigate(ArticuloBD.bufanda));
        findViewById(R.id.imageButton7).setOnClickListener(v ->navigate(ArticuloBD.camiseta));
        findViewById(R.id.imageButton8).setOnClickListener(v ->navigate(ArticuloBD.gorra));
        findViewById(R.id.imageButton9).setOnClickListener(v ->navigate(ArticuloBD.guantes));
        findViewById(R.id.imageButton10).setOnClickListener(v ->navigate(ArticuloBD.licra));
        findViewById(R.id.imageButton11).setOnClickListener(v ->navigate(ArticuloBD.medias));
        findViewById(R.id.imageButton12).setOnClickListener(v ->navigate(ArticuloBD.pantalones));
        findViewById(R.id.imageButton13).setOnClickListener(v ->navigate(ArticuloBD.tops));
        findViewById(R.id.imageButton14).setOnClickListener(v ->navigate(ArticuloBD.vestido));
        findViewById(R.id.imageButton15).setOnClickListener(v ->navigate(ArticuloBD.zapatos));
    }

    private void navigate(ArrayList<Articulo> articuloList){
        Intent intent = new Intent(this, productos_info.class);
        intent.putParcelableArrayListExtra("articulos", articuloList);
        startActivity(intent);
        finish();
    }

    public void onBackPressed(){
        finish();
    }
}