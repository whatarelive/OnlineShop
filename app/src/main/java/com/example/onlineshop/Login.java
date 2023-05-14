package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class Login extends AppCompatActivity {

    private EditText jv_correo, jv_password;
    private TextView textView, textView2, textView3, textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        jv_correo =(EditText) findViewById(R.id.Correo);
        jv_password = (EditText) findViewById(R.id.Password);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);

        textView.getBottom();
        textView2.getBottom();

        findViewById(R.id.button3).setOnClickListener(v -> Inicio());
        findViewById(R.id.textView).setOnClickListener(v -> Cambiar_Password());
        findViewById(R.id.textView2).setOnClickListener(v -> Crear_Cuenta());
    }

    public void Inicio() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "Datos de Usuario", null, 1);
        SQLiteDatabase BD = admin.getReadableDatabase();

        String Gmail = jv_correo.getText().toString();
        String Password_User = jv_password.getText().toString();

        if(!Gmail.isEmpty() && !Password_User.isEmpty()) {
            Cursor fila = BD.rawQuery("select correo, password from Datos", null);

            if (fila.moveToFirst()) {
                jv_correo.setText(fila.getString(0));
                jv_password.setText(fila.getString(1));
                BD.close();
            } else {
                Toast.makeText(this, "Usuario Incorrecto", Toast.LENGTH_LONG).show();
                BD.close();
            }
        } else {
            Toast.makeText(this, "Escriba el dato faltante", Toast.LENGTH_LONG).show();
        }

        String correo = jv_correo.getText().toString();
        String password = jv_password.getText().toString();

        if((!correo.equals("") && !password.equals("")) && (correo.equals(Gmail) && password.equals(Password_User))){
            Intent intent = new Intent(this, Productos.class);
            startActivity(intent);
            finish();
          } else {
                Toast.makeText(this, "Datos Incorrectos", Toast.LENGTH_LONG).show();
            }
            if(correo.equals("") || correo.equals(Gmail)){
                jv_correo.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);

                jv_correo.setText("");
                imm.showSoftInput(jv_correo, InputMethodManager.SHOW_IMPLICIT);
            } else {
                jv_password.requestFocus();
                InputMethodManager ipp = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);

                jv_password.setText("");
                ipp.showSoftInput(jv_password, InputMethodManager.SHOW_IMPLICIT);
            }
    }

    public void Cambiar_Password() {
        Intent intent = new Intent(this, Password.class);
        startActivity(intent);
        finish();
    }

    public void Crear_Cuenta() {
        Intent intent = new Intent(this, Sign_Up.class);
        startActivity(intent);
        finish();
    }

   @Override
    public void onBackPressed(){
        finish();
   }
}