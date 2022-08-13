package com.udacity.shoestore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel : ViewModel() {
    private val _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

//    private val _name = MutableLiveData<String>()
//    val name: LiveData<String>
//        get() = _name
//
//    private val _company = MutableLiveData<String>()
//    val company: LiveData<String>
//        get() = _company
//
//    private val _description = MutableLiveData<String>()
//    val description: LiveData<String>
//        get() = _description
//
//    private val _size = MutableLiveData<String>()
//    val size: LiveData<String>
//        get() = _size


    init {
        _shoes.value = mutableListOf()
    }

    fun addShoe(shoe: Shoe) {


//        val shoe = Shoe(name.value!!, size.value!!.toDouble(), company.value!!, description.value!!)
        _shoes.value?.add(shoe)
        Timber.i("shoe added $shoe")
    }
}