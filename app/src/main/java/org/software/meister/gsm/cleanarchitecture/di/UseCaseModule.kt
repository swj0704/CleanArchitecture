package org.software.meister.gsm.cleanarchitecture.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.software.meister.gsm.domain.TodoRepository
import org.software.meister.gsm.domain.usecase.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideGetTodoListUseCase(repository : TodoRepository) : GetTodoListUseCase{
        return GetTodoListUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideGetTodoItemUseCase(repository : TodoRepository) : GetTodoItemUseCase {
        return GetTodoItemUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideUpdateTodoItemUseCase(repository : TodoRepository) : UpdateTodoItemUseCase{
        return UpdateTodoItemUseCase(repository)
    }
    @Provides
    @Singleton
    fun provideDeleteTodoItemUseCase(repository : TodoRepository) : DeleteTodoItemUseCase{
        return DeleteTodoItemUseCase(repository)
    }
    @Provides
    @Singleton
    fun providePostTodoItemUseCase(repository : TodoRepository) : PostTodoItemUseCase{
        return PostTodoItemUseCase(repository)
    }
}