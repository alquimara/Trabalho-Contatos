package com.example.alquimaraalves.teste.Firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfiguracaoFirebase {
    private static DatabaseReference referenciafirebase;
    public static DatabaseReference getFirebase(){
        if (referenciafirebase == null){
            referenciafirebase = FirebaseDatabase.getInstance().getReference();
        }
        return referenciafirebase;
    }
}
