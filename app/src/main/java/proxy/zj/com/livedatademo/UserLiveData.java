package proxy.zj.com.livedatademo;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LiveData;
import android.util.Log;

/**
 * Created by thinkpad on 2018/2/26.
 */

public class UserLiveData extends LiveData implements LifecycleObserver {

    private static final String TAG = "UserLiveData";

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserLiveData() {
    }

    @Override
    protected void onActive() {
        super.onActive();
        Log.e(TAG, "onActive");
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        Log.e(TAG, "onInactive");
    }

    @Override
    protected void setValue(Object value) {
        super.setValue(value);
        Log.e(TAG, "setValue");
    }


}
