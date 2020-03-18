package com.example.fatec_ipi_chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class NovoUsuarioActivity extends AppCompatActivity {

        private EditText loginNovoUsuarioEditText;
        private EditText senhaNovoUsuarioEditText;
        private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_usuario);
        loginNovoUsuarioEditText =
                findViewById(R.id.loginNovoUsuarioEditText);
        senhaNovoUsuarioEditText =
                findViewById(R.id.senhaNovoUsuarioEditText);
        mAuth = FirebaseAuth.getInstance();
    }

    public void criarNovoUsuario (View v){
        String login =
                loginNovoUsuarioEditText.getEditableText().toString();
        String senha =
                senhaNovoUsuarioEditText.getEditableText().toString();
        mAuth.createUserWithEmailAndPassword(
                login,
                senha

        ).addOnSuccessListener(result -> {
            Toast.makeText(
                NovoUsuarioActivity.this,
                getString(R.string.cadastro_funcionou,result.getUser().getDisplayName()),
                Toast.LENGTH_SHORT).show();
            finish();
        })
        .addOnFailureListener(err -> {
            Toast.makeText(
                    NovoUsuarioActivity.this,
                    getString(R.string.erro_inesperado),
                    Toast.LENGTH_SHORT).show();
            Toast.makeText(
                    NovoUsuarioActivity.this,
                    err.getLocalizedMessage(),
                    Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
