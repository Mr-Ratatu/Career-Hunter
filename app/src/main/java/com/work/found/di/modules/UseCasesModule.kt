package com.work.found.di.modules

import com.work.found.work.articles.api.data.ArticlesService
import com.work.found.work.articles.api.domain.ArticleDetailUseCase
import com.work.found.work.articles.api.domain.ArticlesListUseCase
import com.work.found.work.articles.impl.domain.ArticleDetailUseCaseImpl
import com.work.found.work.articles.impl.domain.ArticlesListUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCasesModule {

    @Provides
    @Singleton
    fun provideArticlesListUseCase(articlesService: ArticlesService): ArticlesListUseCase {
        return ArticlesListUseCaseImpl(articlesService)
    }

    @Provides
    @Singleton
    fun provideArticleDetailUseCase(articlesService: ArticlesService): ArticleDetailUseCase {
        return ArticleDetailUseCaseImpl(articlesService)
    }
}