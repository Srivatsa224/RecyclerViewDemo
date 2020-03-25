package com.example.recyclerviewdemo

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

private val TAG="MainActivityViewModel"

class MainActivityViewModel : ViewModel()
{
    private val contactsLiveData:MutableLiveData<MutableList<ContactsContract.Contacts>>
    init {
        contactsLiveData= MutableLiveData()
        contactsLiveData.value=createContacts()
    }
        fun getContacts():LiveData<MutableList<Contact>>{
            return contactsLiveData
        }

    private fun createContacts(): MutableList<Contact>? {
        val contacts = mutableListOf<Contact>()
        for(i in 1..77)
            contacts.add(Contact("person #$i", i))
        return contacts
    }
    }
