package me.tcpackfrequency.warehouse.util;

import androidx.annotation.NonNull;
import me.tcpackfrequency.warehouse.model.Box;

import java.util.List;

public interface BoxesCallback {
     void onSuccess(@NonNull List<Box> boxes);

     void onError(@NonNull Throwable throwable);
}