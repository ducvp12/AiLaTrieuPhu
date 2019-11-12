package vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.ui.tools;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.R;

public class XHTuanAdapter extends RecyclerView.Adapter<XHTuanAdapter.ViewHolder> {
    private ArrayList<ModelXHTuan> list;
    private Context context;

    public XHTuanAdapter(ArrayList<ModelXHTuan> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_xephang,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull XHTuanAdapter.ViewHolder holder, int position) {
        context = holder.itemView.getContext();
        ModelXHTuan modelXHTuan=list.get(position);
        if (list != null) {
            ModelXHTuan post = list.get(position);
            holder.tvnameXH.setText(modelXHTuan.getName());
            holder.tvdiemXH.setText(modelXHTuan.getDiem());
            holder.tvstt.setText(modelXHTuan.getStt());
           Picasso.with(context).load(modelXHTuan.getImg()).into(holder.imgContent);

//            Toast.makeText(context, post.getUrlM()+"", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgContent;
        TextView tvnameXH;
        TextView tvdiemXH,tvstt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContent = itemView.findViewById(R.id.image_xh);
            tvnameXH=itemView.findViewById(R.id.tv_name_item);
            tvdiemXH= itemView.findViewById(R.id.tv_tienthuong_xh);
            tvstt=itemView.findViewById(R.id.tv_stt_xh);

        }
    }


}
