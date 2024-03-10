package com.example.keys.forms.form

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.keys.MainActivity
import com.example.keys.R
import com.example.keys.databinding.ActivityFormBinding
import com.google.android.material.chip.Chip

class FormActivity : AppCompatActivity(R.layout.activity_form){


    private val binding by viewBinding(ActivityFormBinding::bind)

    private fun getAllChips(): MutableList<Int> {
        return mutableListOf(binding.d1.id, binding.d2.id, binding.d3.id, binding.d4.id, binding.d5.id, binding.d6.id,)
    }



    //private var currentTopics = mutableListOf<String>("8:45", "10:35", "12:25", "14:45", "16:35", "18:25")

    //private var currentTopicss =  ["8:45", "10:35", "12:25", "14:45", "16:35", "18:25"]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var currentDate: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5, 6)

        var date = 0
        val chipData: List<Int> = getAllChips()
        for (id in chipData) {
            val chip: Chip = binding.chipData.findViewById(id)
            chip.text = currentDate[date].toString()
            date++
        }


        val ids: List<Int> = binding.chipTime.checkedChipIds
        date = 0


        for (id in ids) {
            val chip: Chip = binding.chipTime.findViewById(id)
            chip.text = currentDate[date].toString()
            date++
            chip.setOnClickListener{
                chip.isCheckable = !chip.isCheckable
            }
        }

        val idsData: List<Int> = binding.chipData.checkedChipIds
        for (id in idsData) {
            val chip: Chip = binding.chipData.findViewById(id)
            chip.setOnClickListener{
                chip.isCheckable = !chip.isCheckable
            }
        }




        binding.rightDataBtn.setOnClickListener{
            date = 0
            val chipData: List<Int> = getAllChips()
            for (id in chipData) {
                val chip: Chip = binding.chipData.findViewById(id)
                currentDate[date] += 6
                chip.text = currentDate[date].toString()
                date++
            }
        }

        binding.leftDataBtn.setOnClickListener{
            date = 0
            val chipData: List<Int> = getAllChips()
            for (id in chipData) {
                val chip: Chip = binding.chipData.findViewById(id)
                currentDate[date] -= 6
                chip.text = currentDate[date].toString()
                date++
            }
        }

        binding.exitBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.createBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



//        for(topic in currentTopics){
//            //Log.e("BABANOV", currentTopics.toString())
//            //currentTopics.add(topic.title)
//            addChipToGroup(topic)
//        }


    }
//    private fun addChipToGroup(time: String) {
//        val chip = layoutInflater.inflate(R.layout.item_chip_time, binding.chipTime, false) as Chip
//        chip.text = time
//        chip.isClickable = false
//        chip.isChecked = true
//        chip.isCheckable = false
//        chip.isCheckedIconVisible = false
//        binding.chipTime.addView(chip as View)
//    }
}