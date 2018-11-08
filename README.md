# SlidingShut 右滑关闭2.0

## 简介
很多APP中都会有右滑关闭功能，  
尤其是在全面屏时代更显得尤为重要，  
但是，  
Android 8.0禁止非全屏的Activity使用透明主题，   
否则会引发：
> Only fullscreen opaque activities can request orientation  

这导致了体验最优的右滑关闭方案则不能再使用，  
除非有微信那种黑科技。  

手机QQ的右滑关闭虽然不需要透明主题，  
但是没有实时反馈，  
体验巨差，  
那么就没有其他的选择了吗？  

于是我总结了一下，  
目前最多的有两种右滑方案：
  
## 1、以微信为代表的透明方案
> 优点1：  
> 界面移动跟随手指，  
> 实时反馈。  
>   
> 优点2：  
> 拟物化，  
> 层级明确，  
> 视觉体验好。  
———————————  
> 缺点1：  
> 由于涉及到滑动速度，  
> 要滑多快才会触发关闭，  
> 这阈值永远是个未知数，  
> 再加上使用右滑关闭的App越来越多，  
> 每个App的这个阈值都不一样，  
> 无形中增加了关闭失败的几率  
> 以及用户的思考成本。  
>   
> 缺点2：  
> 需要透明主题，  
> 不仅有可能会扰乱上一个Activity的生命周期，  
> 而且SDK 27中非全屏Activity不可用，  
> 否侧会crash。


## 2、以QQ为代表的滑动方向计算
> 优点：  
> 不需要透明主题  
———————————  
> 缺点1：  
> 没有任何反馈，  
> 用户无法知道当前手势是否可以触发关闭，  
> 误触率高。  
>   
> 缺点2：  
> 反应迟钝，  
> 由于需要手势完成才能获得完整手势，  
> 所以手指抬起后才会触发关闭，  
> 虽然微信也是抬起后关闭，  
> 但是视觉上和心理上却不存在此缺点。  
> 不过有个稍优点的方案，  
> 实时计算手势的，  
> 反应灵敏了许多，  
> 但却会增加误触几率。  
>   
> 缺点3：  
> 没有层级感，  
> 更不拟物化。  

那么有没有其他的方案，  
既不需要透明主题，  
又能实时反馈？  

当然，  
既然我写了这篇帖子，  
那么当然会给大家提供一种方案。

## 3：Bamboy右滑关闭方案
> 优点1：  
> 不需要透明主题。  
>   
> 优点2：  
> 界面跟随手指，  
> 实时反馈，  
> 会不会关闭用户一目了然。  
>   
> 优点3：  
> 拟物化，  
> 视觉体验好。  
———————————  
> 缺点：  
> 没有微信的那种方案层级感强。  


废话不多说，  
这就给大家展示一下效果吧：  
  
## 一、抬起模式
顾名思义  
滑动过程中圆环进度条跟随手指而充盈  
当圆环圆满后  
抬起手指后才会触发finish();  

想要使用抬起模式  
调用以下代码即可：
> setUpFinish(true);  
> (注：默认为true，即默认抬起模式)
  
![抬起模式](https://github.com/Bamboy120315/SlidingShut/blob/master/gif/gif01_upFinish.gif)

## 二、即刻模式
与抬起模式相对应  
只要圆环圆满就触发finish();  
相比来说  
即刻模式更敏捷  
但却存在误触的情况  
选择适合自己的  
  
想要使用抬起模式  
调用以下代码即可：
> setUpFinish(false);  

![即刻模式](https://github.com/Bamboy120315/SlidingShut/blob/master/gif/gif02_startInstantly.gif)

## 三、兼容finish()被拦截的情况
当Activity中finish()方法被拦截时  
已经移动的界面自动归位  
归位后自动重新开启右滑关闭  

![finish()被拦截](https://github.com/Bamboy120315/SlidingShut/blob/master/gif/gif03_interceptFinish.gif)

## 四、指定滑动View
看了上面几个动图  
心细的朋友可能发现了  
在界面移动时  
Activity左上角出现了一个白条条  
这是因为TitleBar的颜色和界面的颜色不一致导致的  
虽说无伤大雅  
但作为一个视觉主义的程序员  
这个小细节也是要优化的  
所以我提供了只移动指定View功能  
就是说不会整个界面都移动  
你让他动的才会动  
  
想要指定滑动View  
调用以下代码即可：
> setMoveView(rootView);  

![指定View](https://github.com/Bamboy120315/SlidingShut/blob/master/gif/gif04_assignView.gif)

## 五、圆环颜色自定义
不管是出于性能  
还是出于可扩展性  
这个圆环进度条是完全用Canvas画出来的  
所以颜色当然是支持自定义的  
比如界面背景色不是白色  
而是主题色时  
  
想要指定圆环颜色  
调用以下代码即可：
> int color = ContextCompat.getColor(context, R.color.white);  
> setProgressColor(color);  

![彩色背景](https://github.com/Bamboy120315/SlidingShut/blob/master/gif/gif05_colorBackdrop.gif)

















