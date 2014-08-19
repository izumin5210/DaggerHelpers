package info.izumin.android.daggerhelpers;

import android.app.Application;
import android.content.Context;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.view.WindowManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;
import info.izumin.android.daggerhelpers.annotation.ForApplication;
import info.izumin.android.daggerhelpers.application.DaggerApplication;

/**
 * Created by izumin on 2014/08/19.
 */
@Module(
        library = true
)
public class AndroidModule {
    public static final String TAG = AndroidModule.class.getSimpleName();

    private Application mApplication;

    public AndroidModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    ObjectGraph provideApplicationGraph() {
        return ((DaggerApplication) mApplication).getObjectGraph();
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) mApplication.getSystemService(Context.LOCATION_SERVICE);
    }

    @Provides
    @Singleton
    SensorManager provideSensorManager() {
        return (SensorManager) mApplication.getSystemService(Context.SENSOR_SERVICE);
    }

    @Provides
    @Singleton
    WindowManager provideWindowManager() {
        return (WindowManager) mApplication.getSystemService(Context.WINDOW_SERVICE);
    }
}
