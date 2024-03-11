package poly.quylpph27484.assignmentapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayout searchView;
    private UserAdapter userAdapter;
    private Button btnLoadMore;
    private ProgressBar progressBar;
    private  int userId = 1;

    private List<Albums> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchbar);
        recyclerView = findViewById(R.id.recycler_view);
        btnLoadMore = findViewById(R.id.btnLoadMore);
        progressBar = findViewById(R.id.progressbar);


        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SearchActivity.class));
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);

        getUserData();

        btnLoadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userId ++;
                getUserData();

            }
        });
    }

    private void getUserData() {
        progressBar.setVisibility(View.VISIBLE);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Albums>> call = apiService.getUsers( userId);

        call.enqueue(new Callback<List<Albums>>() {
            @Override
            public void onResponse(Call<List<Albums>> call, Response<List<Albums>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    progressBar.setVisibility(View.GONE);
                    userList.addAll(response.body());
                    userAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Albums>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                t.printStackTrace();
            }
        });
    }

    private void performSearch(String query) {

    }
}
