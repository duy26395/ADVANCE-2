package com.example.mypc.reactivex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String Base_URL = "https://api.learn2crack.com/";
    private RecyclerView recyclerView;
    private CompositeDisposable disposable;
    private ArrayAdapter arrayAdapter;
    private ArrayList<Data> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disposable = new CompositeDisposable();
        init();
        Log.i("ahihi","ahihiaadsađá");
        Loadjson();
    }

    public void init() {
    recyclerView = (RecyclerView)findViewById(R.id.idrecycle);
        //recyclerView.setHasFixedSize(true);
        Log.i("ccc","cqq");
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

    }
    public void Loadjson() {
        Resquest resquest = new Retrofit.Builder()
                .baseUrl(Base_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Resquest.class);
        Log.i("ầdsd",Base_URL);

        disposable.add(resquest.register()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this:: handleRes,this :: Error)
        );
    }

    private void Error(Throwable throwable) {
        Toast.makeText(this, "Error "+throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

    }

    private void handleRes(List<Data> data) {
        list = new ArrayList<>(data);
        arrayAdapter = new ArrayAdapter(list);
        recyclerView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}

