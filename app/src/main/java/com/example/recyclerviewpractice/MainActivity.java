package com.example.recyclerviewpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MedicineAdapter.ItemClicked {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<Medicine> medicines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(true);

        //layoutManager = new LinearLayoutManager(this);
        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        medicines = new ArrayList<>();
        medicines = updateMedicineList(medicines);
        //for(int i=0; i<medicines.size(); i++) System.out.println(medicines.get(i).getName());

        recyclerViewAdapter = new MedicineAdapter(this, medicines);
        recyclerView.setAdapter(recyclerViewAdapter);

        //recyclerViewAdapter.notifyDataSetChanged();
    }

    ArrayList<Medicine> updateMedicineList (ArrayList<Medicine> medicines){
        medicines.add(new Medicine("Xeldrin", 450, 50));
        medicines.add(new Medicine("Emistat", 500, 1000));
        medicines.add(new Medicine("Lesix", 60, 1000));
        medicines.add(new Medicine("Dicaltrol", 440, 30));

        medicines.add(new Medicine("Xeldrin", 450, 50));
        medicines.add(new Medicine("Emistat", 500, 1000));
        medicines.add(new Medicine("Lesix", 60, 1000));
        medicines.add(new Medicine("Dicaltrol", 440, 30));

        medicines.add(new Medicine("Xeldrin", 450, 50));
        medicines.add(new Medicine("Emistat", 500, 1000));
        medicines.add(new Medicine("Lesix", 60, 1000));
        medicines.add(new Medicine("Dicaltrol", 440, 30));

        return medicines;
    }

    @Override
    public void onItemClicked(int index) {
        Toast.makeText(this, medicines.get(index).getName(), Toast.LENGTH_SHORT);
        System.out.println(medicines.get(index).getName());
    }
}
