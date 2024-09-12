package com.example.waterwisetips

import android.app.Dialog
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WaterWiseTips : AppCompatActivity() {

    private val waterTips = arrayOf(
        "Turn off the tap while brushing your teeth to save water.",
        "Use a bucket instead of a hose when washing your car.",
        "Install water-saving showerheads and faucets.",
        "Collect rainwater for gardening and other non-potable uses.",
        "Fix leaky faucets to prevent wasting water.",
        "Run your dishwasher and laundry machine only when full.",
        "Reduce water use by using a broom instead of a hose to clean driveways."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the image buttons with water conservation tips
        val tipButtons = arrayOf(
            findViewById<ImageButton>(R.id.tip1),
            findViewById<ImageButton>(R.id.tip2),
            findViewById<ImageButton>(R.id.tip3),
            findViewById<ImageButton>(R.id.tip4),
            findViewById<ImageButton>(R.id.tip5),
            findViewById<ImageButton>(R.id.tip6),
            findViewById<ImageButton>(R.id.tip7)
        )

        for (i in tipButtons.indices) {
            tipButtons[i].setOnClickListener {
                showWaterTipDialog(waterTips[i])
            }
        }

        // Load YouTube videos into WebView
        val webView1 = findViewById<WebView>(R.id.videoWebView1)
        val webView2 = findViewById<WebView>(R.id.videoWebView2)

        loadYouTubeVideo(webView1, "nTcFXJT0Fsc") // Replace with actual video ID
        loadYouTubeVideo(webView2, "GVmBWQ7Zrzk") // Replace with actual video ID
    }

    private fun loadYouTubeVideo(webView: WebView, videoId: String) {
        webView.settings.javaScriptEnabled = true
        webView.settings.pluginState = WebSettings.PluginState.ON
        webView.webViewClient = WebViewClient()

        val embedHTML = """
            <iframe width="100%" height="100%" src="https://www.youtube.com/embed/$videoId" 
            frameborder="0" allowfullscreen></iframe>
        """.trimIndent()

        webView.loadData(embedHTML, "text/html", "utf-8")
    }

    private fun showWaterTipDialog(tip: String) {
        // Create a dialog instance
        val dialog = Dialog(this)

        // Set the custom layout for the dialog
        dialog.setContentView(R.layout.dialog_tip)

        // Find the TextView and Button from the dialog layout
        val tipTextView = dialog.findViewById<TextView>(R.id.tipText)
        val closeButton = dialog.findViewById<Button>(R.id.closeButton)

        // Set the water conservation tip text
        tipTextView.text = tip

        // Close the dialog when the button is clicked
        closeButton.setOnClickListener {
            dialog.dismiss()
        }

        // Show the dialog
        dialog.show()
    }
}
