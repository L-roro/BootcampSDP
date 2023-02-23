package com.github.l_roro.bootcampsdp

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.BundleMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.EnumSet.allOf


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.github.l_roro.bootcampsdp", appContext.packageName)
    }
}

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    //Careful with the kotlin syntax, it's not the same as java with @Rule
    @get:Rule
    val testRule = ActivityScenarioRule(
        MainActivity::class.java
    )

    @Test
    fun clickOnButtonSendIntentToGreetingActivity() {
        Intents.init()
        val textFieldInteraction = onView(ViewMatchers.withId(R.id.mainTextBox))
        textFieldInteraction.perform(replaceText("Luis"), closeSoftKeyboard())

        val buttonInteraction = onView(ViewMatchers.withId(R.id.mainButton))
        buttonInteraction.perform(ViewActions.click())

        intended(hasComponent(GreetingActivity::class.java.name))
        intended(hasExtras(BundleMatchers.hasEntry("Name", "Luis")))

        Intents.release()
    }
}

@RunWith(AndroidJUnit4::class)
class GreetingActivityTest {

    @Test
    fun testMessage() {
        val context: Context = ApplicationProvider.getApplicationContext()

        val intent = Intent(context, GreetingActivity::class.java)
        val bundle: Bundle = Bundle()
        bundle.putString("Name", "Luis")
        intent.putExtras(bundle)

        val a: ActivityScenario<GreetingActivity> = ActivityScenario.launch(intent)
        onView(ViewMatchers.withId(R.id.greetingMessage)).check(matches(ViewMatchers.withText("Hi there Luis")))
        a.close()
    }
}