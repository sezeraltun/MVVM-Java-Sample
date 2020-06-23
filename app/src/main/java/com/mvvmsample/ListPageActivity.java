package com.mvvmsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.lifecycle.AndroidViewModel;
import com.mvvmsample.adapters.RecyclerAdapter;
import com.mvvmsample.models.UserModel;
import com.mvvmsample.viewmodels.ListPageViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListPageActivity extends AppCompatActivity {

    private RecyclerAdapter mAdapter;
    private RecyclerView recyclerView;
    private ListPageViewModel mListPageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);

        mListPageViewModel= new ViewModelProvider(this).get(ListPageViewModel.class);
        mListPageViewModel.init();
        mListPageViewModel.getmUserData().observe(this, new Observer<List<UserModel>>() {
            @Override
            public void onChanged(List<UserModel> userModels) {

            }
        });

        initRecyclerView();


    }

    private void initRecyclerView() {
        mAdapter= new RecyclerAdapter(this, mListPageViewModel.getmUserData().getValue());
        RecyclerView.LayoutManager linearLayputManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayputManager);
        recyclerView.setAdapter(mAdapter);
    }

}
