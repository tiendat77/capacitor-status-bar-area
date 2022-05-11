package com.dathuynh.plugins.status_bar_area;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;


public class StatusBarArea {

    private int currentStatusbarColor;
    private AppCompatActivity activity;
    private String defaultStyle;

    private static final int LOW_DPI_STATUS_BAR_HEIGHT = 19;
    private static final int MEDIUM_DPI_STATUS_BAR_HEIGHT = 25;
    private static final int HIGH_DPI_STATUS_BAR_HEIGHT = 38;

    public StatusBarArea(AppCompatActivity activity) {
        // save initial color of the status bar
        this.activity = activity;
        this.currentStatusbarColor = activity.getWindow().getStatusBarColor();
        this.defaultStyle = getStyle();
    }

    public void setStyle(String style) {
        Window window = activity.getWindow();
        View decorView = window.getDecorView();

        int visibilityFlags = decorView.getSystemUiVisibility();
        if (style.equals("DEFAULT")) {
            style = this.defaultStyle;
        }
        if (style.equals("DARK")) {
            decorView.setSystemUiVisibility(visibilityFlags & ~View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decorView.setSystemUiVisibility(visibilityFlags | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    public void setBackgroundColor(int color) {
        Window window = activity.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(color);
        // update the local color field as well
        currentStatusbarColor = color;
    }

    public void hide() {
        View decorView = activity.getWindow().getDecorView();
        int uiOptions = decorView.getSystemUiVisibility();
        uiOptions = uiOptions | View.SYSTEM_UI_FLAG_FULLSCREEN;
        uiOptions = uiOptions & ~View.SYSTEM_UI_FLAG_VISIBLE;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void show() {
        View decorView = activity.getWindow().getDecorView();
        int uiOptions = decorView.getSystemUiVisibility();
        uiOptions = uiOptions | View.SYSTEM_UI_FLAG_VISIBLE;
        uiOptions = uiOptions & ~View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void setOverlaysWebView(Boolean overlays) {
        if (overlays) {
            // Sets the layout to a fullscreen one that does not hide the actual status bar, so the webview is displayed behind it.
            View decorView = activity.getWindow().getDecorView();
            int uiOptions = decorView.getSystemUiVisibility();
            uiOptions = uiOptions | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            currentStatusbarColor = activity.getWindow().getStatusBarColor();
            activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            // Sets the layout to a normal one that displays the webview below the status bar.
            View decorView = activity.getWindow().getDecorView();
            int uiOptions = decorView.getSystemUiVisibility();
            uiOptions = uiOptions & ~View.SYSTEM_UI_FLAG_LAYOUT_STABLE & ~View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            // recover the previous color of the status bar
            activity.getWindow().setStatusBarColor(currentStatusbarColor);
        }
    }

    public int getHeight() {
      DisplayMetrics displayMetrics = new DisplayMetrics();
      ((WindowManager) activity.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(displayMetrics);

      int statusBarHeight;

      switch (displayMetrics.densityDpi) {
        case DisplayMetrics.DENSITY_LOW:
          statusBarHeight = LOW_DPI_STATUS_BAR_HEIGHT;
          break;
        case DisplayMetrics.DENSITY_MEDIUM:
          statusBarHeight = MEDIUM_DPI_STATUS_BAR_HEIGHT;
          break;
        default:
          statusBarHeight = HIGH_DPI_STATUS_BAR_HEIGHT;
      }

      return statusBarHeight;
    }

    public StatusBarAreaInfo getInfo() {
        Window window = activity.getWindow();
        View decorView = window.getDecorView();
        StatusBarAreaInfo info = new StatusBarAreaInfo();
        info.setStyle(getStyle());
        info.setHeight(getHeight());
        info.setOverlays(
            (decorView.getSystemUiVisibility() & View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN) == View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
        info.setVisible((decorView.getSystemUiVisibility() & View.SYSTEM_UI_FLAG_FULLSCREEN) != View.SYSTEM_UI_FLAG_FULLSCREEN);
        info.setColor(String.format("#%06X", (0xFFFFFF & window.getStatusBarColor())));

        return info;
    }

    private String getStyle() {
        View decorView = activity.getWindow().getDecorView();
        String style;
        if ((decorView.getSystemUiVisibility() & View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) == View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) {
            style = "LIGHT";
        } else {
            style = "DARK";
        }
        return style;
    }
}
