package com.example.android.persistence;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Created by nubor on 27/02/2018.
 */
@GlideModule public class GlideTestModule extends AppGlideModule {

  @Override public void applyOptions(Context context, GlideBuilder glideBuilder) {
    //new glide uses 888, consumes more ram
    // decrease memory usage with:
    glideBuilder.setDecodeFormat(DecodeFormat.PREFER_RGB_565);

    //CACHE

    // Memorya
    /*este funciona mejor q el bitmappool*/
    int memoryCacheSizeBytes = 1024 * 1024 * 30; // 30mb
    glideBuilder.setMemoryCache(new LruResourceCache(memoryCacheSizeBytes));

    //Disk(glide 4v, not work yet)
    //int diskCacheSizeBytes = 1024 * 1024 * 100; // 100 MB
    //glideBuilder.setDiskCache(new InternalDiskCacheFactory(context, diskCacheSizeBytes));

    //bitmapPool
    /*
    int bitmapPoolSizeBytes = 1024 * 1024 * 30; // 30mb
    glideBuilder.setBitmapPool(new LruBitmapPool(bitmapPoolSizeBytes));
*//*
    Glide.
  }get(context).setMemoryCategory(MemoryCategory.LOW);
    */
  }

  @Override public void registerComponents(@NonNull Context context, @NonNull Glide glide,
      @NonNull Registry registry) {
    super.registerComponents(context, glide, registry);
    //asv empty
  }
}
