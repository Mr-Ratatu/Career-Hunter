package com.work.found.work.articles.impl.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.work.found.work.articles.api.data.ArticlesService
import com.work.found.work.articles.api.model.ArticlesItem
import java.io.InputStreamReader
import javax.inject.Inject

class ArticlesServiceImpl @Inject constructor(private val context: Context): ArticlesService {

    companion object {
        private const val UTF_8 = "UTF-8"
    }

    override fun loadArticles(articlesAssetName : String): List<ArticlesItem> {
        val gson = Gson()
        val inputStream = context.assets.open(articlesAssetName)
        val jsonReader = InputStreamReader(inputStream, UTF_8)
        val licensesListType = object : TypeToken<List<ArticlesItem>>() {}.type

        return gson.fromJson(jsonReader, licensesListType)
    }
}