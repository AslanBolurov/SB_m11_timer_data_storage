package com.skillbox.aslanbolurov.android.sharedpreferencesdemo

import android.content.Context
import android.content.Context.*
import android.content.SharedPreferences
import android.widget.Toast
import kotlinx.coroutines.currentCoroutineContext

private const val PREFERENCE_NAME="preference_name"
private const val SHARED_PREFS_KEY="shared_key"


class Repository {

    var localVar:String?=null

    fun getText(context:Context):String{
        return when{
            getDataFromLocalVariable() !=null -> getDataFromLocalVariable()!!
            getDataFromSharedPreference(context) !=null -> getDataFromSharedPreference(context)!!
            else -> "no one source doesn't contain string"
        }

    }




    private fun getDataFromSharedPreference(context: Context): String?{
        val prefs=context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
        return prefs.getString(SHARED_PREFS_KEY,null)
    }

    private  fun getDataFromLocalVariable(): String?{
        return localVar
    }

    fun saveText(text:String, context: Context) {

        localVar=text

        val prefs:SharedPreferences
        prefs=context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
        val editor:SharedPreferences.Editor =prefs.edit()
        editor.putString(SHARED_PREFS_KEY,text)
        editor.apply()

        Toast.makeText (context
            ,"Yr string is saved on SharedPreference and on localVar."
            ,Toast.LENGTH_LONG).show()
    }

    fun clearText(context: Context){

        localVar=null

        val prefs:SharedPreferences
        prefs=context.getSharedPreferences(PREFERENCE_NAME, MODE_PRIVATE)
        val editor:SharedPreferences.Editor = prefs.edit()
        editor.remove(SHARED_PREFS_KEY)
        editor.apply()

        Toast.makeText(context,"Yr string is deleted from SharedPreference.",Toast.LENGTH_LONG).show()
    }




}