package qulei.android.dagger1.demo.processor;

import dagger.Module;
import dagger.Provides;
import qulei.android.dagger1.demo.main.LoginActivity;
import qulei.android.dagger1.demo.main.LoginFragment;
import qulei.android.dagger1.demo.MainApplication;
import qulei.android.dagger1.demo.main.AppModule;
import qulei.android.dagger1.demo.provider.AuthProvider;
import qulei.android.dagger1.demo.provider.MessageProvider;


@Module(
        injects = {     //注入到LoginActivity，LoginFragment
                LoginActivity.class,
                LoginFragment.class
        },
        addsTo = AppModule.class    //并入到AppModule图谱中。
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
