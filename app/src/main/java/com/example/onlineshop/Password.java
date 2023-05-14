package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Password extends AppCompatActivity {

    private EditText jv_usuario, jv_password, jv_password_confirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        jv_usuario = (EditText) findViewById(R.id.usuario);
        jv_password = (EditText) findViewById(R.id.password);
        jv_password_confirmation = (EditText) findViewById(R.id.confirmation_password);

        findViewById(R.id.button_p).setOnClickListener(v -> Cambiar());
    }

    public void Cambiar(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Datos de Usuario", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String password = jv_password.getText().toString();
        String password_confirmation = jv_password_confirmation.getText().toString();

        if(!password.equals("")) {
            if (password_confirmation.equals(password)) {
                ContentValues registro = new ContentValues();
                registro.put("password", password);

                BD.insert("Datos", null, registro);
                BD.close();

                jv_usuario.setText("");
                jv_password.setText("");
                jv_password_confirmation.setText("");

                Toast.makeText(this, "Cambio exitoso", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                finish();

            } else {
                Toast.makeText(this, "Confirma la Contraseña", Toast.LENGTH_LONG).show();
            }

        }else {
            Toast.makeText(this, "Introduzca el dato", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}