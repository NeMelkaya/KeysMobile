package com.example.keys.forms

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.keys.databinding.ItemFormBinding
import com.example.keys.forms.form.FormActionListener
import com.example.keys.my_enum.StatusForm
import com.example.keys.my_enum.StatusKey

class FormsAdapter(private val formActionListener: FormActionListener) : RecyclerView.Adapter<FormsAdapter.FormsViewHolder>(){

    var formData: List<Forms> = (1..5).map {
        Forms(
            id = it.toLong(),
            name = "name",
            data = "11.01.2024", // Ссылка на фото человека
            time = "8:45 - 10:20",
            room = 111,
            statusForm = StatusForm.WAIT,
            statusKey = StatusKey.NO,
            isKey = false
        )
    }


    inner class FormsViewHolder (val binding: ItemFormBinding) : RecyclerView.ViewHolder(binding.root){
        init {
            binding.statusKeyBtn.setOnClickListener{
                formActionListener.onFormGetKey(formData[bindingAdapterPosition])
            }
        }
    }


    override fun getItemCount(): Int {
        return formData.size // Количество элементов в списке данных
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FormsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFormBinding.inflate(inflater, parent, false)

        return FormsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FormsViewHolder, position: Int) {
        val form = formData[position] // Обновить элемент списка
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