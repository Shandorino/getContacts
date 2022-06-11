package com.odsstudio.contactsbook.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.odsstudio.contactsbook.data.model.Icon
import com.odsstudio.contactsbook.databinding.IconActiveLayoutBinding
import com.odsstudio.contactsbook.databinding.IconDisableLayoutBinding

class IconAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    private val items: MutableList<Icon> = mutableListOf()

    override fun getItemViewType(position: Int): Int {
        return when(items[position]) {
            is Icon.Active -> ViewType.ACTIVE.ordinal
            is Icon.Disable -> ViewType.DISABLE.ordinal
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)


        return when(viewType) {
            ViewType.ACTIVE.ordinal -> {
                val binding = IconActiveLayoutBinding.inflate(inflater, parent, false)
                IconViewHolder(binding)
            }
            ViewType.DISABLE.ordinal -> {
                val binding = IconDisableLayoutBinding.inflate(inflater, parent, false)
                IconDisableViewHolder(binding)
            }
            else -> {
                val binding = IconActiveLayoutBinding.inflate(inflater, parent, false)
                IconViewHolder(binding)
            }
        }


    }

    fun setList(list: List<Icon>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        when (holder.itemViewType) {
            ViewType.ACTIVE.ordinal -> (holder as IconViewHolder).onBind(icon = item as Icon.Active)
            ViewType.DISABLE.ordinal -> (holder as IconDisableViewHolder).onBind(icon = item as Icon.Disable)
        }
    }

    override fun getItemCount(): Int = items.size



    inner class IconViewHolder(private val binding: IconActiveLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun onBind(icon: Icon.Active) {
            binding.text.text = icon.title
        }

    }

    inner class IconDisableViewHolder(private val binding: IconDisableLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun onBind(icon: Icon.Disable) {
            binding.text.text = icon.title
        }

    }

    enum class ViewType {
        ACTIVE, DISABLE
    }


}