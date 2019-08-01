# HoshiiMiki-AndroidVideoPlayer
HoshiiMiki-A android online/offline video player

![](https://raw.githubusercontent.com/mouyase/HoshiiMiki-AndroidVideoPlayer/master/Hoshii-Miki.png)

## How to use

### In the build.gradle of your project

```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url "https://raw.githubusercontent.com/mouyase/HoshiiMiki-AndroidVideoPlayer/master/aar" }
    }
}
```

### In the build.gradle of your module

```
implementation 'tech.yojigen:HoshiiMiki:0.0.1'
```

### And use it

```
VideoPlayer.getInstance().playOnActivity(Context context, String videoActivityTitle, String filePath));
```
or
```
HoshiiMiki.getInstance().playOnActivity(Context context, String videoActivityTitle, String filePath));
```
or
```
Miki.getInstance().playOnActivity(Context context, String videoActivityTitle, String filePath));
```


## Based

 - [SuperPlayer](https://github.com/tencentyun/SuperPlayer_Android)