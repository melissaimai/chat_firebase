package com.example.fatec_ipi_chat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }
}

class ChatViewHolder extends RecyclerView.ViewHolder{
    TextView dataNomeTectView;
    TextView mensagemTextView;

    ChatViewHolder(View raiz){
        super(raiz);
        this.dataNomeTectView = raiz.findViewById(R.id.dataNomeTextView);
        this.mensagemTextView = raiz.findViewById(R.id.dataNomeTextView);

    }
}
class ChatAdapter extends RecyclerView.Adapter <ChatViewHolder>{
    private List<Mensagem> mensagens;
    private Context context;
    ChatAdapter (List <Mensagem> mensagens, Context context){
        this.mensagens = mensagens;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position){
        Mensagem m = mensagens.get(position);
        holder.mensagemTextView.setText(m.getTexto());
        holder.dataNomeTectView.setText(
                context.getString(R.string.mensagem,
                        DataHelper.format(m.getDate()),
                        m.getTexto()
                )
        );

    }
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View raiz = inflater.inflate(R.layout.list_item, parent, false);
        return new ChatViewHolder(raiz);
    }

    @Override
    public int getItemCount() {
        return this.mensagens.size();
    }
}
