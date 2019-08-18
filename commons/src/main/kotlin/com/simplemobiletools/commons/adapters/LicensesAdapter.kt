package com.simplemobiletools.commons.adapters

import android.view.Menu
import android.view.View
import android.view.ViewGroup
import com.simplemobiletools.commons.R
import com.simplemobiletools.commons.activities.BaseSimpleActivity
import com.simplemobiletools.commons.models.License
import com.simplemobiletools.commons.views.MyRecyclerView
import kotlinx.android.synthetic.main.license_list_item.view.*

class LicensesAdapter(activity: BaseSimpleActivity, val licenses: List<License>, recyclerView: MyRecyclerView,
                             itemClick: (Any) -> Unit) : MyRecyclerViewAdapter(activity, recyclerView, null, itemClick) {
    override fun getActionMenuId() = 5 // TODO: update number

    override fun prepareActionMode(menu: Menu) {}

    override fun actionItemPressed(id: Int) {}

    override fun getSelectableItemCount() = licenses.size

    override fun getIsItemSelectable(position: Int) = false

    override fun getItemSelectionKey(position: Int) = licenses[position].hashCode()

    override fun getItemKeyPosition(key: Int) = licenses.indexOfFirst { it.hashCode() == key}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = createViewHolder(R.layout.license_list_item,parent)
    override fun getItemCount() = licenses.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(licenses[position],true,false) { itemView, adapterPosition ->
            setupView(itemView,licenses[position])
        }

    }

    private fun setupView(view: View, license: License){
        view.apply{
            licenceTitle.text = context.getString(license.titleId)
        }


}
                             }