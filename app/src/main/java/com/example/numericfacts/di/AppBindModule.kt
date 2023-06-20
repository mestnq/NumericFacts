package com.example.numericfacts.di

import com.example.numericfacts.domain.repositories.CacheRepository
import com.example.numericfacts.domain.repositories.CacheRepositoryImpl
import com.example.numericfacts.domain.usecases.GetNumericInfo
import com.example.numericfacts.domain.usecases.GetNumericInfoImpl
import com.example.numericfacts.domain.usecases.GetNumericInfoList
import com.example.numericfacts.domain.usecases.GetNumericInfoListImpl
import dagger.Binds
import dagger.Module

@Module
interface AppBindModule {

    @Binds
    fun bindCacheRepository(repository: CacheRepositoryImpl): CacheRepository

//    @Binds
//    fun bindGetNumericInfoUseCase(getNumericInfoImpl: GetNumericInfoImpl): GetNumericInfo

    @Binds
    fun bindGetNumericInfoListUseCase(getNumericInfoListImpl: GetNumericInfoListImpl): GetNumericInfoList

}