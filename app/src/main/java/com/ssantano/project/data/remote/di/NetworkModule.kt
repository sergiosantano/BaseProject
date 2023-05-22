package com.ssantano.project.data.remote.di

import com.squareup.moshi.Moshi
import com.ssantano.project.data.remote.EndpointManager
import com.ssantano.project.data.remote.EndpointManagerImpl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
  single<EndpointManager> { EndpointManagerImpl() }
  single<Moshi> { Moshi.Builder().build() }
  single { createBasicInterceptor() }
  single { getOkHttpClient(get()) }
  single { buildBaseRetrofit(get(), get(), get()) }
}

private fun createBasicInterceptor(): Interceptor {
  return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.HEADERS }
}

private fun getOkHttpClient(interceptor: Interceptor): OkHttpClient {
  return OkHttpClient.Builder().apply {
    addInterceptor(interceptor)
  }.build()
}

private fun buildBaseRetrofit(
  endpointManager: EndpointManager,
  client: OkHttpClient,
  moshi: Moshi
) {
  buildRetrofit(endpointManager.getBaseEndpoint(), client, moshi)
}

private fun buildRetrofit(baseUrl: String, client: OkHttpClient, moshi: Moshi): Retrofit {
  return Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(client)
    .baseUrl(baseUrl)
    .build()
}