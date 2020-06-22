package com.dhbw.pm;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    DatabaseHelper db;
    EditText edt_mail, edt_password;
    Button hilfe, login;
    public static String HILFSMAIL = "inf1234@lehre.dhbw-stuttgart.de";
    public static String HILFSPASSWORD = "1234Password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //Datenbank laden und Startwert einlesen
        db = new DatabaseHelper(this);
        db.insert(HILFSMAIL,HILFSPASSWORD);

        //Initialisieren von Views
        edt_mail = findViewById(R.id.mailField);
        edt_password = findViewById(R.id.passwordField);
        login = findViewById(R.id.btn_login);
        hilfe = findViewById(R.id.btn_hilfe);

        //OnClick Methode Button Login
        login.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                String mail = edt_mail.getText().toString();
                String password = edt_password.getText().toString();
                if (mail.equals("")||password.equals("")){
                    Toast.makeText(getApplicationContext(),"Alle Felder müssen ausgefüllt sein!",Toast.LENGTH_LONG).show();
                }
                else{
                    if(db.emailpassword(mail,password)){
                        Toast.makeText(getApplicationContext(),"Login Gelungen!",Toast.LENGTH_LONG).show();
                        // Hier kommt was als nächstes passieren soll
                        startActivity(new Intent(Login.this, Stundenplan.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Login Fehlgeschlagen!",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
