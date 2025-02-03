package ru.fefu.myapplication.active

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.myapplication.R
import ru.fefu.myapplication.databinding.ActiveTypeItemBinding

fun Int.dpToPx(cntxt: Context): Int = (this * cntxt.resources.displayMetrics.density).toInt()

class ActiveTypeAdapter: RecyclerView.Adapter<ActiveTypeAdapter.ActiveTypeHolder>() {
    private var selectedPos = RecyclerView.NO_POSITION
    lateinit var chosenTitle: String
    private var mutableActiveTypes: ArrayList<ActiveType> = arrayListOf(
        ActiveType("Велосипед", R.drawable.ic_registration_bicycles),
        ActiveType("Бег", R.drawable.ic_registration_bicycles),
        ActiveType("Шаг", R.drawable.ic_registration_bicycles),
    )


    inner class ActiveTypeHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ActiveTypeItemBinding.bind(item)
        fun bind(activeType: ActiveType) = with(binding) {
            activeTypeName.text = activeType.name
            activeTypePic.setImageResource(activeType.picture)
        }

        init {
            itemView.setOnClickListener {
                notifyItemChanged(selectedPos)
                val position = adapterPosition
                selectedPos = position
                chosenTitle = mutableActiveTypes[position].name
                notifyItemChanged(selectedPos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveTypeHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.active_type_item, parent, false)
        return ActiveTypeHolder(view)
    }

    override fun getItemCount(): Int = mutableActiveTypes.size

    override fun onBindViewHolder(holder: ActiveTypeHolder, position: Int) {
        holder.bind(mutableActiveTypes[position])
        holder.itemView.isSelected = selectedPos == position
        if (holder.itemView.isSelected) {
            holder.binding.card.strokeWidth = 2.dpToPx(holder.itemView.context)
        }
        else {
            holder.binding.card.strokeWidth = 1.dpToPx(holder.itemView.context)
        }
    }

}
