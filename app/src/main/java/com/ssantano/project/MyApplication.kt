package com.ssantano.project

import android.app.Application
import com.ssantano.project.di.components.ApplicationComponent
import com.ssantano.project.di.components.DaggerApplicationComponent

class MyApplication : Application() {

  val appComponent: ApplicationComponent = DaggerApplicationComponent.create()

}