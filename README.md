Multistep Wizard 
=================

![Wizard Pager Screenshot](https://lh3.googleusercontent.com/-_-Sv3J3bdcc/UdeUUDd1TjI/AAAAAAAAEEo/yproJ-EbCJg/w412-h716-no/wizardPager.png)

Multistep Wizard is a library that provides an enhanced implementation of a Wizard UI originally developed by Julián Suárez (https://github.com/TechFreak/WizardPager)

Download
============

WizardPager is currently only available for Fusion staff.
Simply add the following code to your root `build.gradle`:

```groovy
allprojects {
    repositories {
        maven { url "http://nexus3.rancher.fusion.one:8081/repository/maven-releases/"}
    }
}
```

Now add the gradle dependency in your application's `build.gradle`:
```groovy
dependencies {
    compile 'com.github.fusion-com-au:wizardpager:2.0.1'
}
```

Usage
============

There is a sample implementation, so you can see how to add this library to your project. The example uses ActionBarCompat.


License
=======

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
