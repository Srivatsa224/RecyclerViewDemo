package com.example.recyclerviewdemo

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import kotlinx.android.synthetic.main.activity_main.*


private const val TAG="MainActivity"
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contacts= mutableListOf<Contact>()
        val ContactAdapter=ContactAdapter(this, contacts)
        //val contacts=createContacts()
        rvcontacts.adapter=ContactAdapter
        rvcontacts.layoutManager=LinearLayoutManager(this)
        rvcontacts.itemAnimator = SlideInUpAnimator()

       val model= ViewModelProviders.of(this)[MainActivityViewModel::class.java]
        model.getContacts().observe(this, Observer { contactsSnapshots ->
            Log.i(TAG, "Received contacts from VM")
            contacts.clear()
            contacts.add(contactsSnapshots)
            ContactAdapter.notifyDataSetChanged()
        })


    }

}
