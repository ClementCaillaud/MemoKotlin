package fr.clementcaillaud.memokotlin.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import fr.clementcaillaud.memokotlin.memo.MemoBDDHelper
import fr.clementcaillaud.memokotlin.memo.MemoDAO
import javax.inject.Singleton

@Module
class AppModule
{
    @Provides
    fun provideContext(application: Application): Context
    {
        return application
    }

    @Singleton
    @Provides
    fun provideMemoDAO(applicationContext: Context): MemoDAO
    {
        return MemoBDDHelper.getBDD(applicationContext).memoDAO()
    }
}