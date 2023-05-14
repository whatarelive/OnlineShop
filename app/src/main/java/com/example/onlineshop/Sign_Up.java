package com.example.onlineshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Sign_Up extends AppCompatActivity {

    private EditText jv_correo, jv_password, jv_password_confirmation, jv_usuario;
    private CheckBox check_terminos;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        jv_usuario = (EditText) findViewById(R.id.Name);
        jv_correo = (EditText) findViewById(R.id.Email);
        jv_password = (EditText) findViewById(R.id.password);
        jv_password_confirmation = (EditText) findViewById(R.id.confirmation_password);
        check_terminos = (CheckBox) findViewById(R.id.checkBox);
        textView = (TextView) findViewById(R.id.Terminos);

        textView.getBottom();

        findViewById(R.id.button).setOnClickListener(v -> Registrar());
        findViewById(R.id.Terminos).setOnClickListener(v -> Terminos());
    }

    public void Registrar() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Datos de Usuario", null, 1);
        SQLiteDatabase BD = admin.getWritableDatabase();

        String usuario = jv_usuario.getText().toString();
        String correo = jv_correo.getText().toString();
        String password = jv_password.getText().toString();
        String password_confirmation = jv_password_confirmation.getText().toString();

        if(!usuario.equals("") && !correo.equals("") && !password.equals("") && !password_confirmation.equals("")) {
            ContentValues registro = new ContentValues();

            registro.put("usuario", usuario);
            registro.put("correo", correo);
            registro.put("password", password);

            BD.insert("Datos", null, registro);

            BD.close();

        } else {
            Toast.makeText(this, "Falta un dato",Toast.LENGTH_LONG).show();

            if(usuario.equals("")){
                jv_usuario.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);

                imm.showSoftInput(jv_usuario, InputMethodManager.SHOW_IMPLICIT);
            } else if(correo.equals("")) {
                jv_correo.requestFocus();
                InputMethodManager inn = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);

                inn.showSoftInput(jv_correo, InputMethodManager.SHOW_IMPLICIT);
            } else if(password.equals("")){
                jv_password.requestFocus();
                InputMethodManager ipp = (InputMethodManager)  getSystemService(this.INPUT_METHOD_SERVICE);

                ipp.showSoftInput(jv_password, InputMethodManager.SHOW_IMPLICIT);
            } else {
                jv_password_confirmation.requestFocus();
                InputMethodManager irr = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);

                irr.showSoftInput(jv_password_confirmation, InputMethodManager.SHOW_IMPLICIT);
            }
        }
            if(!password_confirmation.equals(password)) {
                Toast.makeText(this, "Password incorred", Toast.LENGTH_LONG).show();

                jv_password_confirmation.requestFocus();
                InputMethodManager irr = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);

                irr.showSoftInput(jv_password_confirmation, InputMethodManager.SHOW_IMPLICIT);
            }
            if(check_terminos.isChecked()){
                Toast.makeText(this, "Registro exitoso", Toast.LENGTH_LONG).show();

                jv_usuario.setText("");
                jv_correo.setText("");
                jv_password.setText("");
                jv_password_confirmation.setText("");

                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Acepte los Terminos y Condiciones", Toast.LENGTH_LONG).show();
            }
    }

    public void Terminos(){
        Intent intent = new Intent(this, Terminos.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}