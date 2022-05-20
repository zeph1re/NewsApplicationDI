package binar.ganda.newsapplicationdi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import binar.ganda.newsapplicationdi.model.GetNewsResponseItem
import binar.ganda.newsapplicationdi.network.NewsClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel(){

    var liveDataList: MutableLiveData<List<GetNewsResponseItem>>

    init {
        liveDataList = MutableLiveData()
    }

    fun getliveDataNews(): MutableLiveData<List<GetNewsResponseItem>> {
        return  liveDataList
    }

    fun getDataNews(){
        NewsClient.instance.getAllNews()
            .enqueue(object : Callback<List<GetNewsResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetNewsResponseItem>>,
                    response: Response<List<GetNewsResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataList.postValue(response.body())
                    }else{
                        liveDataList.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetNewsResponseItem>>, t: Throwable) {
                    liveDataList.postValue(null)
                }

            })
    }
}