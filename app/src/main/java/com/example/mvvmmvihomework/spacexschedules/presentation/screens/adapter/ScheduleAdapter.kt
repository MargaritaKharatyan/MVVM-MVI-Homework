package com.example.mvvmmvihomework.spacexschedules.presentation.screens.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmmvihomework.R
import com.example.mvvmmvihomework.databinding.TemplateBinding
import com.example.mvvmmvihomework.spacexschedules.domain.model.ScheduleDomainModel

class ScheduleAdapter : RecyclerView.Adapter<ScheduleAdapter.ScheduleHolder>() {
    private var itemList = listOf<ScheduleDomainModel>()

    class ScheduleHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = TemplateBinding.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.template, parent, false)
        return ScheduleHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleHolder, position: Int) {
        val item = itemList[position]
        holder.binding.apply {
            missionName.text = "Mission name: " + item.missionName
            date.text = "Date: " + item.date
            details.text = "Detailes: " + item.details
            status.text = "Status: " + item.Status
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