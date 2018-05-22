package com.groceryapp.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import static com.groceryapp.util.Contants.BASE_IMG_URL;

/**
 */

public class BindingUtils {

	@BindingAdapter("bind:imageUrl")
	public static void setImageUrl(ImageView imageView, String url){
		Glide.with(imageView.getContext()).load(BASE_IMG_URL + url).into(imageView);
	}
}
