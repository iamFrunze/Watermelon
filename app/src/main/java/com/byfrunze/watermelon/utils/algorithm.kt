package com.byfrunze.watermelon.utils

import com.byfrunze.watermelon.data.tableM
import com.byfrunze.watermelon.data.tableV

fun createMapCircle(): Map<Int, Float> {
    val mMap = mutableMapOf<Int, Float>()
    for ((m, i) in (45..99).withIndex()) {
        mMap[i] = tableM[m]
    }

    return mMap as Map<Int, Float>
}

fun createMapOval(): Map<Float, Int> {
    val mMap = mutableMapOf<Float, Int>()
    for ((m, i) in tableV.withIndex()) {
        mMap[i] = m
    }
    return mMap as Map<Float, Int>
}