package com.vorsk.minimalin.model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;

import com.vorsk.minimalin.R;
import com.vorsk.minimalin.config.ConfigActivity;
import com.vorsk.minimalin.config.ConfigRecyclerViewAdapter;
import com.vorsk.minimalin.config.color.ColorSelectionActivity;
import com.vorsk.minimalin.watchface.MinimalinWatchFaceService;

import java.util.ArrayList;

/**
 * Data represents different views for configuring the
 * {@link MinimalinWatchFaceService} watch face's appearance and complications
 * via {@link ConfigActivity}.
 */
public class ConfigData {

    /**
     * Returns Watch Face Service class associated with configuration Activity.
     */
    public static Class getWatchFaceServiceClass() {
        return MinimalinWatchFaceService.class;
    }

    /**
     * Returns Material Design color options.
     */
    /*public static ArrayList<MaterialColors.Color> getColorOptionsDataSet() {
        ArrayList<MaterialColors.Color> colorOptionsDataSet = new ArrayList<>();
        colorOptionsDataSet.add(Color.parseColor("#FFFFFF")); // White

        colorOptionsDataSet.add(Color.parseColor("#FFEB3B")); // Yellow
        colorOptionsDataSet.add(Color.parseColor("#FFC107")); // Amber
        colorOptionsDataSet.add(Color.parseColor("#FF9800")); // Orange
        colorOptionsDataSet.add(Color.parseColor("#FF5722")); // Deep Orange

        colorOptionsDataSet.add(Color.parseColor("#F44336")); // Red
        colorOptionsDataSet.add(Color.parseColor("#E91E63")); // Pink

        colorOptionsDataSet.add(Color.parseColor("#9C27B0")); // Purple
        colorOptionsDataSet.add(Color.parseColor("#673AB7")); // Deep Purple
        colorOptionsDataSet.add(Color.parseColor("#3F51B5")); // Indigo
        colorOptionsDataSet.add(Color.parseColor("#2196F3")); // Blue
        colorOptionsDataSet.add(Color.parseColor("#03A9F4")); // Light Blue

        colorOptionsDataSet.add(Color.parseColor("#00BCD4")); // Cyan
        colorOptionsDataSet.add(Color.parseColor("#009688")); // Teal
        colorOptionsDataSet.add(Color.parseColor("#4CAF50")); // Green
        colorOptionsDataSet.add(Color.parseColor("#8BC34A")); // Lime Green
        colorOptionsDataSet.add(Color.parseColor("#CDDC39")); // Lime

        colorOptionsDataSet.add(Color.parseColor("#607D8B")); // Blue Grey
        colorOptionsDataSet.add(Color.parseColor("#9E9E9E")); // Grey
        colorOptionsDataSet.add(Color.parseColor("#795548")); // Brown
        colorOptionsDataSet.add(Color.parseColor("#000000")); // Black


        return colorOptionsDataSet;
    }*/

