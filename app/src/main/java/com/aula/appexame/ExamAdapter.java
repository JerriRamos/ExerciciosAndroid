package com.aula.appexame;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;

public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ExamViewHolder>{
    Context context;
    private final LinkedList<Aluno> examList_Adapter;
    private LayoutInflater mInflater;

    public ExamAdapter(Context context, LinkedList<Aluno> examList) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.examList_Adapter = examList;
    }

    @NonNull
    @Override
    public ExamAdapter.ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mItemView = mInflater.inflate(R.layout.aluno_model, parent, false);
        return new ExamAdapter.ExamViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamAdapter.ExamViewHolder holder, int position) {
        Aluno aluno = examList_Adapter.get(position);
        holder.name.setText(aluno.getName());
        holder.avaliacao.setText(aluno.getAvaliacao());
        holder.media.setText(aluno.getMedia());
    }

    @Override
    public int getItemCount() {
        return examList_Adapter.size();
    }

    public class ExamViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{

        public TextView name, media, avaliacao;
        public LinearLayout linear_model;

        public ExamViewHolder(@NonNull View itemView, ExamAdapter examAdapter) {
            super(itemView);
            name = itemView.findViewById(R.id.name_model);
            avaliacao = itemView.findViewById(R.id.avaliacao_model);
            media = itemView.findViewById(R.id.media_model);
            linear_model = itemView.findViewById(R.id.linear_model);

            linear_model.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.add(this.getAdapterPosition(),1,0,"Remover");
        }
    }

    public void removerItem(int position){
        examList_Adapter.remove(position);
        notifyDataSetChanged();
    }

}
