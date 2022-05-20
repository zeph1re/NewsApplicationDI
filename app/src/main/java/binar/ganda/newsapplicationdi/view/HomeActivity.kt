package binar.ganda.newsapplicationdi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import binar.ganda.newsapplicationdi.R
import binar.ganda.newsapplicationdi.viewmodel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsAdapter = NewsAdapter(){}

        rvNews.layoutManager = LinearLayoutManager(this)
        newsAdapter= NewsAdapter(){
            val pindahdata = Intent(this@HomeActivity, DetailActivity::class.java)
            pindahdata.putExtra("detailnews", it)
            startActivity(pindahdata)
        }
        rvNews.adapter = newsAdapter

        initViewModel()

    }

    fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.getliveDataNews().observe(this, Observer {
            if (it != null){
                newsAdapter.setNewsList(it)
                newsAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getDataNews()
    }

}
