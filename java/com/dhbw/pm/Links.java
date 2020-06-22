package com.dhbw.pm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class Links extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);
        setTitle("Nützliche Links");



        ImageView icon = new ImageView(this);
        icon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.menue_24));
        FloatingActionButton actionButton = new FloatingActionButton.Builder(this).setContentView(icon).setBackgroundDrawable(R.drawable.menu_circle).build();

        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this);
        ImageView itemIcon = new ImageView(this);
        itemIcon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_event_note_red_24dp));
        SubActionButton button1 = itemBuilder.setContentView(itemIcon).build();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Links.this, Stundenplan.class));
            }
        });

        itemIcon = new ImageView(this);
        itemIcon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.log_out));
        SubActionButton button2 = itemBuilder.setContentView(itemIcon).build();
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Links.this, Login.class));
            }
        });

        itemIcon = new ImageView(this);
        itemIcon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_http_black_24dp));
        SubActionButton button3 = itemBuilder.setContentView(itemIcon).build();
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Links.this, Links.class));
            }
        });

        itemIcon = new ImageView(this);
        itemIcon.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_event_note_red_24dp));
        SubActionButton button4 = itemBuilder.setContentView(itemIcon).build();



        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1)
                .addSubActionView(button2)
                .addSubActionView(button3)
                .addSubActionView(button4)
                // ...
                .attachTo(actionButton)
                .build();

    }
}
