package com.example.madt_5

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun filterField_isDisplayed() {
        onView(withId(R.id.etFilter))
            .check(matches(isDisplayed()))
    }

    @Test
    fun typingInFilter_doesNotCrash() {
        onView(withId(R.id.etFilter))
            .perform(typeText("EUR"), closeSoftKeyboard())

        onView(withId(R.id.listView))
            .check(matches(isDisplayed()))
    }
}

