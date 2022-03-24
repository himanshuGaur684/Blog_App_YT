package com.gaur.blogappyt.screens.home

import com.gaur.domain.model.Blog

data class HomeState(
    var isLoading:Boolean=false,
    var data:List<Blog>?=null,
    var error:String=""
)