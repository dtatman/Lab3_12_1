package com.example.lab3_12

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ImageAdapter(private val imageUrls: List<String>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_image, parent, false)
        return ImageViewHolder(view)
    }
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val imageUrl = imageUrls[position]


        // Tải ảnh từ URL bằng Glide
        Picasso.with(holder.itemView.context)
            .load(imageUrl)
            .placeholder(R.drawable.placeholder) // Ảnh hiển thị trong khi tải
            .error(R.drawable.error_image) // Ảnh hiển thị nếu xảy ra lỗi
            .into(holder.imageView)

        // Nếu dùng Picasso:
        // Picasso.get().load(imageUrl).into(holder.imageView)
    }
    override fun getItemCount(): Int {
        return imageUrls.size
    }
    class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }
}