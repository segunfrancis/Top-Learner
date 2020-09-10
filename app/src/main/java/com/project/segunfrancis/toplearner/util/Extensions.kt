package com.project.segunfrancis.toplearner.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

/**
 * Created by SegunFrancis
 */

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.displaySnackBar(message: String?) {
    Snackbar.make(this, message!!, Snackbar.LENGTH_LONG).show()
}