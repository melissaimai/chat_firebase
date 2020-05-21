package com.example.fatec_ipi_noite_chat_com_firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class NovoUsuarioActivity extends AppCompatActivity {

    private EditText loginNovoUsuarioEditText;
    private EditText senhaNovoUsuarioEditText;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);

        loginNovoUsuarioEditText = findViewById(R.id.loginNovoUsuarioEditText);
        senhaNovoUsuarioEditText = findViewById(R.id.senhaNovoUsuarioEditText);

        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithEmailAndPassword("melissa1@gmail.com", "melissa1").addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()) {
                    Log.w("AUTH", "Falha ao efetuar o Login: ", task.getException());
                }else{
                    Log.d("AUTH", "Login Efetuado com sucesso!!!");
                }
            }
        });
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void criarNovoUsuario (View view){
        String login = loginNovoUsuarioEditText.getText().toString();
        String senha = senhaNovoUsuarioEditText.getText().toString();
        firebaseAuth.createUserWithEmailAndPassword(login, senha)
                .addOnSuccessListener((result) -> {
                    Toast.makeText(this, getString(R.string.cadastro_sucesso), Toast.LENGTH_SHORT).show();
                    finish();
                }).addOnFailureListener((erro) -> {
                    Toast.makeText(this, getString(R.string.cadastro_falha), Toast.LENGTH_SHORT).show();
                    finish();
                });

    }
}
