package com.example.harsh.fetch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.harsh.fetch.adapter.itemAdapter;
import com.example.harsh.fetch.model.itemModel;
import com.example.harsh.fetch.network.ApiService;
import com.example.harsh.fetch.network.RetroInstance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<itemModel> responseList = new ArrayList<itemModel>();
    private RecyclerView rcv_fetch;
    private itemAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv_fetch = findViewById(R.id.rcv_fetch);

        getDetails();

    }
    private void initRecyclerView(List<itemModel> filterList){
        rcv_fetch = findViewById(R.id.rcv_fetch);
        adapter = new itemAdapter(this, filterList);
        rcv_fetch.setLayoutManager(new GridLayoutManager(this, 1));
        rcv_fetch.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    public void getDetails() {
        ApiService service = RetroInstance.getRetroClient().create(ApiService.class);
        Call<List<itemModel>> call = service.getJson();
        call.enqueue(new Callback<List<itemModel>>() {
            @Override
            public void onResponse(Call<List<itemModel>> call, Response<List<itemModel>> response) {
                if (response.isSuccessful()) {
                    responseList = response.body();

                    List<itemModel> filterList = new ArrayList<>();
                    for (itemModel obj : responseList) {
                        //filtered out null and "" name
                        if (obj.getName() != null && !obj.getName().equals("")) {
                            filterList.add(obj);
                        }
                    }
                    //First sorted by name and then sort by listid
                    Collections.sort(filterList, itemModel.COMPARE_BY_NAME); //Sort by name
                    Collections.sort(filterList, itemModel.COMPARE_BY_LISTID); //Sort by listid
                    //recycler view
                    initRecyclerView(filterList);
                }
            }

            @Override
            public void onFailure(Call<List<itemModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Could not find the URL", Toast.LENGTH_SHORT).show();
            }
        });
    }

}