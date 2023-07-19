package com.example.sampleprojecct.PartSelectionFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleprojecct.R

class PartSelectionAdapter(private val dataset:List<PartSelectionData>):
    RecyclerView.Adapter<PartSelectionAdapter.ViewHolder>() {
    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview){
        val title: TextView = itemview.findViewById(R.id.partSelection_Card_Title)
        val subTitle: TextView =  itemview.findViewById(R.id.partSelection_Card_subTitle)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PartSelectionAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_levelpart_card,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataset.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataset[position]
        when(currentItem.level){
            1->{
                holder.title.text = "초등학교 1학년 ${position.plus(1)}"
                holder.subTitle.text = "${currentItem.startNumber} - ${currentItem.endNumber}"

            }
            2->{
                holder.title.text = "초등학교 2학년 ${position.plus(1)}"
                holder.subTitle.text = "${currentItem.startNumber} - ${currentItem.endNumber}"
            }
            3->{
                holder.title.text = "초등학교 3학년 ${position.plus(1)}"
                holder.subTitle.text = "${currentItem.startNumber} - ${currentItem.endNumber}"
            }
            4->{
                holder.title.text = "초등학교 4학년 ${position.plus(1)}"
                holder.subTitle.text = "${currentItem.startNumber} - ${currentItem.endNumber}"
            }
            5->{
                holder.title.text = "초등학교 5학년 ${position.plus(1)}"
                holder.subTitle.text = "${currentItem.startNumber} - ${currentItem.endNumber}"
            }
            6->{
                holder.title.text = "초등학교 6학년 ${position.plus(1)}"
                holder.subTitle.text = "${currentItem.startNumber} - ${currentItem.endNumber}"
            }
        }
        holder.itemView.setOnClickListener{
            itemClickListener.onClick(it,position)
        }

    }
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    // (4) setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener : OnItemClickListener
}