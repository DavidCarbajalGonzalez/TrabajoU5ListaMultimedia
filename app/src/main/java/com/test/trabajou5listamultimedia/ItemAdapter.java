package com.test.trabajou5listamultimedia;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> itemList;
    private OnItemClickListener onItemClickListener;

    // Constructor
    public ItemAdapter(List<Item> itemList, OnItemClickListener onItemClickListener) {
        this.itemList = itemList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el layout de cada item
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // Obtener el item de la lista
        Item item = itemList.get(position);

        // Configurar el título
        holder.title.setText(item.getTitle());

        // Configurar la imagen (a la izquierda)
        holder.image.setImageResource(item.getImageResId()); // Cargar la imagen

        // Cuando se haga clic en un item, disparar el listener
        holder.itemView.setOnClickListener(v -> onItemClickListener.onItemClick(item));
    }

    @Override
    public int getItemCount() {
        return itemList.size();  // Número de items en la lista
    }

    // Interfaz para manejar el clic en un item
    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    // ViewHolder para el layout de cada item
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            // Inicializar las vistas
            title = itemView.findViewById(R.id.itemTitle);
            image = itemView.findViewById(R.id.itemImage);  // Referencia a la imagen
        }
    }
}


