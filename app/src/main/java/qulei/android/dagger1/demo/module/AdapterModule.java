package qulei.android.dagger1.demo.module;

import dagger.Module;
import dagger.Provides;
import qulei.android.dagger1.demo.MainApplication;
import qulei.android.dagger1.demo.view.adapter.MessageAdapter;

@Module(
        library = true,
        complete = false
)
public class AdapterModule {

    @Provides
    public MessageAdapter provideMessageAdapter(MainApplication application) {
        return new MessageAdapter(application);
    }

}
