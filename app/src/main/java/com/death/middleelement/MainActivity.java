package com.death.middleelement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.death.middleelement.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    LinearLayoutManager linearLayoutManager;
    CountAdapter countAdapter;
    int indexToSelect;
    List<Counting> counting = Arrays.asList(new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false),new Counting(1,false));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL, false);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        countAdapter = new CountAdapter(counting);
        activityMainBinding.list.setAdapter(countAdapter);
        activityMainBinding.list.setLayoutManager(linearLayoutManager);

        activityMainBinding.list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        selectMiddleItem();
                    }
                });
            }
        });

    }

    private void selectMiddleItem() {
        int firstIndex = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        int lastIndex = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        if(indexToSelect==0) {
            indexToSelect = (lastIndex - firstIndex)/2 + firstIndex;
            countAdapter.setSelected(indexToSelect);
        }else{
            countAdapter.clearSelection(indexToSelect);
            indexToSelect = (lastIndex - firstIndex)/2 + firstIndex;
            countAdapter.setSelected(indexToSelect);
        }
    }
}
