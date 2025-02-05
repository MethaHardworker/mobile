package ru.fefu.myapplication.active

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.myapplication.R
import ru.fefu.myapplication.databinding.ActiveItemBinding
import ru.fefu.myapplication.databinding.DividerItemBinding
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Locale
import kotlin.time.DurationUnit
import kotlin.time.toDuration

class ActiveAdapter (
    activeList: ArrayList<Content>
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val ACTIVE = 0
        private const val DIVIDER = 1
    }

    private var itemClickListener: (Int) -> Unit = {}

    private var mutableActives = activeList.toMutableList()


    inner class ActiveHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = ActiveItemBinding.bind(item)
        fun bind(activity: Active) = with(binding) {
            val dist = "231 м"
            distance.text = dist
            duration.text = String.format(
                Locale.ENGLISH,
                (activity.endDate.time - activity.startDate.time).toDuration(DurationUnit.MILLISECONDS).inWholeMinutes.toString())
            active.text = activity.activity.typeName
            user.text = null
            val simpleDate = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            val strDt: String = simpleDate.format(activity.startDate)
            whenDid.text = strDt
        }

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                itemClickListener.invoke(position)
            }
        }
    }

    inner class DividerHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = DividerItemBinding.bind(item)
        fun bind(activity: Divider) = with(binding) {
            val simpleDate = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            val strDt: String = simpleDate.format(activity.date)
            text.text = strDt
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ACTIVE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.active_item, parent, false)
            return ActiveHolder(view)
        } else {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.divider_item, parent, false)
            return DividerHolder(view)
        }
    }

    override fun getItemCount(): Int = mutableActives.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == ACTIVE) {
            (holder as ActiveHolder).bind(mutableActives[position] as Active)
        }
        else {
            (holder as DividerHolder).bind(mutableActives[position] as Divider)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (mutableActives[position]::class == Active::class) ACTIVE else DIVIDER
    }

    fun setItemClickListener(listener: (Int) -> Unit) {
        itemClickListener = listener
    }

     fun addActive(active: Content) {
         mutableActives.add(active)
         notifyDataSetChanged()
     }

    fun submitList(list: List<Active>?): List<Content> {
        if (list != null) {
            mutableActives = list.toMutableList()
        }
        notifyDataSetChanged()
        return mutableActives.toList()
    }

}