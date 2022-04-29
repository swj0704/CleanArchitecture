package org.software.meister.gsm.cleanarchitecture.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.software.meister.gsm.data.TodoDao
import org.software.meister.gsm.data.TodoDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Singleton
    @Provides
    fun provideTodoDao(dataBase: TodoDataBase) : TodoDao {
        return dataBase.getDao()
    }

    @Singleton
    @Provides
    fun provideTodoDataBase(@ApplicationContext appContext: Context) : TodoDataBase{
        return provideDB(appContext)
    }
}

internal fun provideDB(context: Context): TodoDataBase =
    Room.databaseBuilder(context, TodoDataBase::class.java, "todoDatabase.db").build()