package com.example.bluecloudmedicalclinic.Patient_Payment_And_Prescription;

/**
 * Created by HP on 1/8/2020.
 */

public class PatientData {

    private String first_name;
    private String last_name;
    private int zip;
    private String location;
    private int amount;
    private int card_number;
    private int card_exp_date;
    private int card_holder_name;
    private String email_address;


    public  PatientData(String first_name, String last_name, int zip, String location, int amount, int card_number, int card_exp_date, int card_holder_name, String email_address)
    {
        this.first_name = first_name;
        this.last_name = last_name;
        this.zip = zip;
        this.location = location;
        this.amount = amount;
        this.card_number = card_number;
        this.card_exp_date = card_exp_date;
        this.card_holder_name = card_holder_name;
        this.email_address = email_address;

    }

}
