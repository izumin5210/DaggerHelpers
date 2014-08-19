package info.izumin.android.daggerhelpers.application;

import android.app.Application;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;
import info.izumin.android.daggerhelpers.AndroidModule;
import info.izumin.android.daggerhelpers.DaggerContext;

/**
 * Created by izumin on 2014/08/19.
 */
public class DaggerApplication extends Application implements DaggerContext {
    public static final String TAG = DaggerApplication.class.getSimpleName();

    private ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        mObjectGraph = ObjectGraph.create(getModules().toArray());
        mObjectGraph.inject(this);
    }

    @Override
    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(new AndroidModule(this));
    }
}
