package qulei.android.dagger1.demo.provider;

import java.util.List;

import qulei.android.dagger1.demo.model.Message;

public interface MessageProvider {

    void syncMessageCount();

    void findMessageItems(OnFindMessageListener listener);

    interface OnFindMessageListener {
        void onItems(List<Message> items);
    }

    int getMessageUnread();

}
