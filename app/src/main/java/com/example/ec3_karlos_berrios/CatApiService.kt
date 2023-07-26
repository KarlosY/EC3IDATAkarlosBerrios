package com.example.ec3_karlos_berrios

import retrofit2.Call
import retrofit2.http.GET

interface CatApiService {
    @GET("images/search?limit=10&breed_ids=beng&api_key=REPLACE_ME")
    fun getFavoriteCats(): Call<List<CatImage>>
}