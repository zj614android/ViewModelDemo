package proxy.zj.com.livedatademo;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import proxy.zj.com.livedatademo.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity implements LifecycleRegistryOwner {


    private LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserViewModel model = ViewModelProviders.of(this).get(UserViewModel.class);
        final MutableLiveData<List<UserLiveData>> users = model.getUsers();
        users.observe(this, new Observer<List<UserLiveData>>() {

                    @Override
                    public void onChanged(@Nullable List<UserLiveData> userLiveData) {
                        Log.e("MainActivity","更新UI");
                    }
                });


        findViewById(R.id.btnclick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                users.setValue(new ArrayList<UserLiveData>());
            }
        });
    }


    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }
}
