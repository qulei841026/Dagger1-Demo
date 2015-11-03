package qulei.android.dagger1.demo.processor;

import android.content.Context;

import qulei.android.dagger1.demo.provider.AuthProvider;
import qulei.android.dagger1.demo.provider.MessageProvider;

public class LoginProcessorImpl implements LoginProcessor {

    Context mContext;

    private AuthProvider authProvider;

    private MessageProvider messageProvider;

    private LoginListener loginListener;

    public LoginProcessorImpl(Context context, LoginListener listener) {
        this.mContext = context;
        this.loginListener = listener;
    }

    public void setAuthProvider(AuthProvider authProvider) {
        this.authProvider = authProvider;
    }

    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public void login() {
        authProvider.login();
        messageProvider.syncMessageCount();
        loginListener.onSuccess();
    }
}
