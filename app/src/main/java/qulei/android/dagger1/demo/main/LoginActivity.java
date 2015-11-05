package qulei.android.dagger1.demo.main;

import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import qulei.android.dagger1.demo.R;
import qulei.android.dagger1.demo.abs.AbsActivity;
import qulei.android.dagger1.demo.provider.MessageProvider;

/**
 * 登录LoginActivity
 * <p/>
 * <p>手动增加一个loginModule</p>
 */
public class LoginActivity extends AbsActivity {

    @Inject
    MessageProvider messageProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("LoginActivity", "MessageUnread = " + messageProvider.getMessageUnread());
    }

    @Override
    protected boolean isInject() {
        return true;
    }
}
