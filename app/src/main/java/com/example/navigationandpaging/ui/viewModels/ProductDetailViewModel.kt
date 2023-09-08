package com.example.navigationandpaging.ui.viewModels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.navigationandpaging.models.DummyData
import com.example.navigationandpaging.ui.screens.productdetail.ARG_PRODUCT_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(savedStateHandle: SavedStateHandle) :ViewModel(){

    private val productId: String? = savedStateHandle[ARG_PRODUCT_ID]

    val product = DummyData.products.find { it.name == productId }

}