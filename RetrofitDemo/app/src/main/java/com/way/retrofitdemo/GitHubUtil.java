package com.way.retrofitdemo;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by pc on 2016/11/25.
 */

public class GitHubUtil {
    private final static String TAG = GitHubUtil.class.getName();

//    public List<Repo> getGitHubRepositories(String username) {
//        Log.i(TAG, "getGitHubRepositories Debug, Start");
//        //List<Repo> data=null;
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .build();
//
//        GitHubService service = retrofit.create(GitHubService.class);
//        Call<List<Repo>> repos = service.listRepos(username);
//        // 同步调用
//        //List<Repo> data = repos.execute();
//        repos.enqueue(new Callback<List<Repo>>() {
//            @Override
//            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
//                List<Repo> data = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<List<Repo>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
//        // 异步调用
////        repos.enqueue(new Callback<List<Repo>>() {
////            @Override
////            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
////
////            }
////
////            @Override
////            public void onFailure(Call<List<Repo>> call, Throwable t) {
////                t.printStackTrace();
////            }
////        });
//
//    }
}
