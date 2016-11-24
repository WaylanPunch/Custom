package com.way.retrofitdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getName();

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private Button btnGetRepos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        btnGetRepos = (Button) findViewById(R.id.btnGetRepos);
        btnGetRepos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getGitHubRepositories("waylanpunch");
            }
        });
    }

    private void getGitHubRepositories(String username) {
        Log.i(TAG, "getGitHubRepositories Debug, Start");
        //List<Repo> data=null;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Repo>> repos = service.listRepos(username);
        // 同步调用
        //List<Repo> data = repos.execute();
        repos.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> data = response.body();
                if (null != data) {
                    Log.i(TAG, "getGitHubRepositories Debug, Repos Count = " + data.size());
                } else {
                    Log.i(TAG, "getGitHubRepositories Debug, Repos == NULL");
                }
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {
                if (null != t) {
                    Log.e(TAG, "getGitHubRepositories Debug, Error", t);
                    t.printStackTrace();
                }
            }
        });
        Log.i(TAG, "getGitHubRepositories Debug, End");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
