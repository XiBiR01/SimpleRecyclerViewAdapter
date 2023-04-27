package com.example.recyclerviewlinearlayoutmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.recyclerviewlinearlayoutmanager.Adapters.GameCardAdapter;
import com.example.recyclerviewlinearlayoutmanager.Models.GameCardModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    private void initData() {
        ArrayList<GameCardModel> gameData = new ArrayList<>();
        gameData.add(new GameCardModel("Call of Duty Warzone", R.drawable.cod));
        gameData.add(new GameCardModel("Watch Dogs Legion", R.drawable.wdl));
        gameData.add(new GameCardModel("Mafia Definitive Edition", R.drawable.md));
        gameData.add(new GameCardModel("Microsoft Flight Simulator", R.drawable.mfs));
        gameData.add(new GameCardModel("Last of Us", R.drawable.loa));
        gameData.add(new GameCardModel("Valorant", R.drawable.val));
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        GameCardAdapter adapter = new GameCardAdapter(getApplicationContext(), gameData);
        recyclerView.setAdapter(adapter);
//        GridLayoutManager lm= new GridLayoutManager(this,2);
//        StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager lm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(lm);
    }
    //    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.options_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.about) {
//            Toast.makeText(this, "Just For Fun", Toast.LENGTH_SHORT).show();
//        }
//        return true;
//    }

}
