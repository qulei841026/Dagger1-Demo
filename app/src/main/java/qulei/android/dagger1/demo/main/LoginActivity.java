package qulei.android.dagger1.demo.main;

import android.os.Bundle;

import java.util.Collections;

import qulei.android.dagger1.demo.MainApplication;
import qulei.android.dagger1.demo.R;
import qulei.android.dagger1.demo.abs.AbsActivity;
import qulei.android.dagger1.demo.processor.LoginModule;

/**
 * 登录LoginActivity
 * <p/>
 * <p>手动增加一个loginModule</p>
 */
public class LoginActivity extends AbsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginFragment fragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.loginFragment);

        pushGraph((MainApplication) getApplication(),
                Collections.<Object>singletonList(new LoginModule(fragment)));
    }

}
