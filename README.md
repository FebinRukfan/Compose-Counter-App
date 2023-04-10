# Compose-Counter-App
This is basic counter app showcasing the use of Jetpack compose views with modifiers and state hoisting.


This is an assignment from Rajesh Hadiya's Master Android Development Course. 

REQUIREMENTS : 
1. Place a TextView and a Button as shown below. TextView will act as a click counter
for button.
2. When the button is clicked, increment the counter and display it. (e.g., Click count 1,
2, 3...)
3.If user leaves the application (e.g., press the home button or go to other apps)
counter should be reset to 0.
4. When user returns to the app, and again click on button, counter should increment
from 0.
5. When user returns, it's fine if the counter value is visually not updated to 0. But on
next button click, it should start from 0. For example, let's say the counter is at 9,
and user leaves the application. When user returns, if counter shows 9 at that time,
it's fine. But when user again click on button, counter should display "Click count 1"
because you've already reset it to 0.
6. You can use either Jetpack Compose or XML to build the UI.
