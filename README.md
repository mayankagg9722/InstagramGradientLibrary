# InstagramGradientLibrary
[![](https://jitpack.io/v/mayankagg9722/InstagramGradientLibrary.svg)](https://jitpack.io/#mayankagg9722/InstagramGradientLibrary)
This Android library gives a transition of gradient of shades of given color in background of a layout. Just like an Instagram Background.

![alt tag](https://github.com/mayankagg9722/InstagramGradientLibrary/blob/master/InstaGradient.gif)  



Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Add the dependency:
	
	dependencies {
	        compile 'com.github.mayankagg9722:InstagramGradientLibrary:-SNAPSHOT'
	}
	
Usage:

	XML:
	
	<com.example.animatebackground.AnimateActivity
        xmlns:custom="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        custom:LayoutColor="#fff"
        android:id="@+id/mylayout"
        />
	
	Java:

	((com.example.animatebackground.AnimateActivity)findViewById(R.id.mylayout)).setColor(Color.parseColor("#8057e1"));
  
  License:
                                                       
		Apache License
 		Version 2.0, January 2004
		http://www.apache.org/licenses/
