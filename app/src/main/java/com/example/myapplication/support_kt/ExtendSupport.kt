package com.example.myapplication.support_kt

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.Period

/**
 * ******************************
 *@author YOULU-wwb
 *date: 2020/4/21 14:35
 *description：
 * ******************************
 */
class ExtendSupport {

    /**
     * 扩展函数
     */
    fun String.lastChar():Char = this[this.length-1]

    @RequiresApi(Build.VERSION_CODES.O)
    fun Int.days() = Period.ofDays(this)
    @RequiresApi(Build.VERSION_CODES.O)
    fun Period.ago() = LocalDate.now() - this

    @RequiresApi(Build.VERSION_CODES.O)
    val l = 1.days().ago()

    val Int.days:Period
        @RequiresApi(Build.VERSION_CODES.O)
        get() = Period.ofDays(this)
    val Period.ago:LocalDate
        @RequiresApi(Build.VERSION_CODES.O)
        get() = LocalDate.now()-this

    val d = 1.days.ago

    /**
     * 中缀调用
     */

    infix fun Any.to(that:Any) = Pair(this,that)

    var k = "key" to "value"

    object 前
    @RequiresApi(Build.VERSION_CODES.O)
    infix fun Int.天(ago:前) = LocalDate.now()-Period.ofDays(this)

    @RequiresApi(Build.VERSION_CODES.O)
    val 一天前 = 1 天 前

    object start
    infix fun String.should(start:start):String = ""
    infix fun String.with(str:String):String = ""

    val str:String = "kotlin" should start with "kot"
}