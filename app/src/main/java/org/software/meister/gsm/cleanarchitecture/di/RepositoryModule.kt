package org.software.meister.gsm.cleanarchitecture.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.software.meister.gsm.data.TodoDao
import org.software.meister.gsm.data.TodoRepositoryImpl
import org.software.meister.gsm.domain.TodoRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideTodoRepository(dao : TodoDao) : TodoRepository{
        return TodoRepositoryImpl(dao)
    }
}