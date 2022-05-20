package binar.ganda.newsapplicationdi.network

import binar.ganda.newsapplicationdi.model.GetNewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {

    @GET("news")
    fun getAllNews() : Call<List<GetNewsResponseItem>>

}