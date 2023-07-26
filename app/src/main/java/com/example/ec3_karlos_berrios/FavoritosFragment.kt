package com.example.ec3_karlos_berrios


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager


import com.example.ec3_karlos_berrios.databinding.FragmentFavoritosBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class FavoritosFragment : Fragment() {

    private lateinit var binding: FragmentFavoritosBinding
    private val favoritesList = mutableListOf<String>()
    private val MAX_FAVORITES = 10

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(CatApiService::class.java)
        val call = service.getFavoriteCats()

        call.enqueue(object : Callback<List<CatImage>> {
            override fun onResponse(call: Call<List<CatImage>>, response: Response<List<CatImage>>) {
                if (response.isSuccessful) {
                    val catImages = response.body() ?: emptyList()
                    val first10CatImages = catImages.take(MAX_FAVORITES)
                    favoritesList.addAll(first10CatImages.map { it.url })
                    setupRecyclerView()
                }
            }

            override fun onFailure(call: Call<List<CatImage>>, t: Throwable) {

            }
        })
    }

    private fun setupRecyclerView() {

        binding.favoritesRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.favoritesRecyclerView.adapter = CatImageAdapter(favoritesList)
    }
}