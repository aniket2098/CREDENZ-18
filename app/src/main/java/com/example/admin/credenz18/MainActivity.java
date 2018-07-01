package com.example.admin.credenz18;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        final EditText name=findViewById(R.id.name);
        final EditText email=findViewById(R.id.email);
        final EditText phone=findViewById(R.id.ph_no);
        final EditText college=findViewById(R.id.college);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {              //BUTTON ON-CLICK
            @Override
            public void onClick(View view) {
                final String contestantName=name.getText().toString().trim();       //NAME
                final String contestantEmail=email.getText().toString().trim();     //EMAIL
                final String contestantPhone=phone.getText().toString().trim();     //PHONE
                final String contestantCollege=college.getText().toString().trim(); //COLLEGE
                if(!TextUtils.isEmpty(contestantName)&&
                        !TextUtils.isEmpty(contestantEmail)&&
                        !TextUtils.isEmpty(contestantPhone)&&
                        !TextUtils.isEmpty(contestantCollege))
                {
                    if( Patterns.EMAIL_ADDRESS.matcher(email.getText()).matches())
                    {
                        if( android.util.Patterns.PHONE.matcher(phone.getText()).matches())         //SEND INFORMATION TO SERVER AFTER THIS
                        {
                            Intent intent = new Intent(MainActivity.this, Register.class);
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(MainActivity.this, "Invalid Phone no.!", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(MainActivity.this, "Invaid Email!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "All fields are mandatory!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.register) {

        }
        else if (id == R.id.pre_reg) {

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}