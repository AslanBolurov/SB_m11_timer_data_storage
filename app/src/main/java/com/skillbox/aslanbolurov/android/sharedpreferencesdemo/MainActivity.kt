package com.skillbox.aslanbolurov.android.sharedpreferencesdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.addTextChangedListener
import com.skillbox.aslanbolurov.android.sharedpreferencesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository=Repository()
        binding.tv.text="app created!"
        binding.saveButton.setOnClickListener {
            var text=binding.editText.text.toString()
            repository.saveText(text,this)
        }
        binding.clearButton.setOnClickListener {
            repository.clearText(this)
        }

        binding.buttonShowValue.setOnClickListener {
            binding.tv.text=repository.getText(this)
        }

        binding.editText.addTextChangedListener { object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //nothing do
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("abl",s.toString())
                binding.tv.setText(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {
                //nothing do
            }

        } }

    }
}