package com.devalfaro.appmascotas.activity;

import android.os.Message;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.devalfaro.appmascotas.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {
    String correopersonal;
    String contraseña;
    EditText nombre;
    EditText correo;
    EditText mensaje;
    Button btnEnviar;
    Session session;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nombre = (EditText) findViewById(R.id.nombreEmail);
        correo = (EditText) findViewById(R.id.correoEmail);
        mensaje = (EditText) findViewById(R.id.MensajeEmail);
        btnEnviar = ( Button) findViewById(R.id.BtnEnviar);

        correopersonal = "joseperdomoayala1995@gmail.com";
        contraseña = "mralfaro1540";


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);



                Properties properties = new Properties();
                properties.put("mail.smtp.host","smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port","465");
                properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.port","465");

                try{
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correopersonal,contraseña);
                        }
                    });

                    if (session!= null){
                        javax.mail.Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correopersonal));
                        message.setSubject(nombre.getText().toString());
                        message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse("fernandoalfarop13@gmail.com"));
                        message.setContent(correo.getText().toString()+ "\n" + mensaje.getText().toString(),"text/html; charset =utf-8");
                        Transport.send(message);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }



            }
        });
    }
}
