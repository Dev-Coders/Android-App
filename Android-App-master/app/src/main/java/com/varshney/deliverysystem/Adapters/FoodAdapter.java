package com.varshney.deliverysystem.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.varshney.deliverysystem.Pojos.Food;
import com.varshney.deliverysystem.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

/**
 * Created by yash on 23/3/18.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    public static final String TAG = "FA";
    Context context;
    ArrayList<Food> foodArrayList = new ArrayList<>();
    public static final String URL = "https://c3ee6de1.ngrok.io/order";

    public FoodAdapter(Context context, ArrayList<Food> FoodArrayList) {
        this.context = context;
        this.foodArrayList = FoodArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.fragment_food,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: "+position);
        Food thisItem = foodArrayList.get(position);
        // holder.tvCount.setText(thisItem.getCount_of_item());
        holder.tvName.setText(thisItem.getName());
        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestQueue queue = Volley.newRequestQueue(context);

                JSONObject jsonObject = new JSONObject();

                try{
                    jsonObject.put("UserName","yash");
                    jsonObject.put("Latitude","123");
                    jsonObject.put("Longitude","456");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST,URL, jsonObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "onResponse: " + response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: "+error.toString());
                    }
                });

                queue.add(request);

            }
        });
    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        //TextView tvCount;
        TextView tvName;
        ImageView ivFavourite;
        Button btnBuy;
        View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            // tvCount = itemView.findViewById(R.id.tvCount);
            tvName = itemView.findViewById(R.id.tvCardTitle);
            btnBuy = itemView.findViewById(R.id.btnBuy);
            this.itemView = itemView;
        }
    }
}
