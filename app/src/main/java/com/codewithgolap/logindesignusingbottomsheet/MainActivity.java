package com.codewithgolap.logindesignusingbottomsheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<String> moviesList;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(moviesList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        moviesList.add("Captain America");
        moviesList.add("The Fantastic Four");
        moviesList.add("Howard the Duck");
        moviesList.add("Blade");
        moviesList.add("X-Men");
        moviesList.add("Spider-Man");
        moviesList.add("Daredevil");
        moviesList.add("Hulk");
        moviesList.add("The Punisher");
        moviesList.add("Ghost Rider");
        moviesList.add("Iron Man");
        moviesList.add("Thor");
        moviesList.add("The Avengers");
        moviesList.add("Guardians of the Galaxy");
        moviesList.add("Ant-Man");
        moviesList.add("Deadpool");
        moviesList.add("Doctor Strange");
        moviesList.add("Logan");
        moviesList.add("Black Panther");
        moviesList.add("Venom");
        moviesList.add("Dark Phoenix");
        moviesList.add("The New Mutants");


        //swipe to refresh code
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                moviesList.add("Black Window (2020)");
                moviesList.add("The Eternals (2020)");
                moviesList.add("Shang-Chi and the Legend of the Ten Rings (2021)");
                moviesList.add("Doctor Strange in the Multiverse of Madness (2021)");
                moviesList.add("Thor: Love and Thunder (2021)");

                recyclerAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }
}