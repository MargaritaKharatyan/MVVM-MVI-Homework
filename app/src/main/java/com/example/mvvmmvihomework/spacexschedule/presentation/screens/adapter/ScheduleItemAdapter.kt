package com.example.mvvmmvihomework.spacexschedule.presentation.screens.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmmvihomework.R
import com.example.mvvmmvihomework.databinding.TemplateBinding
import com.example.mvvmmvihomework.spacexschedule.domain.model.ScheduleDomainModel

class ScheduleItemAdapter : RecyclerView.Adapter<ScheduleItemAdapter.ScheduleItemHolder>() {
    private var itemList = listOf<ScheduleDomainModel>()

    class ScheduleItemHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = TemplateBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.template, parent, false)
        return ScheduleItemHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleItemHolder, position: Int) {
        val item = itemList[position]
        holder.binding.apply {
            missionName.text = "Mission name: " + item.missionName
//            date.text = SimpleDateFormat("yyyy-MM-dd").format(Date())
            date.text = "Date: " + item.date
            details.text = "Detailes: " + item.details
            status.text = "Status: " + item.scheduleStatus
//            btnDelete.setOnClickListener {
//                removeItem(item, position)
//            }
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    fun submitList(it: List<ScheduleDomainModel>) {
        itemList = it
        notifyDataSetChanged()
    }

}