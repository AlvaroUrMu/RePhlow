package org.ivz.ad.aurbano.rephlow.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.ivz.ad.aurbano.rephlow.R;
import org.ivz.ad.aurbano.rephlow.model.api.FloraClient;
import org.ivz.ad.aurbano.rephlow.model.entity.Flora;
import org.ivz.ad.aurbano.rephlow.view.adapter.FloraAdapter;
import org.ivz.ad.aurbano.rephlow.viewmodel.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FloraClient floraClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Toolbar toolbarMain = findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setTitle("RePhlow");

        FloatingActionButton fabAdd = findViewById(R.id.fabAdd);
        fabAdd.setOnClickListener(view -> openAddActivity());

        RecyclerView rvFlora = findViewById(R.id.rvFlora);
        rvFlora.setLayoutManager(new LinearLayoutManager(this));

        rvFlora.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                if (dy > 0)
                    fabAdd.hide();
                else if (dy < 0)
                    fabAdd.show();
            }
        });

        FloraAdapter floraAdapter = new FloraAdapter(this);
        rvFlora.setAdapter(floraAdapter);

        MainActivityViewModel mavm = new ViewModelProvider(this).get(MainActivityViewModel.class);
        LiveData<ArrayList<Flora>> floraList = mavm.getFloraLiveData();

        floraList.observe(this, floraPlural -> {
            floraAdapter.setFloraList(mavm.getFloraLiveData().getValue());
            rvFlora.setAdapter(floraAdapter);
        });

        mavm.getFlora();
    }

    private void openAddActivity(){
        Intent intent = new Intent(this, AddFloraActivity.class);
        startActivity(intent);
    }
}