package proxy.zj.com.livedatademo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import proxy.zj.com.livedatademo.UserLiveData;

/**
 * Created by thinkpad on 2018/2/26.
 */

public class UserViewModel extends ViewModel{

    private MutableLiveData<List<UserLiveData>> users;

    public MutableLiveData<List<UserLiveData>> getUsers() {
        if(null == users){
            users = new MutableLiveData();
        }
        loadUsers();
        return users;
    }

    private void loadUsers() {
        // do async operation to fetch users
        // 通过网络加载用户列表数据 ...

    }
}
