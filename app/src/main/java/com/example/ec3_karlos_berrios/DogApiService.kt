package com.example.ec3_karlos_berrios

import retrofit2.http.GET

interface DogApiService {
    @GET("breeds")
    suspend fun getPerros(): List<Perro>

}