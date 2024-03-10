package com.example.keys.forms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.keys.databinding.ItemFormBinding
import com.example.keys.forms.form.FormActionListener
import com.example.keys.my_enum.StatusForm
import com.example.keys.my_enum.StatusKey



class FormsAdapterOld(private val formActionListener: FormActionListener) :
    ListAdapter<Forms, FormsAdapterOld.FormsViewHolder>(DiffCallback) {
        companion object{
            val DiffCallback = object : DiffUtil.ItemCallback<Forms>() {
                override fun areItemsTheSame(oldItem: Forms, newItem: Forms): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Forms, newItem: Forms): Boolean {
                    return oldItem == newItem
                }

            }
        }



    inner class FormsViewHolder (val binding: ItemFormBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.statusKeyBtn.setOnClickListener{
                formActionListener.onFormGetKey(getItem(bindingAdapterPosition))
            }
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFormBinding.inflate(inflater, parent, false)

        return FormsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FormsViewHolder, position: Int) {
        val form = getItem(position) // Обновить элемент списка
        val context = holder.itemView.context

        with(holder.binding) {
            //val color = if (form.isLiked) R.color.red else R.color.grey // Цвет "сердца", если пользователь был лайкнут

            holder.itemView.tag = form
            statusKeyBtn.tag = form

            nameText.text = form.name
            timeText.text = form.time
            dataText.text = form.data
            roomNumTV.text = form.room.toString()



            when(form.statusForm){
                StatusForm.WAIT -> statusFormBtn.text = "Ожидание"
                StatusForm.DONE -> statusFormBtn.text = "Одобрено"
                StatusForm.NO -> statusFormBtn.text = "Отклонено"
                else -> {
                    statusFormBtn.text = "Ошибка"
                }
            }

            when(form.statusKey){
                StatusKey.NO -> statusKeyBtn.text = "Ключ не в деканате"
                StatusKey.WAIT -> statusKeyBtn.text = "Ждем подтверждения"
                StatusKey.GET -> statusKeyBtn.text = "Получить ключ"
                StatusKey.DONE -> statusKeyBtn.text = "Ключ получен"
                else -> {
                    statusKeyBtn.text = "Ошибка"
                }
            }


//            if(form.statusForm == StatusForm.WAIT){
//                statusFormBtn.text = "Ожидание"
//            }
//            else{
//                if(form.statusForm == StatusForm.DONE){
//                    statusFormBtn.text = "Одобрено"
//                }
//                else{
//                    statusFormBtn.text = "Отклонено"
//                }
//            }



//            likedImageView.setColorFilter( // Отрисовка цвета "сердца"
//                ContextCompat.getColor(context, color),
//                android.graphics.PorterDuff.Mode.SRC_IN
//            )

        }



    }
}