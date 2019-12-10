package me.tcpackfrequency.warehouse.util;

import androidx.annotation.NonNull;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import me.tcpackfrequency.warehouse.model.Box;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface BoxCallback {
    void onSuccess(Box boxe);

}
