package com.projs.templatesetup

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Hilt requires an Application class annotated with @HiltAndroidApp.
 * Without this, the DI graph will not be generated and the app will crash on start.
 *
 * Remember to reference this class in AndroidManifest.xml:
 *   <application
 *       android:name=".TemplateApplication"
 *       ... >
 */
@HiltAndroidApp
class TemplateApplication : Application()