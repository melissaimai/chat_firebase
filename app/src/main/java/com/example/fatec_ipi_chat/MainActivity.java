package com.example.fatec_ipi_chat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText loginEditText;
    private EditText senhaEditText;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginEditText =
                findViewById(R.id.loginEditText);
        senhaEditText =
                findViewById(R.id.senhaEditText);
        mAuth = FirebaseAuth.getInstance();
    }

    public void irParaCadastro(View view) {
        Intent intent = new Intent(this, NovoUsuarioActivity.class);
        startActivity(intent);
    }

    public void fazerLogin(View view) {
        String login =
                loginEditText.getEditableText().toString();
        String senha =
                senhaEditText.getEditableText().toString();
        mAuth.signInWithEmailAndPassword(
                login,
                senha

        ).addOnSuccessListener(result -> {
            Toast.makeText(this,
                    getString(R.string.cadastro_funcionou, result.getUser().getDisplayName()),
                    Toast.LENGTH_SHORT).show();
            finish();
        })
                .addOnFailureListener(err -> {
                    Toast.makeText(
                            this,
                            getString(R.string.erro_inesperado),
                            Toast.LENGTH_SHORT).show();
                    Toast.makeText(
                            this,
                            err.getLocalizedMessage(),
                            Toast.LENGTH_SHORT).show();
                    finish();
                });
    }
}