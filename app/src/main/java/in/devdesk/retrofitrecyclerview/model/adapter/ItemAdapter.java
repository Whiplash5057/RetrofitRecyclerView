package in.devdesk.retrofitrecyclerview.model.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import in.devdesk.retrofitrecyclerview.R;
import in.devdesk.retrofitrecyclerview.model.Item;
import in.devdesk.retrofitrecyclerview.model.helper.Constants;

/**
 * Created by richardandrews on 06/07/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.Holder> {

    private ItemClickListener mListener;
    private List<Item> mItems;

    public ItemAdapter(ItemClickListener listener) {
        mItems = new ArrayList<>();
        mListener = listener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, null, false);

        return new Holder(row);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Item currentItem = mItems.get(position);
        holder.mName.setText(currentItem.getName());
        holder.mPrice.setText("$ " +Double.toString(currentItem.getPrice()));

        Picasso.with(holder.itemView.getContext()).load( Constants.HTTP.BASE_URL + "/photos/" + currentItem.getPhoto()).into(holder.mPhoto );
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public void addItem(Item item) {
        mItems.add(item);
        notifyDataSetChanged();
    }

    public Item getSelectedItem(int position) {
        return mItems.get(position);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        private ImageView mPhoto;
        private TextView mName, mPrice;
        public Holder(View itemView) {
            super(itemView);

            mPhoto = (ImageView) itemView.findViewById(R.id.itemPhoto);
            mName = (TextView) itemView.findViewById(R.id.itemName);
            mPrice = (TextView) itemView.findViewById(R.id.itemPrice);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mListener.onClick(getLayoutPosition());
        }
    }

    public interface ItemClickListener{
        void onClick(int position);
    }
}
