package com.example.nikhilr129.forgetitnot.main;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nikhilr129.forgetitnot.R;
import com.example.nikhilr129.forgetitnot.action.actionDialog.LoadAppSpinner.CustomAdapter;
import com.example.nikhilr129.forgetitnot.event.EventSelectionActivity;
import com.example.nikhilr129.forgetitnot.service.HelloService;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.roughike.bottombar.BottomBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private  FloatingActionMenu materialDesignFAM;
    private  FloatingActionButton floatingActionButton1;
    private  BottomBar  bottomNavigationBar;
    private  Toolbar toolbar;

    ListView lv;
    Context context;

    public static String [] prgmNameList={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService(new Intent(MainActivity.this,HelloService.class));

        //set Slide Transition
        if(Build.VERSION.SDK_INT >= 21)
            setFadeTransition();
        //Toolbar support in android
        setToolbar();

        context=this;

        lv=(ListView) findViewById(R.id.listView);
        lv.setAdapter(new TaskCustomAdapter(this, prgmNameList));

        //Create and applying action on floating action Menu
        createAndApplyActionOnFloatingActionMenu();


        //starting service

    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setFadeTransition() {
        Fade s = new Fade();
        s.setDuration(200);
        getWindow().setEnterTransition(s);

    }

    private void setToolbar() {
        toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.iconsTint));
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.iconsTint));
    }
    private void createAndApplyActionOnFloatingActionMenu() {
        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.floating_action_menu_item1);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu_main first item clicked
                startActivity(new Intent(MainActivity.this, EventSelectionActivity.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_refresh:
                Intent i=new Intent(this,MainActivity.class);
                startActivity(i);
                this.finish();
                break;
            // action with ID action_settings was selected
            case R.id.action_settings:
                Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
                        .show();
                break;
            case R.id.share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Check out this awesome app.(LINK HERE)It automates most of the boring tasks in Android";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "ForgetItNot");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                break;
            case R.id.aboutUs:
                Intent intent = new Intent(this, AboutUs.class);
                startActivity(intent);
                break;
            case R.id.permissions:

                break;
            default:
                break;
        }

        return true;
    }
}
