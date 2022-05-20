package binar.ganda.newsapplicationdi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import binar.ganda.newsapplicationdi.R
import binar.ganda.newsapplicationdi.model.GetNewsResponseItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class DetailActivity : AppCompatActivity() {
    private var id :Int?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detailnews = intent.getParcelableExtra<GetNewsResponseItem>("detailnews")
        tvDetailjudul.text = detailnews?.title
        tvDetailAuthor.text = detailnews?.author
        tvDetailDate.text = detailnews?.createdAt
        tvDetailDescription.text = detailnews?.description
        Glide.with(this).load(detailnews?.image).into(imgDetail)


    }
}