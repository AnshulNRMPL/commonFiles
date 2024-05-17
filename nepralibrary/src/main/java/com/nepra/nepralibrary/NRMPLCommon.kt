package com.nepra.nepralibrary

import android.app.Dialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.view.Window

class NRMPLCommon {

    companion object {
        lateinit var dialog_loader: Dialog

        fun isNetworkAvaliable(context: Context): Boolean {
            var activeNetwork: NetworkInfo? = null
            try {
                val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                activeNetwork = connectivityManager.activeNetworkInfo
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return !(activeNetwork == null || !activeNetwork.isConnectedOrConnecting)
        }

        fun dialog_loading(context: Context?) {

            if (::dialog_loader.isInitialized) {
                dialog_loader.cancel()
            }

            dialog_loader = Dialog(context!!, R.style.TransparentBackground)
            dialog_loader.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog_loader.setContentView(R.layout.single_dialog_loading)
            dialog_loader.setCancelable(false)
            dialog_loader.show()
        }

        fun dissmis_dialog_loading() {
            if (::dialog_loader.isInitialized) {
                dialog_loader.cancel()
            }
        }
    }
}