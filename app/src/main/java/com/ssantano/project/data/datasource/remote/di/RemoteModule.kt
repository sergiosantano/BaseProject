package com.ssantano.project.data.datasource.remote.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val remoteModule = module {

  // Retrofit and OkHttp
  single { getRetrofitProvider(get(), get()) }
  single { getOkHttpClient(get()) }
  single { getInterceptor() }
  single { getGsonProvider() }

  /// WebServices

  // DataSources

}

private val BASE_URL = "http:://www.your_api_url.com/"
private val DATE_FORMAT = ""

private fun getInterceptor(): Interceptor {
  return HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.HEADERS
  }
}

private fun getOkHttpClient(interceptor: Interceptor): OkHttpClient {
  return OkHttpClient.Builder()
    .addInterceptor(interceptor)
    .build()
}

private fun getGsonProvider(): Gson {
  return GsonBuilder()
    .setDateFormat(DATE_FORMAT)
    .create()
}

private fun getRetrofitProvider(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
  return Retrofit.Builder()
    .client(okHttpClient)
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create(gson))
    .build()
}
