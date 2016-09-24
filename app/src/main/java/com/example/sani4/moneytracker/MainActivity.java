package com.example.sani4.moneytracker;



import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.example.sani4.moneytracker.ui.Fragments.CategoriesFragment;
import com.example.sani4.moneytracker.ui.Fragments.ExpensesFragment;
import com.example.sani4.moneytracker.ui.Fragments.SettingsFragment;
import com.example.sani4.moneytracker.ui.Fragments.StatisticsFragment;




public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawer;
    private  NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null)

        {replaceFragment(new ExpensesFragment());}}


        private void replaceFragment(Fragment fragment) {
            String backStackName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStackName, 0);

        if (!fragmentPopped && manager.findFragmentByTag(backStackName) == null) {
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.main_container, fragment, backStackName);
            ft.addToBackStack(backStackName);
            ft.commit();
        }

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment f = getSupportFragmentManager().findFragmentById(R.id.main_container);
                if (f != null) {
                    updateToolbarTitle(f);
                }
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void updateToolbarTitle(Fragment fragment){
        String fragmentClassName = fragment.getClass().getName();

        if (fragmentClassName.equals(ExpensesFragment.class.getName())) {
            setTitle(getString(R.string.spend_item));
            navigationView.setCheckedItem(R.id.nav_spend);
        } else if (fragmentClassName.equals(CategoriesFragment.class.getName())) {
            setTitle(getString(R.string.category_item));
            navigationView.setCheckedItem(R.id.nav_category);
        } else if (fragmentClassName.equals(StatisticsFragment.class.getName())) {
            setTitle(getString(R.string.statistics_item));
            navigationView.setCheckedItem(R.id.nav_statistics);
        } else if (fragmentClassName.equals(SettingsFragment.class.getName())) {
            setTitle(getString(R.string.settings_item));
            navigationView.setCheckedItem(R.id.nav_settings);
        }
    }



    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
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

        switch (item.getItemId()) {
            case R.id.nav_spend:
                ExpensesFragment expensesFragment = new ExpensesFragment();
                replaceFragment(expensesFragment);
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_category:
                CategoriesFragment categoriesFragment = new CategoriesFragment();
                replaceFragment(categoriesFragment);
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_statistics:
                StatisticsFragment statisticsFragment = new StatisticsFragment();
                replaceFragment(statisticsFragment);
                drawer.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_settings:
                SettingsFragment settingsFragment = new SettingsFragment();
                replaceFragment(settingsFragment);
                drawer.closeDrawer(GravityCompat.START);
                break;
            case  R.id.nav_exit:
                finish();
        }
        return true;
    }


}