    /**
     * Includes all data to populate each of the 5 different custom
     * {@link ViewHolder} types in {@link ConfigRecyclerViewAdapter}.
     */
    public static ArrayList<ConfigItemType> getDataToPopulateAdapter(Context context) {

        ArrayList<ConfigItemType> settingsConfigData = new ArrayList<>();

        // Data for watch face complications UX in settings Activity.
        ConfigItemType complicationConfigItem =
                new ComplicationsConfigItem(R.drawable.add_complication, R.drawable.add_big_complication, R.drawable.added_complication, R.drawable.added_big_complication);
        settingsConfigData.add(complicationConfigItem);

        ConfigItemType primaryColorConfigItem =
                new ColorConfigItem(
                        context.getString(R.string.config_primary_color_label),
                        R.drawable.ic_color_lens,
                        context.getString(R.string.saved_primary_color),
                        ColorSelectionActivity.class);
        settingsConfigData.add(primaryColorConfigItem);

        ConfigItemType accentColorConfigItem =
                new ColorConfigItem(
                        context.getString(R.string.config_secondary_color_label),
                        R.drawable.ic_color_lens,
                        context.getString(R.string.saved_secondary_color),
                        ColorSelectionActivity.class);
        settingsConfigData.add(accentColorConfigItem);

        /*
        // Data for highlight/marker (hour hand) color UX in settings Activity.
        ConfigItemType markerHourColorConfigItem =
                new ColorConfigItem(
                        context.getString(R.string.config_marker_hour_color_label),
                        R.drawable.ic_color_lens,
                        context.getString(R.string.saved_marker_color_hour),
                        ColorSelectionActivity.class);
        settingsConfigData.add(markerHourColorConfigItem);

        // Data for highlight/marker (minute hand) color UX in settings Activity.
        ConfigItemType markerMinuteColorConfigItem =
                new ColorConfigItem(
                        context.getString(R.string.config_marker_minute_color_label),
                        R.drawable.ic_color_lens,
                        context.getString(R.string.saved_marker_color_minute),
                        ColorSelectionActivity.class);
        settingsConfigData.add(markerMinuteColorConfigItem);

        // Data for highlight/marker (second hand) color UX in settings Activity.
        ConfigItemType markerSecondColorConfigItem =
                new ColorConfigItem(
                        context.getString(R.string.config_marker_second_color_label),
                        R.drawable.ic_color_lens,
                        context.getString(R.string.saved_marker_color_second),
                        ColorSelectionActivity.class);
        settingsConfigData.add(markerSecondColorConfigItem);
        */

        // Data for Background color UX in settings Activity.
        ConfigItemType backgroundColorConfigItem =
                new ColorConfigItem(
                        context.getString(R.string.config_background_color_label),
                        R.drawable.ic_color_lens,
                        context.getString(R.string.saved_background_color),
                        ColorSelectionActivity.class);
        settingsConfigData.add(backgroundColorConfigItem);

        // Data for background gradient
        ConfigItemType gradientConfigItem =
                new SwitchConfigItem(
                        context.getString(R.string.config_background_gradient_label),
                        R.drawable.ic_notifications,
                        R.drawable.time_12h,
                        R.string.saved_background_gradient);
        settingsConfigData.add(gradientConfigItem);

        // Data for 'Unread Notifications' UX (toggle) in settings Activity.
        ConfigItemType unreadNotificationsConfigItem =
                new SwitchConfigItem(
                        context.getString(R.string.config_unread_notifications_label),
                        R.drawable.ic_notifications,
                        R.drawable.ic_notifications_off,
                        R.string.saved_unread_notifications_pref);
        settingsConfigData.add(unreadNotificationsConfigItem);

        // Data for 24 hour mode UX (toggle) in settings Activity.
        ConfigItemType militaryTimeConfigItem =
                new SwitchConfigItem(
                        context.getString(R.string.config_24_hour_label),
                        R.drawable.time_24h,
                        R.drawable.time_12h,
                        R.string.saved_24h_pref);
        settingsConfigData.add(militaryTimeConfigItem);

        // Data for background complications UX in settings Activity.
        ConfigItemType backgroundImageComplicationConfigItem =
                // TODO move color and complication selector to same select activity
                new BackgroundComplicationConfigItem(
                        context.getString(R.string.config_background_image_complication_label),
                        R.drawable.ic_landscape);
        settingsConfigData.add(backgroundImageComplicationConfigItem);

        return settingsConfigData;
    }

    /**
     * Interface all ConfigItems must implement so the {@link RecyclerView}'s Adapter associated
     * with the configuration activity knows what type of ViewHolder to inflate.
     */
    public interface ConfigItemType {
        int getConfigType();
    }

    /**
     * Data for Watch Face Complications Preview item in RecyclerView.
     */
    public static class ComplicationsConfigItem implements ConfigItemType {

