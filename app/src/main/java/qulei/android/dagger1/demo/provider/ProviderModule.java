package qulei.android.dagger1.demo.provider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import qulei.android.dagger1.demo.MainApplication;


@Module(    //Adapter的注入声明，不能直接使用。通过AppModule引入。
        library = true,     //是组件
        complete = false    //不是完成的Module
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
