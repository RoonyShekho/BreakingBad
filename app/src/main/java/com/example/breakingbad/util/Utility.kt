package com.example.breakingbad.util

import com.google.gson.Gson

object Utility {

    fun <A> String.fromJson(type:Class<A>):A{
        return Gson().fromJson(this, type)
    }


    fun <A> A.toJson():String?{
        return Gson().toJson(this)
    }
}