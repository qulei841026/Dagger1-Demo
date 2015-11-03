package qulei.android.dagger1.demo.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import qulei.android.dagger1.demo.MainApplication;
import qulei.android.dagger1.demo.provider.AuthProvider;
import qulei.android.dagger1.demo.provider.AuthProviderImpl;
import qulei.android.dagger1.demo.provider.MessageProvider;
import qulei.android.dagger1.demo.provider.MessageProviderImpl;


@Module(
        library = true,
        complete = false
)
public class ProviderModule {

    @Provides
    public AuthProvider provideAuthProvider(MainApplication application) {
        return new AuthProviderImpl(application);
    }

    @Provides
    @Singleton
    public MessageProvider provideMessageProvider(MainApplication application) {
        return new MessageProviderImpl(application);
    }

}
