package com.work.found.work.articles.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.work.found.core.api.model.articles.ArticlesItem
import com.work.found.core.base.extensions.contentView
import com.work.found.core.base.extensions.popBackStack
import com.work.found.core.base.extensions.setImageFromString
import com.work.found.core.base.presentation.BaseFragment
import com.work.found.core.base.utils.Constants
import com.work.found.core.base.utils.ShadowDelegate
import com.work.found.core.base.utils.ViewInsetsController
import com.work.found.work.R
import com.work.found.work.articles.presenter.ArticlesPresenter
import com.work.found.work.articles.provider.ArticlesDataProviderInput

class ArticlesFragment : BaseFragment<ArticlesViewOutput, ArticlesDataProviderInput>() {

    companion object {
        private const val ARGUMENT_ID = "id"

        fun newInstance(id: Int): ArticlesFragment {
            val argument = Bundle().apply {
                putInt(ARGUMENT_ID, id)
            }

            return ArticlesFragment().apply { arguments = argument }
        }
    }

    private val articlePoster = contentView<ImageView>(R.id.articles_iv_poster)
    private val toolbar = contentView<Toolbar>(R.id.articles_tb)
    private val articleTitle = contentView<TextView>(R.id.articles_tv_title)
    private val articleDescription = contentView<TextView>(R.id.articles_tv_description)
    private val articlesContainer = contentView<ScrollView>(R.id.articles_container)

    override val layoutId: Int = R.layout.fragment_articles

    private val shadowDelegate = ShadowDelegate()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val argumentId = arguments?.getInt(ARGUMENT_ID) ?: Constants.UNDEFINED
        viewOutput.onLoadArticles(argumentId)
    }

    override fun initViewOutput(): ArticlesViewOutput {
        return ArticlesPresenter()
    }

    override fun initView() {
        toolbar {
            setNavigationOnClickListener {
                popBackStack()
            }
        }

        shadowDelegate.setShadowScrollListener(
            scrollView = articlesContainer.view,
            shadowView = toolbar.view
        )
    }

    override fun subscribeOnData() {
        dataProvider.article.observe(this@ArticlesFragment) { article ->
            initContent(article)
        }
    }

    private fun initContent(article: ArticlesItem?) {
        articleTitle {
            text = article?.title
        }
        articleDescription {
            text = article?.description
        }
        articlePoster {
            setImageFromString(article!!.poster)
        }
    }

    override fun setInsetListener(rootView: View) {
        ViewInsetsController.bindMargin(rootView, forTop = true, forBottom = true)
    }
}