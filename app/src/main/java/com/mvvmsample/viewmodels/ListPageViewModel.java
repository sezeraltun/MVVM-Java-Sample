package com.mvvmsample.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.mvvmsample.models.UserModel;
import com.mvvmsample.repo.UserDataRepository;

import java.util.List;

public class ListPageViewModel extends ViewModel {

    private LiveData<List<UserModel>> mUserData;
    public LiveData<String> deneme;
    private UserDataRepository userRepository;

    public LiveData<String> getdeneme() {
        return deneme;
    }

    public LiveData<List<UserModel>> getmUserData() {
        return mUserData;
    }

    public void init (){
        if (mUserData!=null){
            return;
        }
        userRepository = UserDataRepository.getInstance();
        mUserData=userRepository.getUsersData();
    }


}
