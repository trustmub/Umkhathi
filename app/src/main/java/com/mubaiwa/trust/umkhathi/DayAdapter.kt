package com.mubaiwa.trust.umkhathi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.mubaiwa.trust.umkhathi.Weather.Day

/**
 * Created by trust on 2016/02/02.
 */
class DayAdapter(private val mContext: Context, private val mDays: Array<Day>) : BaseAdapter() {
    override fun getCount(): Int {
        return mDays.size
    }

    override fun getItem(position: Int): Any {
        return mDays[position]
    }

    override fun getItemId(position: Int): Long {
        return 0 // we are not going touse this, it is used to tag items for easy reference.
    }

    override fun getView(position: Int, convertView: View, parent: ViewGroup): View {
        var convertView = convertView
        val holder: ViewHolder
        if (convertView == null) {
            // that means it is brand new we need to create everything
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_list_item, null)
            holder = ViewHolder()
            holder.iconImageView = convertView.findViewById<View>(R.id.iconImageView) as ImageView
            holder.temperatureLabel = convertView.findViewById<View>(R.id.temperatureLabel) as TextView
            holder.dayLabel = convertView.findViewById<View>(R.id.dayNameLabel) as TextView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        val day = mDays[position]
        holder.iconImageView!!.setImageResource(day.iconId)
        holder.temperatureLabel!!.text = day.temperatureMax.toString() + ""
        holder.dayLabel!!.text = day.dayOfTheWeek
        return convertView
    }

    private class ViewHolder {
        var iconImageView // they are public by default
                : ImageView? = null
        var temperatureLabel: TextView? = null
        var dayLabel: TextView? = null
    }

}