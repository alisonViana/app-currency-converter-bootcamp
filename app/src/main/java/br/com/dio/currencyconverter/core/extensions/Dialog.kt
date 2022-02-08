package br.com.dio.currencyconverter.core.extensions

import android.content.Context
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import br.com.dio.currencyconverter.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

fun Context.createDialog(block: MaterialAlertDialogBuilder.() -> Unit = {}): AlertDialog {
    val builder = MaterialAlertDialogBuilder(this)
    builder.setPositiveButton(R.string.label_ok, null)
    block(builder)
    return builder.create()
}

fun Context.createProgressDialog(): AlertDialog {
    return createDialog {
        val padding =  this@createProgressDialog.resources.getDimensionPixelOffset(R.dimen.layout_padding)
        val progressBar = ProgressBar(this@createProgressDialog)

        progressBar.setPadding(padding, padding, padding, padding)

        setView(progressBar)
        setPositiveButton(null, null)
        setCancelable(false)
    }
}