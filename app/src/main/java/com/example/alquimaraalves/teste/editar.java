package com.example.alquimaraalves.teste;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alquimaraalves.teste.Firebase.ConfiguracaoFirebase;
import com.google.firebase.database.DatabaseReference;

import java.util.UUID;

public class editar extends AppCompatActivity {
    private Button editar, voltar;
    private EditText nome, telefone, endereco;
    private DatabaseReference firebase;
    private Contato produtos;
    private String uid;


    MainActivity atu = new MainActivity();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        nome = findViewById(R.id.nome);
        endereco = findViewById(R.id.endereco);
        telefone = findViewById(R.id.telefone);
        editar = findViewById(R.id.editar);
        voltar = findViewById(R.id.voltar);

        nome.setText(getIntent().getStringExtra("nome"));
        telefone.setText(getIntent().getStringExtra("telefone"));
        endereco.setText(getIntent().getStringExtra("endereco"));
        uid = getIntent().getStringExtra("uid");


        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contato contatos = new Contato();
                contatos.setNome(nome.getText().toString());
                contatos.setTelefone(telefone.getText().toString());
                contatos.setEndereco(endereco.getText().toString());
                contatos.setUid(uid);

                atualizarContatos(contatos);
                nome.setText("");
                telefone.setText("");
                endereco.setText("");
                voltar();


            }
        });





        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltar();
            }
        });
    }

    private boolean atualizarContatos(Contato produtos){
        try {
            firebase = ConfiguracaoFirebase.getFirebase().child("Contatos");
            firebase.child(produtos.getUid()).setValue(produtos);
            Toast.makeText(editar.this, "produto atualizado com sucesso", Toast.LENGTH_LONG).show();
            return true;

        }catch (Exception e){
            e.printStackTrace();
            return false;

        }

    }

    private void voltar(){
        Intent intent = new Intent(editar.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}

