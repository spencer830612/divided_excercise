package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //要加的
    // 我們真正要建立的元件是在 Layout，如果在 Gradle 先設定，就可以再引用元件的 ID。
    // Binding 的意義是把「值」動態設定過來，把在 Layout 的值存到 binding
    // 這種的 assign 有動態的概念。當東西部有更動時，可以自動更新到 binding 裡。
    // Private 代表這個變數只能用在這個大刮號裡
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this)) //要加的
        // inflater 類似於載入器
        // this 代表這頁的 Layout 檔案
        setContentView(binding.root) //要改的
        // 設定這頁的畫面給大家看，然後畫面放在 binding 裡的 root
        // 為何用 root？因為 root 代表階層架構的最上層
        // 如果只想展示 buttom ，那麼就是用 setContentView(binding.btDivide)

        binding.btDivide.setOnClickListener {
            // setOnClickListener 就是請 Android 去監控此按鈕的點擊狀況
            val u = binding.upper.text.toString().toInt()
            val l = binding.lowwer.text.toString().toInt()
            // 原本的 text 的型態是 editable，不是 String。
            val text = "$u / $l = ${u / l}...${u % l}"

            binding.textView.text = text
            // 最後把 text 的內容回傳給 textView 的 text 裡
        }

    }
}