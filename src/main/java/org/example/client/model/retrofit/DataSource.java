package org.example.client.model.retrofit;

import io.reactivex.rxjava3.core.Single;
import org.example.client.model.retrofit.entity.Contract;
import retrofit2.http.GET;

import java.util.List;

public interface DataSource {
    @GET("/contracts")
    Single<List<Contract>> getContracts();
}
