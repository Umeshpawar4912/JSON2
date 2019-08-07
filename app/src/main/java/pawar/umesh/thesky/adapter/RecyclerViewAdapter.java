package pawar.umesh.thesky.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import pawar.umesh.thesky.model.Anime;
import pawar.umesh.thesky.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{


    private Context mContext ;
    private List<Anime> mData ;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Anime> mData) {
        this.mContext = mContext;
        this.mData = mData;


        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.anime_row_item,parent,false) ;

        return new MyViewHolder ( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getTitle ());
        holder.tv_category.setText(mData.get(position).getCaption ());

        Glide.with(mContext).load(mData.get(position).getImage ()).apply(option).into(holder.img_thumbnail);



    }

    @Override
    public int getItemCount() {
        return mData.size ();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView tv_name ;
        TextView tv_category;
        ImageView img_thumbnail;



        public MyViewHolder(@NonNull View itemView) {
            super (itemView);

            tv_name = itemView.findViewById(R.id.anime_name);
            tv_category = itemView.findViewById(R.id.categorie);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);


        }
    }
}


