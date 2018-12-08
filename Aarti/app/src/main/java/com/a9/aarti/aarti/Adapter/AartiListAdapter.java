package com.a9.aarti.aarti.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.a9.aarti.aarti.Activities.AartiDetailActivity;
import com.a9.aarti.aarti.Model.Aarti;
import com.a9.aarti.aarti.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AartiListAdapter extends RecyclerView.Adapter<AartiListAdapter.AartiItemViewHolder> {


    public List<Aarti> aartiList;
    private Context context;

    public AartiListAdapter(Context context, List<Aarti> aartiList)
    {
        this.context = context;
        this.aartiList = aartiList;
    }


    @NonNull
    @Override
    public AartiItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.aarti_item_layout,viewGroup,false);
        AartiItemViewHolder holder = new AartiItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final AartiItemViewHolder aartiItemViewHolder, int i) {

        final int position = i;

        Aarti aarti = aartiList.get(i);
        aartiItemViewHolder.title.setText(aarti.getTitle());
        aartiItemViewHolder.description.setText(aarti.description);

        Picasso.get().load(aarti.getImage()).into(aartiItemViewHolder.image);

        aartiItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent startDetailActivity = new Intent(context, AartiDetailActivity.class);
                startDetailActivity.putExtra("INDEX", position);


                //SHARED TRANSITION

                if(Build.VERSION.SDK_INT>20)
                {

                    //      For single item in Shared transition
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                           makeSceneTransitionAnimation((Activity)context, (View) (aartiItemViewHolder.image), "godImage");
                    context.startActivity(startDetailActivity, options.toBundle());


                    //     For multiple items make Pair - support.v4 library
                    /*
                    Pair<View, String> p1 = Pair.create((View)aartiItemViewHolder.image, "godImage");
                    Pair<View, String> p2 = Pair.create((View)aartiItemViewHolder.title, "aartiTitle");
                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation((Activity) context, p1, p2);
                    */



                }
                else {
                    context.startActivity(startDetailActivity);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return aartiList.size();
    }

    public class AartiItemViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public TextView description;
        public ImageView image;

        public AartiItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (TextView)itemView.findViewById(R.id.description);
            image = (ImageView)itemView.findViewById(R.id.image);

        }
    }

}
