package com.example.sampleprojecct.LearningFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleprojecct.R
import com.example.sampleprojecct.database.KanjiWord
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class LearningAdapter(private val dataSet: List<KanjiWord>) :
    RecyclerView.Adapter<LearningAdapter.ViewHolder>() {
    private val adapterScope = CoroutineScope(Dispatchers.Default)

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val kanji: TextView= itemview.findViewById(R.id.kanji)
        val kanjiKorean: TextView = itemview.findViewById(R.id.kanji_korean)


    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_kanji_card, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val currentItem = dataSet[position]
        viewHolder.kanji.text = currentItem.kanji
        viewHolder.kanjiKorean.text = currentItem.mean
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

