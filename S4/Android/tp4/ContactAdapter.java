package fr.olivierpautrat.tp4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private List<Contact> contactList;

    private LayoutInflater inflater;

    public ContactAdapter(Context context, List<Contact> listSort) {
        super();
        inflater = LayoutInflater.from(context);
        contactList = listSort;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView photo;
        TextView prenomNom;
        TextView courriel;
        TextView telephone;
        TextView adresseCP;
        View view;
        // creations d'une nouvelle view de la liste
        if (convertView == null) {
            view = inflater.inflate(R.layout.contact, null);
            photo = view.findViewById(R.id.contactImage);
            prenomNom = view.findViewById(R.id.contactPrenomNom);
            courriel = view.findViewById(R.id.contactCourriel);
            telephone = view.findViewById(R.id.contactTelephone);
            adresseCP = view.findViewById(R.id.contactAdresse);
        } else {
            view = convertView;
            photo = view.findViewById(R.id.contactImage);
            prenomNom = view.findViewById(R.id.contactPrenomNom);
            courriel = view.findViewById(R.id.contactCourriel);
            telephone = view.findViewById(R.id.contactTelephone);
            adresseCP = view.findViewById(R.id.contactAdresse);
        }

        Contact c = contactList.get(position);
        photo.setImageResource(R.mipmap.photo);
        prenomNom.setText(String.format("%s %s", c.getPrenom(), c.getNom()));
        courriel.setText(c.getCourriel());
        telephone.setText(c.getTelephone());
        adresseCP.setText(String.format("%s, %d", c.getAdresse(), c.getCp()));

        return view;
    }
}