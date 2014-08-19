package info.izumin.android.daggerhelpers.ui;

import android.app.Activity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;
import info.izumin.android.daggerhelpers.ActivityModule;
import info.izumin.android.daggerhelpers.DaggerContext;
import info.izumin.android.daggerhelpers.application.DaggerApplication;

/**
 * Created by izumin on 2014/08/19.
 */
public class DaggerActivity extends Activity implements DaggerContext {
    public static final String TAG = DaggerActivity.class.getSimpleName();

    private ObjectGraph mObjectGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerApplication application = (DaggerApplication) getApplication();
        mObjectGraph = application.getObjectGraph().plus(getModules().toArray());

        mObjectGraph.inject(this);
    }

    @Override
    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }

    protected List<Object> getModules() {
        return Arrays.<Object>asList(new ActivityModule(this));
    }
}