        private int defaultComplicationResourceId;
        private int defaultComplicationLongResourceId;
        private int defaultAddedComplicationResourceId;
        private int defaultAddedComplicationLongResourceId;

        ComplicationsConfigItem(int defaultComplicationResourceId, int defaultComplicationLongResourceId,
                                int defaultAddedComplicationResourceId, int defaultAddedComplicationLongResourceId) {
            this.defaultComplicationResourceId = defaultComplicationResourceId;
            this.defaultComplicationLongResourceId = defaultComplicationLongResourceId;
            this.defaultAddedComplicationResourceId = defaultAddedComplicationResourceId;
            this.defaultAddedComplicationLongResourceId = defaultAddedComplicationLongResourceId;
        }

        public int getDefaultComplicationResourceId() {
            return defaultComplicationResourceId;
        }

        public int getDefaultComplicationLongResourceId() {
            return defaultComplicationLongResourceId;
        }

        public int getDefaultAddedComplicationResourceId() {
            return defaultAddedComplicationResourceId;
        }

        public int getDefaultAddedComplicationLongResourceId() {
            return defaultAddedComplicationLongResourceId;
        }

        @Override
        public int getConfigType() {
            return ConfigRecyclerViewAdapter.TYPE_COMPLICATIONS_CONFIG;
        }
    }

    /**
     * Data for color picker item in RecyclerView.
     */
    public static class ColorConfigItem implements ConfigItemType {

        private String name;
        private int iconResourceId;
        private String sharedPrefString;
        private Class<ColorSelectionActivity> activityToChoosePreference;

        ColorConfigItem(
                String name,
                int iconResourceId,
                String sharedPrefString,
                Class<ColorSelectionActivity> activity) {
            this.name = name;
            this.iconResourceId = iconResourceId;
            this.sharedPrefString = sharedPrefString;
            this.activityToChoosePreference = activity;
        }

        public String getName() {
            return name;
        }

        public int getIconResourceId() {
            return iconResourceId;
        }

        public String getSharedPrefString() {
            return sharedPrefString;
        }

        public Class<ColorSelectionActivity> getActivityToChoosePreference() {
            return activityToChoosePreference;
        }

        @Override
        public int getConfigType() {
            return ConfigRecyclerViewAdapter.TYPE_COLOR_CONFIG;
        }
    }

    /**
     * Data for switch preference picker item in RecyclerView.
     */
    public static class SwitchConfigItem implements ConfigItemType {

        private String name;
        private int iconEnabledResourceId;
        private int iconDisabledResourceId;
        private int sharedPrefId;

        SwitchConfigItem(
                String name,
                int iconEnabledResourceId,
                int iconDisabledResourceId,
                int sharedPrefId) {
            this.name = name;
            this.iconEnabledResourceId = iconEnabledResourceId;
            this.iconDisabledResourceId = iconDisabledResourceId;
            this.sharedPrefId = sharedPrefId;
        }

        public String getName() {
            return name;
        }

        public int getIconEnabledResourceId() {
            return iconEnabledResourceId;
        }

        public int getIconDisabledResourceId() {
            return iconDisabledResourceId;
        }

        public int getSharedPrefId() {
            return sharedPrefId;
        }

        @Override
        public int getConfigType() {
            return ConfigRecyclerViewAdapter.TYPE_SWITCH_CONFIG;
        }
    }

    /**
     * Data for background image complication picker item in RecyclerView.
     */
    public static class BackgroundComplicationConfigItem implements ConfigItemType {

        private String name;
        private int iconResourceId;

        BackgroundComplicationConfigItem(
                String name,
                int iconResourceId) {

            this.name = name;
            this.iconResourceId = iconResourceId;
        }

        public String getName() {
            return name;
        }

        public int getIconResourceId() {
            return iconResourceId;
        }

        @Override
        public int getConfigType() {
            return ConfigRecyclerViewAdapter.TYPE_BACKGROUND_COMPLICATION_IMAGE_CONFIG;
        }
    }
}
