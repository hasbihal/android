package com.hasbihal.data

interface IDataSource {

    fun <T> getData(): T

}