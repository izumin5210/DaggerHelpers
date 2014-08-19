package info.izumin.android.daggerhelpers.util;

import android.content.Context;

import dagger.ObjectGraph;
import info.izumin.android.daggerhelpers.DaggerContext;

/**
 * Created by izumin on 2014/08/19.
 */
public final class DaggerUtils {
    private DaggerUtils() {
        throw new AssertionError("constructor of the utility class should not be called");
    }

    public static ObjectGraph getObjectGraph(Context context) {
        if (context instanceof DaggerContext) {
            return ((DaggerContext) context).getObjectGraph();
        }
        throw new IllegalArgumentException();
    }
}