package de.allianz.allianznavigation;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.media.audiofx.BassBoost;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import de.allianz.allianznavigation.data.SQLiteHelper;
import de.allianz.allianznavigation.gui.MapFragment;
import de.allianz.allianznavigation.gui.SettingsFragment;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Log.d("SQL", "Hallo");

        SQLiteHelper datasource = new SQLiteHelper(this);
        SQLiteDatabase db = datasource.getWritableDatabase();

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.allianzlogo);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        Log.d("SQL", byteArray.toString());

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_NAME_BLOB, byteArray);
        long newRow = db.insert(SQLiteHelper.TABLE_NAME, null, values);
        Log.d("SQL", valueOf(newRow));
        db.close();

        db = datasource.getReadableDatabase();
        String[] s = {
          SQLiteHelper.COLUMN_NAME_ID,
                SQLiteHelper.COLUMN_NAME_BLOB
        };

        List<byte[]> returnValue = new ArrayList<>();
        Cursor cursor = db.query(SQLiteHelper.TABLE_NAME, s, null, null, null, null, null);
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("blob"));
            returnValue.add(blob);
        }
        cursor.close();


        byte[] arr = returnValue.get(0);
        Log.d("SQL", arr.toString());
        Bitmap bitmap = BitmapFactory.decodeByteArray(arr, 0, arr.length);

        ImageView img = (ImageView) findViewById(R.id.imageView3);
        img.setImageBitmap(bitmap);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_map) {

        } else if (id == R.id.nav_update) {

        } else if (id == R.id.nav_settings) {
            SettingsFragment settingsFrag = new SettingsFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, settingsFrag)
                    .addToBackStack(null)
                    .commit();

        } else if (id == R.id.nav_pos) {

        } else if (id == R.id.nav_poi) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
