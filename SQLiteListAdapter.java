package com.example.bluecloudmedicalclinic.db;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bluecloudmedicalclinic.R;

import java.util.ArrayList;

/**
 * Created by HP on 12/26/2019.
 */

public class SQLiteListAdapter extends BaseAdapter {



    private Context context;
    private ArrayList<String> PatientID;
    private ArrayList<String> FirstName;
    private ArrayList<String> LastName;
    private ArrayList<String>  Zip;
    private ArrayList<String> Location;
    private ArrayList<String> Amount;
    private ArrayList<String> CardNumber;
    private ArrayList<String> ExpiryDate;
    private ArrayList<String> CardHolderName;
    private ArrayList<String> EmailAddress;

    public SQLiteListAdapter(

            Context context2,
            ArrayList<String> id,
            ArrayList<String> firstName,
            ArrayList<String> lastName,
            ArrayList<String> zip,
            ArrayList<String> location,
            ArrayList<String> amount,
            ArrayList<String> cardNumber,
            ArrayList<String> expiryDate,
            ArrayList<String> cardHolderName,
            ArrayList<String> emailAddress
    )
    {

        this.context = context2;
        this.PatientID = id;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Zip = zip;
        this.Location = location;
        this.Amount = amount;
        this.CardNumber = cardNumber;
        this.ExpiryDate = expiryDate;
        this.CardHolderName = cardHolderName;
        this.EmailAddress = emailAddress;
    }

    @Override
    public int getCount() {
        return PatientID.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View child, ViewGroup parent) {
        Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            child = layoutInflater.inflate(R.layout.list_view_data_layout, null);

            holder = new Holder();

            holder.ID = (TextView) child.findViewById(R.id.txtView_id);
            holder.First_Name = (TextView) child.findViewById(R.id.txtView_name);
            holder.Last_Name = (TextView) child.findViewById(R.id.txtView_last_name);
            holder.Zip = (TextView) child.findViewById(R.id.txtView_zip);
            holder.Location = (TextView) child.findViewById(R.id.txtView_location);
            holder.Amount = (TextView) child.findViewById(R.id.txtView_amount);
            holder.CardNumber = (TextView) child.findViewById(R.id.txtView_card_number);
            holder.ExpiryDate = (TextView) child.findViewById(R.id.txtView_expiry_date);
            holder.CardHolderName = (TextView) child.findViewById(R.id.txtView_card_holder_name);
            holder.EmailAddress = (TextView) child.findViewById(R.id.txtView_email);

            child.setTag(holder);

        }
        else {

            holder = (Holder) child.getTag();
        }

        holder.ID.setText(PatientID.get(position));
        holder.First_Name.setText(FirstName.get(position));
        holder.Last_Name.setText(LastName.get(position));
        holder.Zip.setText(Zip.get(position));
        holder.Location.setText(Location.get(position));
        holder.Amount.setText(Amount.get(position));
        holder.CardNumber.setText(CardNumber.get(position));
        holder.ExpiryDate.setText(ExpiryDate.get(position));
        holder.CardHolderName.setText(CardHolderName.get(position));
        holder.EmailAddress.setText(EmailAddress.get(position));


        return child;
    }

    private class Holder {

        TextView ID;
        TextView First_Name;
        TextView Last_Name;
        TextView Zip;
        TextView Location;
        TextView Amount;
        TextView CardNumber;
        TextView ExpiryDate;
        TextView CardHolderName;
        TextView EmailAddress;

    }
}
