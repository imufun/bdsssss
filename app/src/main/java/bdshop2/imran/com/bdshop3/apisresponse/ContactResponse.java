package bdshop2.imran.com.bdshop3.apisresponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import bdshop2.imran.com.bdshop3.model.Contact;

/**
 * Created by imran on 4/13/2017.
 */

public class ContactResponse {
    @SerializedName("contacts")
    @Expose
    private ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }
}
