package org.oppia.app.recyclerview

import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

/**
 * Binds the specified generic data to the adapter of the [RecyclerView]. This is called by
 * Android's data binding framework and should not be used directly. For reference:
 * https://android.jlelse.eu/1bd08b4796b4.
 */
@BindingAdapter("data")
fun <T: Any> bindToRecyclerViewAdapter(recyclerView: RecyclerView, liveData: LiveData<List<T>>) {
  liveData.value?.let { data ->
    val adapter = recyclerView.adapter
    checkNotNull(adapter) { "Cannot bind data to a RecyclerView missing its adapter." }
    check(adapter is BindableAdapter<*>) { "Can only bind data to a BindableAdapter." }
    adapter.setDataUnchecked(data)
  }
}
