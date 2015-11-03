package qulei.android.dagger1.demo.provider;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import qulei.android.dagger1.demo.model.Message;

class MessageProviderImpl implements MessageProvider {

    protected int unreadCount;

    Context mContext;

    public MessageProviderImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public void syncMessageCount() {
        unreadCount = 10;

    }

    @Override
    public void findMessageItems(OnFindMessageListener listener) {
        List<Message> list = new ArrayList<>(unreadCount);
        for (int i = 0; i < unreadCount; i++) {
            list.add(new Message(i, "Message:" + i));
        }

        if (listener != null)
            listener.onItems(list);
    }

    @Override
    public int getMessageUnread() {
        return unreadCount;
    }
}
