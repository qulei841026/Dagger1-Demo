package qulei.android.dagger1.demo.processor;

import dagger.Module;
import dagger.Provides;
import qulei.android.dagger1.demo.LoginActivity;
import qulei.android.dagger1.demo.LoginFragment;
import qulei.android.dagger1.demo.MainApplication;
import qulei.android.dagger1.demo.module.AppModule;
import qulei.android.dagger1.demo.provider.AuthProvider;
import qulei.android.dagger1.demo.provider.MessageProvider;


@Module(
        injects = {
                LoginActivity.class,
                LoginFragment.class
        },
        addsTo = AppModule.class
)
public class LoginModule {

    private LoginListener loginListener;

    public LoginModule(LoginListener listener) {
        this.loginListener = listener;
    }

    @Provides
    public LoginListener provideLoginListener() {
        return loginListener;
    }

    @Provides
    public LoginProcessor provideLoginProcessor(MainApplication application,
                                                LoginListener loginListener,
                                                AuthProvider authProvider,
                                                MessageProvider messageProvider) {
        LoginProcessorImpl impl = new LoginProcessorImpl(application, loginListener);
        impl.setAuthProvider(authProvider);
        impl.setMessageProvider(messageProvider);
        return impl;
    }

}
