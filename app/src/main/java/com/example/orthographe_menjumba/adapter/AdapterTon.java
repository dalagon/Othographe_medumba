package com.example.orthographe_menjumba.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orthographe_menjumba.R;
import com.example.orthographe_menjumba.classSimple.Lettre;
import com.example.orthographe_menjumba.classSimple.Ton;
import com.example.orthographe_menjumba.listeners.BaseListenerCheckBox;

import java.util.List;

/*
Peut-être faudrait il penser à supprimer cette classe et utiliser la AdapterDouaneFactureBordereau ?? Dupplication inule on dirait bien
 */
public class AdapterTon extends RecyclerView.Adapter<AdapterTon.ViewHolder> {

    private List<Ton> customBillsItems;
    BaseListenerCheckBox listener;
    Context context;

    public AdapterTon(Context context, List<Ton> listItems, BaseListenerCheckBox listener) {
        this.customBillsItems = listItems;
        this.context = context;
        this.listener = listener;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.item_ton, parent, false );

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

        final Ton listem = customBillsItems.get( position );



        holder.cardTon.setOnClickListener(v -> listener.onClick( position, v ));


    }

    @Override
    public int getItemCount() {
        return customBillsItems.size();
    }


    // confirmation dialog box to delete an unit
    private void deleteItemFromList(View v, final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());

        builder.setMessage("Delete Item ?")
                .setCancelable(false)
                .setPositiveButton("CONFIRM",
                        (dialog, id) -> {

                            customBillsItems.remove(position);
                            notifyDataSetChanged();


                        })
                .setNegativeButton("CANCEL", (dialog, id) -> {


                });

        builder.show();

    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ton;
        CardView cardTon;

        public ViewHolder(View itemView) {

            super( itemView );

            ton = itemView.findViewById( R.id.ton );
            cardTon = itemView.findViewById( R.id.card_ton );

        }
    }
}

