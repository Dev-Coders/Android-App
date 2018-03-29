package com.varshney.deliverysystem;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.varshney.deliverysystem.Adapters.FoodAdapter;
import com.varshney.deliverysystem.Pojos.Food;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodFragment extends Fragment {
    public static final String TAG = "FF";

    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView rvRecyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view,container,false);

        ArrayList<Food> FoodArrayList = new ArrayList<>();

        Food dummyData = new Food();
        dummyData.setCount_of_item(5);
        dummyData.setName("Hello");
        FoodArrayList.add(dummyData);
        FoodArrayList.add(dummyData);
        FoodArrayList.add(dummyData);
        FoodArrayList.add(dummyData);
        FoodArrayList.add(dummyData);

        FoodAdapter FoodAdapter = new FoodAdapter(getContext(),FoodArrayList);
        rvRecyclerView.setHasFixedSize(true);
        rvRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvRecyclerView.setAdapter(FoodAdapter);

        Log.d(TAG, "onCreateView: "+FoodArrayList.size());
        return  rvRecyclerView;
    }

}
