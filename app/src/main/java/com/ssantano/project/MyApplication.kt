package com.ssantano.project

import android.app.Application
import com.ssantano.project.di.components.DaggerApplicationComponent

class MyApplication : Application() {

  val appComponent = DaggerApplicationComponent.create()

}