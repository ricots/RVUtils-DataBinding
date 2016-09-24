RecyclerView Utils For DataBinding

###  duplicate v4 support library
```
// if use other library of dependency support, exclude group: 'com.android.support'
dependencies {
    compile("com.github.captain-miao:uniqueadapter:1.0.3") {
        exclude group: 'com.android.support'
    }
    compile("com.android.support:recyclerview-v7:${this.supportLibrariesVersion}")
    
    // other example
    compile("com.wang.avi:library:1.0.3") {
        exclude group: 'com.android.support'
    }

    compile("com.android.support:appcompat-v7:${this.supportLibrariesVersion}")
}


```
<br/>

### RefreshRecyclerView    
![load_more_screenshot](https://raw.githubusercontent.com/captain-miao/me.github.com/master/screenshot/refresh_and_load_more.gif "refresh_and_load_more")


### StickyRecyclerHeaderView    
![sticky_header_view](https://raw.githubusercontent.com/captain-miao/me.github.com/master/screenshot/sticky_header_view.gif "sticky_header_view")

<br/>


QQ  Group:436275452(Q&A)
# Thanks
## import Pull to Refresh
Ultra Pull to Refresh for Android:https://github.com/liaohuqiu/android-Ultra-Pull-To-Refresh.

## import sticky-headers-recyclerview
Sticky Headers decorator for Android's RecyclerView:https://github.com/timehop/sticky-headers-recyclerview

## License

    Copyright 2014, 2015, 2016 captain_miao

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
