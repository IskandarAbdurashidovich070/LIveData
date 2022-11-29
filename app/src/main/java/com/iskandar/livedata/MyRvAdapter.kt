package com.iskandar.livedata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.iskandar.livedata.databinding.RvItem1Binding
import com.iskandar.livedata.databinding.RvItemBinding


class MyRvAdapter(var lifecycleOwner: LifecycleOwner) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class Vh(var rvItemBinding: RvItemBinding) : RecyclerView.ViewHolder(rvItemBinding.root) {
        fun onBind() {
            rvItemBinding.edt.addTextChangedListener {
                LiveData.live.postValue(it.toString())
            }
        }

    }

    inner class Vh1(var rvItem1Binding: RvItem1Binding) :RecyclerView.ViewHolder(rvItem1Binding.root) {
        fun onBind() {
            LiveData.live.observe(lifecycleOwner){
                rvItem1Binding.edt.text = it
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == 0) {
            Vh(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else {
            Vh1(RvItem1Binding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position==0){
            (holder as Vh).onBind()
        }else{
            (holder as Vh1).onBind()
        }
    }


    override fun getItemCount(): Int = 2

    override fun getItemViewType(position: Int): Int {
        return position
    }

}