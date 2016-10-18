package ashishrpa.session_06_assignment_04;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> al_contactName,al_contactNumber;

    private MyAdapter adapter;
    private Intent contextIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.lv_contacts);

        al_contactName = new ArrayList<>();
        al_contactNumber = new ArrayList<>();

        al_contactName.add("Name1");
        al_contactName.add("Name2");
        al_contactName.add("Name3");
        al_contactName.add("Name4");
        al_contactName.add("Name5");
        al_contactName.add("Name6");
        al_contactName.add("Name7");
        al_contactName.add("Name8");
        al_contactName.add("Name9");
        al_contactName.add("Name10");
        al_contactName.add("Name11");
        al_contactName.add("Name12");
        al_contactName.add("Name13");
        al_contactName.add("Name14");
        al_contactName.add("Name15");

        al_contactNumber.add("9895444801");
        al_contactNumber.add("9895444802");
        al_contactNumber.add("9895444803");
        al_contactNumber.add("9895444804");
        al_contactNumber.add("9895444805");
        al_contactNumber.add("9895444806");
        al_contactNumber.add("9895444807");
        al_contactNumber.add("9895444808");
        al_contactNumber.add("9895444809");
        al_contactNumber.add("9895444810");
        al_contactNumber.add("9895444811");
        al_contactNumber.add("9895444812");
        al_contactNumber.add("9895444813");
        al_contactNumber.add("9895444814");
        al_contactNumber.add("9895444815");

        adapter = new MyAdapter(getApplicationContext(),al_contactName,al_contactNumber);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_context_menu, menu);
        menu.setHeaderTitle("Select The Action");
        Log.e("MainACTIVITY","ContextMenu is inflated");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int currentposition = info.position;
        int selecteditemid = item.getItemId();

        switch (selecteditemid) {
            case R.id.subOptionMenuCall:
                Toast.makeText(MainActivity.this, "CALL Option Selected", Toast.LENGTH_LONG).show();
                Log.e("MainActivity", "CALL Option Selected");
                contextIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +al_contactNumber.get(currentposition)));
                startActivity(contextIntent);
                finish();
                return true;
            case R.id.subOptionMenuSMS:
                Toast.makeText(MainActivity.this, "SMS Option Selected", Toast.LENGTH_LONG).show();
                Log.e("MainActivity", "SMS Option Selected");
                contextIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" +al_contactNumber.get(currentposition)));
                startActivity(contextIntent);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


}