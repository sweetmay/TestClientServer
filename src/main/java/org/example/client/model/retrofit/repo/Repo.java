package org.example.client.model.retrofit.repo;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import org.example.client.model.retrofit.ApiHolder;
import org.example.client.model.retrofit.DataSource;
import org.example.client.model.retrofit.entity.Contract;
import org.example.client.model.retrofit.repo.IRepo;

import java.util.List;

public class Repo implements IRepo {

    DataSource dataSource;

    public Repo(ApiHolder apiHolder) {
        dataSource = apiHolder.getDataSource();
    }

    @Override
    public Single<List<Contract>> getContracts() {
        return dataSource.getContracts().subscribeOn(Schedulers.io());
    }
}
