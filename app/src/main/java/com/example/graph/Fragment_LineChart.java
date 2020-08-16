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

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Fragment_LineChart extends Fragment {
    EditText ed_x1,ed_x2,ed_x3,ed_x4,ed_y1,ed_y2,ed_y3,ed_y4;
    Button showResult;
    private LineChart lineChart;
    LineData lineData;
    LineDataSet lineDataSet;
    ArrayList lineEntries;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.linechart, container, false);

        getActivity().setTitle("Line Chart"); //set fragment name
        lineChart=view.findViewById(R.id.linechart);
        showResult=view.findViewById(R.id.showResult);
        ed_x1=view.findViewById(R.id.xed1);
        ed_x2=view.findViewById(R.id.xed2);
        ed_x3=view.findViewById(R.id.xed3);
        ed_x4=view.findViewById(R.id.xed4);
        ed_y1=view.findViewById(R.id.yed1);
        ed_y2=view.findViewById(R.id.yed2);
        ed_y3=view.findViewById(R.id.yed3);
        ed_y4=view.findViewById(R.id.yed4);

        showResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lineEntries=new ArrayList();
                lineEntries.add(new Entry(Float.parseFloat(ed_x1.getText().toString()),Float.parseFloat(ed_y1.getText().toString())));
                lineEntries.add(new Entry(Float.parseFloat(ed_x2.getText().toString()),Float.parseFloat(ed_y2.getText().toString())));
                lineEntries.add(new Entry(Float.parseFloat(ed_x3.getText().toString()),Float.parseFloat(ed_y3.getText().toString())));
                lineEntries.add(new Entry(Float.parseFloat(ed_x4.getText().toString()),Float.parseFloat(ed_y4.getText().toString())));

                lineDataSet =new LineDataSet(lineEntries,"Graph Is Shown.");
                lineDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                lineDataSet.setValueTextColor(Color.MAGENTA);
                lineDataSet.setLineWidth(3f);
                lineDataSet.setValueTextSize(16f);

                lineData= new LineData(lineDataSet);
                lineChart.setData(lineData);
                lineChart.animate();
                lineChart.animateX(500);


            }
        });





        return view;
    }


}
