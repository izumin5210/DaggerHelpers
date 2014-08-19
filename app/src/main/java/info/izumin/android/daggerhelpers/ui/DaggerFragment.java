package info.izumin.android.daggerhelpers.ui;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by izumin on 2014/08/19.
 */
public class DaggerFragment extends Fragment {
    public static final String TAG = DaggerFragment.class.getSimpleName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((DaggerActivity) getActivity()).getObjectGraph().inject(this);
    }
}
