package com.eric.notebook.di

import android.content.Context
import com.eric.notebook.data.local.preferences.PreferenceHelper
import com.eric.notebook.data.local.preferences.userdata.UserPreferenceData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {

    @Singleton
    @Provides
    fun providePreferenceHelper(@ApplicationContext context: Context): PreferenceHelper =
        PreferenceHelper(context)

    @Singleton
    @Provides
    fun provideUserPreferenceData(preferenceHelper: PreferenceHelper): UserPreferenceData =
        UserPreferenceData(preferenceHelper)

}