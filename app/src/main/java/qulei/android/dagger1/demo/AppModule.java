package qulei.android.dagger1.demo;

import dagger.Module;
import dagger.Provides;
import qulei.android.dagger1.demo.view.adapter.AdapterModule;
import qulei.android.dagger1.demo.provider.ProviderModule;

@Module(
        injects = { //注入到MainApplication
                MainApplication.class
        },
        includes = { //引入依赖的Module
                ProviderModule.class,
                AdapterModule.class
        }
)
public class AppModule {

    private MainApplication app;

    public AppModule(MainApplication app) {
        this.app = app;
    }

    @Provides
    public MainApplication provideApplication() {
        return app;
    }
}
