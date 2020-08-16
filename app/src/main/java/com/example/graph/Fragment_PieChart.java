package com.example.graph;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Fragment_PieChart extends Fragment {
    EditText l1, l2, l3, v1, v2, v3;
    Button button;
    PieChart pieChart;
    PieData pieData;
    PieDataSet pieDataSet;
    ArrayList<PieEntry> entries;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.piechart, container, false);

        getActivity().setTitle("Pie Chart"); //set fragment name

        pieChart=view.findViewById(R.id.piechart);
        v1=view.findViewById(R.id.ved1);
        v2=view.findViewById(R.id.ved2);
        v3=view.findViewById(R.id.ved3);
        l1=view.findViewById(R.id.led1);
        l2=view.findViewById(R.id.led2);
        l3=view.findViewById(R.id.led3);
        button=view.findViewById(R.id.showResult);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entries=new ArrayList<>();
                entries.add(new PieEntry(Float.parseFloat(v1.getText().toString()),l1.getText().toString()));
                entries.add(new PieEntry(Float.parseFloat(v2.getText().toString()),l2.getText().toString()));
                entries.add(new PieEntry(Float.parseFloat(v3.getText().toString()),l3.getText().toString()));

                pieDataSet=new PieDataSet(entries,"Companies");
                pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                pieDataSet.setValueTextSize(15f);
                pieDataSet.setValueTextColor(Color.BLUE);
                pieDataSet.setVisible(true);

                pieData=new PieData(pieDataSet);
                pieChart.setData(pieData);
                pieChart.getDescription().setEnabled(false);
                pieChart.setCenterText("Graph Is Shown.");
                pieChart.animateX(1000);
            }
        });


        return view;
    }


}
