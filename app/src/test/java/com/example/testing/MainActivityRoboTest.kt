package com.example.testing

import android.content.Intent
import android.widget.Button
import android.widget.EditText
import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowActivity


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [30])
class MainActivityRoboTest {

    @Test
    fun btnLoginTest0() {
        // Create MainActivity using Robolectric
        val controller = Robolectric.buildActivity(MainActivity::class.java).setup()
        val activity = controller.get()

        // Find views in MainActivity
        val usernameField = activity.findViewById<EditText>(R.id.et_username)
        val passwordField = activity.findViewById<EditText>(R.id.et_password)
        val loginButton = activity.findViewById<Button>(R.id.btn_login)

        // Set user input
        usernameField.setText("user")
        passwordField.setText("pass")

        // Simulate button click
        loginButton.performClick()

        // Verify intent
        val shadowActivity: ShadowActivity = org.robolectric.Shadows.shadowOf(activity)
        val startedIntent: Intent = shadowActivity.nextStartedActivity
        assertNotNull("Intent was not started", startedIntent)
        assertEquals(SecondActivity::class.java.name, startedIntent.component?.className)
    }

    @Test
    fun btnLoginTest1() {
        val controller = Robolectric.buildActivity(MainActivity::class.java).setup()
        val activity = controller.get()

        // Verify views are not null
        val usernameField = activity.findViewById<EditText>(R.id.et_username)
        val passwordField = activity.findViewById<EditText>(R.id.et_password)
        val loginButton = activity.findViewById<Button>(R.id.btn_login)

        assertNotNull("Username field not found", usernameField)
        assertNotNull("Password field not found", passwordField)
        assertNotNull("Login button not found", loginButton)
    }

}