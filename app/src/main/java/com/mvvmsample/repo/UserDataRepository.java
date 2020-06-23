package com.mvvmsample.repo;

import android.service.autofill.UserData;

import androidx.lifecycle.MutableLiveData;

import com.mvvmsample.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserDataRepository {

    private static UserDataRepository instance;
    private ArrayList<UserModel> data = new ArrayList<>();
    public static UserDataRepository getInstance() {
        if(instance==null){
            instance = new UserDataRepository();
        }

        return instance;
    }


    public MutableLiveData<List<UserModel>> getUsersData(){

        setData();
        MutableLiveData<List<UserModel>> data = new MutableLiveData<>();
        data.setValue(this.data);
        return data;

    }

    private void setData(){

        data.add(new UserModel("234f23f3f32f","Sezer",30));
        data.add(new UserModel("23423523f3f3f","Merve",15));
        data.add(new UserModel("sdfsf323rf23fr","Nur",20));
        data.add(new UserModel("231332423ede2","Nur",50));
    }

}
