package bdshop2.imran.com.bdshop3;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import bdshop2.imran.com.bdshop3.adapter.MyContactAdapter;
import bdshop2.imran.com.bdshop3.apisresponse.ContactResponse;
import bdshop2.imran.com.bdshop3.model.Contact;
import bdshop2.imran.com.bdshop3.utils.InternetConnection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private View parentView;

    private ArrayList<Contact> contactList;
    private MyContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contactList = new ArrayList<>();
        parentView = findViewById(R.id.parentLayout);


        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parnet, View view, int position, long id) {

                Snackbar.make(parentView, contactList.get(position).getName() + " => " + contactList.get(position).getPhone().getHome(), Snackbar.LENGTH_LONG).show();
            }
        });
        LoadContactList();

//        Toast toast = Toast.makeText(getApplicationContext(), R.string.string_click_to_load, Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.show();


        // LoadContactList();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
//
//            }
//        });


    }


    void LoadContactList() {
        if (InternetConnection.checkConnection(getApplicationContext())) {
            final ProgressDialog dialog;
            /**
             * Progress Dialog for User Interaction
             */
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle(getString(R.string.string_getting_json_title));
            dialog.setMessage(getString(R.string.string_getting_json_message));
            dialog.show();


            ApiInterfaceService api = RetroClient.getContactJSON();

            Call<ContactResponse> call = api.getContact();

            call.enqueue(new Callback<ContactResponse>() {
                @Override
                public void onResponse(Call<ContactResponse> call, Response<ContactResponse> response) {
                    dialog.dismiss();
                    if (response.isSuccessful()) {
                        contactList = response.body().getContacts();

                        Log.d("Contact List", "onResponse" + contactList);

                        adapter = new MyContactAdapter(MainActivity.this, contactList);
                        listView.setAdapter(adapter);
                    } else {
                        Snackbar.make(parentView, R.string.sting_something_worng, Snackbar.LENGTH_LONG).show();
                    }

                    System.out.print("heeeee");
                }

                @Override
                public void onFailure(Call<ContactResponse> call, Throwable throwable) {
                    dialog.dismiss();
                    Log.d("Contact List", "onResponse" + throwable.getMessage());
                }
            });
        } else {
            Snackbar.make(parentView, R.string.string_internet_connection_not_available, Snackbar.LENGTH_LONG).show();
        }

    }


    public boolean isNetworkAvailable(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

}
