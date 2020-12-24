package org.example.client.model.retrofit;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHolder {

    private final DataSource dataSource;

    public ApiHolder(String baseUrl){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
        dataSource = retrofit.create(DataSource.class);
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
