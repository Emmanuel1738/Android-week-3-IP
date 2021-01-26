package com.moringaschool.mywallpaperapi;

import android.widget.Filter;

import java.util.ArrayList;
import java.util.List;
import com.moringaschool.mywallpaperapi.*;

public interface MyInterface {
    ArrayList<WallpaperModel> wallpaperModelArrayList = new ArrayList<>();


   public   Filter myFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<WallpaperModel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(wallpaperModelArrayList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (WallpaperModel wallpaperModel : wallpaperModelArrayList) {
                    if (wallpaperModel.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(wallpaperModel);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            wallpaperModelArrayList.clear();
            wallpaperModelArrayList.addAll((List) results.values);

        }

    };
}
