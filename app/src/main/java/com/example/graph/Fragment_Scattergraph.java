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

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Fragment_Scattergraph extends Fragment {
    EditText ed_x1,ed_x2,ed_x3,ed_x4,ed_x5,ed_y1,ed_y2,ed_y3,ed_y4,ed_y5;
    Button showResult;
    ScatterChart scatterChart;
    ScatterData scatterData;
    ScatterDataSet scatterDataSet;
    ArrayList barEnteries;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.scattergraph_fragment,container,false);

        getActivity().setTitle("Scatter Chart");  //set fragment name

        scatterChart=view.findViewById(R.id.scattergraph);
        showResult=view.findViewById(R.id.showResult);
        ed_x1=view.findViewById(R.id.xed1);
        ed_x2=view.findViewById(R.id.xed2);
        ed_x3=view.findViewById(R.id.xed3);
        ed_x4=view.findViewById(R.id.xed4);
        ed_x5=view.findViewById(R.id.xed5);
        ed_y1=view.findViewById(R.id.yed1);
        ed_y2=view.findViewById(R.id.yed2);
        ed_y3=view.findViewById(R.id.yed3);
        ed_y4=view.findViewById(R.id.yed4);
        ed_y5=view.findViewById(R.id.yed5);



        showResult.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                barEnteries=new ArrayList<>();
                barEnteries.add(new BarEntry(Float.parseFloat(ed_x1.getText().toString()),Float.parseFloat(ed_y1.getText().toString())));
                barEnteries.add(new BarEntry(Float.parseFloat(ed_x2.getText().toString()),Float.parseFloat(ed_y2.getText().toString())));
                barEnteries.add(new BarEntry(Float.parseFloat(ed_x3.getText().toString()),Float.parseFloat(ed_y3.getText().toString())));
                barEnteries.add(new BarEntry(Float.parseFloat(ed_x4.getText().toString()),Float.parseFloat(ed_y4.getText().toString())));
                barEnteries.add(new BarEntry(Float.parseFloat(ed_x5.getText().toString()),Float.parseFloat(ed_y5.getText().toString())));
                scatterDataSet=new ScatterDataSet(barEnteries,"Data Set");
                scatterDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                scatterDataSet.setValueTextColor(Color.BLUE);
                scatterDataSet.setValueTextSize(15f);
                scatterDataSet.setScatterShapeSize(25f);
                scatterDataSet.setScatterShape(ScatterChart.ScatterShape.CIRCLE);

                scatterData=new ScatterData(scatterDataSet);
                scatterChart.setData(scatterData);


            }
        });


        return view;
    }


}
