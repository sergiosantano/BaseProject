package com.ssantano.project.data.remote

interface EndpointManager {

  fun getBaseEndpoint(): String

}

class EndpointManagerImpl : EndpointManager {

  override fun getBaseEndpoint(): String = "http://www.your_api_url.com/"

}