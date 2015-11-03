package qulei.android.dagger1.demo.main;

import dagger.Module;
import dagger.Provides;
import qulei.android.dagger1.demo.MainApplication;
import qulei.android.dagger1.demo.provider.ProviderModule;
import qulei.android.dagger1.demo.view.adapter.AdapterModule;

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
