package com.example.numericfacts.di

import dagger.Module

@Module(includes = [AppBindModule::class, ViewModelModule::class, ContextModule::class, CacheModule::class])
class AppModule