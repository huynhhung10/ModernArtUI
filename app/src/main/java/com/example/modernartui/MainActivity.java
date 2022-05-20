package com.example.modernartui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        View left1 = (View) findViewById(R.id.left1);
        View left2 = (View) findViewById(R.id.left2);
        View rightTop1 = (View) findViewById(R.id.rightTop1);
        View rightTop2 = (View) findViewById(R.id.rightTop2);
        View rightBot1 = (View) findViewById(R.id.rightBot1);

        left1.setBackgroundColor(Color.parseColor("#6e7df0"));
        left2.setBackgroundColor(Color.parseColor("#f05bed"));
        rightTop1.setBackgroundColor(Color.RED);
        rightTop2.setBackgroundColor(Color.WHITE);
        rightBot1.setBackgroundColor(Color.BLUE);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int step = i*2;
                left1.setBackgroundColor(Color.parseColor("#6e7df0")+step);
                left2.setBackgroundColor(Color.parseColor("#f05bed")+step);
                rightTop1.setBackgroundColor(Color.RED+step);
                rightTop2.setBackgroundColor(Color.WHITE+step);
                rightBot1.setBackgroundColor(Color.BLUE+step);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(Menu.NONE, Menu.FIRST, Menu.NONE, "More Information");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case Menu.FIRST:
                AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
                dlgAlert.setMessage("Do you want to vist moma.org?");


                dlgAlert.setNegativeButton("Not Now",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                dlgAlert.setPositiveButton("Visit MOMA",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
                                startActivity(browserIntent);
                            }
                        });
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}