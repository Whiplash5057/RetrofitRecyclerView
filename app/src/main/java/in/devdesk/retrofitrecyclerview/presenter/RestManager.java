package in.devdesk.retrofitrecyclerview.presenter;

import in.devdesk.retrofitrecyclerview.model.callback.ItemService;
import in.devdesk.retrofitrecyclerview.model.helper.Constants;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by richardandrews on 06/07/17.
 */

public class RestManager {


    private ItemService mItemService;


    public ItemService getmItemService()
    {
        if(mItemService == null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.HTTP.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            mItemService = retrofit.create(ItemService.class);
        }

        return mItemService;
    }


}
