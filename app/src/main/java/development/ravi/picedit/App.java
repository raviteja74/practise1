package development.ravi.picedit;

import android.app.Application;

import development.ravi.picedit.di.AppComponent;
import development.ravi.picedit.di.DaggerAppComponent;
import development.ravi.picedit.di.modules.AppModule;
import development.ravi.picedit.di.modules.EditorModule;

public class App extends Application {
    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
           return sAppComponent;
    }
}