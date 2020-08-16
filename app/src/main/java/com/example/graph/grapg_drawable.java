package com.example.graph;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class grapg_drawable extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
 private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grapg_drawable);

        FloatingActionButton fab=findViewById(R.id.fpb);
        fab.setOnClickListener(this);

        drawerLayout=findViewById(R.id.drawableLayout);
        NavigationView navigationView=findViewById(R.id.nav_view);
        Toolbar toolbar=findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.Open,R.string.Close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);





    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.bargraph:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Fragment_Bargraph()).commit();
                Toast.makeText(this, "Bar Graph", Toast.LENGTH_SHORT).show();
                break;
            case R.id.piechart:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Fragment_PieChart()).commit();
                Toast.makeText(this, "Pie Chart", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radarchart:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Fragment_Radar()).commit();
                Toast.makeText(this, "Radar Chart", Toast.LENGTH_SHORT).show();
                break;
            case R.id.linechart:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Fragment_LineChart()).commit();
                Toast.makeText(this,"Line Chart Graph",Toast.LENGTH_LONG).show();
                break;
            case R.id.scatterChart:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Fragment_Scattergraph()).commit();
                Toast.makeText(this, "Scatter Chart Graph", Toast.LENGTH_SHORT).show();
                break;
            case R.id.equationChart:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Fragment_EquationGraph()).commit();
                Toast.makeText(this, "Equation Chart Graph", Toast.LENGTH_SHORT).show();
                break;
            case R.id.share:
                shareData();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.about:
                about_detail();
                break;
            case R.id.home:
                startActivity(new Intent(this,grapg_drawable.class));
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void about_detail() {
        LayoutInflater layoutInflater=LayoutInflater.from(this);
        View customTilte= layoutInflater.inflate(R.layout.about_costomized,null);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCustomTitle(customTilte);
        //String data="The Graph app is based on java programming language.\nIt can easily visualize data & information.\nThe primary purpose of graph is to show relationship among variables.In this app,You can" +
             //   "\nBar Graph,\nPie Chart,\nLine Graph,\nScatter Graph,\nGraphical equations of two lines and etc.\nThis is basic app for information of android application. ";
        //builder.setMessage(data);
        builder.setNeutralButton("Fine",null);
        builder.show();

    }

    private void shareData() {
        Intent share=new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_SUBJECT,"Intent subject here");
        String app_url="";//url link of google play store
        share.putExtra(Intent.EXTRA_TEXT,app_url);
        startActivity(Intent.createChooser(share,"share via"));
    }



    @Override
    public void onClick(View v) {
        ImageView imageView = findViewById(R.id.imageview1);
        //for gif image
        String gifurl ="https://gifimage.net/wp-content/uploads/2018/11/vote-of-thanks-gif-2.gif";
        Glide.with(grapg_drawable.this).load(gifurl).into(imageView);


    }
}
