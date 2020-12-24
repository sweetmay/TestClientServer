package org.example.client.model.retrofit.repo;

import io.reactivex.rxjava3.core.Single;
import org.example.client.model.retrofit.entity.Contract;

import java.util.List;

public interface IRepo {
    Single<List<Contract>> getContracts();
}
