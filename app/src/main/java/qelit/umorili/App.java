package qelit.umorili;

import android.app.Application;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Qelit on 31.03.2017.
 */

public class App extends Application {
    private static UmoriliApi umoriliApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("http://www.umori.li/") // базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) // конвертер, необходимый для преобразования JSON в объекты
                .build();
        umoriliApi = retrofit.create(UmoriliApi.class); // создаём объект, при помощи которого будем выполнять запросы

    }

    public static UmoriliApi getApi(){
        return umoriliApi;
    }
}
