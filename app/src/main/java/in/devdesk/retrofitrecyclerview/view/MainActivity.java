package in.devdesk.retrofitrecyclerview.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import in.devdesk.retrofitrecyclerview.R;
import in.devdesk.retrofitrecyclerview.model.Item;
import in.devdesk.retrofitrecyclerview.model.adapter.ItemAdapter;
import in.devdesk.retrofitrecyclerview.model.helper.Constants;
import in.devdesk.retrofitrecyclerview.presenter.RestManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ItemAdapter.ItemClickListener {


    private RecyclerView mRecyclerView;
    private RestManager mManager;
    private ItemAdapter mItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configViews();
        mManager = new RestManager();
        Call<List<Item>> listCall = mManager.getmItemService().getAllItems();
        listCall.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {

                if (response.isSuccessful())
                {
                    List<Item> itemList = response.body();

                    for (int i = 0; i < itemList.size(); i++)
                    {
                        Item item = itemList.get(i);
                        mItemAdapter.addItem(item);
                    }

                }
                else {
                    int sc = response.code();
                    switch (sc) {
                        case 400:
                            Log.e("Error 400", "Bad Request");
                            break;
                        case 404:
                            Log.e("Error 404", "Not Found");
                            break;
                        default:
                            Log.e("Error", "Generic Error");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });
    }

    private void configViews() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        mItemAdapter = new ItemAdapter(this);
        mRecyclerView.setAdapter(mItemAdapter);
    }

    @Override
    public void onClick(int position) {
        Item selectedItem = mItemAdapter.getSelectedItem(position);
        Toast.makeText(this, "on click listened", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(Constants.REFERENCE.ITEM , selectedItem);
        startActivity(intent);
    }
}
