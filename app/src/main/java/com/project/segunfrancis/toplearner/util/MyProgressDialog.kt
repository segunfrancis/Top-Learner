package com.project.segunfrancis.toplearner.util

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.os.Bundle
import java.text.NumberFormat

/**
 * Created by SegunFrancis
 */

class MyProgressDialog : AlertDialog {

    constructor(context: Context?) : super(null as Context?) {
        throw RuntimeException("Stub!")
    }

    constructor(
        context: Context?,
        theme: Int
    ) : super(null as Context?) {
        throw RuntimeException("Stub!")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        throw RuntimeException("Stub!")
    }

    public override fun onStart() {
        throw RuntimeException("Stub!")
    }

    override fun onStop() {
        throw RuntimeException("Stub!")
    }

    fun setProgress(value: Int) {
        throw RuntimeException("Stub!")
    }

    fun setSecondaryProgress(secondaryProgress: Int) {
        throw RuntimeException("Stub!")
    }

    fun getProgress(): Int {
        throw RuntimeException("Stub!")
    }

    fun getSecondaryProgress(): Int {
        throw RuntimeException("Stub!")
    }

    fun getMax(): Int {
        throw RuntimeException("Stub!")
    }

    fun setMax(max: Int) {
        throw RuntimeException("Stub!")
    }

    fun incrementProgressBy(diff: Int) {
        throw RuntimeException("Stub!")
    }

    fun incrementSecondaryProgressBy(diff: Int) {
        throw RuntimeException("Stub!")
    }

    fun setProgressDrawable(d: Drawable?) {
        throw RuntimeException("Stub!")
    }

    fun setIndeterminateDrawable(d: Drawable?) {
        throw RuntimeException("Stub!")
    }

    fun setIndeterminate(indeterminate: Boolean) {
        throw RuntimeException("Stub!")
    }

    fun isIndeterminate(): Boolean {
        throw RuntimeException("Stub!")
    }

    override fun setMessage(message: CharSequence?) {
        throw RuntimeException("Stub!")
    }

    fun setProgressStyle(style: Int) {
        throw RuntimeException("Stub!")
    }

    fun setProgressNumberFormat(format: String?) {
        throw RuntimeException("Stub!")
    }

    fun setProgressPercentFormat(format: NumberFormat?) {
        throw RuntimeException("Stub!")
    }

    companion object {

        val STYLE_HORIZONTAL = 1

        val STYLE_SPINNER = 0

        fun show(
            context: Context?,
            title: CharSequence?,
            message: CharSequence?
        ): MyProgressDialog {
            throw RuntimeException("Stub!")
        }

        fun show(
            context: Context?,
            title: CharSequence?,
            message: CharSequence?,
            indeterminate: Boolean
        ): MyProgressDialog {
            throw RuntimeException("Stub!")
        }

        fun show(
            context: Context?,
            title: CharSequence?,
            message: CharSequence?,
            indeterminate: Boolean,
            cancelable: Boolean
        ): MyProgressDialog {
            throw RuntimeException("Stub!")
        }

        fun show(
            context: Context?,
            title: CharSequence?,
            message: CharSequence?,
            indeterminate: Boolean,
            cancelable: Boolean,
            cancelListener: DialogInterface.OnCancelListener?
        ): MyProgressDialog {
            throw RuntimeException("Stub!")
        }
    }
}
