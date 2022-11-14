package algonquin.cst2335.nur00076;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    /** This test Function will automatically run the password complexity
     * app, enter "12345" as the password and record the results.
     */
    @Test
    public void mainActivityTest() {

        ViewInteraction appCompatEditText = onView (withId(R.id.editText));
        appCompatEditText.perform(replaceText("12345"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));
        textView.check(matches(withText("You shall not pass!")));
    }

    /** This test Function will automatically run the password complexity
     * app, enter "password123#$*" as the password and record the results.
     *
     * It's going to test for the missing Uppercase letter.
     */
    @Test
    public void testFindMissingUpperCase(){

        ViewInteraction appCompatEditText = onView (withId(R.id.editText));
        appCompatEditText.perform(replaceText("password123#$*"));

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));
        textView.check(matches(withText("You shall not pass!")));

    }

    /** This test Function will automatically run the password complexity
     * app, enter "KANE!234" as the password and record the results.
     *
     * It's going to test for the missing Lowercase letter.
     */
    @Test
    public void testFindMissingLowerCase() {

        ViewInteraction appCompatEditText = onView (withId(R.id.editText));
        appCompatEditText.perform(replaceText("KANE!234"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));
        textView.check(matches(withText("You shall not pass!")));
    }

    /** This test Function will automatically run the password complexity
     * app, enter "Kane!@#$" as the password and record the results.
     *
     * It's going to test for the missing Number.
     */
    @Test
    public void testFindMissingNumber() {

        ViewInteraction appCompatEditText = onView (withId(R.id.editText));
        appCompatEditText.perform(replaceText("Kane!@#$"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));
        textView.check(matches(withText("You shall not pass!")));
    }

    /** This test Function will automatically run the password complexity
     * app, enter "Kane1234" as the password and record the results.
     *
     * It's going to test for the missing Symbol.
     */
    @Test
    public void testFindMissingSymbol() {

        ViewInteraction appCompatEditText = onView (withId(R.id.editText));
        appCompatEditText.perform(replaceText("Kane1234"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));
        textView.check(matches(withText("You shall not pass!")));
    }

    /** This test Function will automatically run the password complexity
     * app, enter "Kane!@34" as the password and record the results.
     *
     * The password will meet all the requirements.
     */
    @Test
    public void successfulTest() {

        ViewInteraction appCompatEditText = onView (withId(R.id.editText));
        appCompatEditText.perform(replaceText("Kane!@34"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.button));
        materialButton.perform(click());

        ViewInteraction textView = onView(withId(R.id.textView));
        textView.check(matches(withText("Your password meets the requirements")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
