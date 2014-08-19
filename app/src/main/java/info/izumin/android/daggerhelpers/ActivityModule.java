package info.izumin.android.daggerhelpers;

import android.app.Activity;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.ObjectGraph;
import dagger.Provides;
import info.izumin.android.daggerhelpers.annotation.ForActivity;
import info.izumin.android.daggerhelpers.ui.DaggerActivity;

/**
 * Created by izumin on 2014/08/19.
 */
@Module(
        complete = false,
        library = true
)
public class ActivityModule {
    public static final String TAG = ActivityModule.class.getSimpleName();

    private final Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @Singleton
    ObjectGraph provideActivityGraph() {
        return ((DaggerActivity) mActivity).getObjectGraph();
    }

    @Provides
    @Singleton
    @ForActivity
    Context provideActivityContext() {
        return mActivity;
    }

    @Provides
    @Singleton
    Activity provideActivity() {
        return mActivity;
    }
}
