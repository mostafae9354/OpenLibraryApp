package com.moessa.openLibrary.module.docs_list.di

import com.moessa.openLibrary.module.docs_list.data.repository.DocsRepositoryImpl
import com.moessa.openLibrary.module.docs_list.data.source.remote.DocsService
import com.moessa.openLibrary.module.docs_list.domain.repository.DocsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
abstract class ReposModule {

    companion object {
        @Provides
        @ViewModelScoped
        fun provideDocsService(retrofit: Retrofit): DocsService =
            retrofit.create(DocsService::class.java)
    }

    @Binds
    @ViewModelScoped
    abstract fun bindDocsRepository(impl: DocsRepositoryImpl): DocsRepository
}