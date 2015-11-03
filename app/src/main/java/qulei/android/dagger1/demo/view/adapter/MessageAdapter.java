package qulei.android.dagger1.demo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import qulei.android.dagger1.demo.R;
import qulei.android.dagger1.demo.model.Message;


public class MessageAdapter extends ListCacheAdapter<Message> {

    public MessageAdapter(Context context) {
        super(context);
    }

    @Override
    public ListCacheHolder getHolder() {
        return new BaseHolder();
    }

    @Override
    public void updateView(ListCacheHolder holder, int position) {
        Message message = getItem(position);
        ((BaseHolder) holder).tvItemMessage.setText(message.title);
    }

    static class BaseHolder implements ListCacheHolder {

        TextView tvItemMessage;

        @Override

        public View createView(LayoutInflater inflater, ViewGroup parent, int position) {
            return inflater.inflate(R.layout.layout_item_message, parent, false);
        }

        @Override
        public void initView(View convertView, int position) {
            tvItemMessage = (TextView) convertView.findViewById(R.id.tvItemMessage);
        }
    }

}
