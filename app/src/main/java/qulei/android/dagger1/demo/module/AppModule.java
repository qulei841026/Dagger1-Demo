package qulei.android.dagger1.demo.module;

import dagger.Module;
import dagger.Provides;
import qulei.android.dagger1.demo.MainApplication;

@Module(
        injects = {
                MainApplication.class
        },
        includes = {
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
