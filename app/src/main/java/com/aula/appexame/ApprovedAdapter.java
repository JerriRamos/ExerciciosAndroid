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

public class ApprovedAdapter extends RecyclerView.Adapter<ApprovedAdapter.ApprovedViewHolder> {
    Context context;
    private final LinkedList<Aluno> approvedList_Adapter;
    private LayoutInflater mInflater;

    public ApprovedAdapter(Context context, LinkedList<Aluno> approvedList) {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        this.approvedList_Adapter = approvedList;
    }

    @NonNull
    @Override
    public ApprovedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View mItemView = mInflater.inflate(R.layout.aluno_model, parent, false);
        return new ApprovedViewHolder(mItemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull ApprovedViewHolder holder, int position) {
        Aluno aluno = approvedList_Adapter.get(position);
        holder.name.setText(aluno.getName());
        holder.avaliacao.setText(aluno.getAvaliacao());
        holder.media.setText(aluno.getMedia());
    }

    @Override
    public int getItemCount() {
        return approvedList_Adapter.size();
    }

    public class ApprovedViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {

        public TextView name, media, avaliacao;
        public LinearLayout linear_model;

        public ApprovedViewHolder(@NonNull View itemView, ApprovedAdapter approvedAdapter){
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
        approvedList_Adapter.remove(position);
        notifyDataSetChanged();
    }

}
