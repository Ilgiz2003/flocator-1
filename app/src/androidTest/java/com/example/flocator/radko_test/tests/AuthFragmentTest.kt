package com.example.flocator.radko_test.tests

import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.GrantPermissionRule
import com.example.flocator.MainActivity
import com.example.flocator.R
import com.example.flocator.authentication.authorization.AuthFragment
import com.example.flocator.common.storage.shared.SharedStorage
import com.example.flocator.common.utils.FragmentNavigationUtils
import com.example.flocator.di.SharedStorageModule
import com.example.flocator.radko_test.fragments.TestAuthFragment
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class AuthFragmentTest {
    @get:Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)
    @get:Rule
    val permissionRule: GrantPermissionRule =
        GrantPermissionRule.grant(android.Manifest.permission.ACCESS_FINE_LOCATION)

    @Before
    fun adjust() {
        val storage = SharedStorage(
            ApplicationProvider.getApplicationContext(),
            SharedStorageModule.encryptedSharedPreferences(ApplicationProvider.getApplicationContext())
        )
        storage.clearUserData()
        activityScenario.scenario.onActivity {
            FragmentNavigationUtils.clearAllAndOpenFragment(
                it.supportFragmentManager,
                AuthFragment()
            )
        }
    }

    @Test
    fun testLogin() {
        val testAuthFragment = TestAuthFragment()
        testAuthFragment.login()
        onView(withId(R.id.open_add_mark_fragment)).check(matches(isDisplayed()))
    }
}
