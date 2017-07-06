package in.devdesk.retrofitrecyclerview.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import in.devdesk.retrofitrecyclerview.R;
import in.devdesk.retrofitrecyclerview.model.Item;
import in.devdesk.retrofitrecyclerview.model.helper.Constants;

public class DetailActivity extends AppCompatActivity {


    private ImageView mPhoto;
    private TextView mName, mId, mCategory, mInstruction, mPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();

        Item item = (Item) intent.getSerializableExtra(Constants.REFERENCE.ITEM);

        configViews();

        mId.setText(String.format("%d", item.getProductId()));
        mName.setText(item.getName());
        mCategory.setText(item.getCategory());
        mInstruction.setText(item.getInstructions());
        mPrice.setText(String.format("$%.2f", item.getPrice()));
        Picasso.with(getApplicationContext()).load( Constants.HTTP.BASE_URL + "/photos/" + item.getPhoto() ).into(mPhoto);
    }

    private void configViews() {
        mPhoto = (ImageView) findViewById(R.id.itemPhoto);
        mName = (TextView) findViewById(R.id.itemName);
        mId = (TextView) findViewById(R.id.itemId);
        mCategory = (TextView) findViewById(R.id.itemCategory);
        mInstruction = (TextView) findViewById(R.id.itemInstruction);
        mPrice = (TextView) findViewById(R.id.itemPrice);
    }
}
