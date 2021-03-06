package com.a9.aarti.aarti.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.a9.aarti.aarti.Adapter.AartiListAdapter;
import com.a9.aarti.aarti.Interfaces.AartiListLoader;
import com.a9.aarti.aarti.Model.Aarti;
import com.a9.aarti.aarti.R;
import com.a9.aarti.aarti.StaticData.AartiData;

import java.util.List;

public class AartiListActvity extends AppCompatActivity {

    private RecyclerView aartiListView;
    private List<Aarti> aartiList;
    private AartiListAdapter adapter;
    private LinearLayoutManager llm;
    private AartiListLoader listLoader;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aarti_list_activity_layout);

        aartiListView = (RecyclerView)findViewById(R.id.aartiList);
        aartiList = AartiData.getList();
        llm = new LinearLayoutManager(this);
        adapter = new AartiListAdapter(AartiListActvity.this, aartiList);
        aartiListView.setLayoutManager(llm);
        aartiListView.setAdapter(adapter);

    }



    // Dummy List

    /*
    private List<Aarti> loadList()
    {
        aartiList = new ArrayList<Aarti>();

        for(int i=0; i<10;i++)
        {
            Aarti aarti = new Aarti();
            aarti.setTitle("Aarti "+i);
            aarti.setDescription("desc "+i);
            aartiList.add(aarti);
        }

        return aartiList;
    }

    */


}
