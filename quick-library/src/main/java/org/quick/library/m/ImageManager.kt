package org.quick.library.m

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.text.TextUtils
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.util.Util
import org.quick.library.R
import org.quick.library.config.GlideApp
import java.io.File

/**
 * 请在这里写上用途
 *
 * @author chris
 * @Date 16/9/23
 * @modifyInfo1 chris-16/9/23
 * @modifyContent
 */

object ImageManager {
    var defaultError = R.drawable.ic_broken_image_gray_24dp
    var defaultEmpty = R.drawable.ic_image_gray_24dp

    @Synchronized
    fun loadImage(context: Context, resId: Int, iv: ImageView) {
        loadImage(context, resId, -1, -1, iv)
    }

    @Synchronized
    fun loadImage(context: Context, resId: Int, errorImg: Int, emptyImg: Int, iv: ImageView) {
        loadImage(context, null, null, resId, errorImg, emptyImg, iv)
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context 可以是Activity 和 Fragment
     * @param file    图片file
     * @param iv      显示图片的ImageView
     */
    @Synchronized
    fun loadImage(context: Context, file: File, iv: ImageView) {
        loadImage(context, file, -1, -1, iv)
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context 可以是Activity 和 Fragment
     * @param file    图片file
     * @param iv      显示图片的ImageView
     */
    @Synchronized
    fun loadImage(context: Context, file: File, errorImg: Int, emptyImg: Int, iv: ImageView) {
        loadImage(context, null, file, -1, errorImg, emptyImg, iv)
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context 可以是Activity 和 Fragment
     * @param url     图片url
     * @param iv      显示图片的ImageView
     */
    @Synchronized
    fun loadImage(context: Context, url: String, iv: ImageView) {
        loadImage(context, url, -1, -1, iv)
    }

    fun loadImage(context: Context, url: String, listener: RequestListener<Bitmap>) {
        Glide.with(context).asBitmap().load(url).addListener(listener).preload()
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context  可以是Activity 和 Fragment
     * @param url      图片url
     * @param errImg   加载出错显示的图片
     * @param emptyImg 加载前的默认图
     * @param iv       显示图片的ImageView
     */
    @Synchronized
    fun loadImage(context: Context, url: String, errImg: Int, emptyImg: Int, iv: ImageView) {
        loadImage(context, url, null, -1, errImg, emptyImg, iv)
    }

    /**
     * @param context
     * @param url      允许为空
     * @param file     允许为空
     * @param resId    允许为空
     * @param errImg   允许为空
     * @param emptyImg 允许为空
     * @param iv
     */
    @Synchronized
    private fun loadImage(context: Context?, url: String?, file: File?, resId: Int, errImg: Int, emptyImg: Int, iv: ImageView) {
        var err = errImg
        var empty = emptyImg
        if (Util.isOnMainThread() && context != null) {
            if (context is Activity) if (context.isFinishing || context.isDestroyed) return
            if (err == -1) err = defaultError
            if (empty == -1) empty = defaultEmpty
            when {
                !TextUtils.isEmpty(url) -> GlideApp.with(context).load(url).centerCrop().placeholder(empty).error(err).transition(withCrossFade()).into(iv)
                file != null -> GlideApp.with(context).load(file).centerCrop().placeholder(empty).error(err).transition(withCrossFade()).into(iv)
                resId != -1 -> GlideApp.with(context).load(resId).centerCrop().placeholder(empty).error(err).transition(withCrossFade()).into(iv)
            }
        }
    }

    /**
     * 加载Assets中的图片
     *
     * @param context   可以是Activity 和 Fragment
     * @param name      图片名称
     * @param imageView 显示图片的ImageView
     */
    @Synchronized
    fun loadAssetImage(context: Context, name: String, imageView: ImageView) {

        if (Util.isOnMainThread())
            Glide.with(context).load("file:///android_asset/$name").into(imageView)
    }


    @Synchronized
    fun loadCircleImage(context: Context, resId: Int, iv: ImageView) {

        loadCircleImage(context, resId, -1, -1, iv)
    }

    @Synchronized
    fun loadCircleImage(context: Context, resId: Int, errorImg: Int, emptyImg: Int, iv: ImageView) {
        loadCircleImage(context, null, null, resId, errorImg, emptyImg, iv)
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context 可以是Context 和 Fragment
     * @param file    图片file
     * @param iv      显示图片的ImageView
     */
    @Synchronized
    fun loadCircleImage(context: Context, file: File, iv: ImageView) {
        loadCircleImage(context, file, -1, -1, iv)
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context 可以是Context 和 Fragment
     * @param file    图片file
     * @param iv      显示图片的ImageView
     */
    @Synchronized
    fun loadCircleImage(context: Context, file: File, errorImg: Int, emptyImg: Int, iv: ImageView) {
        loadCircleImage(context, null, file, -1, errorImg, emptyImg, iv)
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context 可以是Context 和 Fragment
     * @param url     图片url
     * @param iv      显示图片的ImageView
     */
    @Synchronized
    fun loadCircleImage(context: Context, url: String, iv: ImageView) {
        loadCircleImage(context, url, -1, -1, iv)
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context  可以是Context 和 Fragment
     * @param url      图片url
     * @param errImg   加载出错显示的图片
     * @param emptyImg 加载前的默认图
     * @param iv       显示图片的ImageView
     */
    @Synchronized
    fun loadCircleImage(context: Context, url: String, errImg: Int, emptyImg: Int, iv: ImageView) {
        loadCircleImage(context, url, null, -1, errImg, emptyImg, iv)
    }

    /**
     * @param context
     * @param url      允许为空
     * @param file     允许为空
     * @param resId    允许为空
     * @param errImg   允许为空
     * @param emptyImg 允许为空
     * @param iv
     */
    @Synchronized
    private fun loadCircleImage(context: Context?, url: String?, file: File?, resId: Int, errImg: Int, emptyImg: Int, iv: ImageView) {
        var err = errImg
        var empty = emptyImg
        if (Util.isOnMainThread() && context != null) {
            if (context is Activity) if (context.isFinishing && context.isDestroyed) return
            if (err == -1) err = defaultError
            if (empty == -1) empty = defaultEmpty
            when {
                !TextUtils.isEmpty(url) -> GlideApp.with(context).load(url).centerCrop().placeholder(empty).error(err).transform(CircleCrop()).transition(withCrossFade()).into(iv)
                file != null -> GlideApp.with(context).load(file).centerCrop().placeholder(empty).error(err).transform(CircleCrop()).transition(withCrossFade()).into(iv)
                resId != -1 -> GlideApp.with(context).load(resId).transform(CircleCrop()).centerCrop().placeholder(empty).error(err).transition(withCrossFade()).into(iv)
            }
        }
    }

    @Synchronized
    fun loadRoundImage(context: Context, resId: Int, iv: ImageView) {
        loadRoundImage(context, resId, 4, -1, -1, iv)
    }

    @Synchronized
    fun loadRoundImage(context: Context, resId: Int, radius: Int, errorImg: Int, emptyImg: Int, iv: ImageView) {
        loadRoundImage(context, null, null, resId, radius, errorImg, emptyImg, iv)
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context 可以是Context 和 Fragment
     * @param file    图片file
     * @param iv      显示图片的ImageView
     */
    @Synchronized
    fun loadRoundImage(context: Context, file: File, iv: ImageView) {
        loadRoundImage(context, file, -1, 4, -1, iv)
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context 可以是Context 和 Fragment
     * @param file    图片file
     * @param iv      显示图片的ImageView
     */
    @Synchronized
    fun loadRoundImage(context: Context, file: File, radius: Int, errorImg: Int, emptyImg: Int, iv: ImageView) {
        loadRoundImage(context, null, file, -1, radius, errorImg, emptyImg, iv)
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context 可以是Context 和 Fragment
     * @param url     图片url
     * @param iv      显示图片的ImageView
     */
    @Synchronized
    fun loadRoundImage(context: Context, url: String, iv: ImageView) {
        loadRoundImage(context, url, -1, 4, -1, iv)
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context 可以是Context 和 Fragment
     * @param url     图片url
     * @param iv      显示图片的ImageView
     */
    @Synchronized
    fun loadRoundImage(context: Context, url: String, radius: Int, iv: ImageView) {
        loadRoundImage(context, url, null, -1, radius, -1, -1, iv)
    }

    /**
     * 加载图片为圆形图片
     *
     * @param context  可以是Context 和 Fragment
     * @param url      图片url
     * @param errImg   加载出错显示的图片
     * @param emptyImg 加载前的默认图
     * @param iv       显示图片的ImageView
     */
    @Synchronized
    fun loadRoundImage(context: Context, url: String, radius: Int, errImg: Int, emptyImg: Int, iv: ImageView) {
        loadRoundImage(context, url, null, -1, radius, errImg, emptyImg, iv)
    }

    /**
     * @param context
     * @param url      允许为空
     * @param file     允许为空
     * @param resId    允许为空
     * @param errImg   允许为空
     * @param emptyImg 允许为空
     * @param radius   圆角
     * @param iv
     */
    @Synchronized
    private fun loadRoundImage(context: Context?, url: String?, file: File?, resId: Int, radius: Int, errImg: Int, emptyImg: Int, iv: ImageView) {
        var err = errImg
        var empty = emptyImg
        if (Util.isOnMainThread() && context != null) {
            if (context is Activity) if (context.isFinishing && context.isDestroyed) return
            if (err == -1) err = defaultError
            if (empty == -1) empty = defaultEmpty
            when {
                !TextUtils.isEmpty(url) -> GlideApp.with(context).load(url).transform(RoundedCorners(radius)).centerCrop().placeholder(empty).error(err).transition(withCrossFade()).into(iv)
                file != null -> GlideApp.with(context).load(file).transform(RoundedCorners(radius)).centerCrop().placeholder(empty).error(err).transition(withCrossFade()).into(iv)
                resId != -1 -> GlideApp.with(context).load(resId).transform(RoundedCorners(radius)).centerCrop().placeholder(empty).error(err).transition(withCrossFade()).into(iv)
            }
        }
    }

    /**
     * 取消所有正在下载或等待下载的任务。
     **/
    @Synchronized
    fun cancelAllTasks(context: Context) {
        Glide.with(context).pauseRequests()
    }

    /**
     * 恢复所有任务
     */
    @Synchronized
    fun resumeAllTasks(context: Context) {
        Glide.with(context).resumeRequests()
    }


    /**
     * 清除内存缓存
     */
    fun clearMemory(context: Context) {
        Glide.get(context).clearMemory()
    }

    /**
     * 清除磁盘缓存
     */
    fun clearDiskCache(context: Context) {
        Thread(Runnable { Glide.get(context).clearDiskCache() }).start()
    }

    /**
     * 清除所有缓存
     */
    @Synchronized
    fun cleanAllCache(context: Context) {
        clearDiskCache(context)
        clearMemory(context)
    }
}
