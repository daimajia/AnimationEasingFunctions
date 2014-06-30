#Android Easing Functions

This project is originally from my another project, [AndroidViewAnimation](https://github.com/daimajia/AndroidViewAnimations), which is an animation collection, to help you make animation easier.

While, I was still unsatisfied with the animation effect.

So, I started to explore how to make it more and more real.

I found the [Easing Functions](http://easings.net/) made by [Robert Penne](http://robertpenner.com/), then, I implemented Easing Functions and make a lovely demo.

##Demo

![](http://ww4.sinaimg.cn/mw690/610dc034jw1ehuzoul4h8g20b00gmh9s.gif)

##Uasage

### Step 1

Gradle

```groovy
compile 'com.daimajia.easing:library:1.0.0'
```
or maven

```xml
<dependency>
    <groupId>com.daimajia.easing</groupId>
    <artifactId>library</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Step 2

Just like a glider.

```java
AnimatorSet set = new AnimatorSet();
 set.playTogether(
         Glider.glide(s, 1200, ObjectAnimator.ofFloat(mTarget, "translationY", 0, 100)
 );

set.setDuration(1200);
set.start();
```

#About me

A student in mainland China. 

Welcome to [offer me an internship](mailto:daimajia@gmail.com).
If you have any new idea about this project, feel free to [contact me](mailto:daimajia@gmail.com).

