package in.devdesk.retrofitrecyclerview.model.callback;

import java.util.List;

import in.devdesk.retrofitrecyclerview.model.Item;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by richardandrews on 06/07/17.
 */

public interface ItemService {

    @GET("/feeds/flowers.json")
    Call<List<Item>> getAllItems();
}
